package test2;

/**
 * A class that represents Canadian coins.
 *
 */
public class Coin implements Comparable<Coin> {
	/**
	 * A coin representing a Canadian penny.
	 */
	public static final Coin PENNY;
	
	/**
	 * A coin representing a Canadian nickel.
	 */
	public static final Coin NICKEL;
	
	/**
	 * A coin representing a Canadian dime.
	 */
	public static final Coin DIME;
	
	/**
	 * A coin representing a Canadian quarter.
	 */
	public static final Coin QUARTER;
	
	/**
	 * A coin representing a Canadian $1 coin.
	 */
	public static final Coin LOONIE;
	
	/**
	 * A coin representing a Canadian $2 coin.
	 */
	public static final Coin TOONIE;
	
	static {
		PENNY = new Coin(1);
		NICKEL = new Coin(5);
		DIME = new Coin(10);
		QUARTER = new Coin(25);
		LOONIE = new Coin(100);
		TOONIE = new Coin(200);
	}
	
	private int value;
	
	private Coin(int value) {
		this.value = value;
	}
	
	/**
	 * Initializes this coin to have the same value as the
	 * specified coin.
	 * 
	 * @param c a coin
	 */
	public Coin(Coin c) {
		this.value = c.value;
	}
	
	/**
	 * Returns the value of this coin in Canadian cents.
	 * 
	 * @return the value of this coin in Canadian cents
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Returns a hash code for this coin.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	/**
	 * Compares this coin to another coin returning true if and
	 * only if the specified object is a Coin with the same 
	 * value as this coin.
	 * 
	 * @param obj the object to compare to this coin
	 * @return true if obj is a coin with the same value as this
	 * coin, and false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coin other = (Coin) obj;
		if (value != other.value)
			return false;
		return true;
	}

	/**
	 * Returns a string describing this coin. The returned
	 * string is one of <code>"penny", "nickel", "dime",
	 * "quarter", "loonie", "twoonie"</code>.
	 * 
	 * @return a string representation of this coin
	 */
	@Override
	public String toString() {
		switch (this.value) {
		case 1:
			return "penny";
		case 5:
			return "nickel";
		case 10:
			return "dime";
		case 25:
			return "quarter";
		case 100:
			return "loonie";
		case 200:
			return "toonie";
		}
		return "";
	}

	/**
	 * Compares this coin to the specified coin. The result
	 * is the equal to the difference
	 * <code>this.getValue() - other.getValue()</code>. 
	 *  
	 * @param other a coin to compare
	 * @return a positive value if the value of this coin is
	 * greater than the value of the other coin,
	 * a positive value if the value of this coin is
	 * greater than the value of the other coin,
	 * or zero if the coins have equal value.
	 */
	@Override
	public int compareTo(Coin other) {
		return this.value - other.value;
	}
}
