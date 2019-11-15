import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class RecursiveMethodsTest {
	
	@Rule
    public Timeout globalTimeout = Timeout.seconds(2);
	
	@Test
	public void testArithmeticArrayHelper() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] seq = new int[5];
		seq[0] = 4;
		/* Start filling up `seq` as an arithmetic sequence from index 1, 
		 * with common difference 3.
		 */
		rm.arithmeticArrayHelper(1, 3, seq);
		int[] expected = {4, 7, 10, 13, 16};
		assertArrayEquals(expected, seq);
	}
	
	@Test
	public void testArithmeticArray1() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] seq = rm.arithmeticArray(4, 3, 0);
		int[] expected = {};
		assertArrayEquals(expected, seq);
	}
	
	@Test
	public void testArithmeticArray2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] seq = rm.arithmeticArray(4, 3, 1);
		int[] expected = {4};
		assertArrayEquals(expected, seq);
	}
	
	@Test
	public void testArithmeticArray3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] seq = rm.arithmeticArray(4, 3, 5);
		int[] expected = {4, 7, 10, 13, 16};
		assertArrayEquals(expected, seq);
	}
	
	@Test
	public void testArithmeticArray4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] seq = rm.arithmeticArray(4, 3, 10);
		int[] expected = {4, 7, 10, 13, 16, 19, 22, 25, 28, 31};
		assertArrayEquals(expected, seq);
	}
	
	@Test
	public void testArithmeticArray5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] seq = rm.arithmeticArray(4, -3, 10);
		int[] expected = {4, 1, -2, -5, -8, -11, -14, -17, -20, -23};
		assertArrayEquals(expected, seq);
	}
	
	@Test
	public void testArithmeticListHelper() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> seq = new ArrayList<>();
		seq.add(4);
		/* Start filling up `seq` as an arithmetic sequence from index 1, 
		 * with common difference 3.
		 */
		rm.arithmeticListHelper(1, 3, seq, 5);
		int[] expected = {4, 7, 10, 13, 16};
		assertEquals(a2l(expected), seq);
	}
	
	@Test
	public void testArithmeticList1() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> seq = rm.arithmeticList(4, 3, 0);
		int[] expected = {};
		assertEquals(a2l(expected), seq);
	}
	
	@Test
	public void testArithmeticList2() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> seq = rm.arithmeticList(4, 3, 1);
		int[] expected = {4};
		assertEquals(a2l(expected), seq);
	}
	
	@Test
	public void testArithmeticList3() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> seq = rm.arithmeticList(4, 3, 5);
		int[] expected = {4, 7, 10, 13, 16};
		assertEquals(a2l(expected), seq);
	}
	
	@Test
	public void testArithmeticList4() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> seq = rm.arithmeticList(4, 3, 10);
		int[] expected = {4, 7, 10, 13, 16, 19, 22, 25, 28, 31};
		assertEquals(a2l(expected), seq);
	}
	
	@Test
	public void testArithmeticList5() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> seq = rm.arithmeticList(4, -3, 10);
		int[] expected = {4, 1, -2, -5, -8, -11, -14, -17, -20, -23};
		assertEquals(a2l(expected), seq);
	}
	
	
	@Test
	public void testIsArithmeticArrayHelper() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] seq1 = {4, 7, 10, 13, 16};
		/*
		 * Is `seq` an arithmetic sequence with common difference 3 starting from index 1.
		 */
		assertTrue(rm.isArithmeticArrayHelper(1, 3, seq1));
		
		int[] seq2 = {4, 7, 11, 14, 17};
		assertFalse(rm.isArithmeticArrayHelper(1, 3, seq2));
	}
	
	@Test
	public void testIsArithmeticArray1() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {};
		assertTrue(rm.isArithmeticArray(a));
	}
	
	@Test
	public void testIsArithmeticArray2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {7};
		assertTrue(rm.isArithmeticArray(a));
	}
	
	@Test
	public void testIsArithmeticArray3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {7, 10};
		assertTrue(rm.isArithmeticArray(a));
	}
	
	@Test
	public void testIsArithmeticArray4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {10, 7};
		assertTrue(rm.isArithmeticArray(a));
	}
	
	@Test
	public void testIsArithmeticArray5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {7, 10, 13, 16, 19, 22, 25, 28};
		assertTrue(rm.isArithmeticArray(a));
	}
	
	@Test
	public void testIsArithmeticArray6() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {7, 10, 13, 16, 20, 23, 26, 29};
		assertFalse(rm.isArithmeticArray(a));
	}
	
	@Test
	public void testIsArithmeticArray7() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {7, 10, 13, 16, 19, 22, 25, 29};
		assertFalse(rm.isArithmeticArray(a));
	}
	
	@Test
	public void testIsArithmeticArray8() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {29, 26, 23, 20, 17, 14, 11, 8};
		assertTrue(rm.isArithmeticArray(a));
	}
	
	@Test
	public void testIsArithmeticArray9() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {29, 26, 23, 20, 16, 13, 10, 7};
		assertFalse(rm.isArithmeticArray(a));
	}
	
	@Test
	public void testIsArithmeticArray10() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {29, 25, 22, 19, 16, 13, 10, 7};
		assertFalse(rm.isArithmeticArray(a));
	} 
	
	@Test
	public void testIsArithmeticListHelper() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] seq1 = {4, 7, 10, 13, 16};
		/*
		 * Is `seq` an arithmetic sequence with common difference 3 starting from index 1.
		 */
		assertTrue(rm.isArithmeticListHelper(1, 3, a2l(seq1)));
		
		int[] seq2 = {4, 7, 11, 14, 17};
		assertFalse(rm.isArithmeticListHelper(1, 3, a2l(seq2)));
	}
	
	@Test
	public void testIsArithmeticList1() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {};
		assertTrue(rm.isArithmeticList(a2l(a)));
	}
	
	@Test
	public void testIsArithmeticList2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {7};
		assertTrue(rm.isArithmeticList(a2l(a)));
	}
	
	@Test
	public void testIsArithmeticList3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {7, 10};
		assertTrue(rm.isArithmeticList(a2l(a)));
	}
	
	@Test
	public void testIsArithmeticList4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {10, 7};
		assertTrue(rm.isArithmeticList(a2l(a)));
	}
	
	@Test
	public void testIsArithmeticList5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {7, 10, 13, 16, 19, 22, 25, 28};
		assertTrue(rm.isArithmeticList(a2l(a)));
	}
	
	@Test
	public void testIsArithmeticList6() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {7, 10, 13, 16, 20, 23, 26, 29};
		assertFalse(rm.isArithmeticList(a2l(a)));
	}
	
	@Test
	public void testIsArithmeticList7() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {7, 10, 13, 16, 19, 22, 25, 29};
		assertFalse(rm.isArithmeticList(a2l(a)));
	}
	
	@Test
	public void testIsArithmeticList8() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {29, 26, 23, 20, 17, 14, 11, 8};
		assertTrue(rm.isArithmeticList(a2l(a)));
	}
	
	@Test
	public void testIsArithmeticList9() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {29, 26, 23, 20, 16, 13, 10, 7};
		assertFalse(rm.isArithmeticList(a2l(a)));
	}
	
	@Test
	public void testIsArithmeticList10() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a = {29, 25, 22, 19, 16, 13, 10, 7};
		assertFalse(rm.isArithmeticList(a2l(a)));
	} 

	@Test
	public void testInsertIntoSortedArray1() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa0 = {};
		int[] sa1 = rm.insertIntoSortedArray(sa0, 1);
		int[] sa1_ = {1};
		assertArrayEquals(sa1, sa1_);
	}
	
	@Test
	public void testInsertIntoSortedArray2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa0 = rm.insertIntoSortedArray(sa, 0);
		int[] sa0_ = {0, 1, 3, 5};
		assertArrayEquals(sa0, sa0_);
	}
	
	@Test
	public void testInsertIntoSortedArray3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa1 = rm.insertIntoSortedArray(sa, 1);
		int[] sa1_ = {1, 1, 3, 5};
		assertArrayEquals(sa1, sa1_);
	}
	
	@Test
	public void testInsertIntoSortedArray4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa2 = rm.insertIntoSortedArray(sa, 2);
		int[] sa2_ = {1, 2, 3, 5};
		assertArrayEquals(sa2, sa2_);
	}
	
	@Test
	public void testInsertIntoSortedArray5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa3 = rm.insertIntoSortedArray(sa, 3);
		int[] sa3_ = {1, 3, 3, 5};
		assertArrayEquals(sa3, sa3_);
	}
	
	@Test
	public void testInsertIntoSortedArray6() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa4 = rm.insertIntoSortedArray(sa, 4);
		int[] sa4_ = {1, 3, 4, 5};
		assertArrayEquals(sa4, sa4_);
	}
	
	@Test
	public void testInsertIntoSortedArray7() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa5 = rm.insertIntoSortedArray(sa, 5);
		int[] sa5_ = {1, 3, 5, 5};
		assertArrayEquals(sa5, sa5_);
	}
	
	@Test
	public void testInsertIntoSortedArray8() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa6 = rm.insertIntoSortedArray(sa, 6);
		int[] sa6_ = {1, 3, 5, 6};
		assertArrayEquals(sa6, sa6_);
	}
	
	@Test
	public void testInsertIntoSortedList1() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> sl0 = new ArrayList<>();
		List<Integer> sl1 = rm.insertIntoSortedList(sl0, 1);
		int[] sa1 = {1};
		List<Integer> sl1_ = a2l(sa1);
		assertEquals(sl1, sl1_);
	}
	
	@Test
	public void testInsertIntoSortedList2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl0 = rm.insertIntoSortedList(sl, 0);
		int[] sa0_ = {0, 1, 3, 5};
		List<Integer> sl0_ = a2l(sa0_);
		assertEquals(sl0, sl0_);
	}
	
	@Test
	public void testInsertIntoSortedList3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl1 = rm.insertIntoSortedList(sl, 1);
		int[] sa1_ = {1, 1, 3, 5};
		List<Integer> sl1_ = a2l(sa1_);
		assertEquals(sl1, sl1_);
	}
	
	@Test
	public void testInsertIntoSortedList4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl2 = rm.insertIntoSortedList(sl, 2);
		int[] sa2_ = {1, 2, 3, 5};
		List<Integer> sl2_ = a2l(sa2_);
		assertEquals(sl2, sl2_);
	}
	
	@Test
	public void testInsertIntoSortedList5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl3 = rm.insertIntoSortedList(sl, 3);
		int[] sa3_ = {1, 3, 3, 5};
		List<Integer> sl3_ = a2l(sa3_);
		assertEquals(sl3, sl3_);
	}
	
	@Test
	public void testInsertIntoSortedList6() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl4 = rm.insertIntoSortedList(sl, 4);
		int[] sa4_ = {1, 3, 4, 5};
		List<Integer> sl4_ = a2l(sa4_);
		assertEquals(sl4, sl4_);
	}
	
	@Test
	public void testInsertIntoSortedList7() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl5 = rm.insertIntoSortedList(sl, 5);
		int[] sa5_ = {1, 3, 5, 5};
		List<Integer> sl5_ = a2l(sa5_);
		assertEquals(sl5, sl5_);
	}
	
	@Test
	public void testInsertIntoSortedList8() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl6 = rm.insertIntoSortedList(sl, 6);
		int[] sa6_ = {1, 3, 5, 6};
		List<Integer> sl6_ = a2l(sa6_);
		assertEquals(sl6, sl6_);
	}
	
	@Test
	public void testMergeSortedArrays_1() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {};
		int[] R = {};
		int[] merge = rm.mergeSortedArrays(L, R);
		int[] expected = {};
		assertArrayEquals(expected, merge);
	}
	
	@Test
	public void testMergeSortedArrays_2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {};
		int[] R = {3, 2, 1};
		int[] merge = rm.mergeSortedArrays(L, R);
		int[] expected = {1, 2, 3};
		assertArrayEquals(expected, merge);
	}
	
	@Test
	public void testMergeSortedArrays_3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {1, 2, 3};
		int[] R = {};
		int[] merge = rm.mergeSortedArrays(L, R);
		int[] expected = {1, 2, 3};
		assertArrayEquals(expected, merge);
	}
	
	@Test
	public void testMergeSortedArrays_4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {-3, -1, 1, 3, 5, 7};
		int[] R = {10, 9, 8, 6, 4, 2};
		int[] merge = rm.mergeSortedArrays(L, R);
		int[] expected = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(expected, merge);
	}
	
	@Test
	public void testMergeSortedArrays_5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {2, 4, 6, 8, 9, 10};
		int[] R = {7, 5, 3, 1, -1, -3};
		int[] merge = rm.mergeSortedArrays(L, R);
		int[] expected = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(expected, merge);
	}
	
	@Test
	public void testMergeSortedArrays_6() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {2, 4, 6};
		int[] R = {10, 9, 8, 7, 5, 3, 1, -1, -3};
		int[] merge = rm.mergeSortedArrays(L, R);
		int[] expected = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(expected, merge);
	}
	
	@Test
	public void testMergeSortedArrays_7() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {-3, -1, 1, 3, 5, 7, 8, 9, 10};
		int[] R = {6, 4, 2};
		int[] merge = rm.mergeSortedArrays(L, R);
		int[] expected = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(expected, merge);
	}
	
	@Test
	public void testMergeSortedLists_1() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {};
		int[] R = {};
		List<Integer> merge = rm.mergeSortedLists(a2l(L), a2l(R));
		int[] expected = {};
		assertEquals(a2l(expected), merge);
	}
	
	@Test
	public void testMergeSortedLists_2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {};
		int[] R = {3, 2, 1};
		List<Integer> merge = rm.mergeSortedLists(a2l(L), a2l(R));
		int[] expected = {1, 2, 3};
		assertEquals(a2l(expected), merge);
	}
	
	@Test
	public void testMergeSortedLists_3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {1, 2, 3};
		int[] R = {};
		List<Integer> merge = rm.mergeSortedLists(a2l(L), a2l(R));
		int[] expected = {1, 2, 3};
		assertEquals(a2l(expected), merge);
	}
	
	@Test
	public void testMergeSortedLists_4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {-3, -1, 1, 3, 5, 7};
		int[] R = {10, 9, 8, 6, 4, 2};
		List<Integer> merge = rm.mergeSortedLists(a2l(L), a2l(R));
		int[] expected = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertEquals(a2l(expected), merge);
	}
	
	@Test
	public void testMergeSortedLists_5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {2, 4, 6, 8, 9, 10};
		int[] R = {7, 5, 3, 1, -1, -3};
		List<Integer> merge = rm.mergeSortedLists(a2l(L), a2l(R));
		int[] expected = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertEquals(a2l(expected), merge);
	}
	
	@Test
	public void testMergeSortedLists_6() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {2, 4, 6};
		int[] R = {10, 9, 8, 7, 5, 3, 1, -1, -3};
		List<Integer> merge = rm.mergeSortedLists(a2l(L), a2l(R));
		int[] expected = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertEquals(a2l(expected), merge);
	}
	
	@Test
	public void testMergeSortedLists_7() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L = {-3, -1, 1, 3, 5, 7, 8, 9, 10};
		int[] R = {6, 4, 2};
		List<Integer> merge = rm.mergeSortedLists(a2l(L), a2l(R));
		int[] expected = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertEquals(a2l(expected), merge);
	}
	
	private List<Integer> a2l(int[] a) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < a.length; i ++) {
			list.add(a[i]);
		}
		return list;
	}
}
