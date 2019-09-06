import static org.junit.Assert.*;

import org.junit.Test;

public class TestSort {

	@Test
	public void testSelectionSort_1() {
		int[] a = {};
		int[] sorted = {};
		RecursiveMethods.selectionSort(a);
		assertArrayEquals(sorted, a);
	}
	
	@Test
	public void testSelectionSort_2() {
		int[] a = {4};
		int[] sorted = {4};
		RecursiveMethods.selectionSort(a);
		assertArrayEquals(sorted, a);
	}
	
	@Test
	public void testSelectionSort_3() {
		int[] a = {5, 4};
		int[] sorted = {4, 5};
		RecursiveMethods.selectionSort(a);
		assertArrayEquals(sorted, a);
	}
	
	@Test
	public void testSelectionSort_4() {
		int[] a = {5, 4, 3, 2, 1};
		int[] sorted = {1, 2, 3, 4, 5};
		RecursiveMethods.selectionSort(a);
		assertArrayEquals(sorted, a);
	}
	
	@Test
	public void testSelectionSort_5() {
		int[] a = {5, 4, 4, 3, 2, 2, 1};
		int[] sorted = {1, 2, 2, 3, 4, 4, 5};
		RecursiveMethods.selectionSort(a);
		assertArrayEquals(sorted, a);
	}
}
