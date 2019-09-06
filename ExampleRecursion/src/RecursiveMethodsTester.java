
public class RecursiveMethodsTester {

	public static void main(String[] args) {
		RecursiveMethods rm = new RecursiveMethods();
		
		/* Tests of factorial */
		System.out.println("====================");
		System.out.println("0! = " + rm.factorial(0));
		System.out.println("1! = " + rm.factorial(1));
		System.out.println("2! = " + rm.factorial(2));
		System.out.println("3! = " + rm.factorial(3));
		System.out.println("4! = " + rm.factorial(4));
		System.out.println("5! = " + rm.factorial(5));
		// What would be rm.factorial(-1)?
		// The if-branch is never executed, resulting in
		// an infinite number of recursive calls (in the else-branch).
		
		/* Tests of Fibonacci */
		System.out.println("====================");
		System.out.println("fib(1) = " + rm.fib(1));
		System.out.println("fib(2) = " + rm.fib(2));
		System.out.println("fib(3) = " + rm.fib(3));
		System.out.println("fib(4) = " + rm.fib(4));
		System.out.println("fib(5) = " + rm.fib(5));
		System.out.println("fib(6) = " + rm.fib(6));
		
		/* Tests of isPalindrome */
		System.out.println("====================");
		System.out.println("\"\" is a palindrome: " + rm.isPalindrome(""));
		System.out.println("\"a\" is a palindrome: " + rm.isPalindrome("a"));
		System.out.println("\"madam\" is a palindrome: " + rm.isPalindrome("madam"));
		System.out.println("\"racecar\" is a palindrome: " + rm.isPalindrome("racecar"));
		System.out.println("\"man\" is a palindrome: " + rm.isPalindrome("man"));
		
		/* Tests of reverseOf */
		System.out.println("====================");
		System.out.println("Reverse of \"\": " + rm.reverseOf("")); 
		System.out.println("Reverse of \"a\": " + rm.reverseOf("a"));
		System.out.println("Reverse of \"ab\": " + rm.reverseOf("ab"));
		System.out.println("Reverse of \"abc\": " + rm.reverseOf("abc"));
		System.out.println("Reverse of \"abcd\": " + rm.reverseOf("abcd"));
		
		/* Tests of occurrencesOf */
		System.out.println("====================");
		System.out.println("Number of occurrences of 'a' in \"\": " + rm.occurrencesOf("", 'a'));
		System.out.println("Number of occurrences of 'a' in \"a\": " + rm.occurrencesOf("a", 'a'));
		System.out.println("Number of occurrences of 'a' in \"b\": " + rm.occurrencesOf("b", 'a'));
		System.out.println("Number of occurrences of 'a' in \"baaba\": " + rm.occurrencesOf("baaba", 'a'));
		System.out.println("Number of occurrences of 'b' in \"baaba\": " + rm.occurrencesOf("baaba", 'b'));
		System.out.println("Number of occurrences of 'c' in \"baaba\": " + rm.occurrencesOf("baaba", 'c'));
		
		/* Tests of allPositive */
		System.out.println("====================");
		int[] a1 = {};
		System.out.println("All numbers in [] are positive: " + rm.allPositive(a1));
		int[] a2 = {1, 2, 3, 4, 5};
		System.out.println("All numbers in [1, 2, 3, 4, 5] are positive: " + rm.allPositive(a2));
		int[] a3 = {1, 2, -3, 4, 5};
		System.out.println("All numbers in [1, 2, -3, 4, 5] are positive: " + rm.allPositive(a3));
		
		/* Tests of isSorted */
		System.out.println("====================");
		int[] a4 = {};
		System.out.println("[] is sorted: " + rm.isSorted(a4));
		int[] a5 = {1, 2, 2, 3, 4};
		System.out.println("[1, 2, 2, 3, 4] is sorted: " + rm.isSorted(a5));
		int[] a6 = {1, 2, -3, 4, 5};
		System.out.println("[1, 2, 2, 1, 3] is sorted: " + rm.isSorted(a6));
		
		/* Tests of binarySearch */
		System.out.println("====================");
		int[] a7 = {};
		System.out.println("5 exists in []: " + rm.binarySearch(a7, 5));
		int[] a8 = {1, 2, 3, 4, 5};
		System.out.println("3 exists in [1, 2, 3, 4, 5]: " + rm.binarySearch(a8, 3));
		System.out.println("1 exists in [1, 2, 3, 4, 5]: " + rm.binarySearch(a8, 1));
		System.out.println("5 exists in [1, 2, 3, 4, 5]: " + rm.binarySearch(a8, 5));
		System.out.println("0 exists in [1, 2, 3, 4, 5]: " + rm.binarySearch(a8, 0));
		System.out.println("6 exists in [1, 2, 3, 4, 5]: " + rm.binarySearch(a8, 6));
		
		/* Tests of towerOfHanoi */
		System.out.println("====================");
		String[] disks = {"A", "B", "C"};
		RecursiveMethods.towerOfHanoi(disks);
	}
}
