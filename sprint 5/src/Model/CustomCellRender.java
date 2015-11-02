package Model;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

//this.tableau.setDefaultRenderer(JComponent.class, new TableComponent());

/**
 * Non-used class
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class CustomCellRender extends DefaultTableCellRenderer {

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
	 */
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

		// Si la valeur de la cellule est un JButton, on transtype cette valeur

		if (value instanceof JButton) {

			return (JButton) value;
		}

		else if (value instanceof JComboBox) {

			return (JComboBox) value;
		}
		return this;

	}

}