package Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import Controller.PanelController;
import Controller.ProjectController;
import Model.Modelisable;
import Model.Project;


/**
 * 
 * The projectControllerTest is the test class corresponding to the projectController class
 * @author Groupe 1B2
 * @version Sprint 4 <br>
 */
public class projectControllerTest extends CustomControllerTest {

	public void test_save() {
		super.test_save();
	}
	
	public void test_add() {
		super.test_add();
	}
	
	public void test_remove() {
		super.test_remove();
	}
	
	public void test_update() {
		super.test_update();
	}

	@Override
	protected Modelisable[] getModelisables() {
		Modelisable[] retour = {new Project("id", "group", "sujet", "client", "superviseur", "support")};
		return retour ;
	}

	@Override
	protected PanelController getController() {
		return new ProjectController();
	}
	public static void main(String[] args) {

		System.out.println("Tests en cours ...");
		junit.textui.TestRunner.run(new TestSuite(
				projectControllerTest.class));

	}

}
