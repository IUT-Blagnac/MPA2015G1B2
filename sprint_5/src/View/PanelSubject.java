package View;

import javax.swing.JFrame;
import javax.swing.JTable;

import Controller.PanelController;
import Model.*;

/**
 * 
 * The PanelSubject is a class used to display a list of Subjects by Id,a name and a title. <br>
 * @see CustomPanel
 *
 * 
 * @author Groupe 1B2
 * @version Sprint 4 <br>
 */
public class PanelSubject extends CustomPanel {
	/**This constructor creates a JPanel which takes as argument a frame and a controller.
	 * @param frame JFrame where the JPanel will be put
	 * @param controller Controller for the PanelSubject
	 */
	public PanelSubject(JFrame frame, PanelController controller) {
		super(frame, new String[] { "ID",
				"Name", "Title" }, controller);
		tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
}