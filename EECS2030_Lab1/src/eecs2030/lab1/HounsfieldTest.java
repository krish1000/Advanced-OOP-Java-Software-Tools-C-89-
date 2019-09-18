package eecs2030.lab1;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HounsfieldTest {
	
	private static boolean IS_MIN_VALUE_OK = false;
	private static boolean IS_MAX_VALUE_OK = false;
	private static boolean IS_NO_ARG_CTOR_OK = false;
	private static boolean IS_CTOR_OK = false;
	private static boolean IS_COPY_CTOR_OK = false;

	@Rule
	public Timeout globalTimeout = Timeout.seconds(2);

	@Test
	public void test01_minValue() {
		// the expected value of Hounsfield.MIN_VALUE
		final int exp = -1024;

		// the actual value of Hounsfield.MIN_VALUE
		final int got = Hounsfield.MIN_VALUE;

		// assert that exp is equal to got
		assertEquals(exp, got);
		IS_MIN_VALUE_OK = true;
	}

	@Test
	public void test02_maxValue() {
		// the expected value of Hounsfield.MAX_VALUE
		final int exp = 3071;

		// the actual value of Hounsfield.MAX_VALUE
		final int got = Hounsfield.MAX_VALUE;

		// assert that exp is equal to got
		assertEquals(exp, got);
		IS_MAX_VALUE_OK = true;
	}

	@Test
	public void test03_noArgCtor() {
		// invoke the no-argument constructor
		Hounsfield v = new Hounsfield();

		// the expected value of calling v.get()
		final int exp = 0;

		// the actual value returned by v.get()
		final int got = v.get();

		// make an error message in case the test fails
		String error = String.format("new Hounsfield() failed");

		// assert that exp is equal to got
		assertEquals(error, exp, got);
		IS_NO_ARG_CTOR_OK = true;
	}

	@Test
	public void test04_ctor() {
		assumeTrue("test requires a correct value of MIN_VALUE", IS_MIN_VALUE_OK);
		assumeTrue("test requires a correct value of MAX_VALUE", IS_MAX_VALUE_OK);
		
		for (int i = Hounsfield.MIN_VALUE; i <= Hounsfield.MAX_VALUE; i++) {
			// invoke the constructor
			Hounsfield v = new Hounsfield(i);

			// the expected value of calling v.get()
			final int exp = i;

			// the actual value returned by v.get()
			final int got = v.get();

			// make an error message in case the test fails
			String error = String.format("new Hounsfield(%s) failed", i);

			// assert that exp is equal to got
			assertEquals(error, exp, got);
		}
		IS_CTOR_OK = true;
	}

	@Test(expected = IllegalArgumentException.class)
	public void test05_ctorThrows() {
		// make a Hounsfield unit with a value that is too small
		final int val = -1025;
		new Hounsfield(val);

		// fail the test if the previous line did not throw an exception
		String error = String.format("new Hounsfield(%s) should have thrown an exception", val);
		fail(error);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test06_ctorThrows() {
		// make a Hounsfield unit with a value that is too large
		final int val = 3072;
		new Hounsfield(val);

		// fail the test if the previous line did not throw an exception
		String error = String.format("new Hounsfield(%s) should have thrown an exception", val);
		fail(error);
	}

	@Test
	public void test07_copyCtor() {
		assumeTrue("test requires a correct value of MIN_VALUE", IS_MIN_VALUE_OK);
		assumeTrue("test requires a correct value of MAX_VALUE", IS_MAX_VALUE_OK);
		assumeTrue("test requires a correct implementation of Hounsfield(int)", IS_CTOR_OK);
		
		for (int i = Hounsfield.MIN_VALUE; i <= Hounsfield.MAX_VALUE; i++) {
			// make a Hounsfield unit to copy
			Hounsfield toCopy = new Hounsfield(i);

			// invoke the copy constructor
			Hounsfield v = new Hounsfield(toCopy);

			// the expected value of calling v.get()
			final int exp = i;

			// the actual value returned by v.get()
			final int got = v.get();

			// make an error message in case the test fails
			String error = String.format("new Hounsfield(%s) failed", i);

			// assert that exp is equal to got
			assertEquals(error, exp, got);
		}
		IS_COPY_CTOR_OK = true;
	}

	@Test
	public void test08_set() {
		assumeTrue("test requires a correct value of MIN_VALUE", IS_MIN_VALUE_OK);
		assumeTrue("test requires a correct value of MAX_VALUE", IS_MAX_VALUE_OK);
		assumeTrue("test requires a correct implementation of Hounsfield()", IS_NO_ARG_CTOR_OK);
		
		// make a Hounsfield unit to call set on
		Hounsfield v = new Hounsfield();

		for (int i = Hounsfield.MIN_VALUE; i <= Hounsfield.MAX_VALUE; i++) {
			// invoke set
			v.set(i);

			// the expected value of calling v.get()
			final int exp = i;

			// the actual value returned by v.get()
			final int got = v.get();

			// make an error message in case the test fails
			String error = String.format("set(%s) failed", i);

			// assert that exp is equal to got
			assertEquals(error, exp, got);
		}
	}
	
	@Test
	public void test08_setReturns() {
		assumeTrue("test requires a correct value of MIN_VALUE", IS_MIN_VALUE_OK);
		assumeTrue("test requires a correct value of MAX_VALUE", IS_MAX_VALUE_OK);
		assumeTrue("test requires a correct implementation of Hounsfield()", IS_NO_ARG_CTOR_OK);
		
		// make a Hounsfield unit to call set on
		Hounsfield v = new Hounsfield();
		int expOldValue = 0;  // the current expected value of v

		for (int i = Hounsfield.MIN_VALUE; i <= Hounsfield.MAX_VALUE; i++) {
			// invoke set
			int gotOldValue = v.set(i);

			// make an error message in case the test fails
			String error = String.format("set(%s) failed to return the correct value", i);

			// assert that expOldValue is equal to gotOldValue
			assertEquals(error, expOldValue, gotOldValue);
			
			expOldValue = i;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void test09_setThrows() {
		assumeTrue("test requires a correct implementation of Hounsfield()", IS_NO_ARG_CTOR_OK);
		
		// make a Hounsfield unit to call set on
		Hounsfield v = new Hounsfield();

		// invoke set with a value that is too small
		final int val = -1025;
		v.set(val);

		// fail the test if the previous line did not throw an exception
		String error = String.format("set(%s) should have thrown an exception", val);
		fail(error);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test10_setThrows() {
		assumeTrue("test requires a correct implementation of Hounsfield()", IS_NO_ARG_CTOR_OK);
		
		// make a Hounsfield unit to call set on
		Hounsfield v = new Hounsfield();

		// invoke set with a value that is too large
		final int val = 3072;
		v.set(val);

		// fail the test if the previous line did not throw an exception
		String error = String.format("set(%s) should have thrown an exception", val);
		fail(error);
	}

	@Test
	public void test11_toString() {
		assumeTrue("test requires a correct implementation of Hounsfield(int)", IS_CTOR_OK);
		
		// make a Hounsfield unit
		final int val = 25;
		Hounsfield v = new Hounsfield(val);
		
		// the expected value of calling v.toString();
		final String exp = "25 HU";
		
		// the actual value returned by v.toString();
		final String got = v.toString();
		
		// make an error message in case the test fails
		String error = String.format("toString() failed for a Hounsfield unit of %s", val);
		
		// assert that exp is equal to got
		assertEquals(error, exp, got);
	}

	@Test
	public void test12_toString() {
		assumeTrue("test requires a correct implementation of Hounsfield(int)", IS_CTOR_OK);
		
		// make a Hounsfield unit
		final int val = -1000;
		Hounsfield v = new Hounsfield(val);
		
		// the expected value of calling v.toString();
		final String exp = "-1000 HU";
		
		// the actual value returned by v.toString();
		final String got = v.toString();
		
		// make an error message in case the test fails
		String error = String.format("toString() failed for a Hounsfield unit of %s", val);
		
		// assert that exp is equal to got
		assertEquals(error, exp, got);
	}
}