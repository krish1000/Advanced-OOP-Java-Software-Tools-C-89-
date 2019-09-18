package eecs2030.lab1;

/**
 * A class that represents a windowed view of Hounsfield units. A Hounsfield
 * window is defined by two values: (1) the window level, and (2) the window
 * width. The window level is the Hounsfield unit value that the window is
 * centered on. The window width is the range of Hounsfield unit values that the
 * window is focused on.
 * 
 * <p>
 * A window has a lower and upper bound. The lower bound is defined as the
 * window level minus half the window width:
 * 
 * <p>
 * lo = level - (width / 2)
 * 
 * <p>
 * The upper bound is defined as the window level plus half the window width:
 * 
 * <p>
 * hi = level + (width / 2)
 * 
 * <p>
 * Hounsfield units are mapped by the window to a real number in the range of
 * {@code 0} to {@code 1}. A Hounsfield unit with a value less than lo is mapped
 * to the value {@code 0}. A Hounsfield unit with a value greater than hi is
 * mapped to the value {@code 1}. A Hounsfield unit with a value v between lo
 * and hi is mapped to the value:
 * 
 * <p>
 * (v - lo) / width
 * 
 *
 */
public class HounsfieldWindow {

	// private double lo;
	// private double hi;
	private int level;
	private int width;

	// intializes window if the user doesn't give params
	public HounsfieldWindow() {
		this.level = 0;
		this.width = 400;
	}

	// intialzes level and width of the window
	public HounsfieldWindow(int level, int width) {
		// cant call checkvalue cuz private i think
		if (level < Hounsfield.MIN_VALUE || level > Hounsfield.MAX_VALUE) {
			throw new IllegalArgumentException();
		} else if (width < 1) {
			throw new IllegalArgumentException();
		}
		this.level = level;
		this.width = width;

	}

	// returns level value
	public int getLevel() {
		return this.level;
	}

	// returns width value
	public int getWidth() {
		return this.width;
	}

	// sets level and checks if its less than min or greater than max
	public int setLevel(int level) {

		if (level < Hounsfield.MIN_VALUE || level > Hounsfield.MAX_VALUE) {
			throw new IllegalArgumentException();
		}
		int temp = this.level;
		this.level = level;
		return temp;
	}

	// sets width and checks if its under 1
	public int setWidth(int width) {
		if (width < 1) {
			throw new IllegalArgumentException();
		}
		int temp = this.width;
		this.width = width;
		return temp;
	}

	// does the formula stuff ting
	public double map(Hounsfield h) {
		double lo = getLevel() - (getWidth() / 2.0);
		double hi = getLevel() + (getWidth() / 2.0);

		if (h.get() < lo) {
			return 0;
		} else if (h.get() > hi) {
			return 1;
		} else {
			return (h.get() - lo) / width;
		}

	}

}
