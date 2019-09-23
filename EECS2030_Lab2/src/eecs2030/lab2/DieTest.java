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
public class DieTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(5);

	@Test
	public void test01_ctorFaces() {
		// tests that the constructor initializes the faces correctly
		Die d = new Die();
		for (int face = 0; face < 6; face++) {
			d.setValueToFace(face);
			final int exp = face + 1;
			final int got = d.value();
			String error = String.format("face %s has the wrong value", face);
			assertEquals(error, exp, got);
		}
	}

	@Test
	public void test02_ctorValue() {
		// tests that the constructor initializes the value correctly
		Die d = new Die();
		final int exp = 1;
		final int got = d.value();
		assertEquals("new Die() failed to set the die value correctly", exp, got);
	}

	@Test
	public void test03_compareToLessThan() {
		// tests cases where x.compareTo(y) should return -1
		final int[] X = { -1, -1, 2, 2, 7, 8 };
		final int[] Y = { 9, 10, 11, 12, 13, 14 };
		Die x = new Die(X);
		Die y = new Die(Y);
		for (int i = 0; i < 6; i++) {
			x.setValueToFace(i);
			for (int j = 0; j < 6; j++) {
				y.setValueToFace(j);

				String error = String.format(
						"(die with value %s).compareTo(die with value %s) should return a negative int", X[i], Y[j]);
				assertTrue(error, x.compareTo(y) < 0);
			}
		}
	}

	@Test
	public void test04_compareToGreaterThan() {
		// tests cases where x.compareTo(y) should return -1
		final int[] X = { 9, 10, 11, 12, 13, 14 };
		final int[] Y = { -1, -1, 2, 2, 7, 8 };
		Die x = new Die(X);
		Die y = new Die(Y);
		for (int i = 0; i < 6; i++) {
			x.setValueToFace(i);
			for (int j = 0; j < 6; j++) {
				y.setValueToFace(j);

				String error = String.format(
						"(die with value %s).compareTo(die with value %s) should return a positive int", X[i], Y[j]);
				assertTrue(error, x.compareTo(y) > 0);
			}
		}
	}

	@Test
	public void test05_compareToEquals() {
		// tests cases where x.compareTo(y) should return 0
		final int[] X = { 9, 10, 11, 12, 13, 14 };
		final int[] Y = X;
		Die x = new Die(X);
		Die y = new Die(Y);
		for (int i = 0; i < 6; i++) {
			x.setValueToFace(i);
			y.setValueToFace(i);
			String error = String.format("(die with value %s).compareTo(die with value %s) should return 0", X[i],
					Y[i]);
			assertEquals(error, 0, x.compareTo(y));

		}
	}

	private static final List<Card> DECK = new ArrayList<Card>();
	static {
		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				DECK.add(new Card(r, s));
			}
		}
	}

	@Test
	public void test06_equalsSelf() {
		CommonTests.test_equalsSelf(new Die());
		final int[] X = { -1, -1, 1, 1, 2, 2 };
		final int[] Y = { 0, 1, 2, 10, 11, 12 };
		final int[] Z = { 2, 4, 6, 8, 10, 12 };
		CommonTests.test_equalsSelf(new Die(X));
		CommonTests.test_equalsSelf(new Die(Y));
		CommonTests.test_equalsSelf(new Die(Z));
	}

	@Test
	public void test07_equalsNull() {
		CommonTests.test_equalsNull(new Die());
		final int[] X = { -1, -1, 1, 1, 2, 2 };
		final int[] Y = { 0, 1, 2, 10, 11, 12 };
		final int[] Z = { 2, 4, 6, 8, 10, 12 };
		CommonTests.test_equalsNull(new Die(X));
		CommonTests.test_equalsNull(new Die(Y));
		CommonTests.test_equalsNull(new Die(Z));
	}

	@Test
	public void test08_equalsOtherClass() {
		CommonTests.test_equalsOtherClass(new Die());
		final int[] X = { -1, -1, 1, 1, 2, 2 };
		final int[] Y = { 0, 1, 2, 10, 11, 12 };
		final int[] Z = { 2, 4, 6, 8, 10, 12 };
		CommonTests.test_equalsOtherClass(new Die(X));
		CommonTests.test_equalsOtherClass(new Die(Y));
		CommonTests.test_equalsOtherClass(new Die(Z));
	}

	@Test
	public void test09_equalsTrue() {
		// tests if two dice with the same faces and identical values are equal
		final int[] X = { 2, 4, 6, 8, 10, 12 };
		final int[] Y = X;
		Die x = new Die(X);
		Die y = new Die(Y);
		for (int i = 0; i < 6; i++) {
			x.setValueToFace(i);
			y.setValueToFace(i);
			String error = String.format("two dice with the same faces and value %s should be equal", X[i]);
			final boolean exp = true;
			final boolean got = x.equals(y);
			assertEquals(error, exp, got);
		}
	}

	@Test
	public void test10_equalsFalse() {
		// tests if two dice with the same faces but different values are not
		// equal

		final int[] X = { 2, 4, 6, 8, 10, 12 };
		final int[] Y = X;
		Die x = new Die(X);
		Die y = new Die(Y);
		for (int i = 0; i < 6; i++) {
			x.setValueToFace(i);
			y.setValueToFace((i + 3) % 6);
			String error = String.format("(die with value %s).equals(die with value %s) should return false", x.value(),
					y.value());
			final boolean exp = false;
			final boolean got = x.equals(y);
			assertEquals(error, exp, got);
		}
	}

	@Test
	public void test11_equalsFalse() {
		// tests if two dice with different faces are not equal

		final int[] X = { 2, 4, 6, 8, 10, 12 };
		final int[] Y = { 1, 4, 6, 8, 10, 12 };
		Die x = new Die(X);
		Die y = new Die(Y);
		for (int i = 0; i < 6; i++) {
			x.setValueToFace(i);
			for (int j = 0; j < 6; j++) {
				y.setValueToFace(j);
				String error = String.format("two dice with different faces are never equal");
				final boolean exp = false;
				final boolean got = x.equals(y);
				assertEquals(error, exp, got);
			}
		}
	}
}
