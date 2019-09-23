package eecs2030.lab2;

import java.util.Objects;

/*
 * NOTE TO STUDENTS: The two methods you need to complete can 
 * be found at the end of this file.
 */

public class Card implements Comparable<Card> {

	/**
	 * The rank of this card.
	 */
	private Rank rank;

	/**
	 * The suit of this card.
	 */
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		if (rank == null || suit == null) {
			throw new NullPointerException();
		}
		this.rank = rank;
		this.suit = suit;
	}

	public Rank rank() {
		return this.rank;
	}

	public Suit suit() {
		return this.suit;
	}

	public Colour color() {
		return this.suit.color();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.rank, this.suit);
	}

	@Override
	public String toString() {
		return this.rank + " of " + this.suit;
	}

	/*
	 * You need to implement the compareTo and equals methods below.
	 * 
	 * For compareTo, you may compare ranks using the compareTo method found in the
	 * Rank class. You may compare suits using the compareTo method found in the
	 * Suit class.
	 */

	@Override
	/* rank of suits are: #1 spades, hearts, diamonds , clubs #4 */
	public int compareTo(Card other) {
		int ranknum = (this.rank).compareTo(other.rank());

		if (ranknum < 0) {
			return -1;
		} else if (ranknum > 0) {
			return 1;
		}

		int suitnum = (this.suit).compareTo(other.suit());
//	int ranknum = other.rank().compareTo(this.rank());
//	int colournum = other.suit().compareTo(this.suit());

//	
//	System.out.println("ranknum: "+ranknum);
//	System.out.println("colournum: "+ colournum);
//	
		if (suitnum < 0) {
			return -1;
		} else if (suitnum > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		//first checks if object is null, and checks using or; that if obj is a card
		// if it isn't than return false
		if (obj == null || obj.getClass() != Card.class) {
			return false;
		// casts card to object and then uses compareTo class to check if the rank and suit are the same
		} else if (compareTo((Card) obj) == 0) {
			return true;
		}
		return false;
	}

}
