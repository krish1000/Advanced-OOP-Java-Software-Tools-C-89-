
public class Rectangle extends Polygon {
	// We inherit the attribute sides from Polygon.
	
	// Construct a new instance of Rectangle.
	Rectangle(double width, double length) {
		sides = new double[4];
		sides[0] = width;
		sides[1] = length;
		sides[2] = width;
		sides[3] = length;
	}
	
	/* Supply implementation to the abstract method
	 * getArea() that is inherited from Polygon.
	 */
	double getArea() {
		return sides[0] * sides[1];
		// equally: sides[0] * sides[3];
	}
}







