/**
 * 
 */
package Controller;

import java.util.ArrayList;

import Model.Modelisable;
import Model.Student;
import Utilitaires.CSV;

/**
 * Controller class for Student and PanelStudent class
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class StudentController extends PanelController {

	/**
	 * Constructor fot the StudentController class
	 */
	public StudentController() {
		super("data\\etudiants2014_2015.csv");
	}

	/* (non-Javadoc)
	 * @see Controller.PanelController#buildData()
	 */
	@Override
	protected void buildData() {
		for(String[] entry : CSV.read(this.filepath)) {
			this.data.add(new Student(entry[0], entry[1], entry[2], entry[3]));
		}
	}
	
	/* (non-Javadoc)
	 * @see Controller.PanelController#addDataById(java.lang.String)
	 */
	@Override
	public void addDataById(String id) {
		data.add(new Student(" ", id, " ", " "));
	}
	
	/**
	 * Stocks the students which are not attributed to a group
	 * @return The List of students which are not attributed to a group
	 */
	public ArrayList<Student> getLoneStudents(){
		ArrayList<Student> loneStudents = new ArrayList<Student>();
		for (Modelisable stu : this.data) {
			if (((String) stu.toArray()[3]).equals(" ") || ((String) stu.toArray()[3]).equals("")){
				loneStudents.add((Student) stu);
			}
		}
		return loneStudents;
	}
	/**
	 * @return the list of group already created.
	 */
	public ArrayList<String> getAllGroups() {
		ArrayList<String> groups = new ArrayList<String>();
		for(Modelisable student : this.data) {
			if (!groups.contains(student.toStringArray()[0]) && !student.toStringArray()[0].equals(" ")) {
				groups.add(student.toStringArray()[0]);
			}
		}
		return groups;
	}
	/**
	 * @return the student corresponding to the id.
	 */
	public Student getStudentById(String id) {
		System.out.println(id);
		System.out.println(this.data);
		for(Modelisable student : this.data) {
			if(student.toStringArray()[1].equals(id)) {
				System.out.println(student.toStringArray()[1]);
				return (Student) student;
			}
		}
		return null;
	}
}
