
public class PolygonConstructorTester {
	public static void main(String[] args) {
		Polygon p = null; // ST: Polygon; DT: unknown
		PolygonConstructor pc = new PolygonConstructor();
		double[] sides1 = {2, 4};
		p = pc.getPolygon(sides1);
		// Questions:
		// ST of p? Polygon
		// DT of p? Rectangle

		double[] sides2 = {3, 4, 5};
		p = pc.getPolygon(sides2);
		// Questions:
		// ST of p? Polygon
		// DT of p? Triangle
	}
}
