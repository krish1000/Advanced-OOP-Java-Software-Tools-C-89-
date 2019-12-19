package aggregation;

public class Point {
	private double x;
	private double y;
	 
	Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Point other = (Point) obj;
		return 
			this.x == other.x
			&&
			this.y == other.y;
	}
}
