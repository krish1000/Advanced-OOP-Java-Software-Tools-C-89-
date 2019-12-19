
/*
 * This is an example on how to use an Object variable to hold either an Integer or a Boolean. 
 */

public class WrapperClassTester {
	public static void main(String[] args) {
		int i = 8;
		int j = 3;
		Object o = i * j; /* i * j is wrapped as an Integer object */
		/* Static type of o is Object; Dynamic type of o is Integer */
		Integer k = (Integer) o;
		System.out.println(k);

		boolean p = true;
		boolean q = false;
		o = p || q; /* p || q is wrapped as a Boolean object */
		/* Static type of o remains Object; Dynamic type of o changes to Boolean */
		Boolean r = (Boolean) o;
		System.out.println(r);

		/*
		 * Lesson: Object is a suitable static type which allows dynamic types Integer
		 * and Boolean
		 */
	}
}
