package Controller;

import java.util.ArrayList;

import Model.Group;
import Utilitaires.CSV;

/**
 * Controller class for Group and PanelGroup class
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class GroupController extends PanelController {

	/**
	 * Constructor for the GroupController class
	 */
	public GroupController() {
		super("data\\etudiants2014_2015.csv");
	}

	/* (non-Javadoc)
	 * @see Controller.PanelController#buildData()
	 */
	@Override
	protected void buildData() {
		ArrayList<String> addedGroups = new ArrayList<String>();
		for (String[] entry : CSV.read(this.filepath)) {
			if (!addedGroups.contains(entry[0]) && !entry[0].toString().equals(" ") && !entry[0].toString().equals("")) {
				this.data.add(new Group(entry[0]));
				addedGroups.add(entry[0]);
			}
		}		
	}

	/* (non-Javadoc)
	 * @see Controller.PanelController#addDataById(java.lang.String)
	 */
	@Override
	public void addDataById(String id) {
	}
}
