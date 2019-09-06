package asdf;

public class fdsa {

	//reverse of a string asdf
	public static String reverse(String x) {
		StringBuffer peepeepoopoo = new StringBuffer();
		char letter = '0';
		
		for(int i = x.length()-1; i >= 0; i--) {
			letter = x.charAt(i);
			peepeepoopoo.append(letter);
		}
		
		return peepeepoopoo.toString();
	}
	
	public static int factorialting(int x) {
		int product = x;
		
		if (x == 0) {
			return 1;
		} else if (x == 1) {
			return 1;
		}
		
		for(int i = x-1; i > 0; i--) {
			product = product*i;
			//System.out.println(product);
		}
		//System.out.println("============");
		
		return product;
	}
	
	public static void main(String[] args) {
		String x = "asdf";
		System.out.println(x);
		System.out.println(reverse(x));
		System.out.println("-----------------");
		
		int a = 0;
		System.out.println(factorialting(a));
		a = 1;
		System.out.println(factorialting(a));
		a = 2;
		System.out.println(factorialting(a));
		a = 3;
		System.out.println(factorialting(a));
		a = 4;
		System.out.println(factorialting(a));
		a = 5;
		System.out.println(factorialting(a));
	}
}
