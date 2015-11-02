package Model;

import javax.swing.table.AbstractTableModel;

/**
 * Non-used class
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class CustomTableModel extends AbstractTableModel {

	private Object[][] data;
	private String[] title;

	public CustomTableModel() {
		// TODO Auto-generated constructor stub
	}

	// Retourne le nombre de colonnes
	public int getColumnCount() {
		return this.title.length;
	}

	// Retourne le nombre de lignes
	public int getRowCount() {
		return this.data.length;
	}

	// Retourne la valeur à l'emplacement spécifié
	public Object getValueAt(int row, int col) {
		return this.data[row][col];
	}

	/**
	 * 
	 * Returns the column title at the specified index.
	 */

	public String getColumnName(int col) {

		return this.title[col];

	}

	public Class getColumnClass(int col) {
		return this.data[0][col].getClass();
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return column != 0;
	}

}
