import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {
	
	@Test
	public void test1() {
		Course eecs2030 = new Course("Advanced OOP", 1000.0);
		Course eecs2001 = new Course("Intro. Theory of Computation", 1500.0);
		assertEquals(1000.0, eecs2030.getFee(), 0.01);
		assertEquals(1500.0, eecs2001.getFee(), 0.01);

		ResidentStudent rachael = new ResidentStudent("Rachael");
		rachael.setPremiumRate(1.25); 
		assertEquals(1.25, rachael.getPremiumRate(), 0.01);
		
		Student s;
		s = rachael;
		assertEquals(0, s.getCourses().length);
		assertEquals(0.0, s.getTuition(), 0.01);
		s.register(eecs2030);
		assertEquals(1, s.getCourses().length);
		assertEquals(1250.0, s.getTuition(), 0.01);
		s.register(eecs2001);
		assertEquals(2, s.getCourses().length);
		assertEquals(3125.0, s.getTuition(), 0.01);
		s.drop(eecs2030);
		assertEquals(1, s.getCourses().length);
		assertEquals(1875.0, s.getTuition(), 0.01);
		s.drop(eecs2001);
		assertEquals(0, s.getCourses().length);
		assertEquals(0.0, s.getTuition(), 0.01);
	}
	
	@Test
	public void test2() {
		Course eecs2030 = new Course("Advanced OOP", 1000.0);
		Course eecs2001 = new Course("Intro. Theory of Computation", 1500.0);
		assertEquals(1000.0, eecs2030.getFee(), 0.01);
		assertEquals(1500.0, eecs2001.getFee(), 0.01);

		NonResidentStudent nancy = new NonResidentStudent("Nancy");
		nancy.setDiscountRate(0.75); 
		assertEquals(0.75, nancy.getDiscountRate(), 0.01);
		
		Student s;
		s = nancy;
		assertEquals(0, s.getCourses().length);
		assertEquals(0.0, s.getTuition(), 0.01);
		s.register(eecs2001);
		assertEquals(1, s.getCourses().length);
		assertEquals(1125.0, s.getTuition(), 0.01);
		s.register(eecs2030);
		assertEquals(2, s.getCourses().length);
		assertEquals(1875.0, s.getTuition(), 0.01);
		s.drop(eecs2030);
		assertEquals(1, s.getCourses().length);
		assertEquals(1125.0, s.getTuition(), 0.01);
		s.drop(eecs2001);
		assertEquals(0, s.getCourses().length);
		assertEquals(0.0, s.getTuition(), 0.01);
	}
	
	@Test
	public void test3() {
		Course eecs2030 = new Course("Advanced OOP", 1000.0);
		Course eecs2001 = new Course("Intro. Theory of Computation", 1500.0);
		assertEquals(1000.0, eecs2030.getFee(), 0.01);
		assertEquals(1500.0, eecs2001.getFee(), 0.01);
		
		ResidentStudent rachael = new ResidentStudent("Rachael");
		rachael.setPremiumRate(1.25); 		
		NonResidentStudent nancy = new NonResidentStudent("Nancy");
		nancy.setDiscountRate(0.75);
		
		StudentManagementSystem sms = new StudentManagementSystem();
		assertEquals(0, sms.getStudents().length);
		// register eecs2001 for all students in the system
		sms.addStudent(rachael);
		sms.addStudent(nancy);
		assertEquals(2, sms.getStudents().length);
		assertSame(rachael, sms.getStudents()[0]);
		assertSame(nancy, sms.getStudents()[1]);
		sms.registerAll(eecs2030);
		sms.registerAll(eecs2001);
		assertEquals(3125.0, sms.getStudents()[0].getTuition(), 0.01);
		assertEquals(1875.0, sms.getStudents()[1].getTuition(), 0.01);
	}
}
