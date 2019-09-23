package eecs2030.lab2;

import static org.junit.Assert.*;

import java.util.Date;


public class CommonTests {

	public static void test_equalsSelf(Object obj) {
		assertTrue("x.equals(x) failed to return true", obj.equals(obj));
	}

	public static void test_equalsNull(Object obj) {
		assertFalse("x.equals(null) failed to return false", obj.equals(null));
	}
	
	public static void test_equalsOtherClass(Object obj) {
		String s = "hello";
		assertFalse("x.equals(\"hello\") failed to return false", obj.equals(s));
		
		Date d = new Date();
		assertFalse("x.equals(new Date()) failed to return false", obj.equals(d));
	}
}
