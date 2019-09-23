package eecs2030.lab2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CardTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(5);

	private static final List<Card> DECK = new ArrayList<Card>();
	static {
		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				DECK.add(new Card(r, s));
			}
		}
	}

	@Test
	public void test01_compareToLessThan() {
		// tests cases where x.compareTo(y) should return -1
		for (int i = 0; i < DECK.size() - 1; i++) {
			Card x = DECK.get(i);
			for (int j = i + 1; j < DECK.size(); j++) {
				Card y = DECK.get(j);
				String error = String.format("(%s).compareTo(%s) failed to return -1", x, y);
				final int exp = -1;
				final int got = x.compareTo(y);
				assertEquals(error, exp, got);
			}
		}
	}

	@Test
	public void test02_compareToGreaterThan() {
		// tests cases where x.compareTo(y) should return 1
		for (int i = 1; i < DECK.size(); i++) {
			Card x = DECK.get(i);
			for (int j = 0; j < i; j++) {
				Card y = DECK.get(j);
				String error = String.format("(%s).compareTo(%s) failed to return 1", x, y);
				final int exp = 1;
				final int got = x.compareTo(y);
				assertEquals(error, exp, got);
			}
		}
	}

	@Test
	public void test03_compareToEquals() {
		// tests cases where x.compareTo(y) should return 0
		for (int i = 0; i < DECK.size(); i++) {
			Card x = DECK.get(i);
			Card y = new Card(x.rank(), x.suit());
			String error = String.format("(%s).compareTo(%s) failed to return 0", x, y);
			final int exp = 0;
			final int got = x.compareTo(y);
			assertEquals(error, exp, got);
		}
	}
	
	@Test
	public void test04_equalsSelf() {
		CommonTests.test_equalsSelf(new Card(Rank.TWO, Suit.HEARTS));
		CommonTests.test_equalsSelf(new Card(Rank.NINE, Suit.CLUBS));
		CommonTests.test_equalsSelf(new Card(Rank.QUEEN, Suit.DIAMONDS));
		CommonTests.test_equalsSelf(new Card(Rank.ACE, Suit.SPADES));
	}
	
	@Test
	public void test05_equalsNull() {
		CommonTests.test_equalsNull(new Card(Rank.TWO, Suit.HEARTS));
		CommonTests.test_equalsNull(new Card(Rank.NINE, Suit.CLUBS));
		CommonTests.test_equalsNull(new Card(Rank.QUEEN, Suit.DIAMONDS));
		CommonTests.test_equalsNull(new Card(Rank.ACE, Suit.SPADES));
	}
	
	@Test
	public void test06_equalsOtherClass() {
		CommonTests.test_equalsOtherClass(new Card(Rank.TWO, Suit.HEARTS));
		CommonTests.test_equalsOtherClass(new Card(Rank.NINE, Suit.CLUBS));
		CommonTests.test_equalsOtherClass(new Card(Rank.QUEEN, Suit.DIAMONDS));
		CommonTests.test_equalsOtherClass(new Card(Rank.ACE, Suit.SPADES));
	}
	
	@Test
	public void test07_equalsTrue() {
		// tests each card against itself
		for (int i = 0; i < DECK.size(); i++) {
			Card x = DECK.get(i);
			Card y = new Card(x.rank(), x.suit());
			String error = String.format("(%s).equals(%s) failed to return true", x, y);
			final boolean exp = true;
			final boolean got = x.equals(y);
			assertEquals(error, exp, got);
		}
	}
	
	@Test
	public void test08_equalsfalse() {
		// tests each card against every other card
		for (int i = 0; i < DECK.size(); i++) {
			Card x = DECK.get(i);
			for (int j = 0; j < DECK.size(); j++) {
				if (i == j) {
					continue;
				}
				Card y = DECK.get(j);
				String error = String.format("(%s).equals(%s) failed to return true", x, y);
				final boolean exp = false;
				final boolean got = x.equals(y);
				assertEquals(error, exp, got);
			}
		}
	}
}
