/**
 * 
 */
package Controller;

import javax.swing.JFrame;

import Model.Intervenant;
import Utilitaires.CSV;
import View.PanelIntervenant;

/**
 * Controller class for Intervenant and PanelIntervenant class
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class IntervenantController extends PanelController {

	/**
	 * Constructor for the IntervenantController class
	 */
	public IntervenantController() {
		super("data\\intervenants2014_2015.csv");
	}

	/* (non-Javadoc)
	 * @see Controller.PanelController#buildData()
	 */
	@Override
	protected void buildData() {
		for(String[] entry : CSV.read(this.filepath)) {
			this.data.add(new Intervenant(entry[0], entry[2], entry[1]));
		}
	}

	/* (non-Javadoc)
	 * @see Controller.PanelController#addDataById(java.lang.String)
	 */
	@Override
	public void addDataById(String id) {
		data.add(new Intervenant(id, " ", " "));
	}

}
