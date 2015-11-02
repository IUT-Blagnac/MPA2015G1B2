package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import Controller.PanelController;

/**
 * Project Pop-Up Not yet implemented.
 * It will display the Project field as JComboBox
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class ProjectPopUp extends JPanel {

	private JFrame frame;
	
	private CustomPanel groupPanel;
	
	private JButton ok;
	
	private JPanel field;
	private JPanel buttons;
	
	private JLabel group;
	private JLabel subject;
	private JLabel client;
	private JLabel supervisor;
	private JLabel support;
	
	private JLabel groupID;
	private JLabel subjectID;
	private JLabel clientID;
	private JLabel supervisorID;
	private JLabel supportID;
	
	private JComboBox<String> groupCombo;
	private JComboBox<String> subjectCombo;
	private JComboBox<String> clientCombo;
	private JComboBox<String> supervisorCombo;
	private JComboBox<String> supportCombo;
	
	private PanelController groupController;
	private PanelController subjectController;
	private PanelController intervenantController;

	private PanelController projectController;
	
	public ProjectPopUp(final JFrame frame, PanelController[] tabController, final JTable projectTable, final CustomPanel groupPanel) {
		this.groupPanel=groupPanel;
		this.frame=frame;
		
		this.groupController = tabController[0];
		this.subjectController = tabController[1];
		this.intervenantController = tabController[2];
		this.projectController = tabController[3];
		
		this.setLayout(new BorderLayout());
		field = new JPanel(new GridLayout(5,3));
		buttons = new JPanel(new BorderLayout());
		
		groupCombo = new JComboBox<String>();
		subjectCombo = new JComboBox<String>();
		clientCombo = new JComboBox<String>();
		supervisorCombo = new JComboBox<String>();
		supportCombo = new JComboBox<String>();
		
		for (int i = 1; i < groupController.getData().size(); i++) {
			groupCombo.addItem((String) groupController.getData().get(i).toArray()[0]);
		}
		
		for (int i = 1; i < subjectController.getData().size(); i++) {
			subjectCombo.addItem((String) subjectController.getData().get(i).toArray()[1]);
		}
		
		for (int i = 1; i < intervenantController.getData().size(); i++) {
			clientCombo.addItem((String) intervenantController.getData().get(i).toArray()[1]);
			supervisorCombo.addItem((String) intervenantController.getData().get(i).toArray()[1]);
			supportCombo.addItem((String) intervenantController.getData().get(i).toArray()[1]);
		}
		groupCombo.addItem("");
		subjectCombo.addItem("");
		clientCombo.addItem("");
		supervisorCombo.addItem("");
		supportCombo.addItem("");
		
		group = new JLabel("Groupe : ");
		subject = new JLabel("Sujet : ");
		client = new JLabel ("Client : ");
		supervisor = new JLabel ("Supervisor : ");
		support = new JLabel ("Support : ");
		
		for (int i = 1; i < groupController.getData().size(); i++) {
			String a = new String((String) projectTable.getValueAt(projectTable.getSelectedRow(),1));
			String b = new String((String) groupController.getData().get(i).toArray()[0]);
			if(a.equals(b)){
				System.out.println("Group selected");
				groupCombo.setSelectedItem(groupController.getData().get(i).toArray()[0]);
				break;
			}
			else{
				groupCombo.setSelectedItem(groupCombo.getItemAt(groupCombo.getItemCount()));
			}
		}		

		for (int i = 1; i < subjectController.getData().size(); i++) {
			String a = new String((String) projectTable.getValueAt(projectTable.getSelectedRow(),2));
			String b = new String((String) subjectController.getData().get(i).toArray()[0]);
			if(a.equals(b)){
				System.out.println("Subject selected");
				subjectCombo.setSelectedItem(subjectController.getData().get(i).toArray()[1]);
				break;
			}
			else{
				subjectCombo.setSelectedItem(subjectCombo.getItemAt(subjectCombo.getItemCount()));
			}
		}


		for (int i = 1; i < intervenantController.getData().size(); i++) {
			String a = new String((String) projectTable.getValueAt(projectTable.getSelectedRow(),3));
			String b = new String((String) intervenantController.getData().get(i).toArray()[0]);
			if(a.equals(b)){
				System.out.println("Client selected");
				clientCombo.setSelectedItem(intervenantController.getData().get(i).toArray()[1]);
				break;
			}
			else{
				clientCombo.setSelectedItem(clientCombo.getItemAt(clientCombo.getItemCount()));
			}
		}

		

		for (int i = 1; i < intervenantController.getData().size(); i++) {
			String a = new String((String) projectTable.getValueAt(projectTable.getSelectedRow(),4));
			String b = new String((String) intervenantController.getData().get(i).toArray()[0]);
			if(a.equals(b)){
				System.out.println("Supervisor selected");
				supervisorCombo.setSelectedItem(intervenantController.getData().get(i).toArray()[1]);
				break;
			}
			else{
				supervisorCombo.setSelectedItem(supervisorCombo.getItemAt(supervisorCombo.getItemCount()));
			}
		}
		
		
		
		for (int i = 1; i < intervenantController.getData().size(); i++) {
			String a = new String((String) projectTable.getValueAt(projectTable.getSelectedRow(),5));
			String b = new String((String) intervenantController.getData().get(i).toArray()[0]);
			if(a.equals(b)){
				System.out.println("Support selected");
				supportCombo.setSelectedItem(intervenantController.getData().get(i).toArray()[1]);
				break;
			}
			else{
				supportCombo.setSelectedItem(supportCombo.getItemAt(supportCombo.getItemCount()));
			}
		}
		
		groupID = new JLabel("");
		subjectID = new JLabel("");
		clientID = new JLabel("");
		supervisorID = new JLabel("");
		supportID = new JLabel("");
		
		for (int i =0; i <groupController.getData().toArray().length; i++){
			if(i==groupCombo.getSelectedIndex()){
				groupID = new JLabel(groupController.getData().get(i+1).toArray()[0]+"");
			}
		}
		
		for (int i =0; i <subjectController.getData().toArray().length; i++){
			if(i==subjectCombo.getSelectedIndex()){
				subjectID = new JLabel(subjectController.getData().get(i+1).toArray()[0]+"");
			}
		}
		
		for (int i =0; i <intervenantController.getData().toArray().length; i++){
			if(i==clientCombo.getSelectedIndex()){
				clientID = new JLabel(intervenantController.getData().get(i+1).toArray()[0]+"");
			}
			if(i==supervisorCombo.getSelectedIndex()){
				supervisorID = new JLabel(intervenantController.getData().get(i+1).toArray()[0]+"");
			}
			if(i==supportCombo.getSelectedIndex()){
				supportID = new JLabel(intervenantController.getData().get(i+1).toArray()[0]+"");
			}
		}
		
		class ComboListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				for (int i =0; i <groupController.getData().toArray().length; i++){
					if(groupCombo.getSelectedIndex()==groupCombo.getItemCount()-1){
						groupID.setText("");
					}else{
					if(i==groupCombo.getSelectedIndex()){
						groupID.setText(groupController.getData().get(i+1).toArray()[0]+"");
					}}
				}
				
				for (int i =0; i <subjectController.getData().toArray().length; i++){
					if(subjectCombo.getSelectedIndex()==subjectCombo.getItemCount()-1){
						subjectID.setText("");
					}else{
					if(i==subjectCombo.getSelectedIndex()){
						subjectID.setText(subjectController.getData().get(i+1).toArray()[0]+"");
					}}
				}
				
				for (int i =0; i <intervenantController.getData().toArray().length; i++){
					if(clientCombo.getSelectedIndex()==clientCombo.getItemCount()-1){
						clientID.setText("");
					}else{
					if(i==clientCombo.getSelectedIndex()){
						clientID.setText(intervenantController.getData().get(i+1).toArray()[0]+"");
					}}
					if(supervisorCombo.getSelectedIndex()==supervisorCombo.getItemCount()-1){
						supervisorID.setText("");
					}else{
					if(i==supervisorCombo.getSelectedIndex()){
						supervisorID.setText(intervenantController.getData().get(i+1).toArray()[0]+"");
					}}
					if(supportCombo.getSelectedIndex()==supportCombo.getItemCount()-1){
						supportID.setText("");
					}else{
						if(i==supportCombo.getSelectedIndex()){
							supportID.setText(intervenantController.getData().get(i+1).toArray()[0]+"");
						}
					}}
				}
				
			}
		
		groupCombo.addActionListener(new ComboListener());
		subjectCombo.addActionListener(new ComboListener());
		clientCombo.addActionListener(new ComboListener());
		supervisorCombo.addActionListener(new ComboListener());
		supportCombo.addActionListener(new ComboListener());
		
		ok = new JButton("OK");
		buttons.add(ok);
		
		field.add(group);
		field.add(groupID);
		field.add(groupCombo);
		
		field.add(subject);
		field.add(subjectID);
		field.add(subjectCombo);
		
		field.add(client);
		field.add(clientID);
		field.add(clientCombo);
		
		field.add(supervisor);
		field.add(supervisorID);
		field.add(supervisorCombo);
		
		field.add(support);
		field.add(supportID);
		field.add(supportCombo);
		
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				if(!groupID.getText().equals("")){
					for (int i=0; i<projectTable.getRowCount();i++){
						String a = (String)projectTable.getValueAt(i,1);
						if(a.equals(groupID.getText())&&i!=projectTable.getSelectedRow()){
							JOptionPane.showConfirmDialog(frame, "The selectionned group is already attributed to another project", "Error", JOptionPane.PLAIN_MESSAGE);
							return;
						}
							
					}
				}
				
				if(!subjectID.getText().equals("")){
					for (int i=0; i<projectTable.getRowCount();i++){
						String a = (String)projectTable.getValueAt(i,2);
						if(a.equals(subjectID.getText())&&i!=projectTable.getSelectedRow()){
							JOptionPane.showConfirmDialog(frame, "The selectionned subject is already attributed to another project", "Error", JOptionPane.PLAIN_MESSAGE);
							return;
						}
							
					}
				}
				
				if(supervisorID.getText().equals("")||clientID.getText().equals("")){
					if(supervisorID.getText().equals(clientID.getText())){
						JOptionPane.showConfirmDialog(frame, "The client and the supervisor cannot be the same person", "Error", JOptionPane.PLAIN_MESSAGE);
						return;
					}
				}
				
				projectTable.setValueAt(groupID.getText(), projectTable.getSelectedRow(), 1);
				projectTable.setValueAt(subjectID.getText(), projectTable.getSelectedRow(), 2);
				projectTable.setValueAt(clientID.getText(), projectTable.getSelectedRow(), 3);
				projectTable.setValueAt(supervisorID.getText(), projectTable.getSelectedRow(), 4);
				projectTable.setValueAt(supportID.getText(), projectTable.getSelectedRow(), 5);	
				
				for(int i=0; i<groupPanel.getTable().getRowCount();i++){
					if(groupID.getText().equals(groupPanel.getTable().getValueAt(i, 0))){
						groupPanel.getTable().setValueAt(subjectCombo.getSelectedItem(),i,1);
					}
				}
				
				projectController.updateByIndex(projectTable.getSelectedRow() + 1, 1,
						groupID.getText());
				projectController.updateByIndex(projectTable.getSelectedRow() + 1, 2,
						subjectID.getText());
				projectController.updateByIndex(projectTable.getSelectedRow() + 1, 3,
						supervisorID.getText());
				projectController.updateByIndex(projectTable.getSelectedRow() + 1, 4,
						supportID.getText());
				projectController.updateByIndex(projectTable.getSelectedRow() + 1, 5,
						clientID.getText());
	
				frame.dispose();
			}
			
		});
		
		this.add(field, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.EAST);
		
	}		
}
