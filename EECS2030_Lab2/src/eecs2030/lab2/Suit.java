package eecs2030.lab2;

import eecs2030.lab2.Colour;

/**
 * The four suits of cards in a standard 52-card French deck. This
 * enumeration orders the suits in ascending alphabetical order;
 * the suits in order from "smallest" suit to "greatest" suit is:
 * 
 * <ul>
 * <li><code>CLUBS</code>
 * <li><code>DIAMONDS</code>
 * <li><code>HEARTS</code>
 * <li><code>SPADES</code>
 * </ul>
 *
 */
public enum Suit {
	/**
	 * The black suit clubs.
	 */
	CLUBS(Colour.BLACK),
	
	/**
	 *  The red suit diamonds.
	 */
	DIAMONDS(Colour.RED),
	
	/**
	 * The red suit hearts.
	 */
	HEARTS(Colour.RED),
	
	/**
	 * The black suit spades.
	 */
	SPADES(Colour.BLACK);
	
	private Colour color;
	
	private Suit(Colour c) {
		this.color = c;
	}
	
	/**
	 * Returns the color of this suit.
	 * 
	 * @return the color of this suit
	 */
	public Colour color() {
		return this.color;
	}
}
