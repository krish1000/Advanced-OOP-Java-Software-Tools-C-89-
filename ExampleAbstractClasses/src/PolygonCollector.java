
public class PolygonCollector {
	// ST of each element in polygons is Polygon
	// which means it can be assigned any object
	// whose ST is a descendant class of Polygon
	// (i.e., Triangle and Rectangle)
	Polygon[] polygons; 
	int nop; // number of polygons
	
	
	
	/**************Added this**************/
	public static int x = 21;
	
	//Not visible to other classes
	//private static int y  = 69;
	
	static int w = 69;
	
	//testing whether you can have a mutator method without params
	
	void mutator1() {
		this.w = 5; //works but warns you of you to do in a static way
		PolygonCollector.w = 523;
	}
	/**************************************/
	

	PolygonCollector() {
		polygons = new Polygon[10];
	} 

	// ST of parameter p is Polygon
	// This means any object whose ST is a descendant class
	// of Polygon can be passed as argument for this method.
	// i.e., Rectangle and Triangle
	void addPolygon(Polygon p) {
		polygons[nop] = p;
		nop ++;
	}

	// ST of parameter p is Rectangle
	// This means any object whose ST is a descendant class
	// of Rectangle can be passed as argument for this method.
	// i.e., Rectangle and Triangle
	void addRectangle(Rectangle p) {
		polygons[nop] = p;
		nop ++;
	}

	// ST of parameter p is Triangle
	// This means any object whose ST is a descendant class
	// of Triangle can be passed as argument for this method.
	// i.e., Triangle
	void addTriangle(Triangle p) {
		polygons[nop] = p;
		nop ++;
	}
}
