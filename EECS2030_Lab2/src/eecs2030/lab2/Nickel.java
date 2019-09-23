package eecs2030.lab2;

import java.util.Objects;

/**
 * @author krish I like pancakes
 */
public class Nickel implements Comparable<Nickel> {

	private int year;
	/**
	 * The monetary value of a nickel in cents.
	 */
	public final int CENTS = 5;

	/**
	 * @pre. Initializes this nickel to have the specified issue year.
	 * 
	 * @param year the year this coin was issued in
	 * @throws IllegalArgumentException if year is less than 1858
	 */
	public Nickel(int year) {
		if (year < 1858) {
			throw new IllegalArgumentException();
		}
		this.year = year;
	}

	/**
	 * Returns the issue year of this coin.
	 * 
	 * @return the issue year of this coin
	 */
	public int issueYear() {
		return this.year;
	}

	/**
	 * Compares this nickel to another nickel by their issue year. The result is a
	 * negative integer if this nickel has an earlier issue year than the other
	 * nickel, a positive integer if this nickel has a later issue year than the the
	 * other nickel, and zero otherwise. Specifically, this method returns the
	 * difference of the issue year of this nickel and the issue year of the other
	 * nickel.
	 * 
	 * @return the difference of the issue year of this nickel and the issue year of
	 *         the other nickel
	 */
	public int compareTo(Nickel other) {
		return this.year - other.year;
	}

	/**
	 * Compares this nickel to the specified object for equality. The result is true
	 * if obj is a nickel. The issue year is not considered when comparing two
	 * nickels for equality.
	 * 
	 * @return true if obj is a nickel
	 */
	// this.class should work as well i think
	public boolean equals(Object obj) {
		/*
		 * return ((Nickel.class == obj.getClass()) && (obj != null)); IMPORTANT AF^^^^
		 * this doesn't work b/c once u put null into the damn code it crashes the
		 * thing, so always put null at the front
		 */
		return (obj != null) && (Nickel.class == obj.getClass());

	}
	/*
	 * OTHER WAY OF DOING THE ABOVE EQUALS METHOD public boolean equals(Object obj)
	 * { boolean eq; if(obj == null) { return false; } return Nickel.class ==
	 * obj.getClass(); }
	 */

	/**
	 * Returns a hash code for this nickel. Specifically, this method returns the
	 * issue year of this nickel.
	 * 
	 * @return the issue year of this nickel
	 */
	public int hashCode() {
		return Objects.hash(this.year);
	}
}
