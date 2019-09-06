
public class StringTester {

	public static void main(String[] args) {
		String s1 = "";
		System.out.println("s1 is empty: " + s1.isEmpty());
		
		String s2 = "abcd";
		System.out.println("s2 is empty: " + s2.isEmpty());
		
		System.out.println("Lenth of s1: " + s1.length());
		System.out.println("Lenth of s2: " + s2.length());
		
		System.out.println("Char at pos 0 of s2: " + s2.charAt(0));
		System.out.println("Char at pos 1 of s2: " + s2.charAt(1));
		System.out.println("Char at pos 2 of s2: " + s2.charAt(2));
		System.out.println("Char at pos 3 of s2: " + s2.charAt(3));
		
		// Print out s1, character by character
		System.out.print("s2 is: ");
		for(int i = 0; i < s2.length(); i ++) {
			System.out.print(s2.charAt(i));
		}
		System.out.println();
		
		// When we write s2.substring(i, j)
		// We return a substring consisting of
		// characters from s2 in the index interval
		// [i, j) which means [i, j - 1]
		System.out.println("s2.substring(0, 1): " + s2.substring(0, 1));
		
		System.out.println("Substring equal to s2: " + s2.substring(0, s2.length()));
		System.out.println("Substring equal to front of s2: " + s2.substring(0, s2.length() - 1));
		System.out.println("Substring equal to tail of s2: " + s2.substring(1, s2.length()));
		
		System.out.println("Concatenation: " + s2.substring(0, 2) + s2.substring(2, s2.length()));
	}

}










