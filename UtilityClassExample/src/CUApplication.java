
// This is a class that uses CircleUtilites
public class CUApplication {
	public static void main(String[] args) {
		// Use a variable to store 
		int i = CircleUtilities.radius;
		System.out.println("i is: " + i);
		System.out.println("CU.radius is: " + CircleUtilities.radius);
		i = 20;
		System.out.println("i is: " + i);
		System.out.println("CU.radius is: " + CircleUtilities.radius);
		CircleUtilities.radius = 20;
		System.out.println("i is: " + i);
		System.out.println("CU.radius is: " + CircleUtilities.radius);
	}
}
