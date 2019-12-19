
// By declaring this as interface,
// all methods must be abstract, i.e., signagures only.
public interface Point {
	// As far as users of Point are concerned,
	// they only want to access the location (x and y coordinate values).
	double getX();
	double getY();
}
