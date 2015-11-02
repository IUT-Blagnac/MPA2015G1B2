package View;

/// TODO rajouter le nombre de personnes déjà présentes dans un groupe;
/// TODO Add new group to list

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.StudentController;

/**
 * Temporary class
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class PanelNewGroup extends CustomPanel {
	private JComboBox<String> groupList;
	private JTextField groupNameField;
	private AddGroupPopUp frame;
	private StudentController controller;
	
	public PanelNewGroup(AddGroupPopUp frame, StudentController controller) {
		super(frame, new String[] { "ID", "FirstName", "Name" }, controller);
		this.frame = frame;
		this.controller = controller;
		
		JPanel panGroupName = new JPanel();
		
		panbut.add(panGroupName, BorderLayout.NORTH);
		
		class CustomTableModel extends DefaultTableModel {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == -1;
			}
		}
		
		model = new CustomTableModel();

		model.setColumnIdentifiers(title);

		for (int i = 0; i < controller.getLoneStudents().size(); i++) {
			model.addRow(controller.getLoneStudents().get(i).toArray());
		}
		
		ArrayList<String> groupArrayList = controller.getAllGroups();
		///: Fill the combobox with all available groups.
		
		for (int i = 0; i < groupArrayList.size(); i++) {
			if(groupArrayList.get(i).equals("") || groupArrayList.get(i).equals(" ")) {
				groupArrayList.remove(i);
			}
		}
		
		///: Lists all groups in a combobox		
		String[] groupStrings = Arrays.copyOf(groupArrayList.toArray(), groupArrayList.size(), String[].class);
		groupStrings[0] = "Select a group or enter a new group Id";
		groupList = new JComboBox<String>(groupStrings);
		groupList.setPreferredSize(new Dimension(260, 20));
		groupList.setEditable(true);
		groupList.getEditor().getEditorComponent().addFocusListener(new FocusListener());
		///: adds combobox
		panGroupName.add(groupList);
		
		model.addTableModelListener(new TableListener());
		
		tableau.setModel(model);
		
		panbut.remove(remove);
		panbut.remove(saveAs);
		panbut.remove(save);
		add.setText("Add to group");
	}
	
	@Override
	protected void addListeners() {
		add.addActionListener(new AddListener());
	}
	
	private class FocusListener extends FocusAdapter {

		@Override
		public void focusGained(FocusEvent e) {
			JTextField f = (JTextField) e.getSource();
			f.selectAll();
		}
	}
	
	private class AddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String group = (String)groupList.getSelectedItem();
			int[] selectedRows = tableau.getSelectedRows();
			
			if (group.equals("Select a group or enter a new group Id")) return;
			else if (selectedRows.length == 0) return;
			
			for(int i = 0; i < selectedRows.length; i++) {
				String id = (String) model.getValueAt(selectedRows[i], 0); /// ID
				
				/// Sets the group id of the student.
				controller.getStudentById(id).set(3, group);
			}
			
			/// Writes new data to csv files. 
			controller.saveData();
			
			/// Reloads student and group tab to show new group ids.
			AddGroupPopUp.homeFrame.pageStudents.fillTable();
			AddGroupPopUp.homeFrame.pageGroups.fillTable();
			
			/// Closes popup
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}		
	}
}
