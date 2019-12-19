
public class Triangle extends Polygon {
	
	Triangle(double side1, double side2, double side3) {
		sides = new double[3];
		sides[0] = side1;
		sides[1] = side2;
		sides[2] = side3;
	}
	
	double getArea() {
		// Apply Haron's formula
		double a = sides[0];
		double b = sides[1];
		double c = sides[2];
		double s = (a + b + c) / 2;
		double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		return area;
	}
}









