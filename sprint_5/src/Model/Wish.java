package Model;

/**
 * Class that represents the wishes from a group
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class Wish extends Modelisable {

	private String id;
	private String nom;
	private String titre;
	private String voeu;

	/**The constructor create an Object Wish with an Id, a Name, a title and an order
	 * @param pId Subject's Id
	 * @param pNom Subject's name
	 * @param pTitre Subject's title
	 * @param pVoeu position number of Subject's wish
	 */
	public Wish(String pId, String pNom, String pTitre, String pVoeu) {
		this.id = pId;
		this.nom = pNom;
		this.titre = pTitre;
		this.voeu = pVoeu;
	}
	
	/* (non-Javadoc)
	 * @see Model.Modelisable#toArray()
	 */
	public Object[] toArray() {
		Object[] array = { id, nom, titre, voeu };
		return array;
	}
	
	@Override
	public String toString() {
		return "Wish [id=" + id + ", nom=" + nom + ", titre=" + titre + ", voeu=" + voeu + "]";
	}

	/* (non-Javadoc)
	 * @see Model.Modelisable#toStringArray()
	 */
	@Override
	public String[] toStringArray() {
		String[] array = { id, nom, titre, voeu };
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
		case 3:
			voeu = change;
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
		return this.id + ";" + this.nom + ";" + this.titre + ";" + this.voeu;
	}

}

