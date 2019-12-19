package aggregation;

public class Line {

	Point[] pcoll;

	public Line(Line l1) {
		// TODO Auto-generated constructor stub
		pcoll = new Point[2];

		pcoll[0] = l1.pcoll[0];
		pcoll[1] = l1.pcoll[1];
	}

	public Line(Point p1, Point p2) {
		// TODO Auto-generated constructor stub
		pcoll = new Point[100];

		pcoll[0] = p1;
		pcoll[1] = p2;
	}

	public Point getStart() { // used to be object
		// TODO Auto-generated method stub
		return this.pcoll[0];
	}

	public Point getEnd() { // used to be object
		// TODO Auto-generated method stub
		return this.pcoll[1]; // TEMPROORARYRYRAYYRYYYYYYYYYYyyyyyyyyyyyyyyyyyyyyyyyyyy
	}

	public boolean equals(Object obj) {

		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		} else if (this.getStart() == ((Line) obj).getStart() && this.getEnd() == ((Line) obj).getEnd()) {
			return true;
		}

		return false;
	}

}
