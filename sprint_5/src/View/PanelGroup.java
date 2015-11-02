package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import View.CustomPanel.TableListener;
import Controller.PanelController;



/**
 * 
 * The PanelGroup is a class used to display a list of Groups by Id, the subject
 * attributed to the group. <br>
 * 
 * @see CustomPanel
 *
 * 
 * @author Groupe 1B2
 * @version Sprint 4 <br>
 */
public class PanelGroup extends CustomPanel {
	PanelController projectController;
	PanelController subjectController;
	/**
	 * This constructor creates a JPanel which takes as argument a frame and a
	 * controller.
	 * 
	 * @param frame
	 *            JFrame where the JPanel will be put
	 * @param controller Controller for the PanelGroup class
	 */
	public PanelGroup(Home frame, PanelController controller, PanelController projectController, PanelController subjectController) {
		super(frame, new String[] { "Group ID", "Subject" }, controller);
		
		this.projectController=projectController;
		this.subjectController=subjectController;
		
		class CustomTableModel extends DefaultTableModel {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == -1;
			}
		}
		
		model = new CustomTableModel();

		model.setColumnIdentifiers(title);

		for (int i = 1; i < controller.getData().size(); i++) {
			model.addRow(controller.getData().get(i).toArray());
		}

		model.addTableModelListener(new TableListener());

		tableau.setModel(model);
		
		for(int i=0; i<tableau.getRowCount();i++){
			String groupGroup = (String) tableau.getValueAt(i, 0);
			for(int j=0; j<projectController.getData().size();j++){
				String groupProject = (String) projectController.getData().get(j).toArray()[1];
				if(groupGroup.equals(groupProject)){
					String subjectProject = (String) projectController.getData().get(j).toArray()[2];
					for(int k=0; k<subjectController.getData().size();k++){
						String subjectSubject = (String) subjectController.getData().get(k).toArray()[0];
						if(subjectProject.equals(subjectSubject)){
							tableau.setValueAt(subjectController.getData().get(k).toArray()[1], i, 1);
						}
					}
				}
			}
		}
		
		add.setText("Assign students to group");
		
		this.tableau.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					WishesPopUp wishesPopUp = new WishesPopUp(tableau);
					wishesPopUp.setLocationRelativeTo(null);
					wishesPopUp.setVisible(true);
				}

			}
		});
	}
	
	protected void addListeners() {
		add.addActionListener(new addListener());
		remove.addActionListener(new removeListener());
	}
	
	private class addListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AddGroupPopUp.getInstance(frame);
		}		
	}
	
	private class removeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			/// TODO Remove all group ids from student objects
		}
	}
}