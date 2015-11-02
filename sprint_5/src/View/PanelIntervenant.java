package View;

import javax.swing.JFrame;

import Controller.PanelController;
import Model.Intervenant;
import Model.Modelisable;
import Model.Student;


/**
 * 
 * The PanelIntervenant is a class used to display a list of tutors by Id, surname and name. <br>
 * @see CustomPanel
 * @author Groupe 1B2
 * @version Sprint 4 <br>
 * 
 */
public class PanelIntervenant extends CustomPanel {

	/**The constructor creates a JPanel which takes as argument a frame and a controller.
	 * @param frame JFrame where the JPanel will be put
	 * @param controller Controller for the PanelIntervenant class
	 */
	public PanelIntervenant(JFrame frame, PanelController controller) {
		super(frame, new String[] { "ID",
				"Firstname", "Name" }, controller);
	}
	/* (non-Javadoc)
	 * @see View.CustomPanel#getT(java.lang.String[])
	 */
}
