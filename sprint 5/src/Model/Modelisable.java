package Model;

/**
 * Modelisable is an abstract class that passes <br>
 * methods to return the field as an Object array <br>
 * @author Groupe 1B2
 * @version Sprint 4 <br>
 */
public abstract class Modelisable {
	
	/**
	 * Returns an array of Objects which contains the class fields.
	 * @return An array of Objects.
	 */
	public abstract Object[] toArray();
	
	/**
	 * Returns an array of Strings which contains the class fields.
	 * @return An array of Strings.
	 */
	public abstract String[] toStringArray();
	
	/**
	 * Modify a field depending on the rank i into a String change
	 * @param i rank which select the field to change
	 * @param change new value of the field
	 */
	public abstract void set(int i, String change);
	
	/**
	 * @return csv representation of the object.
	 */
	public abstract String toCSV();
}
