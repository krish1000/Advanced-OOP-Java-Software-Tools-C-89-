
public class PointTester {
	public static void main(String[] args) {
		double A = 5;
		double X = A * Math.sqrt(3);
		double Y = A;
		
		Point p = null;
		// This is not valid, because interface
		// cannot be a dynamic type.
//		p = new Point(); 
		
		// This compiles because CartisianPoint is
		// a descendant class of Point.
		p = new CartisianPoint(X, Y);
		System.out.println("Cartisian Point: " + (p instanceof CartisianPoint));
		System.out.println("Polar Point: " + (p instanceof PolarPoint));
		
		System.out.println("[Cartisian] x is: " + String.format("%.2f", p.getX()));
		System.out.println("[Cartisian] y is: " + String.format("%.2f", p.getY()));
		
		p = new PolarPoint(2 * A, Math.toRadians(30));
		// Compare line 15 and line 22
		// We construct the same location using two
		// different systems. (Refer to the diagram on the slides.)
		
		System.out.println("Cartisian Point: " + (p instanceof CartisianPoint));
		System.out.println("Polar Point: " + (p instanceof PolarPoint));
		
		System.out.println("[Polar] x is: " + String.format("%.2f", p.getX()));
		System.out.println("[Polar] y is: " + String.format("%.2f", p.getY()));
		
		// Compare Line 19 and Line 30.
		// The two method calls p.getX() 
		// call different versions of the getX() method.
		// In Line 19, since the DT of p is CartisianPoint,
		// the version in CartisianPoint is called.
		// In Line 30, since the DT of p is PolarPoint,
		// the version in PolarPoint is called.
	}
}
