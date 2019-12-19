
public class StudentManagementSystem {

	Student[] studentArr;
	int nos;
	
	public StudentManagementSystem() {
		// TODO Auto-generated constructor stub
		studentArr = new Student[100];
	}

	public Student[] getStudents() {
		// TODO Auto-generated method stub
		
		Student[] newtemp = new Student[this.nos];
		for(int i =0; i<nos; i++) {
			newtemp[i] = this.studentArr[i];
		}
		return newtemp;
	}

	public void addStudent(ResidentStudent student1) {
		// TODO Auto-generated method stub
		this.studentArr[nos++] = student1;
		
	}

	public void addStudent(NonResidentStudent student) {
		// TODO Auto-generated method stub
		this.studentArr[nos++] = student;
	}

	public void registerAll(Course course) {
		// TODO Auto-generated method stub
		Student[] newtemp = getStudents();
		for(int i =0; i<newtemp.length; i++) {
			newtemp[i].register(course);
		}
		
	}

	
	
}
