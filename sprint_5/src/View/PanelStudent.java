package View;

import javax.swing.JFrame;

import Controller.PanelController;
import Model.Modelisable;
import Model.Student;

/**
 * 
 * The PanelStudent is a class used to display a list of Students by an Id,a
 * group, a name and a surname.<br>
 * 
 * @see CustomPanel
 *
 * 
 * @author Groupe 1B2
 * @version Sprint 4 <br>
 */
public class PanelStudent extends CustomPanel {

	/**
	 * This constructor creates a JPanel which takes as argument a frame and a controller.
	 * 
	 * @param frame
	 *            JFrame where the JPanel will be put
	 * @param controller Controller for the PanelStudent class
	 */
	public PanelStudent(JFrame frame, PanelController controller) {
		super(frame, new String[] { "ID", "Firstname", "Name", "Group" },
				controller);
	}

}
