
public class RecursiveMethods {

	int factorial(int i) {
		// Base case: 
		// Problem that is small enough to solve right away.
		if(i == 0) {
			return 1;
		}
		// Recursive case:
		// Problem that is too big to be solved right away.
		else { // i > 0
			return i * factorial(i - 1);
		}
	}

	int fib(int n) {
		int result; 
		if(n == 1) { /* base case */ 
			result = 1; 
		} 
		else if(n == 2) { /* base case */ 
			result = 1; 
		} 
		else { /* recursive case */
			result = fib(n - 1) + fib(n - 2);
		} 
		return result; 
	}

	boolean isPalindrome(String word) { 
		if(word.length() == 0 || word.length() == 1) { 
			/* base case */
			return true;
		} 
		else { 
			/* recursive case */
			char firstChar = word.charAt(0);
			char lastChar = word.charAt(word.length() - 1); 
			String middle = word.substring(1, word.length() - 1);
			return
					firstChar == lastChar 
					/* See the API of java.lang.String.substring. */
					&& isPalindrome(middle);
		}
	}

	String reverseOf (String s) { 
		if(s.isEmpty()) { /* base case 1 */  
			return "";
		} 
		else if(s.length() == 1) { /* base case */ 
			return s;
		} 
		else { /* recursive case */
			String tail = s.substring(1, s.length()); 
			String reverseOfTail = reverseOf(tail);  
			char head = s.charAt(0);  
			return reverseOfTail + head;
		}
	}

	int occurrencesOf(String s, char c) {
		if(s.isEmpty()) {
			/* Base Case */
			return 0;
		}
		else {
			/* Recursive Case */
			char head = s.charAt(0);
			String tail = s.substring(1, s.length());
			if(head == c) {
				return 1 + occurrencesOf(tail, c);
			}
			else {
				return 0 + occurrencesOf(tail, c);
			}
		}
	}

	boolean allPositive(int[] a) { 
		return allPositiveHelper(a, 0, a.length - 1);
	}

	boolean allPositiveHelper(int[] a, int from, int to) { 
		if(from > to) { /* base case 1: empty range */
			return true;
		} 
		else if(from == to) { /* base case 2: range of one element */
			return true;
		}
		else { /* recursive case */
			return a[from] > 0 && allPositiveHelper(a, from + 1, to);
		}
	}

	boolean isSorted(int[] a) {
		return isSortedHelper(a, 0, a.length - 1);
	}

	boolean isSortedHelper(int[] a, int from, int to) {
		if(from > to) { /* base case 1: empty range */
			return true;
		} 
		else if(from == to) { /* base case 2: range of one element */
			return true;
		}
		else {
			return a[from] <= a[from + 1] 
					&& isSortedHelper(a, from + 1, to);
		}
	}

	boolean binarySearch(int[] sorted, int key) { 
		return binarySearchHelper(sorted, 0, sorted.length - 1, key);
	} 
	
	boolean binarySearchHelper(int[] sorted, int from, int to, int key) { 
		if(from > to) { /* base case 1: empty range */
			return false;
		} 
		else if(from == to) { /* base case 2: range of one element */
			return sorted[from] == key;
		} 
		else {
			int middle = (from + to) / 2;
			int middleValue = sorted[middle];
			
			if(key < middleValue) { 
				return binarySearchHelper(sorted, from, middle - 1, key);
			} 
			else if (key > middleValue) { 
				return binarySearchHelper(sorted, middle + 1, to, key);
			} 
			else  { 
				return true; 
			}
		}
	}
	
	public static void selectionSort(int[] a) {
		if(a.length == 0 || a.length == 1) {
			/* already sorted, do nothing */
		}
		else {
			for(int i = 0; i < a.length; i ++) {
				/* recursively figure out the index of min value 
				 * from a[i] to a[a.length - 1] 
				 */
				int minIndex = getMinIndex(a, i, a.length - 1);
				/* swap a[i] and a[minIndex] */
				int temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
		}
	}
	
	public static int getMinIndex(int[] a, int from, int to) {
		if(from == to) {
			return from;
		}
		else {
			int minIndexOfTail = getMinIndex(a, from + 1, to);
			if(a[from] < a[minIndexOfTail]) {
				return from;
			}
			else {
				return minIndexOfTail;
			}
		}
	}
	
	/*
	 * Assumption: 'disks' denote names of disks that
	 * are sorted in increasing sizes, to simulate 
	 * a stack of increasing-sized disks.
	 * For example, {"A", "B", "C"} means that
	 * "A" is the smallest disk on the top, and
	 * "C" is the biggest disk on the bottom. 
	 * There are 3 pegs. 
	 */
	public static void towerOfHanoi(String[] disks) {
		tohHelper(disks, 0, disks.length - 1, 1, 3);
	}
	
	/*
	 * towerOfHanoiHelper(disks, from, to, p1, p2) means
	 * to move {disks[from], disks[from+1], ..., disks[to]} from peg p1 to peg p2, 
	 * using peg (6 - p1 - p2) as the intermediate peg. 
	 */
	public static void tohHelper(String[] disks, int from, int to, int p1, int p2) {
		if(from > to) {
			
		}
		else if(from == to) {
			System.out.println("move disk " + disks[to] + " from peg " + p1 + " to peg " + p2);
		}
		else {
			int intermediate = 6 - p1 - p2;
			tohHelper(disks, from, to - 1, p1, intermediate);
			System.out.println("move disk " + disks[to] + " from peg " + p1 + " to peg " + p2);
			tohHelper(disks, from, to - 1, intermediate, p2);
		}
	}
}