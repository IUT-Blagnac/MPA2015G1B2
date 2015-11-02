/**
 * 
 */
package Controller;

import javax.swing.JFrame;

import Model.Modelisable;
import Model.Project;
import Model.Student;
import Model.Subject;
import Utilitaires.CSV;
import View.CustomPanel;
import View.PanelIntervenant;

/**
 * Controller class for Subject and PanelSubject class
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class SubjectController extends PanelController {

	/**
	 * Constructor for the SubjectController class
	 */
	public SubjectController() {
		super("data\\sujets2014_2015.csv");
	}

	/* (non-Javadoc)
	 * @see Controller.PanelController#buildData()
	 */
	@Override
	protected void buildData() {
		for(String[] entry : CSV.read(this.filepath)) {
			this.data.add(new Subject(entry[0], entry[1], entry[2]));
		}
	}
	
	/* (non-Javadoc)
	 * @see Controller.PanelController#addDataById(java.lang.String)
	 */
	@Override
	public void addDataById(String id) {
		data.add(new Subject(id, " ", " "));
	}

}
