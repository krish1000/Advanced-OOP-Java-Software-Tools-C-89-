package eecs2030.lab3;

import org.junit.Before;
import org.junit.FixMethodOrder;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComplexTest {

	private static double[] real = {
		0.0, -2.5, 7.20000001
	};
	private static double[] imag = {
		0.0, -3.6, 8.1
	};
	
	private static int[] hashes = {
			0,
			-356,
			801,
			-24997,
			-25353,
			-24195,
			71992,
			71636,
			72794
	};

	private static class Pair {
		public double first;
		public double second;
		
		public Pair(double first, double second) {
			this.first = first;
			this.second = second;
		}
	}
	
	private static Pair[] values;

	@Before
	public void setUp() throws Exception {
		ComplexTest.values = new Pair[ComplexTest.real.length * 
		                              ComplexTest.imag.length];
		int i = 0;
		for (double re : ComplexTest.real) {
			for (double im : ComplexTest.imag) {
				ComplexTest.values[i++] = new Pair(re, im);
			}
		}
	}

	@Test
	public void test00_constants() {
		assertEquals("real part of ONE is wrong",
				1.0, Complex.ONE.re(), Math.ulp(1.0));
		assertEquals("imaginary part of ONE is wrong",
				0.0, Complex.ONE.im(), Math.ulp(0.0));
		
		assertEquals("real part of I is wrong",
				0.0, Complex.I.re(), Math.ulp(0.0));
		assertEquals("imaginary part of I is wrong",
				1.0, Complex.I.im(), Math.ulp(1.0));
	}
	
	/**
	 * Test for Complex()
	 */
	@Test
	public void test01_noArgCtor() {
		Complex c = new Complex();
		assertEquals("real part is incorrect",
				0.0, c.re(), Math.ulp(0));
		assertEquals("imaginary part is incorrect",
				0.0, c.im(), Math.ulp(0));
	}

	/**
	 * Test for Complex(double, double)
	 */
	@Test
	public void test02_ctor() {
		for (Pair v : ComplexTest.values) {
			Complex c = new Complex(v.first, v.second);
			assertEquals("real part is incorrect",
					v.first, c.re(), Math.ulp(v.first));
			assertEquals("imaginary part is incorrect",
					v.second, c.im(), Math.ulp(v.second));
		}
	}
	
	/**
	 * Test for Complex(Complex)
	 */
	@Test
	public void test03_copyCtor() {
		for (Pair v : ComplexTest.values) {
			Complex c = new Complex(v.first, v.second);
			Complex copy = new Complex(c);
			assertEquals("real part is incorrect",
					v.first, copy.re(), Math.ulp(v.first));
			assertEquals("imaginary part is incorrect",
					v.second, copy.im(), Math.ulp(v.second));
		}
	}
	
	/**
	 * Test for real(double re)
	 */
	@Test
	public void test04_real() {
		for (double re : ComplexTest.real) {
			Complex c = Complex.real(re);
			assertEquals("real part is incorrect",
					re, c.re(), Math.ulp(re));
			assertEquals("imaginary part is incorrect",
					0.0, c.im(), Math.ulp(0.0));
		}
	}
	
	/**
	 * Test for imag(double im)
	 */
	@Test
	public void test04_imag() {
		for (double im : ComplexTest.imag) {
			Complex c = Complex.imag(im);
			assertEquals("real part is incorrect",
					0.0, c.re(), Math.ulp(0.0));
			assertEquals("imaginary part is incorrect",
					im, c.im(), Math.ulp(im));
		}
	}
	
	/**
	 * Test for add(Complex)
	 */
	@Test
	public void test05_add() {
		for (Pair v : ComplexTest.values) {
			Complex c = new Complex(v.first, v.second);
			for (Pair w : ComplexTest.values) {
				Complex d = new Complex(w.first, w.second);
				Complex sum = c.add(d);
				
				// test the sum
				double exp = v.first + w.first;
				assertEquals("real part of the sum is incorrect", 
						sum.re(), exp, Math.ulp(exp));
				exp = v.second + w.second;
				assertEquals("imaginary part of the sum is incorrect",
						sum.im(), exp, Math.ulp(exp));
			}
		}
	}

	/**
	 * Test for multiply(Complex)
	 */
	@Test
	public void test06_multiply() {
		for (Pair v : ComplexTest.values) {
			Complex c = new Complex(v.first, v.second);
			for (Pair w : ComplexTest.values) {
				Complex d = new Complex(w.first, w.second);
				Complex prod = c.multiply(d);
				
				// test the product
				double exp = v.first * w.first - v.second * w.second;
				assertEquals("real part of the product is incorrect",
						prod.re(), exp, Math.ulp(exp));
				exp = v.first * w.second + v.second * w.first;
				assertEquals("imaginary part of the sum is incorrect",
						prod.im(), exp, Math.ulp(exp));
			}
		}
	}

	/**
	 * Test for mag()
	 */
	@Test
	public void test07_mag() {
		for (Pair v : ComplexTest.values) {
			Complex c = new Complex(v.first, v.second);
			double exp = Math.hypot(v.first, v.second);
			assertEquals("the magnitude is incorrect",
					exp, c.mag(), Math.ulp(exp));
		}

		// test a complex number with large real and imaginary components
		double big = Math.sqrt(Double.MAX_VALUE);
		Complex huge = new Complex(big, big);
		final double HYPOT = Math.hypot(big, big);
		assertEquals("mag() overflowed! Look in java.lang.Math for a method to compute the magnitude",
				HYPOT, huge.mag(), Math.ulp(HYPOT));
	}

	/**
	 * Test for equals(Object)
	 */
	@Test
	public void test08_equals() {
		for (Pair v : ComplexTest.values) {
			Complex c = new Complex(v.first, v.second);
			Complex alias = c;
			Complex copy = new Complex(c);
			Complex diff1 = new Complex(v.first + Math.ulp(v.first), v.second);
			Complex diff2 = new Complex(v.first, v.second + Math.ulp(v.second));
			Complex diff3 = new Complex(v.first + Math.ulp(v.first), 
					v.second + Math.ulp(v.second));
			
			assertEquals("c.equals(c) failed to return true",
					c, c);
			assertEquals("c.equals(c) failed to return true",
					c, alias);
			assertEquals("c.equals(d) failed to return true for equal complex numbers",
					c, copy);
			assertFalse("c.equals(null) failed to return false",
					c.equals(null));
			assertFalse("c.equals(v) failed to return false when v is not a Complex number",
					c.equals(v));
			assertFalse("c.equals(d) failed to return false when the real parts differ",
					c.equals(diff1));
			assertFalse("c.equals(d) failed to return false when the imaginary parts differ",
					c.equals(diff2));
			assertFalse("c.equals(d) failed to return false for unequal c and d",
					c.equals(diff3));
		}
	}

	/**
	 * Test for hashCode()
	 */
	@Test
	public void test09_hashCode() {
		for (int i = 0; i < ComplexTest.values.length; i++) {
			Pair v = ComplexTest.values[i];
			Complex c = new Complex(v.first, v.second);
			int exp = ComplexTest.hashes[i];
			assertEquals("wrong hash code for " + c,
					exp, c.hashCode());
		}
	}

	/**
	 * Test for toString()
	 */
	@Test
	public void test10_toString() {
		Complex c1 = new Complex();
		assertEquals("toString returned the wrong string", 
				"0.0 + 0.0i", c1.toString());
		
		Complex c2 = new Complex(-1.23456789, 99.9999);
		assertEquals("toString returned the wrong string",
				"-1.23456789 + 99.9999i", c2.toString());
		
		Complex c3 = new Complex(1.0, -2.7300001);
		assertEquals("toString returned the wrong string",
				"1.0 - 2.7300001i", c3.toString());
		
		Complex c4 = new Complex(-1.0, -2.73);
		assertEquals("toString returned the wrong string",
				"-1.0 - 2.73i", c4.toString());
	}

	/**
	 * Test for valueOf(String)
	 */
	@Test
	public void test11_valueOf() {
		String s1 = "0.0 + 0.0i";
		Complex c1 = new Complex();
		assertEquals(c1, Complex.valueOf(s1));
		
		String s2 = "-1.23456789 + 99.9999i";
		Complex c2 = new Complex(-1.23456789, 99.9999);
		assertEquals(c2, Complex.valueOf(s2));
		
		String s3 = "1.0 - 2.73i";
		Complex c3 = new Complex(1.0, -2.73);
		assertEquals(c3, Complex.valueOf(s3));
		
		String s4 = "-1.0 - 2.73i";
		Complex c4 = new Complex(-1.0, -2.73);
		assertEquals(c4, Complex.valueOf(s4));
	}

	/**
	 * Tests for valueOf(String) where we expect the method to throw an
	 * exception.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValueOfStringEx1() {
		// missing i
		Complex.valueOf("1 + 1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOfStringEx2() {
		// missing sign
		Complex.valueOf("1 1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOfStringEx3() {
		// missing imaginary part
		Complex.valueOf("1 + ");
	}
}
