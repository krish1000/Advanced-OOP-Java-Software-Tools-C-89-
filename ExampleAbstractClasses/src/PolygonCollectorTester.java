
public class PolygonCollectorTester {

	public static void main(String[] args) {
		
		//public static
		System.out.println(PolygonCollector.x);
		PolygonCollector.x = 12;
		System.out.println(PolygonCollector.x);
		System.out.println("*************************");
		
		//private static is not visible
//		System.out.println(PolygonCollector.y);
//		PolygonCollector.y = 12;
//		System.out.println(PolygonCollector.y);
		
		//trying regular static int w *it works* acts the same as public
		System.out.println(PolygonCollector.w);
		PolygonCollector.w = 96;
		System.out.println(PolygonCollector.w);
		PolygonCollector mutcheck = new PolygonCollector();
		mutcheck.mutator1();
		System.out.println("After mutator meth: " + PolygonCollector.w);
		System.out.println("*************************");
		/*************************/
		
		Polygon p1 = new Rectangle(2, 4);
		Polygon p2 = new Triangle(3, 4, 5);
		Rectangle r = new Rectangle(3, 5);
		Triangle t = new Triangle(6, 8, 10);

		PolygonCollector pc = new PolygonCollector();
		// This does not compile because the argument p1 
		// has ST Polygon, which is not a descendant class
		// of the paramter type of addRectangle (Rectangle) 
//		pc.addRectangle(p1);
		
		pc.addPolygon(p1);
		pc.addPolygon(p2);
		
		// These two lines compile because the STs of
		// r and t (Rectangle and Triangle) are both 
		// descendant classes of the parameter type of addPolygon.
//		pc.addPolygon(r);
//		pc.addPolygon(t);
		pc.addRectangle(r);
		pc.addTriangle(t);
		
		System.out.println("Number of polygons collected: " + pc.nop);
		
		//myowntest
		Rectangle rect = new Rectangle(1 ,2);
		//8888888888888
		
		for(int i = 0; i < pc.nop; i ++) {
			// This compiles because
			// ST of pc.polygons[i] is Polygon
			Polygon p = pc.polygons[i];
			
			// Since every possible DT of p (i.e., Rectangle or Triangle)
			// is a descendant class of Polygon,
			// p instanceof Polygon always evaluates to True.
			// This means the two elseif's are unreachable. 
//			if(rect instanceof Polygon) {
//				///testinginging
//				System.out.println("pooo");
//			}
//			else 
				if(p instanceof Polygon) {
				System.out.println("Polygon with area: " + p.getArea());
			}
			else
				if(p instanceof Rectangle) {
				System.out.println("Rectangle with area: " + p.getArea());
			}
			else if(p instanceof Triangle) {
				System.out.println("Triangle with area: " + p.getArea());
			}
		}
	}

}





