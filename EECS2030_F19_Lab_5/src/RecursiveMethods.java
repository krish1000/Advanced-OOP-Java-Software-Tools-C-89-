import java.util.ArrayList;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 * See under doc/index.html for the API of methods.
 * This lab requires definitions of recursive helper methods. 
 * You may review the recording of parts of Lecture 14 (October 28): 
 * 		https://youtu.be/J2CB3QHinQU 
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticArray(2, 3, 5)
	 * returns an array {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return an array representing the first n numbers in the specified arithmetic
	 *         sequence
	 * 
	 *         <b>You are forbidden to use the arithmeticList method below to solve
	 *         this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] arithmeticArray(int start, int diff, int n) {
		/*
		 * Your Task: Make use of the recursive method arithmeticArrayHelper.
		 */
		int[] arthseq = new int[n];
		if (n == 1) {
			arthseq[0] = start;
		} else if (n > 1) {
			arthseq[0] = start;
			arithmeticArrayHelper(1, diff, arthseq);

		}
		return arthseq; // given
	}

	/********************************************/
//		for(int i = 0; i < arthseq.length; i++) { //check if it actually changez
//		System.out.println("num: " + arthseq[i] );
//		}

	/*********************
	 * *********** boolean allpoitive(int[] a) { return allpoitivehelper (a, 0,
	 * a.length - 1);
	 *
	 * }
	 * 
	 * boolean allpoitivehelper(int [] a, int from, int to){ if from > to return
	 * true ele if from == to, return a[from] > 0; ele return a[from] > 0 &&
	 * allpotiivehelper(a, from+1, to); *********************
	 */

	/**
	 * This is a recursive helper method expected to be used by arithmeticArray.
	 * 
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticArrayHelper(int i, int diff, int[] seq) {
		/*
		 * Your Task
		 */

		int size1 = seq.length - 1;
//		System.out.println("ize: " + size1);

		if (i != size1 +1) {
			seq[i] = seq[i - 1] + diff;
			arithmeticArrayHelper(i + 1, diff, seq);
		} 
	}

	/**
	 * Return a list storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticList(2, 3, 5)
	 * returns a list {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return a list representing the first n numbers in the specified arithmetic
	 *         sequence
	 * 
	 *         <b>You are forbidden to use the arithmeticArray method above to solve
	 *         this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> arithmeticList(int start, int diff, int n) {
		/*
		 * Your Task: Make use of the recursive method arithmeticListHelper.
		 */
		ArrayList<Integer> arthseq = new ArrayList<Integer>();
		if (n == 1) {
			arthseq.add(start);
		} else if (n > 1) {
			arthseq.add(start);
			arithmeticListHelper(1, diff, arthseq, n);

		}
		return arthseq;

	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticList.
	 * 
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * @param n    size of the arithmetic sequence to be built eventually
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticListHelper(int i, int diff, List<Integer> seq, int n) {
		/*
		 * Your Task
		 */
		if (i == n - 1) {
			seq.add(seq.get(i - 1) + diff);
		} else {
			seq.add(seq.get(i - 1) + diff);
			arithmeticListHelper(i + 1, diff, seq, n);
		}

	}

	/**
	 * Return whether or not an array represents the first n numbers of an
	 * arithmetic sequence. An arithmetic sequence has a common difference between
	 * every two adjacent terms. The array may or may not be empty. e.g.,
	 * isArithmeticArray({1, 3, 5, 8, 10}) returns false and isArithmeticArray({1,
	 * 3, 5, 7, 9}) returns true (because the common difference is 2).
	 * 
	 * @param a an array
	 * @return true if input array a represents an arithmetic sequence; false
	 *         otherwise.
	 * 
	 *         <b>You are forbidden to use the isArithmeticList method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticArray(int[] a) {
		/*
		 * Your Task: Make use of the recursive method isArithmeticArrayHelper.
		 */
		int size1 = a.length;
		if (size1 > -1 && size1 < 3) {
			return true;
		} else if (size1 > 2) {
			int diff = a[1] - a[0];
			return isArithmeticArrayHelper(1, diff, a);
		}
		return false;
	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticArray.
	 * 
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param a    an array which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `a` with indices i - 1, i, i + 1,
	 *         ..., a.length - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `a` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., a.length - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticArrayHelper(int i, int diff, int[] a) {
		/*
		 * Your Task
		 */
		int size1 = a.length - 1;
		if (diff != (a[i] - a[i - 1])) {
			return false;
		} else if (size1 == i) {
			return (diff == (a[i] - a[i - 1]));
		}
		return isArithmeticArrayHelper(i + 1, diff, a);

	}
	// Both works

//	if(size1 == i) {
//		return (diff == (a[i]-a[i-1]));
//	} else if(diff != (a[i]-a[i-1])) {
//		return false;
//	} else {
//		return isArithmeticArrayHelper(i+1, diff, a);
//	}

	/**
	 * Return whether or not a list represents the first n numbers of an arithmetic
	 * sequence. An arithmetic sequence has a common difference between every two
	 * adjacent terms. The list may or may not be empty. e.g., isArithmeticList({1,
	 * 3, 5, 8, 10}) returns false and isArithmeticList({1, 3, 5, 7, 9}) returns
	 * true (because the common difference is 2).
	 * 
	 * @param l a list
	 * @return true if input list l represents an arithmetic sequence; false
	 *         otherwise.
	 * 
	 *         <b>You are forbidden to use the isArithmeticArray method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticList(List<Integer> l) {
		/*
		 * Your Task: Make use of the recursive method isArithmeticListHelper.
		 */
		if (l.size() > -1 && l.size() < 3) {
			return true;
		} else if (l.size() > 1) {
			int diff = l.get(1) - l.get(0);
			return isArithmeticListHelper(1, diff, l);
		}

		return false;
	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticList.
	 * 
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param l    a list which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `l` with indices i - 1, i, i + 1,
	 *         ..., l.size() - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `l` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., l.size() - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticListHelper(int i, int diff, List<Integer> l) {
		/*
		 * Your Task
		 */
		int size = l.size() - 1;
		if (size == i) {
			return l.get(i) - l.get(i - 1) == diff;
		} else if (l.get(i) - l.get(i - 1) == diff) {
			return isArithmeticListHelper(i + 1, diff, l);
		}
		return false; // no need for this
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 *         <b>You are forbidden to use the insertIntoSortedList method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		int[] newarray = new int[a.length + 1];

		// If the length of array is 0, then adds i and returns it
		if (a.length == 0) {
			newarray[0] = i;
			return newarray;
			// If the last value of array is less than i, then adds i
			// to the end of the new array
		} else if (a[a.length - 1] < i) {
			newarray[newarray.length - 1] = i;
		}

		// counter starts from index 0
		insertIntoSortedArrayHelper(a, i, newarray, 0);

		return newarray;
	}

	public void insertIntoSortedArrayHelper(int[] a, int i, int[] newarr, int counter) {
		// new array with size+1
		// If the counter is less than the max index
		if (counter < newarr.length - 1) {
			// If a is less than i, then add a to new array
			if (a[counter] < i) {
				newarr[counter] = a[counter];
			}
			// Else if a is greater/eq than i and if the current index
			// Is less than i then adds i to newarr and adds a to newarr +1
			else if (a[counter] >= i && newarr[counter] <= i) {
				newarr[counter] = i;
				newarr[counter + 1] = a[counter];
			}
			// Else if a is greater/eq than i and if newarr is greater/eq than i
			// Then we know i is already in newarr so we add a to newarr +1
			else if (a[counter] >= i && newarr[counter] >= i) {
				newarr[counter + 1] = a[counter];
			}
			// recursion
			insertIntoSortedArrayHelper(a, i, newarr, counter + 1);
		}

	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param list a list that is sorted in a non-descending order
	 * @param i    an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 *         <b>You are forbidden to use the insertIntoSortedArray method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		// if size=0 or ending is less than i then add i to end
		if (list.size() == 0 || list.get(list.size() - 1) < i) {
			list.add(i);
			return list;
		} else if (list.get(0) > i) {
			list.add(0, i);
			return list;
		}
		insertIntoSortedListHelper(list, i, 0);
		return list;
	}

	public void insertIntoSortedListHelper(List<Integer> list, int i, int counter) {

		if (counter < list.size() - 1) {
			if (list.get(counter) <= i && list.get(counter + 1) >= i) {
				list.add(counter + 1, i);
			} else {
				insertIntoSortedListHelper(list, i, counter + 1);
			}
		}
	}

	/**
	 * Given two sorted arrays left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return an array (of size left.length + right.length) sorted in a
	 * non-descending order, consisting of all elements of arrays left and right.
	 * 
	 * @param left  an array sorted in a non-descending order
	 * @param right an array sorted in a non-ascending order
	 * @return a sorted array of size left.length + right.length, consisting of all
	 *         elements of arrays left and right. e.g., mergeSortedArraysV2({1, 3,
	 *         5, 7}, {8, 6, 4, 2}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         <b>You are forbidden to use the mergeSortedListsV2 method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		int sizecombined = left.length + right.length;
		int[] mergarr = new int[sizecombined];
		mergeSortedArraysHelper(left, right, mergarr, 0, right.length - 1, 0);

		return mergarr;
	}

	public void mergeSortedArraysHelper(int[] left, int[] right, int[] mergarr, int countL, int countR, int countmerg) {

		if (countmerg != mergarr.length) {
			// if right array reached end, add the left array till the end
			if (countR == -1) {
				mergarr[countmerg] = left[countL++];
			} else if (countL == left.length) {
				mergarr[countmerg] = right[countR--];
			} else if (left[countL] <= right[countR]) {
				mergarr[countmerg] = left[countL++];
			} else if (left[countL] >= right[countR]) {
				mergarr[countmerg] = right[countR--];
			}
			mergeSortedArraysHelper(left, right, mergarr, countL, countR, countmerg + 1);
		}
	}
	// wont work since the next index does not exist
//	if(countL != left.length) {
//		insertIntoSortedArray(mergarr, left[countL]);
//		mergeSortedArraysHelper(left, right, mergarr, countL+1, countR);
//	}
//	else if (countR != right.length) {
//		/**do*/
//		insertIntoSortedArray(mergarr, right[countR]);
//		mergeSortedArraysHelper(left, right, mergarr, countL, countR+1);
//	}

	/**
	 * Given two sorted lists left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return a list (of size left.length + right.length) sorted in a non-descending
	 * order, consisting of all elements of lists left and right.
	 * 
	 * @param left  a list sorted in a non-descending order
	 * @param right a list sorted in a non-ascending order
	 * @return a sorted list of size left.size() + right.size(), consisting of all
	 *         elements of lists left and right. e.g., mergeSortedListsV2({1, 3, 5,
	 *         7}, {8, 6, 4, 2}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         <b>You are forbidden to use the mergeSortedArraysV2 method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence Sof a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */

		ArrayList<Integer> mergarr = new ArrayList<Integer>();
		mergeSortedListsHelper(left, right, mergarr, 0, right.size() - 1, 0);

		return mergarr;
	}

	public void mergeSortedListsHelper(List<Integer> left, List<Integer> right, List<Integer> mergarr, int countL,
			int countR, int countmerg) {
		if (countmerg != left.size() + right.size()) {
			if (countL == left.size()) {
				// add right array b/c left is added to merg
				mergarr.add(right.get(countR--));
			} else if (countR == -1) {
				// add left array b/c right is added to merg
				mergarr.add(left.get(countL++));
			} else if (left.get(countL) <= right.get(countR)) {
				mergarr.add(left.get(countL++));
			} else if (left.get(countL) >= right.get(countR)) {
				mergarr.add(right.get(countR--));
			}
			mergeSortedListsHelper(left, right, mergarr, countL, countR, countmerg + 1);
		}
	}
}
