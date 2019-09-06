package eecs2030.lab0;

/**
 * A class that represents a range of values on the real number line. A range
 * has two properties: a <code>minimum</code> value and a <code>maximum</code>
 * value. Range objects always ensure that the following class invariant is
 * true:
 * 
 * <p>
 * <code>minimum &lt;= maximum</code>
 * 
 * <p>
 * The constructors of the class are responsible for ensuring that the above
 * class invariant is always true.
 * 
 * @author EECS2030 Winter 2019-2020
 * 
 */
public class Range {
	private static double DEFAULT_MIN = 0;
	private static double DEFAULT_MAX = 100;

	private double min;
	private double max;

	/**
	 * Create a range with minimum value 0 and a maximum value 100.
	 */
	public Range() {
		this(Range.DEFAULT_MIN, Range.DEFAULT_MAX);
	}

	/**
	 * Create a range with the specified minimum and maximum values.
	 * 
	 * @param min
	 *            the minimum value of the range
	 * @param max
	 *            the maximum value of the range
	 * @throws IllegalArgumentException
	 *             if min is greater than max
	 */
	public Range(double min, double max) {
		if (min > max) {
			throw new IllegalArgumentException("min > max");
		}
		this.min = min;
		this.max = max;
	}

	/**
	 * Returns the minimum value of the range
	 * 
	 * @return the minimum value of the range
	 */
	public double getMinimum() {
		return this.min;
	}

	/**
	 * Returns the maximum value of the range
	 * 
	 * @return the maximum value of the range
	 */
	public double getMaximum() {
		return this.max;
	}

	/**
	 * Returns the string representation of a range. The string contains the
	 * minimum and maximum values separated by a comma and space all inside of a
	 * pair of square brackets. For example, the string
	 * 
	 * <p>
	 * <code>[-3.14, 3.14]</code>
	 * 
	 * <p>
	 * represents the range whose minimum value is <code>-3.14</code> and whose
	 * maximum value is <code>3.14</code>
	 * 
	 * @return a string representation of the range
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.getMinimum() + ", " + this.getMaximum() + "]";
	}

	/**
	 * Returns a hash code for this range.
	 * 
	 * @return a hash code for this range
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(max);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(min);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Compares this <code>Range</code> to the specified <code>Object</code>.
	 * The result is true if and only if the argument is a <code>Range</code>
	 * object having the same minimum and maximum value as this object.
	 * 
	 * @param obj
	 *            the object to compare with
	 * @return <code>true</code> if this object is equal to <code>obj</code>;
	 *         <code>false</code> otherwise
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Range other = (Range) obj;
		if (Double.doubleToLongBits(max) != Double.doubleToLongBits(other.max)) {
			return false;
		}
		if (Double.doubleToLongBits(min) != Double.doubleToLongBits(other.min)) {
			return false;
		}
		return true;
	}

}
