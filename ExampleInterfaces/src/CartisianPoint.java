
public class CartisianPoint implements Point {
	private double x; // x-coordinate value
	private double y; // y-coordinate value
	
	CartisianPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public String toString() {
		return "x = " + x + ", " + "y = " + y;
	}
}
