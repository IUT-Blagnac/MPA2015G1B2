package View;

import javax.swing.JFrame;
import javax.swing.JTable;

import Controller.WishController;

/**
 * Pop-Up for the PanelWish class
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class WishesPopUp extends JFrame {
	
	PanelWish panelWish;
	WishController wishController;
	
	/**
	 * Set the JFrame and take a JTable to know the selected row
	 * @param tableau JTable to know the selected row
	 */
	public WishesPopUp(JTable tableau){
		super("Groupe "+tableau.getValueAt(tableau.getSelectedRow(),0));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		wishController = new WishController(tableau.getValueAt(tableau.getSelectedRow(),0).toString());
		panelWish = new PanelWish(this, wishController);
		this.add(panelWish);
		this.pack();
		
	}
	
}
