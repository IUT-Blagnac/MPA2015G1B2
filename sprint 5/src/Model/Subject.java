package Model;

/**
 * The Subject class is a model of a subject from the PTUT unit 
 * 
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class Subject extends Modelisable {

	private String id;
	private String nom;
	private String titre;

	/**The constructor create an Object Subject with an Id, a Name and a title
	 * @param pId Subject's Id
	 * @param pNom Subject's name
	 * @param pTitre Subject's title
	 */
	public Subject(String pId, String pNom, String pTitre) {
		this.id = pId;
		this.nom = pNom;
		this.titre = pTitre;
	}
	
	/* (non-Javadoc)
	 * @see Model.Modelisable#toArray()
	 */
	public Object[] toArray() {
		Object[] array = { id, nom, titre };
		return array;
	}
	
	@Override
	public String toString() {
		return "Subject [id=" + id + ", nom=" + nom + ", titre=" + titre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		Subject other = (Subject) obj;
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
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see Model.Modelisable#toStringArray()
	 */
	@Override
	public String[] toStringArray() {
		String[] array = { id, nom, titre };
		return array;
	}
	
	/* (non-Javadoc)
	 * @see Model.Modelisable#set(int, java.lang.String)
	 */
	public void set(int i, String change) {
		switch (i) {
		case 1:
			nom = change;
			break;
		case 2:
			titre = change;
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
		return this.id + ";" + this.nom + ";" + this.titre;
	}

}
