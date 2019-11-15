package aggregation;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAggregation {

	@Test
	public void testLine() {
		Point p1 = new Point(2, 4);
		Point p2 = new Point(6, 10);
		Point p3 = new Point(6, 10);
		assertTrue(p1 != p2);
		assertTrue(!p1.equals(p2));
		assertTrue(p2 != p3);
		assertTrue(p2.equals(p3));
		
		Point p4 = new Point(p3);
		assertTrue(p3 != p4);
		assertTrue(p3.equals(p4));
		
		Line l1 = new Line(p1, p2);
		Line l2 = new Line(p1, p2);
		assertTrue(l1.getStart() == l2.getStart());
		assertTrue(l1.getEnd() == l2.getEnd());
		assertTrue(l1.getStart().equals(l2.getStart()));
		assertTrue(l1.getEnd().equals(l2.getEnd()));
		
		Line l3 = new Line(l1);
		assertTrue(l1 != l3);
		assertTrue(l1.equals(l3));
		assertTrue(l1.getStart() == l3.getStart());
		assertTrue(l1.getEnd() == l3.getEnd());
		assertTrue(l1.getStart().equals(l3.getStart()));
		assertTrue(l1.getEnd().equals(l3.getEnd()));
	}
	
	@Test
	public void testLineCollector1() {
		Point p1 = new Point(2, 4);
		Point p2 = new Point(6, 10);
		
		Line l1 = new Line(p1, p2);
		Line l3 = l1;
		
		LineCollector lc = new LineCollector();
		lc.addLine(l1);
		lc.addLine(l1);
		lc.addLine(l3);
		/* getLineAt(0) returns the first inserted line, 
		 * getLineAt(1) returns the second inersted lined,
		 * and so on. */
		assertTrue(lc.getLineAt(0) == l1);
		assertTrue(lc.getLineAt(1) == l1);
		assertTrue(lc.getLineAt(2) == l1);
		assertTrue(lc.getLineAt(2) == l3);
		
			
		assertTrue(lc.getLineAt(0).getStart() == l1.getStart());
		assertTrue(lc.getLineAt(0).getEnd() == l1.getEnd());
		assertTrue(lc.getLineAt(1).getStart() == l1.getStart());
		assertTrue(lc.getLineAt(1).getEnd() == l1.getEnd());
		assertTrue(lc.getLineAt(2).getStart() == l1.getStart());
		assertTrue(lc.getLineAt(2).getEnd() == l1.getEnd());
		assertTrue(lc.getLineAt(2).getStart() == l1.getStart());
		assertTrue(lc.getLineAt(2).getEnd() == l1.getEnd());
			
		assertTrue(lc.getLineAt(0).equals(l1));
		assertTrue(lc.getLineAt(1).equals(l1));
		assertTrue(lc.getLineAt(2).equals(l1));
		assertTrue(lc.getLineAt(2).equals(l3));
			
		assertTrue(lc.getLineAt(0).getStart().equals(l1.getStart()));
		assertTrue(lc.getLineAt(0).getEnd().equals(l1.getEnd()));
		assertTrue(lc.getLineAt(1).getStart().equals(l1.getStart()));
		assertTrue(lc.getLineAt(1).getEnd().equals(l1.getEnd()));
		assertTrue(lc.getLineAt(2).getStart().equals(l1.getStart()));
		assertTrue(lc.getLineAt(2).getEnd().equals(l1.getEnd()));
		assertTrue(lc.getLineAt(2).getStart().equals(l1.getStart()));
		assertTrue(lc.getLineAt(2).getEnd().equals(l1.getEnd()));
		
		Line[] lines = lc.getLines();
		assertTrue(lines[0] == l1);
		assertTrue(lines[1] == l1);
		assertTrue(lines[2] == l1);
		assertTrue(lines[2] == l3);
			
		assertTrue(lines[0].getStart() == l1.getStart());
		assertTrue(lines[0].getEnd() == l1.getEnd());
		assertTrue(lines[1].getStart() == l1.getStart());
		assertTrue(lines[1].getEnd() == l1.getEnd());
		assertTrue(lines[2].getStart() == l1.getStart());
		assertTrue(lines[2].getEnd() == l1.getEnd());
		assertTrue(lines[2].getStart() == l1.getStart());
		assertTrue(lines[2].getEnd() == l1.getEnd());
			
		assertTrue(lines[0].equals(l1));
		assertTrue(lines[1].equals(l1));
		assertTrue(lines[2].equals(l1));
		assertTrue(lines[2].equals(l3));
			
		assertTrue(lines[0].getStart().equals(l1.getStart()));
		assertTrue(lines[0].getEnd().equals(l1.getEnd()));
		assertTrue(lines[1].getStart().equals(l1.getStart()));
		assertTrue(lines[1].getEnd().equals(l1.getEnd()));
		assertTrue(lines[2].getStart().equals(l1.getStart()));
		assertTrue(lines[2].getEnd().equals(l1.getEnd()));
		assertTrue(lines[2].getStart().equals(l1.getStart()));
		assertTrue(lines[2].getEnd().equals(l1.getEnd()));
	}
	
	@Test
	public void testLineCollector2() {
		Point p1 = new Point(2, 4);
		Point p2 = new Point(6, 10);
		
		Line l1 = new Line(p1, p2);
		Line l3 = l1;
		
		LineCollector lc1 = new LineCollector();
		lc1.addLine(l1);
		lc1.addLine(l1);
		lc1.addLine(l3);
		
		LineCollector lc2 = new LineCollector(lc1);
		assertTrue(lc1 != lc2);
		assertTrue(lc1.equals(lc2));
			
		assertTrue(lc1.getLineAt(0) == lc2.getLineAt(0));
		assertTrue(lc1.getLineAt(1) == lc2.getLineAt(1));
		assertTrue(lc1.getLineAt(2) == lc2.getLineAt(2));
			
		assertTrue(lc1.getLineAt(0).getStart() == lc2.getLineAt(0).getStart());
		assertTrue(lc1.getLineAt(0).getEnd() == lc2.getLineAt(0).getEnd());
		assertTrue(lc1.getLineAt(1).getStart() == lc2.getLineAt(1).getStart());
		assertTrue(lc1.getLineAt(1).getEnd() == lc2.getLineAt(1).getEnd());
		assertTrue(lc1.getLineAt(2).getStart() == lc2.getLineAt(2).getStart());
		assertTrue(lc1.getLineAt(2).getEnd() == lc2.getLineAt(2).getEnd());
		assertTrue(lc1.getLineAt(0).getStart() == lc2.getLineAt(0).getStart());
		assertTrue(lc1.getLineAt(0).getEnd() == lc2.getLineAt(0).getEnd());
		assertTrue(lc1.getLineAt(1).getStart() == lc2.getLineAt(1).getStart());
		assertTrue(lc1.getLineAt(1).getEnd() == lc2.getLineAt(1).getEnd());
		assertTrue(lc1.getLineAt(2).getStart() == lc2.getLineAt(2).getStart());
		assertTrue(lc1.getLineAt(2).getEnd() == lc2.getLineAt(2).getEnd());
			
		assertTrue(lc1.getLineAt(0).equals(lc2.getLineAt(0)));
		assertTrue(lc1.getLineAt(1).equals(lc2.getLineAt(1)));
		assertTrue(lc1.getLineAt(2).equals(lc2.getLineAt(2)));
			
		assertTrue(lc1.getLineAt(0).getStart().equals(lc2.getLineAt(0).getStart()));
		assertTrue(lc1.getLineAt(0).getEnd().equals(lc2.getLineAt(0).getEnd()));
		assertTrue(lc1.getLineAt(1).getStart().equals(lc2.getLineAt(1).getStart()));
		assertTrue(lc1.getLineAt(1).getEnd().equals(lc2.getLineAt(1).getEnd()));
		assertTrue(lc1.getLineAt(2).getStart().equals(lc2.getLineAt(2).getStart()));
		assertTrue(lc1.getLineAt(2).getEnd().equals(lc2.getLineAt(2).getEnd()));
		
		assertTrue(lc2.getLineAt(0).getStart().getX() == 2);
		lc2.getLineAt(0).getStart().setX(100);
		/* WHY? */
		assertTrue(lc2.getLineAt(0).getStart().getX() == 100);
		
		lc2.addLine(new Line(new Point(0, 0), new Point(10, 10)));
		assertTrue(!lc1.equals(lc2));
	}
}
