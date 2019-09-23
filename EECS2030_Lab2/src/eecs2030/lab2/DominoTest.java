package eecs2030.lab2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DominoTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);
	
	

	@Test
	public void test01_getSmallerValue() {
		for (int v1 = 0; v1 <= 6; v1++) {
			for (int v2 = v1; v2 <= 6; v2++) {
				Domino d = new Domino(v1, v2);
				assertEquals("getSmallerValue returned the larger value", 
						v1, d.getSmallerValue());
				
				d = new Domino(v2, v1);
				assertEquals("getSmallerValue returned the larger value", 
						v1, d.getSmallerValue());
			}
		}
	}
	
	@Test
	public void test02_getLargerValue() {
		for (int v1 = 0; v1 <= 6; v1++) {
			for (int v2 = v1; v2 <= 6; v2++) {
				Domino d = new Domino(v1, v2);
				assertEquals("getLargerValue returned the smaller value", 
						v2, d.getLargerValue());
				
				d = new Domino(v2, v1);
				assertEquals("getLargerValue returned the smaller value", 
						v2, d.getLargerValue());
			}
		}
	}
	
	@Test
	public void test03_compareToLessThan() {
		// generate all dominoes in sorted ascending order
		List<Domino> all1 = new ArrayList<>();
		List<Domino> all2 = new ArrayList<>();
		for (int v1 = 0; v1 <= 6; v1++) {
			for (int v2 = v1; v2 <= 6; v2++) {
				all1.add(new Domino(v1, v2));
				all2.add(new Domino(v2, v1));
			}
		}
		
		// test that each domino is smaller than every domino after
		// it in the list
		for (int i = 0; i < all1.size(); i++) {
			for (int j = i + 1; j < all1.size(); j++) {
				Domino di = all1.get(i);
				Domino dj = all1.get(j);
				String error = String.format("(%s).compareTo(%s) should return a negative int", di, dj);
				assertTrue(error, di.compareTo(dj) < 0);
				
				// also try the same domino di with faces flipped
				di = all2.get(i);
				error = String.format("(%s).compareTo(%s) should return a negative int", di, dj);
				assertTrue(error, di.compareTo(dj) < 0);
			}
		}
	}
	
	@Test
	public void test04_compareToGreaterThan() {
		// generate all dominoes in sorted ascending order
		List<Domino> all1 = new ArrayList<>();
		List<Domino> all2 = new ArrayList<>();
		for (int v1 = 0; v1 <= 6; v1++) {
			for (int v2 = v1; v2 <= 6; v2++) {
				all1.add(new Domino(v1, v2));
				all2.add(new Domino(v2, v1));
			}
		}
		
		// test that each domino is greater than every domino before
		// it in the list
		for (int i = 0; i < all1.size(); i++) {
			for (int j = i + 1; j < all1.size(); j++) {
				Domino di = all1.get(i);
				Domino dj = all1.get(j);
				String error = String.format("(%s).compareTo(%s) should return a positive int", dj, di);
				assertTrue(error, dj.compareTo(di) > 0);
				
				// also try the same domino di with faces flipped
				di = all2.get(i);
				error = String.format("(%s).compareTo(%s) should return a positive int", dj, di);
				assertTrue(error, dj.compareTo(di) > 0);
			}
		}
	}
	
	@Test
	public void test05_equals() {
		// generate all dominoes in sorted ascending order
		List<Domino> all1 = new ArrayList<>();
		List<Domino> all2 = new ArrayList<>();
		for (int v1 = 0; v1 <= 6; v1++) {
			for (int v2 = v1; v2 <= 6; v2++) {
				all1.add(new Domino(v1, v2));
				all2.add(new Domino(v2, v1));
			}
		}
		
		// test that each domino is equal to itself and to
		// the domino with the same faces in reverse order
		for (int i = 0; i < all1.size(); i++) {
			Domino di = all1.get(i);
			Domino dj = all2.get(i);
			String error = String.format("(%s).compareTo(%s) should return 0", di, di);
			assertEquals(error, 0, di.compareTo(di));
				
			// also try the same domino with faces flipped
			error = String.format("(%s).compareTo(%s) should return 0", di, dj);
			assertEquals(error, 0, di.compareTo(dj));
		}
	}
	
	
	@Test
	public void test06_equalsSelf() {
		CommonTests.test_equalsSelf(new Domino(2, 5));
		CommonTests.test_equalsSelf(new Domino(1, 1));
		CommonTests.test_equalsSelf(new Domino(4, 6));
		CommonTests.test_equalsSelf(new Domino(5, 1));
	}
	
	
	@Test
	public void test07_equalsNull() {
		CommonTests.test_equalsNull(new Domino(2, 5));
		CommonTests.test_equalsNull(new Domino(1, 1));
		CommonTests.test_equalsNull(new Domino(4, 6));
		CommonTests.test_equalsNull(new Domino(5, 1));
	}
	
	@Test
	public void test08_equalsOtherClass() {
		CommonTests.test_equalsOtherClass(new Domino(2, 5));
		CommonTests.test_equalsOtherClass(new Domino(1, 1));
		CommonTests.test_equalsOtherClass(new Domino(4, 6));
		CommonTests.test_equalsOtherClass(new Domino(5, 1));
	}
	
	
	@Test
	public void test09_equals() {
		// tests if three dominoes with the same values are equal
		for (int v1 = 0; v1 <= 6; v1++) {
			for (int v2 = 0; v2 <= 6; v2++) {
				Domino d1 = new Domino(v1, v2);
				Domino d2 = new Domino(v1, v2);
				Domino d3 = new Domino(v2, v1);
				assertTrue(d1.equals(d2));
				assertTrue(d2.equals(d1));
				assertTrue(d1.equals(d3));
				assertTrue(d3.equals(d1));
			}
		}
	}
	
	@Test
	public void test10_equals() {
		// tests all dominoes having unequal values
		for (int v1 = 0; v1 <= 6; v1++) {
			for (int v2 = 0; v2 <= 6; v2++) {
				Domino d = new Domino(v1, v2);
				for (int u1 = 0; u1 <= 6; u1++) {
					for (int u2 = 0; u2 <= 6; u2++) {
						if (u1 != v1 && u1 != v2) {
							Domino x = new Domino(u1, u2);
							Domino y = new Domino(u2, u1);
							assertFalse(d.equals(x));
							assertFalse(x.equals(d));
							assertFalse(d.equals(y));
							assertFalse(y.equals(d));
						}
					}
				}
			}
		}
	}
	
}
