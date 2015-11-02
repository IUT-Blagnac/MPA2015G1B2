/**
 * 
 */
package Controller;

import java.io.IOException;
import java.util.ArrayList;

import Model.Modelisable;
import Utilitaires.CSV;
import View.CustomPanel;

/**
 * Controller class which extends to other Controller class.
 * 
 * @author Groupe 1B2
 * @version Sprint 4
 */
public abstract class PanelController {

	protected final String filepath;
	protected ArrayList<Modelisable> data;
	protected CustomPanel panel;

	/**
	 * Constructor for PanelController that take a filepath as argument to build
	 * the data
	 * 
	 * @param filepath
	 *            Filepath of the file that contains the data
	 */
	public PanelController(String filepath) {
		this.filepath = filepath;
		this.data = new ArrayList<>();
		this.buildData();
	}

	/**
	 * Appends {@link Modelisable} objects to the data array from the csv file
	 * found at the filepath variable.
	 */
	protected abstract void buildData();

	/**
	 * Writes all {@link Modelisable} to the csv file found at the filepath
	 * variable.
	 */
	public void saveData() {
		try {
			for (Modelisable cursor : this.data) {
			}
			CSV.write(this.data, this.filepath);
		} catch (IOException e) {
			// TODO FAIRE UNE TURC
			// LE TRUC : AFFICHER UN MESSAGE D'ERRERU
		}
	}

	public void saveData(String filepath) {
		try {
			for (Modelisable cursor : this.data) {
			}
			CSV.write(this.data, filepath);
		} catch (IOException e) {
			// TODO FAIRE UNE TURC
			// LE TRUC : AFFICHER UN MESSAGE D'ERRERU
		}
	}

	public ArrayList<Modelisable> getData() {
		return this.data;
	}

	public void addData(Modelisable modelisable) {
		this.data.add(modelisable);
	}

	public void removeByIndex(int index) {
		this.data.remove(index);
	}

	public void updateByIndex(int index, int column, String change) {
		this.data.get(index).set(column, change);
	}

	public abstract void addDataById(String id);

	public String getNewID() {

		int id = 1;
		for (Modelisable cursor : data) {
			
			if (cursor.toArray()[0].equals("id")) {
				continue;
			}
			
			int temp = Integer.valueOf((String) cursor.toArray()[0]);
			if (temp >= id) {
				id = temp + 1;
			}
		}

		return String.valueOf(id);
	}
}
