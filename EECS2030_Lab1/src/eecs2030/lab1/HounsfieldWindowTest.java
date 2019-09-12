package eecs2030.lab1;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HounsfieldWindowTest {
	
	private static boolean IS_NO_ARG_CTOR_OK = false;
	private static boolean IS_CTOR_OK = false;

	@Rule
	public Timeout globalTimeout = Timeout.seconds(2);

	@Test
	public void test01_noArgCtorLevel() {
		// invoke the no-argument constructor
		HounsfieldWindow w = new HounsfieldWindow();

		// the expected value of calling w.getLevel()
		final int exp = 0;

		// the actual value returned by w.getLevel()
		final int got = w.getLevel();

		// make an error message in case the test fails
		String error = String.format("new HounsfieldWindow() failed to set the level correctly");

		// assert that exp is equal to got
		assertEquals(error, exp, got);
	}

	@Test
	public void test02_noArgCtorWidth() {
		// invoke the no-argument constructor
		HounsfieldWindow w = new HounsfieldWindow();

		// the expected value of calling w.getWidth()
		final int exp = 400;

		// the actual value returned by w.getWidth()
		final int got = w.getWidth();

		// make an error message in case the test fails
		String error = String.format("new HounsfieldWindow() failed to set the width correctly");

		// assert that exp is equal to got
		assertEquals(error, exp, got);
		IS_NO_ARG_CTOR_OK = true;
	}

	@Test
	public void test03_ctorLevel() {
		// some expected window levels
		final int[] EXP = { Hounsfield.MIN_VALUE, -122, 0, 297, Hounsfield.MAX_VALUE };

		for (int exp : EXP) {
			// invoke the constructor
			HounsfieldWindow w = new HounsfieldWindow(exp, 400);

			// the actual value returned by w.getLevel()
			final int got = w.getLevel();

			// make an error message in case the test fails
			String error = String.format("new HounsfieldWindow(%s, 400) failed to set the level correctly", exp);

			// assert that exp is equal to got
			assertEquals(error, exp, got);
		}
	}

	@Test
	public void test04_ctorWidth() {
		// some expected window widths
		final int[] EXP = { 1, 10, 117, 999, 2507 };

		for (int exp : EXP) {
			// invoke the constructor
			HounsfieldWindow w = new HounsfieldWindow(0, exp);

			// the actual value returned by w.getWidth()
			final int got = w.getWidth();

			// make an error message in case the test fails
			String error = String.format("new HounsfieldWindow(0, %s) failed to set the width correctly", exp);

			// assert that exp is equal to got
			assertEquals(error, exp, got);
		}
		IS_CTOR_OK = false;
	}

	@Test
	public void test05_setLevel() {
		assumeTrue("test requires a correct implementation of HounsfieldWindow()", IS_NO_ARG_CTOR_OK);
		
		// make a window to modify
		int expOldLevel = 0;
		final int expWidth = 400;
		HounsfieldWindow w = new HounsfieldWindow();

		// some expected window levels
		final int[] EXP = { Hounsfield.MIN_VALUE, -122, 0, 297, Hounsfield.MAX_VALUE };

		for (int exp : EXP) {
			// invoke setLevel
			int gotOldLevel = w.setLevel(exp);

			// the actual value returned by w.getLevel()
			final int got = w.getLevel();

			// make an error message for if the new level is incorrect
			String error = String.format("setLevel(%s) failed to set the correct level", exp);

			// assert that exp is equal to got
			assertEquals(error, exp, got);

			// make an error message for if the returned old level is incorrect
			error = String.format("setLevel(%s) failed to return the correct old level", exp);

			// assert that expected old level is equal to the returned old level
			assertEquals(error, expOldLevel, gotOldLevel);

			// make an error message for if the width has changed
			error = String.format("setLevel(%s) changed the window width!", exp);

			// assert that the window width has not changed
			assertEquals(error, expWidth, w.getWidth());

			// the expected old level is now the current level
			expOldLevel = exp;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void test06_setLevelThrows() {
		assumeTrue("test requires a correct implementation of HounsfieldWindow()", IS_NO_ARG_CTOR_OK);
		
		// make a window to call set on
		HounsfieldWindow w = new HounsfieldWindow();

		// invoke setLevel with a value that is too small
		final int val = -1025;
		w.setLevel(val);

		// fail the test if the previous line did not throw an exception
		String error = String.format("setLevel(%s) should have thrown an exception", val);
		fail(error);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test07_setLevelThrows() {
		assumeTrue("test requires a correct implementation of HounsfieldWindow()", IS_NO_ARG_CTOR_OK);
		
		// make a window to call set on
		HounsfieldWindow w = new HounsfieldWindow();

		// invoke setLevel with a value that is too large
		final int val = 3072;
		w.setLevel(val);

		// fail the test if the previous line did not throw an exception
		String error = String.format("setLevel(%s) should have thrown an exception", val);
		fail(error);
	}

	@Test
	public void test08_setWidth() {
		assumeTrue("test requires a correct implementation of HounsfieldWindow(int, int)", IS_CTOR_OK);
		
		// make a window to modify
		final int expLevel = 10;
		int expOldWidth = 125;
		HounsfieldWindow w = new HounsfieldWindow(10, 125);

		// some expected window widths
		final int[] EXP = { 1, 10, 117, 999, 2507 };

		for (int exp : EXP) {
			// invoke setWidth
			int gotOldWidth = w.setWidth(exp);

			// the actual value returned by w.getWidth()
			final int got = w.getWidth();

			// make an error message for if the new width is incorrect
			String error = String.format("setWidth(%s) failed to set the correct width", exp);

			// assert that exp is equal to got
			assertEquals(error, exp, got);

			// make an error message for if the returned old width is incorrect
			error = String.format("setWidth(%s) failed to return the correct old width", exp);

			// assert that expected old level is equal to the returned old level
			assertEquals(error, expOldWidth, gotOldWidth);

			// make an error message for if the level has changed
			error = String.format("setWidth(%s) changed the window level!", exp);

			// assert that the window width has not changed
			assertEquals(error, expLevel, w.getLevel());

			// the expected old width is now the current width
			expOldWidth = exp;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void test09_setWidthThrows() {
		assumeTrue("test requires a correct implementation of HounsfieldWindow()", IS_NO_ARG_CTOR_OK);
		
		// make a window to call set on
		HounsfieldWindow w = new HounsfieldWindow();

		// invoke set with a value that is too small
		final int val = 0;
		w.setWidth(val);

		// fail the test if the previous line did not throw an exception
		String error = String.format("setWidth(%s) should have thrown an exception", val);
		fail(error);
	}

	@Test
	public void test10_map() {
		assumeTrue("test requires a correct implementation of HounsfieldWindow(int, int)", IS_CTOR_OK);
		
		// uses windows of width 1
		// easy to test because map should always return 0.5 for
		// Hounsfield values inside the window
		final int width = 1;

		for (int level = Hounsfield.MIN_VALUE; level <= Hounsfield.MAX_VALUE; level++) {
			// make a window to call map on
			HounsfieldWindow w = new HounsfieldWindow(level, width);

			// the actual value returned by map
			double got = w.map(new Hounsfield(level));

			// make an error message in case the test fails
			String error = String.format(
					"map(%s) failed to return the correct value for a window with level %s, width %s", level, level,
					width);

			// assert that 0.5 equals got
			assertEquals(error, 0.5, got, 1e-9);
		}
	}

	private static double[] mapValues(int winWidth) {
		final int n = winWidth / 2 * 2 + 1;
		double[] result = new double[n];
		for (int i = 0; i < n; i++) {
			if (winWidth % 2 == 0) {
				result[i] = (0.0 + i) / winWidth;
			}
			else {
				result[i] = (1.0 + 2 * i) / (2 * winWidth);
			}
		}
		return result;
	}
	
	@Test
	public void test11_map() {
		assumeTrue("test requires a correct implementation of HounsfieldWindow(int, int)", IS_CTOR_OK);
		
		// tests Hounsfield units in windows of various widths and levels
		final int[] WIDTH = {2, 3, 4, 5, 10, 25, 50, 75, 100, 255};
		final int[] LEVEL = {-800, -1, 1, 750};
		
		for (int level : LEVEL) {
			for (int width : WIDTH) {
				// make a window to call map on
				HounsfieldWindow w = new HounsfieldWindow(level, width);
				
				// expected values map should return 
				double[] EXP = HounsfieldWindowTest.mapValues(width);
				
				for (int i = 0; i < EXP.length; i++) {
					// Hounsfield unit to map
					Hounsfield h = new Hounsfield(level - width / 2 + i);
					
					// the expected return value of map(h)
					double exp = EXP[i];
					
					// the actual value returned by map(h)
					double got = w.map(h);
					
					// make an error message in case the test fails
					String error = String.format(
							"map(%s) failed to return the correct value for a window with level %s, width %s", h.get(), level,
							width);

					// assert that exp equals got
					assertEquals(error, exp, got, 1e-9);
				}
			}
		}
	}

}
