package compredo;

public class Line {

	Point p1;
	Point p2;
	
	public Line() {
		// TODO Auto-generated constructor stub
	}

	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Line(Line line) {
		this.p1 = line.p1;
		this.p2 = line.p2;
	}
	
	public Point getStart() {
		return new Point(this.p1);
	}
	
	public Point getEnd() {
		return new Point(this.p2);
	}
	
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() == null || obj.getClass() != this.getClass()){
			return false;
		} else {
			if(this.p1 == ((Line)obj).p1 && this.p2 == ((Line)obj).p2) {
				return true;
			}
			
		}
		return false;
	}
	
}
