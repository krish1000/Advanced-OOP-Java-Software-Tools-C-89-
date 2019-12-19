package aggregation;

public class Point {

	int x, y;
	
	public Point(Point p1) {
		// TODO Auto-generated constructor stub
		//intialize tha shiz
		this.x = p1.x;
		this.y = p1.y;
		
	}

	public Point(int x, int y) {
		// TODO Auto-generated constructor stub
		//intialize tha shiz
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object obj) {
		
		if(obj == null || obj.getClass() != this.getClass()) {
			return false;
		} else if(this.x == ((Point)obj).x && this.y == ((Point)obj).y) {
			return true;
		}
		
		return false;
	}
	
	public int getX() {
		return this.x;
	}
	//not needed:
	public int getY() {
		return this.y;
	}

	public void setX(int i) {
		// TODO Auto-generated method stub
		this.x = i;
	}



}
