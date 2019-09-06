
public class CircleUtilities {
	/* Section of attributes */
	/* This is a static attribute with initial value 10 */
	static int radius = 10;
	private static final int RADIUS_TO_DIAMETER = 2;
	public static final int PI = 3;
	
	/* Section of methods */
	/*
	 * This method has no parameters (inputs)
	 * and it returns an integer.
	 * A method that returns something is called
	 * an accessor.
	 */
	static int getDiameter() {
		// return RADIUS_TO_DIAMETER * radius;
		int diameter = RADIUS_TO_DIAMETER * radius;
		return diameter;
	}
	
	/*
	 * This method returns no value (i.e., void)
	 * so it is a mutator (which changes some attribute without returning).
	 */
	static void setRadius(int newRadius) {
		radius = newRadius;
	}
}
