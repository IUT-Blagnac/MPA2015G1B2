package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import View.CustomPanel.TableListener;
import Controller.GroupController;
import Controller.IntervenantController;
import Controller.PanelController;
import Controller.SubjectController;

/**
 * 
 * The PanelProject is a class used to display a list of projects by an Id,<br>
 * a student's group,a subject, a customer, and a supervisor.<br> 
 * @see CustomPanel
 *
 * 
 * @author Groupe 1B2
 * @version Sprint 4 <br>
 */
public class PanelProject extends CustomPanel {
	/**The constructor creates a JPanel which takes as argument a frame and a controller.
	 * @param frame JFrame where the JPanel will be put
	 * @param controller Controller for the PanelProject class
	 * @param tabController Additional Controller for the PanelProject class
	 */
	public PanelProject(JFrame frame,PanelController controller, final PanelController[] tabController, final CustomPanel groupPanel) {
		super(frame, new String[] { "ID", "group", "sujet", "client", "superviseur",
						"support_technique" }, controller);
	
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
		
		this.tableau.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					JFrame fen = new JFrame("Project "+tableau.getValueAt(tableau.getSelectedRow(),0));
					ProjectPopUp pan = new ProjectPopUp(fen, tabController, tableau, groupPanel);
					fen.add(pan);
					fen.pack();
					fen.setLocationRelativeTo(null);
					fen.setVisible(true);
					
				}

			}
		});
	
	}
	
}
