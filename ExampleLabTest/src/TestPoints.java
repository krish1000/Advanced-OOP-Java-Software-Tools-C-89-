import static org.junit.Assert.*;

import org.junit.Test;

public class TestPoints {

	@Test
	public void test1() {
		Point p = new Point(3, 4);
		int x = p.getX();
		int y = p.getY();
		assertEquals(3, x);
		assertEquals(4, y);
	}

	@Test
	public void test2() {
		Point p = new Point();
		int x = p.getX();
		int y = p.getY();
		assertEquals(0, x);
		assertEquals(0, y);
		p.setX(3);
		p.setY(4);
		x = p.getX();
		y = p.getY();
		assertEquals(3, x);
		assertEquals(4, y);
	}
	
	@Test
	public void test3() {
		PointCollector pc = new PointCollector();
		Point[] points = pc.getPoints();
		assertEquals(0, points.length);
	}
	
	@Test
	public void test4() {
		PointCollector pc = new PointCollector();
		Point p1 = new Point(3, 4);
		Point p2 = new Point();
		p2.setX(6);
		p2.setY(8);
		pc.addPoint(p1);
		pc.addPoint(p2);
		Point[] points = pc.getPoints();
		assertEquals(2, points.length);
		assertEquals(p1.getX(), points[0].getX());
		assertEquals(p1.getY(), points[0].getY());
		assertEquals(p2.getX(), points[1].getX());
		assertEquals(p2.getY(), points[1].getY());
	}
	
	@Test
	public void test5() {
		PointCollector pc = new PointCollector();
		pc.addPoint(3, 4);
		pc.addPoint(6, 8);
		Point[] points = pc.getPoints();
		assertEquals(2, points.length);
		assertEquals(3, points[0].getX());
		assertEquals(4, points[0].getY());
		assertEquals(6, points[1].getX());
		assertEquals(8, points[1].getY());
	}
}
