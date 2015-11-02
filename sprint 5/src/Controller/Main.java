/**
 * 
 */
package Controller;

import javax.swing.JFrame;

import View.AddGroupPopUp;
import View.Home;

/**
 * Main class for the project.
 * Builds all the view frame and all the controller.
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class Main {
	public static JFrame frame;
	
	public static void main(String[] args) {
		
		PanelController inte = new IntervenantController();
		PanelController proj = new ProjectController();
		PanelController stud = new StudentController();
		PanelController subj = new SubjectController();
		PanelController grou = new GroupController();
		AuthentificationController auth = new AuthentificationController();
		
		AddGroupPopUp.setController((StudentController)stud);
		
		Main.frame = new Home.Builder()
			.intervenantController(inte)
			.projectController(proj)
			.studentController(stud)
			.subjectController(subj)
			.groupController(grou)
			.authentificationController(auth)
			.build();

	}

}
