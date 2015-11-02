package Test;

import java.util.ArrayList;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import Controller.PanelController;
import Model.Modelisable;
import Model.Project;

/**
 * 
 * The CustomControllerTest is an abstract class used as a main pattern for the others
 * ControllerTest. <br>
 * It is a test class that display test_add, test_remove, test_update, test_save.
 * 
 * @author Groupe 1B2
 * @version Sprint 4 <br>
 */

public abstract class CustomControllerTest extends TestCase {

	/*
	 * public static void main(String[] args) { junit.textui.TestRunner.run(new
	 * TestSuite(projectControllerTest.class)); }
	 */
	
	protected void test_add() {
		PanelController pr = getController();
		
		ArrayList<Modelisable> array = (ArrayList<Modelisable>) pr.getData().clone();
		
		for (Modelisable cursor : this.getModelisables()) {
			pr.addData(cursor);
		}
		
		for (Modelisable cursor : this.getModelisables()) {
			array.add(cursor);
		}
		
		assertEquals("Affiche : " +array, array, pr.getData());
		
	}
	
	protected void test_save() {

		PanelController pr = getController();

		for (Modelisable cursor : this.getModelisables()) {
			pr.addData(cursor);
		}

		pr.saveData();

		PanelController pr2 = getController();

		assertEquals("Affiche : " + pr.getData(), pr.getData(), pr2.getData());

	}
	
	protected void test_remove() {
		
		PanelController pr = getController();
		
		ArrayList<Modelisable> array = (ArrayList<Modelisable>) pr.getData().clone();
		
		pr.removeByIndex(0);
		
		array.remove(0);
		
		assertEquals("Affiche : " +array, array, pr.getData());
		
	}
	
	protected void test_update() {

		PanelController pr = getController();
		
		ArrayList<Modelisable> array = (ArrayList<Modelisable>) pr.getData().clone();
		

		pr.updateByIndex(1, 1, "groupe 2");
		
		array.get(1).set(1, "groupe 2");
		

		
		assertEquals("Affiche : " +array, array, pr.getData());
		
	}

	protected abstract Modelisable[] getModelisables();
	protected abstract PanelController getController();
	
	public static void main(String[] args) {
		
	}

}
