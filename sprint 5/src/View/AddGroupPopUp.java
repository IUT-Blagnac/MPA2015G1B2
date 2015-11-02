package View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import Controller.StudentController;

/**
 * Pop-Up frame for the PanelGroup class
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class AddGroupPopUp extends JFrame {
	private static AddGroupPopUp instance = null;
	private static StudentController controller;
	public static Home homeFrame;

	/**
	 * Private constructor for the AddGroupPopUp frame
	 */
	private AddGroupPopUp(JFrame homeFrame) {
		super("Lone Students");
	
		AddGroupPopUp.homeFrame = (Home) homeFrame;
		
		this.addWindowListener(new WindowEventHandler());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		PanelNewGroup panNewGroup = new PanelNewGroup(this, controller);
		
		this.add(panNewGroup);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/**
	 * Instanced the class if not yet instanced
	 * @return The object instanced
	 */
	public static AddGroupPopUp getInstance(JFrame frame) {
		if(instance == null) {
			instance = new AddGroupPopUp(frame);
		}
		return instance;
	}
	
	/**
	 * Set the controller of the class
	 * @param c Controller of PanelStudents
	 */
	public static void setController(StudentController c) {
		controller = c;
	}
	
	/**
	 * Reset the instance if the frame is closing
	 * @author Groupe 1B2
	 * @version Sprint 2
	 */
	public class WindowEventHandler extends WindowAdapter {
		/* (non-Javadoc)
		 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowClosing(WindowEvent e) {
			instance = null;
		}
	}
}
