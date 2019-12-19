package test2;

/**
 * An owner of some item. Every owner has a name and a unique
 * <code>long</code> identification number.
 *
 */
public class Owner {
	private static long ID = 1000;
	private String name;
	private long id;
	
	/**
	 * Initialize this owner to have the given name. A unique
	 * identification number is assigned to this owner.
	 * 
	 * @param name the non-null name of this owner
	 */
	public Owner(String name) {
		this.name = name;
		this.id = Owner.ID++;
	}
	
	/**
	 * Returns the unique identification number assigned to this owner.
	 * 
	 * @return the unique identification number assigned to this owner
	 */
	public long getID() {
		return this.id;
	}
	
	/**
	 * Returns the name of this owner.
	 * 
	 * @return the name of this owner
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns a hash code for this owner.
	 * 
	 * @return a hash code for this owner
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	/**
	 * Compares two owners for equality. Returns true if obj is
	 * a non-null owner reference having an identification number equal
	 * to the identification number of this owner, and false otherwise.
	 * 
	 * @return true if obj is
	 * a non-null owner reference having an identification number equal
	 * to the identification number of this owner, and false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Owner other = (Owner) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns a string representation of this owner. The string
	 * contains the name and id of this owner.
	 * 
	 * @return a string representation of this owner
	 */
	@Override
	public String toString() {
		return this.name + "(" + this.id + ")";
	}
}
