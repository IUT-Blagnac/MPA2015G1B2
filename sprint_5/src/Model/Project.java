package Model;

/**
 * The Project class is a model of a project which will contain <br>
 * Intervenant, Students and Subjects objects.
 * 
 * @see Modelisable
 * 
 * @author Groupe 1B2
 * @version Sprint 4
 *
 */
public class Project extends Modelisable {

	private String id;
	private String group;
	private String sujet;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sujet == null) ? 0 : sujet.hashCode());
		result = prime * result
				+ ((superviseur == null) ? 0 : superviseur.hashCode());
		result = prime * result + ((support == null) ? 0 : support.hashCode());
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
		Project other = (Project) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
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
		if (sujet == null) {
			if (other.sujet != null)
				return false;
		} else if (!sujet.equals(other.sujet))
			return false;
		if (superviseur == null) {
			if (other.superviseur != null)
				return false;
		} else if (!superviseur.equals(other.superviseur))
			return false;
		if (support == null) {
			if (other.support != null)
				return false;
		} else if (!support.equals(other.support))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", group=" + group + ", sujet=" + sujet
				+ ", superviseur=" + superviseur + ", support=" + support
				+ ", client=" + client + "]";
	}

	private String superviseur;
	private String support;
	private String client;

	/**
	 * This constructor creates a Project Object with an Id, a group, a subject, <br>
	 * a customer, a supervisor and a support. surname.
	 * 
	 * @param id
	 *            Project's Id
	 * @param group
	 *            Project's group
	 * @param sujet
	 *            Project's subject
	 * @param client
	 *            Project's customer
	 * @param superviseur
	 *            Project's supervisor
	 * @param support
	 *            Project's support
	 */
	public Project(String id, String group, String sujet, String client,
			String superviseur, String support) {

		this.id = id;
		this.group = group;
		this.sujet = sujet;
		this.superviseur = superviseur;
		this.support = support;
		this.client = client;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Model.Modelisable#toArray()
	 */
	public Object[] toArray() {
		Object[] array = { id, group, sujet, client, superviseur, support };
		return array;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Model.Modelisable#toStringArray()
	 */
	@Override
	public String[] toStringArray() {
		String[] array = { id, group, sujet, client, superviseur, support };
		return array;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Model.Modelisable#set(int, java.lang.String)
	 */
	public void set(int i, String change) {
		switch (i) {
		case 1:
			group = change;
			break;
		case 2:
			sujet = change;
			break;
		case 3:
			superviseur = change;
			break;
		case 4:
			support = change;
			break;
		case 5:
			client = change;
			break;
		default:
			System.out.println("This is not gonna happening !");
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Model.Modelisable#toCSV()
	 */
	@Override
	public String toCSV() {
		return this.id + ";" + this.group + ";" + this.sujet + ";"
				+ this.client + ";" + this.superviseur + ";" + this.support;
	}

}
