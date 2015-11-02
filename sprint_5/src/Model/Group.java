package Model;

import java.util.ArrayList;

/**
 * Group class that represents a group and contains the group ID 
 * as well as the attributed subject for this group
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class Group extends Modelisable {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((attributedSubject == null) ? 0 : attributedSubject
						.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
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
		Group other = (Group) obj;
		if (attributedSubject == null) {
			if (other.attributedSubject != null)
				return false;
		} else if (!attributedSubject.equals(other.attributedSubject))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		return true;
	}

	private String groupId;
	private String attributedSubject = "NA";
	//private ArrayList<Wish> wishes;

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", attributedSubject="
				+ attributedSubject + "]";
	}

	/**
	 * Create a group with his group ID
	 * @param groupId Group ID which define the group
	 */
	public Group(String groupId) {
		this.groupId = groupId;
	}
	
	/* (non-Javadoc)
	 * @see Model.Modelisable#toArray()
	 */
	@Override
	public Object[] toArray() {
		Object[] array = { groupId, attributedSubject };
		return array;
	}

	/* (non-Javadoc)
	 * @see Model.Modelisable#toStringArray()
	 */
	@Override
	public String[] toStringArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see Model.Modelisable#set(int, java.lang.String)
	 */
	@Override
	public void set(int i, String change) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see Model.Modelisable#toCSV()
	 */
	@Override
	public String toCSV() {
		// TODO Auto-generated method stub
		return null;
	}

}
