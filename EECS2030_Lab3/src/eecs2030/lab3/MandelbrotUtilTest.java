package eecs2030.lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class MandelbrotUtilTest {

	@Test
	public void test_inMandelbrotSet() {
		// all of these values are in the Mandelbrot set
		// MandelbrotUtil.mandelbrotIterations(c, max) should return max
		Complex[] c = {
				new Complex(),
				new Complex(-1.0, 0.0),
				new Complex(-0.1, 0.8),
				new Complex(0.2499, 0),
				new Complex(-1.3, 0.04),
				new Complex(-1.3, -0.04),
				new Complex(-0.6254, 0.4355),
				new Complex(-0.6254, -0.4355),
				new Complex(-1.76, 0),
				new Complex(-1.138, 0.2415)
		};
		int maxIter = 255;
		for (int i = 0; i < c.length; i++) {
			String err = String.format("wrong number of iterations for %s", c[i]);
			assertEquals(err,
					maxIter, MandelbrotUtil.mandelbrotIterations(c[i], maxIter));
		}
	}

	
	@Test
	public void test_notInMandelbrotSet() {
		// all of these values are not in the Mandelbrot set
		// MandelbrotUtil.mandelbrotIterations(c, 255) should return a value less than 255
		Complex[] c = {
				new Complex(5.0, 0.0),
				new Complex(0.0, 5.0),
				new Complex(-0.7568, 0.1139),
				new Complex(-0.2673, -0.6869),
				new Complex(-0.2673, 0.6869),
				new Complex(-1.694, -0.01126),
				new Complex(-1.694, 0.01126),
				new Complex(0.2943, 0),
				new Complex(0.4054, 0.274)
		};
		int[] expIter = {1, 1, 26, 12, 12, 10, 10, 13, 11};
		int maxIter = 255;
		for (int i = 0; i < c.length; i++) {
			String err = String.format("wrong number of iterations for %s", c[i]);
			assertEquals(err,
					expIter[i], MandelbrotUtil.mandelbrotIterations(c[i], maxIter));
		}
	}
}
