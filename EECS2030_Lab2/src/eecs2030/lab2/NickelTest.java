package eecs2030.lab2;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NickelTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(5);

	@Test
	public void test01_ctor() {
		for (int year = 1858; year < 2019; year++) {
			Nickel n = new Nickel(year);
			int exp = year;
			int got = n.issueYear();
			String error = String.format("Nickel(%s) failed to set the issue year correctly", year);
			assertEquals(error, exp, got);
		}
	}

	@Test
	public void test02_ctorThrows() {
		final int[] BAD_YEARS = { -10000, 0, 1857 };
		for (int badYear : BAD_YEARS) {
			try {
				new Nickel(badYear);
				String error = String.format("Nickel(%s) failed to throw an exception", badYear);
				fail(error);
			} catch (IllegalArgumentException x) {
				// ok
			} catch (Exception x) {
				fail("wrong type of exception thrown");
			}
		}
	}

	@Test
	public void test03_compareToLessThan() {
		// tests cases where x.compareTo(y) should return a negative int

		final int[] THIS_YEAR = { 1859, 1900, 2019 };
		for (int thisYr : THIS_YEAR) {
			// try every year greater than thisYr up to 2100
			Nickel x = new Nickel(thisYr);
			for (int difference = 1; (thisYr + difference) <= 2100; difference++) {
				final int otherYr = thisYr + difference;
				Nickel y = new Nickel(otherYr);
				String error = String.format("(nickel with year %s).compareTo(nickel with year %s) failed", thisYr,
						otherYr);
				final int exp = -difference;
				final int got = x.compareTo(y);
				assertEquals(error, exp, got);
			}
		}
	}

	@Test
	public void test04_compareToGreaterThan() {
		// tests cases where x.compareTo(y) should return a positive int

		final int[] THIS_YEAR = { 1859, 1900, 2019 };
		for (int thisYr : THIS_YEAR) {
			// try every year less than thisYr down to 1858
			Nickel x = new Nickel(thisYr);
			for (int difference = 1; (thisYr - difference) >= 1858; difference++) {
				final int otherYr = thisYr - difference;
				Nickel y = new Nickel(otherYr);
				String error = String.format("(nickel with year %s).compareTo(nickel with year %s) failed", thisYr,
						otherYr);
				final int exp = difference;
				final int got = x.compareTo(y);
				assertEquals(error, exp, got);
			}
		}
	}

	@Test
	public void test05_compareToEquals() {
		// tests cases where x.compareTo(y) should return 0

		for (int thisYr = 1858; thisYr <= 2100; thisYr++) {
			Nickel x = new Nickel(thisYr);
			final int otherYr = thisYr;
			Nickel y = new Nickel(otherYr);
			String error = String.format("(nickel with year %s).compareTo(nickel with year %s) failed", thisYr,
					otherYr);
			final int exp = 0;
			final int got = x.compareTo(y);
			assertEquals(error, exp, got);
		}
	}

	@Test
	public void test06_equalsSelf() {
		CommonTests.test_equalsSelf(new Nickel(1858));
		CommonTests.test_equalsSelf(new Nickel(1900));
		CommonTests.test_equalsSelf(new Nickel(1986));
		CommonTests.test_equalsSelf(new Nickel(2017));
	}

	@Test
	public void test07_equalsNull() {
		CommonTests.test_equalsNull(new Nickel(1858));
		CommonTests.test_equalsNull(new Nickel(1900));
		CommonTests.test_equalsNull(new Nickel(1986));
		CommonTests.test_equalsNull(new Nickel(2017));
	}

	@Test
	public void test08_equalsOtherClass() {
		CommonTests.test_equalsOtherClass(new Nickel(1858));
		CommonTests.test_equalsOtherClass(new Nickel(1901));
		CommonTests.test_equalsOtherClass(new Nickel(1973));
		CommonTests.test_equalsOtherClass(new Nickel(2018));
	}


	@Test
	public void test09_equals() {
		for (int thisYr = 1858; thisYr <= 2100; thisYr++) {
			Nickel x = new Nickel(thisYr);

			// try every year
			for (int otherYr = 1858; otherYr <= 2100; otherYr++) {
				Nickel y = new Nickel(otherYr);
				String error = String.format("(nickel with year %s).equals(nickel with year %s) failed", thisYr,
						otherYr);
				final boolean exp = true;
				boolean got = x.equals(y);
				assertEquals(error, exp, got);

				got = y.equals(x);
				assertEquals(error, exp, got);
			}
		}
	}
}
