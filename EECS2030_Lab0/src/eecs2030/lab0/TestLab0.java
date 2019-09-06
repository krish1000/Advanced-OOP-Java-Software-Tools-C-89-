package eecs2030.lab0;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLab0 {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(2);

	private static Random rng = new Random();

	@Test
	public void test01_maxInt() {
		assertEquals(Integer.MAX_VALUE, Lab0.maxInt());
	}

	@Test
	public void test02_minDouble() {
		assertEquals(0, Double.compare(Double.MIN_VALUE, Lab0.minDouble()));
	}

	@Test
	public void test03_removeLastTwoDigits() {
		final int[] EXPECTED = { 1, 5, 9, 27, 345, 7821 };
		for (Integer exp : EXPECTED) {
			for (int i = 0; i < 100; i++) {
				int n = i + 100 * exp;
				String error = String.format("removeLastTwoDigits(%d) failed", n);
				assertEquals(error, exp.intValue(), Lab0.removeLastTwoDigits(n));
			}
		}
		assertEquals("removeLastTwoDigits(2147483647) failed", 21474836, Lab0.removeLastTwoDigits(Integer.MAX_VALUE));
	}

	@Test
	public void test04_removeLastTwoDigits() {
		for (int n = 0; n < 100; n++) {
			String error = String.format("removeLastTwoDigits(%d) failed", n);
			assertEquals(error, 0, Lab0.removeLastTwoDigits(n));
		}
	}

	@Test
	public void test05_lastTwoDigits() {
		final int[] FIRST_DIGITS = { 0, 1, 5, 9, 27, 345, 7821 };
		for (Integer d : FIRST_DIGITS) {
			for (int exp = 0; exp < 100; exp++) {
				int n = 100 * d + exp;
				String error = String.format("lastTwoDigits(%d) failed", n);
				assertEquals(error, exp, Lab0.lastTwoDigits(n));
			}
		}
		assertEquals("lastTwoDigits(2147483647) failed", 47, Lab0.lastTwoDigits(Integer.MAX_VALUE));
	}

	@Test
	public void test06_avg() {
		rng.setSeed(6);
		for (int i = 0; i < 100; i++) {
			int a = rng.nextInt();
			int b = rng.nextInt();
			double sum = 0.0 + a + b;
			String error = String.format("avg(%d, %d) failed", a, b);
			assertEquals(error, sum, 2.0 * Lab0.avg(a, b), Math.ulp(sum));
		}
	}

	@Test
	public void test07_windChill() {
		final double[] AIR_TEMP = { 0.0, -5.0, -9.0, -12.0, -20.0 };
		final double[] WIND_VEL = { 5.0, 20.0, 25.0, 30.0, 40.0 };
		final double[] WIND_CHILL = { -1.589424, -11.551404, -17.475652, -22.130007, -34.134662 };
		for (int i = 0; i < AIR_TEMP.length; i++) {
			double airT = AIR_TEMP[i];
			double windV = WIND_VEL[i];
			double exp = WIND_CHILL[i];
			String error = String.format("windChill(%f, %f) failed", airT, windV);
			assertEquals(error, exp, Lab0.windChill(airT, windV), 1e-6);
		}
	}

	@Test
	public void test08_isOdd() {
		rng.setSeed(8);
		for (int i = 0; i < 100; i++) {
			int even = 2 * rng.nextInt(Integer.MAX_VALUE / 2);
			int odd = even + 1;
			String error = String.format("isOdd(%d) failed (returned true)", even);
			assertFalse(error, Lab0.isOdd(even));

			error = String.format("isOdd(%d) failed (returned false)", odd);
			assertTrue(error, Lab0.isOdd(odd));
		}
	}

	@Test
	public void test09_isOnUnitCircle() {
		rng.setSeed(9);
		// random points inside the unit circle
		for (int i = 0; i < 100; i++) {
			double radius = rng.nextDouble(); // less than 1
			double radians = 2.0 * Math.PI * i / 100;
			double x = radius * Math.cos(radians);
			double y = radius * Math.sin(radians);
			String error = String.format("isOnUnitCircle(%f, %f) failed (returned true)", x, y);
			assertFalse(error, Lab0.isOnUnitCircle(x, y));
		}
		// random points outside the unit circle
		for (int i = 0; i < 100; i++) {
			double radius = 1.0 + rng.nextDouble() + Math.ulp(1.0); // greater
																	// than 1
			double radians = 2.0 * Math.PI * i / 100;
			double x = radius * Math.cos(radians);
			double y = radius * Math.sin(radians);
			String error = String.format("isOnUnitCircle(%f, %f) failed (returned true)", x, y);
			assertFalse(error, Lab0.isOnUnitCircle(x, y));
		}
		// some points exactly on the unit circle
		final double[] X = { 1.0, 0.0, -1.0, 0.0 };
		final double[] Y = { 0.0, 1.0, 0.0, -1.0 };
		for (int i = 0; i < X.length; i++) {
			double x = X[i];
			double y = Y[i];
			String error = String.format("isOnUnitCircle(%f, %f) failed (returned false)", x, y);
			assertTrue(error, Lab0.isOnUnitCircle(x, y));
		}
	}

	@Test
	public void test10_isInsideUnitSquare() {
		double X[] = { 0.0, 0.3, 0.5, 0.7, 1.0 };
		double Y[] = { 0.0, 0.2, 0.5, 0.8, 1.0 };
		for (double x : X) {
			for (double y : Y) {
				String error = String.format("isInsideUnitSquare(%f, %f) failed (returned false)", x, y);
				assertTrue(error, Lab0.isInsideUnitSquare(x, y));
			}
		}
	}

	@Test
	public void test11_isNotInsideUnitSquare() {
		double X[] = { -100.0, -0.01, 1.01, 100.0 };
		double Y[] = { -6.0, -0.001, 1.001, 7.0 };
		for (double x : X) {
			for (double y : Y) {
				String error = String.format("isInsideUnitSquare(%f, %f) failed (returned true)", x, y);
				assertFalse(error, Lab0.isInsideUnitSquare(x, y));
			}
		}
	}

	@Test
	public void test12_isOutsideUnitSquare() {
		double X[] = { -100.0, -0.01, 1.01, 100.0 };
		double Y[] = { -6.0, -0.001, 1.001, 7.0 };
		for (double x : X) {
			for (double y : Y) {
				String error = String.format("isOutsideUnitSquare(%f, %f) failed (returned false)", x, y);
				assertTrue(error, Lab0.isOutsideUnitSquare(x, y));
			}
		}
	}

	@Test
	public void test13_isNotOutsideUnitSquare() {
		double X[] = { 0.0, 0.3, 0.5, 0.7, 1.0 };
		double Y[] = { 0.0, 0.2, 0.5, 0.8, 1.0 };
		for (double x : X) {
			for (double y : Y) {
				String error = String.format("isOutsideUnitSquare(%f, %f) failed (returned true)", x, y);
				assertFalse(error, Lab0.isOutsideUnitSquare(x, y));
			}
		}
	}

	@Test
	public void test14_flipBit() {
		int x = 0;
		String error = String.format("flipBit(%s) failed", x);
		assertEquals(error, 1, Lab0.flipBit(x));
	}

	@Test
	public void test15_flipBit() {
		int x = 1;
		String error = String.format("flipBit(%s) failed", x);
		assertEquals(error, 0, Lab0.flipBit(x));
	}

	@Test
	public void test16_flipBit_throws() {
		for (int x = -100; x < 0; x++) {
			try {
				Lab0.flipBit(x);
				String error = String.format("flipBit(%s) should have thrown an exception", x);
				fail(error);
			} catch (BadBitException ex) {
				// ok
			} catch (Exception ex) {
				fail("flipBit threw the wrong type of exception");
			}
		}

	}

	@Test
	public void test17_contains() {
		rng.setSeed(13);
		for (int i = 0; i < 100; i++) {
			int min = rng.nextInt(100) - 50;
			int max = min + i;
			this.testOutsideRange(min, max);
			this.testInsideRange(min, max);
		}
	}

	private void testOutsideRange(int min, int max) {
		final double[] X = { Double.NEGATIVE_INFINITY, min - 100.0, min - 1.0, Math.nextAfter(min, min - 1.0), min, max,
				Math.nextAfter(max, max + 1.0), max + 1.0, max + 100.0, Double.POSITIVE_INFINITY };
		Range r = new Range(min, max);
		for (double x : X) {
			String error = String.format("contains(%f, r) failed\n" + "where r = %s\n", x, r);
			assertEquals(error, 0, Lab0.contains(x, r));
		}
	}

	private void testInsideRange(int min, int max) {
		if (min == max) {
			return;
		}
		double xStart = Math.nextAfter(min, min + 1.0);
		double xEnd = Math.nextAfter(max, max - 1.0);
		double step = (xEnd - xStart) / 10;
		double[] X = new double[10];
		X[0] = xStart;
		X[9] = xEnd;
		for (int i = 1; i < 9; i++) {
			X[i] = X[i - 1] + step;
		}
		Range r = new Range(min, max);
		for (double x : X) {
			String error = String.format("contains(%f, r) failed\n" + "where r = %s\n", x, r);
			assertEquals(error, 1, Lab0.contains(x, r));
		}
	}

	@Test
	public void test18_compareTo() {
		rng.setSeed(14);
		for (int i = 0; i < 100; i++) {
			int min = rng.nextInt(100) - 50;
			Range skinny = new Range(min, min + 1);
			min = rng.nextInt(100) - 50;
			Range skinny2 = new Range(min, min + 1);
			min = rng.nextInt(100) - 50;
			Range wide = new Range(min, min + 2);
			String error = String.format("compareTo(r1, r2) failed for r1 = %s, r2 = %s", skinny, skinny);
			assertEquals(error, 0, Lab0.compareTo(skinny, skinny));

			error = String.format("compareTo(r1, r2) failed for r1 = %s, r2 = %s", skinny, skinny2);
			assertEquals(error, 0, Lab0.compareTo(skinny, skinny2));

			error = String.format("compareTo(r1, r2) failed for r1 = %s, r2 = %s", skinny, wide);
			assertEquals(error, -1, Lab0.compareTo(skinny, wide));

			error = String.format("compareTo(r1, r2) failed for r1 = %s, r2 = %s", wide, skinny);
			assertEquals(error, 1, Lab0.compareTo(wide, skinny));
		}
	}

	@Test
	public void test19_getCourseName() {
		assertEquals("getCourseName() failed", "Advanced Object Oriented Programming", Lab0.getCourseName());
	}

	@Test
	public void test20_toString() {
		String exp = "range from -10.00000001 to 9253.353156731684";
		Range r = new Range(-10.00000001, 9253.353156731684);
		String error = String.format("toString(r) failed for r = %s", r.toString());
		assertEquals(error, exp, Lab0.toString(r));
	}

	@Test
	public void test21_toString() {
		String exp = "range from 1234.0 to 873502.0";
		Range r = new Range(1234, 873502);
		String error = String.format("toString(r) failed for r = %s", r.toString());
		assertEquals(error, exp, Lab0.toString(r));
	}

	private static char randomChar() {
		return (char) (TestLab0.rng.nextInt('Z' - 'A') + 'A');
	}

	@Test
	public void test22_middleChar() {
		StringBuilder builder = new StringBuilder();
		int mid = 0;
		builder.append(TestLab0.randomChar());
		String s = builder.toString();
		String error = String.format("middleChar(%s) failed with s = %s", s, s);
		assertEquals(error, s.charAt(mid), Lab0.middleChar(s));
		mid++;

		for (int i = 0; i < 500; i++) {
			builder.append(TestLab0.randomChar());
			s = builder.toString();
			error = String.format("middleChar(%s) failed with s = %s", s, s);
			assertEquals(error, s.charAt(mid), Lab0.middleChar(s));

			builder.append(TestLab0.randomChar());
			s = builder.toString();
			error = String.format("middleChar(%s) failed with s = %s", s, s);
			assertEquals(error, s.charAt(mid), Lab0.middleChar(s));

			mid++;
		}
	}

	private static class Pair {
		String exp;
		String in;

		public Pair(String exp, String in) {
			this.exp = exp;
			this.in = in;
		}
	}

	private static char randomCase(char c) {
		if (TestLab0.rng.nextBoolean()) {
			return Character.toLowerCase(c);
		} else {
			return Character.toUpperCase(c);
		}
	}

	private static Pair randomString(int n) {
		StringBuilder exp = new StringBuilder();
		StringBuilder in = new StringBuilder();
		for (int i = 0; i < n; i++) {
			char c1 = TestLab0.randomChar();
			char c2 = TestLab0.randomChar();
			char lower = Character.toLowerCase(c1);
			char upper = c2;
			exp.append(lower);
			in.append(TestLab0.randomCase(lower));
			if (i < n - 1) {
				exp.append(upper);
				in.append(TestLab0.randomCase(upper));
			}
		}
		return new Pair(exp.toString(), in.toString());
	}

	@Test
	public void test23_alternatingCaps() {
		for (int length = 1; length < 1000; length++) {
			for (int i = 0; i < 10; i++) {
				Pair testCase = TestLab0.randomString(length);
				String error = String.format("alternatingCaps(\"%s\") failed", testCase.in);
				assertEquals(error, testCase.exp, Lab0.alternatingCaps(testCase.in));
			}
		}
	}
}
