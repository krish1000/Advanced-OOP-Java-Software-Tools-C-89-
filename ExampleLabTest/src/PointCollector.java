
public class PointCollector {

	private Point[] points;
	private int nop;
	
	public PointCollector() {
		// TODO Auto-generated constructor stub
		points = new Point[99];
	}
	
	public Point[] getPoints() {
		Point[] temp = new Point[nop];
		for(int i = 0; i< nop; i++) {
			temp[i] = points[i];
		}
		
		return temp; //temp
	}
	
	public void addPoint(Point p) {
		points[nop] = p;
		nop++;
	}
	
	public void addPoint(int x, int y) {
		
		points[nop] = new Point(x,y);
		nop++;
	}

}
