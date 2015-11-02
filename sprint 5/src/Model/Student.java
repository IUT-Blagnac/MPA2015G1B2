package Model;

import java.io.IOException;
import java.util.ArrayList;

import Utilitaires.CSV;

/**
 * The Student class is a model of a student of a PTUT Project.
 * 
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class Student extends Modelisable {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	private String nom;
	private String prenom;
	private String id;
	private String group;

	@Override
	public String toString() {
		return "Student [nom=" + nom + ", prenom=" + prenom + ", id=" + id
				+ ", group=" + group + "]";
	}

	/* (non-Javadoc)
	 * @see Model.Modelisable#toArray()
	 */
	public Object[] toArray() {
		Object[] array = { id, prenom, nom, group };
		return array;
	}

	/* (non-Javadoc)
	 * @see Model.Modelisable#toStringArray()
	 */
	public String[] toStringArray() {
		String[] array = { group, id, nom, prenom };
		return array;
	}
	
	/**
	 * Create a student with a group, an id, a name and a surname
	 * @param group student's group
	 * @param id student's id
	 * @param nom student's name
	 * @param prenom student's surname
	 */
	public Student(String group, String id, String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
		this.group = group;
	}
	
	/* (non-Javadoc)
	 * @see Model.Modelisable#set(int, java.lang.String)
	 */
	public void set(int i, String change) {
		switch (i) {
		case 1:
			prenom = change;
			break;
		case 2:
			nom = change;
			break;
		case 3:
			group = change;
			break;

		default:
			System.out.println("This is not gonna happening !");
			break;
		}
	}

	/* (non-Javadoc)
	 * @see Model.Modelisable#toCSV()
	 */
	@Override
	public String toCSV() {
		return this.group + ";" + this.id + ";" + this.nom + ";" + this.prenom;
	}

}
