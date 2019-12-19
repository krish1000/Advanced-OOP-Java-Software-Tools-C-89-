package redo;

public class StudentManagementSystem {

	Student[] studList;
	int nos;
	
	public StudentManagementSystem() {
		// TODO Auto-generated constructor stub
		studList = new Student[100];
	}

	public Student[] getStudents() {
		Student[] temp = new Student[this.nos];
		
		for(int i = 0; i < this.nos; i++) {
			temp[i] = this.studList[i];
		}
		return temp;
	
	}
	
	public void addStudent(Student stud) {
		this.studList[this.nos++] = stud;
	}
	
	
	public void registerAll(Course course) {
		for(int i = 0; i < this.nos; i++) {
			this.studList[i].register(course);
		}
	}
}
