
public class PolygonConstructor {
	Polygon getPolygon(double[] sides) {
		// Since the return type of this method is Polygon,
		// we declare an object of the same type.
		Polygon p = null;
		
		if(sides.length == 3) {
			// We change the DT of p to Triangle
			p = new Triangle(sides[0], sides[1], sides[2]);
		}
		else if (sides.length == 2) {
			// We change the DT of p to Rectangle
			p = new Rectangle(sides[0], sides[1]);
		}
		
		return p;
	}
}
