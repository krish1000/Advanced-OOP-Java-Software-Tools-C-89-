
// Declaring Polygon to be an abstract class
// means that at least one method will be signature-only.
public abstract class Polygon {
	// For a rectangle, sides.length == 4
	// For a triangle, sides.length == 3
	double[] sides;
	
	// We do not need to have a constructor for Polygon
	// because we simply don't know how to initialzie 
	// the sides array.
	Polygon() {
		
	}
	
	/* Grow each side of the polygon by one unit. */
	// This method can be reused by all subclasses of Polygon:
	// Rectangle and Triangle.
	void grow() {
		for(int i = 0; i < sides.length; i ++) {
//			sides[i] ++;
			sides[i] = sides[i] + 1;
		}
	}
	
	/* Return the perimeter of the polygon. */
	// This method, like grow, will also be shared
	// by all subclasses of Polygon.
	double getPerimeter() {
		double perimeter = 0;
		for(int i = 0; i < sides.length; i ++) {
			perimeter += sides[i];
		}
		return perimeter;
	}
	
	// Since there is not a single mechanism 
	// for calculating all possible Polygons (Rectangle and Triangle),
	// we will delay this implementation to the subclasses.
	// That is, we will make getArea() an abstract method
	// by including its signature only.
	
	// By declaring this method to be abstract,
	// we do not need to supply its implementation {...}.
	abstract double getArea();
}








