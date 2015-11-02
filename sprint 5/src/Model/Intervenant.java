package Model;

import java.io.IOException;
import java.util.ArrayList;

import Utilitaires.CSV;

/**
 * The Intervenant class is a model of a tutor which will be assigned as a PTUT
 * project.
 * 
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class Intervenant extends Modelisable {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Intervenant other = (Intervenant) obj;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Intervenant [nom=" + nom + ", prenom=" + prenom + ", id=" + id
				+ "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public Object[] toArray() {
		Object[] array = { id, prenom, nom };
		return array;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Model.Modelisable#toStringArray()
	 */
	public String[] toStringArray() {
		String[] array = { id, prenom, nom };
		return array;
	}

	/**
	 * This constructor creates an Intervenant Object with an Id, a name and a
	 * surname.
	 * 
	 * @param id
	 *            the tutor's Id
	 * @param prenom
	 *            the tutor's surname
	 * @param nom
	 *            the tutor's name
	 */
	public Intervenant(String id, String prenom, String nom) {
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see Model.Modelisable#set(int, java.lang.String)
	 */
	@Override
	public void set(int i, String change) {
		// TODO Auto-generated method stub
		switch (i) {
		case 1:
			prenom = change;
			break;
		case 2:
			nom = change;
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
		return this.id + ";" + this.nom + ";" + this.prenom;
	}
}
