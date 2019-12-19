
public class PolarPoint implements Point {
	double r; // distance from point to origin
	double theta; // angle from x-axis (radian, not degree)
	
	PolarPoint(double r, double theta) {
		this.r = r;
		this.theta = theta;
	}
	
	@Override
	public double getX() {
		return r * Math.cos(theta);
	}

	@Override
	public double getY() {
		return r * Math.sin(theta);
	}
	
	public String toString() {
		return "r = " + r + ", " + "theta = " + theta;
	}

}
