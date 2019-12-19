package compredo;

public class Point {

	int x, y;
	
	public Point() {
		// TODO Auto-generated constructor stub
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass() == null || obj.getClass() != this.getClass()) {
			return false;
		} else if (this.x == ((Point)obj).x && this.y == ((Point)obj).y) {
			return true;
		}
		return false;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int newx) {
		this.x=newx;
	}
	
}
