
public class PolygonTester {
	public static void main(String[] args) {
		// declare a variable p of static type Polygon
		Polygon p;
		
		// Polygon is an abstract class, meaning that
		// some methods of it have no implementations.
		// Consequently, we can never use an abstract class
		// as a dynamic type.
//		p = new Polygon();
		
		// The RHS dynamic type Rectangle is a 
		// descendant class of the static type of the LHS,
		// which is Polygon. So this line compiles.
		// Rectangle can be a dynamic type because 
		// it has NO abstract methods.
		p = new Rectangle(2, 4);
		boolean instanceofCheck = p instanceof Rectangle;
		System.out.println("p is an instanc of Rectangle: " + instanceofCheck);
		instanceofCheck = p instanceof Triangle;
		System.out.println("p is an instanc of Triangle: " + instanceofCheck);
		
		// Since p is of static type Polygon, we can cast 
		// p into any of the descendant classes of Polygon.
		Rectangle r = (Rectangle) p;
		// This line compiles but there will be ClassCastException
		// because the DT of p (Rectangle) is not a descendant class of Triangle.
//		Triangle t = (Triangle) p;
		
		// These two method calls compile because
		// both getPerimenter() and getArea() are declared
		// in Polygon, which is the static type of context object p.
		System.out.println("Perimeter of p: " + p.getPerimeter());
		System.out.println("Area of p: " + p.getArea());
		
		System.out.println("Grow p.");
		p.grow();
		
		System.out.println("Perimeter of p: " + p.getPerimeter());
		// Here, DT of p is Rectangle, so
		// the version of getArea() defined in Rectangle is called.
		// Dynamic Binding!
		System.out.println("Area of p: " + p.getArea());
		
		
		p = new Triangle(3, 4, 5);
		System.out.println("Perimeter of p: " + p.getPerimeter());
		// Here, DT of p is Triangle, so
		// the version of getArea() defined in Triangle is called.
		// Dynamic Binding!
		System.out.println("Area of p: " + p.getArea());
	}
}







