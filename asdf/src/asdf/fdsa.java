package asdf;

public class fdsa {
	private int poo;
	//reverse of a string asdf
	public fdsa(int x) {
		this.poo = x;
	}
	
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
		fdsa y1 = new fdsa(1);
		fdsa y2 = new fdsa(2);
		fdsa[] x = {y1,y2};
		System.out.println(y1.poo);
		y1 = y2;
		System.out.println(y1.poo);
		System.out.println(x[0].poo);
		System.out.println(x[0] == y1);
		
		
		
		
		
//		int[] x1 = new int[0];
//		x1[0]= 1;
//		System.out.println(x1);
		
		
		
//		String x = "asdf";
//		System.out.println(x);
//		System.out.println(reverse(x));
//		System.out.println("-----------------");
//		
//		int a = 0;
//		System.out.println(factorialting(a));
//		a = 1;
//		System.out.println(factorialting(a));
//		a = 2;
//		System.out.println(factorialting(a));
//		a = 3;
//		System.out.println(factorialting(a));
//		a = 4;
//		System.out.println(factorialting(a));
//		a = 5;
//		System.out.println(factorialting(a));
		
		
		
//		
//		int count =0;
//		String[] x = {"Hola", "abc", "oppa"};
//		for(int i = 0; i<x.length; i++) {
//			count++;
//		}
//		
//		int[] y = new int[2];
//		System.out.println(count);
//		System.out.println(x[0].charAt(0));
//		System.out.println("x length: "+ x.length);
//		System.out.println("y length: " + y.length);
//		System.out.println(x[x.length -1] != null);
		
		
//		int[] asdf = new int[2];
//		System.out.println(asdf.length);
//		asdf[0] = 1;
//		asdf[1] = 2;
//		System.out.println(asdf[0] + asdf[1]);
	    
		
		
	}
		
}
