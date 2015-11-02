/**
 * 
 */
package Controller;

import javax.swing.JFrame;

import Model.Intervenant;
import Model.Project;
import Model.Student;
import Model.Subject;
import Utilitaires.CSV;
import View.CustomPanel;
import View.PanelIntervenant;

/**
 * Controller class for Project and PanelProject class
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class ProjectController extends PanelController {

	/**
	 * Constructor for the ProjectController class
	 */
	public ProjectController() {
		super("data\\projets2014_2015.csv");
	}

	/* (non-Javadoc)
	 * @see Controller.PanelController#buildData()
	 */
	@Override
	protected void buildData() {
		for (String[] entry : CSV.read(this.filepath)) {
			this.data.add(new Project(entry[0], entry[1], entry[2], entry[3],
					entry[4], entry[5]));
		}
	}
	
	/* (non-Javadoc)
	 * @see Controller.PanelController#addDataById(java.lang.String)
	 */
	@Override
	public void addDataById(String id) {
		data.add(new Project(id, " ", " ", " ", " ", " "));
	}

}
