import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test01() {
		CourseRecord cr1 = new CourseRecord("EECS2030");
		String cr1Title = cr1.getTitle();
		int cr1Credits = cr1.getNumberOfCredits();
		int cr1RawMarks = cr1.getRawMarks();
		assertEquals("EECS2030", cr1Title);
		assertEquals(0.0, cr1Credits, 0.01);
		assertEquals(0, cr1RawMarks);
	}
	
	@Test
	public void test02() {
		CourseRecord cr1 = new CourseRecord("EECS2030");
		cr1.setNumberOfCredits(3);
		cr1.setRawMarks(88);
		String cr1Title = cr1.getTitle();
		int cr1Credits = cr1.getNumberOfCredits();
		int cr1RawMarks = cr1.getRawMarks();
		assertEquals("EECS2030", cr1Title);
		assertEquals(3, cr1Credits);
		assertEquals(88, cr1RawMarks);
	}
	
	@Test
	public void test03() {
		/*
		 * Two course records are equal if their title,
		 * number of credits, and raw marks are the same.
		 */
		CourseRecord cr1 = new CourseRecord("EECS2030", 3);
		cr1.setRawMarks(89);
		CourseRecord cr2 = cr1;
		
		assertTrue(cr1.equals(cr2));
		assertFalse(cr1.equals(null));
		assertFalse(cr1.equals("EECS2030"));
	
		CourseRecord cr3 = new CourseRecord("EECS2030", 3);
		cr3.setRawMarks(89);
		assertTrue(cr1.equals(cr3));
		
		CourseRecord cr4 = new CourseRecord("EECS2030", 3);
		cr4.setRawMarks(87);
		assertFalse(cr1.equals(cr4));
	}
	
	@Test
	public void test04() {
		/*
		 * It is assumed that a student object can store 
		 * up to and including 30 course records.
		 */
		Student heeyeon = new Student("Heeyeon");
		int numberOfCourses = heeyeon.getNumberOfCourses();
		assertEquals(0, numberOfCourses);
		assertTrue(heeyeon.getCourses().length == 0);
	}
	
	@Test
	public void test05() {
		Student jiyoon = new Student("Jiyoon");
		CourseRecord cr1 = new CourseRecord("EECS1022", 3);
		cr1.setRawMarks(67);
		CourseRecord cr2 = new CourseRecord("EECS2030", 3);
		cr2.setRawMarks(78);
		jiyoon.addCourse(cr1);
		jiyoon.addCourse(cr2);
		int numberOfCourses = jiyoon.getNumberOfCourses();
		assertEquals(2, numberOfCourses);
		assertTrue(jiyoon.getCourses().length == 2);
		assertSame(jiyoon.getCourses()[0], cr1);
		assertTrue(jiyoon.getCourses()[0].getTitle().equals("EECS1022"));
		assertTrue(jiyoon.getCourses()[1] == cr2);
		assertTrue(jiyoon.getCourses()[1].getTitle().equals("EECS2030"));
	}
	
	@Test
	public void test06() {
		Student jaebin = new Student("Jaebin");
		CourseRecord cr1 = new CourseRecord("EECS1022", 3);
		cr1.setRawMarks(87);
		CourseRecord cr2 = new CourseRecord("EECS2030", 3);
		cr2.setRawMarks(98);
		jaebin.addCourse(cr1);
		jaebin.addCourse(cr2);
		/*
		 * Mapping of marks `m` to letter grades:
		 * 90 <= m			A+
		 * 80 <= m < 90 	A
		 * 70 <= m < 80		B
		 * 60 <= m < 70		C
		 * 50 <= m < 60		D
		 *       m < 50		F
		 */
		String lg1 = jaebin.getLetterGradeOf("EECS1022");
		assertEquals("A", lg1);
		String lg2 = jaebin.getLetterGradeOf("EECS2030");
		assertEquals("A+", lg2);
	}
	
	@Test
	public void test07() {
		/*
		 * Two students are equal if 
		 * they store equal lists of courses in the same order.
		 */
		Student suyeon = new Student("Jaebin");
		Student yuna = new Student("Jaebin");
		
		assertEquals(suyeon, yuna);
		
		CourseRecord cr1 = new CourseRecord("EECS1022", 3);
		cr1.setRawMarks(87);
		CourseRecord cr2 = new CourseRecord("EECS2030", 3);
		cr2.setRawMarks(98);
		suyeon.addCourse(cr1);
		suyeon.addCourse(cr2);
		
		CourseRecord cr3 = new CourseRecord("EECS1022", 3);
		cr3.setRawMarks(87);
		CourseRecord cr4 = new CourseRecord("EECS2030", 3);
		cr4.setRawMarks(98);
		yuna.addCourse(cr3);
		yuna.addCourse(cr4);
		
		assertEquals(suyeon, yuna);
		
		cr4.setRawMarks(99);
		assertFalse(suyeon.equals(yuna));
		assertFalse(yuna.equals(suyeon));
	}
}
