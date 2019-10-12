/****************** KRIZIHZZIHZ *********/

public class Student {

	CourseRecord[] courselist;
	int noc;
	String name;

	public Student(String s) {
		// TODO Auto-generated constructor stub
		/* DONT REDECLARE ARRAY OR ELE IT ZCREZ IT UP */
		courselist = new CourseRecord[30];
		this.name = s;
		this.noc = 0;
	}

	public int getNumberOfCourses() {
		// TODO Auto-generated method stub
		return this.noc;
	}

	public CourseRecord[] getCourses() {
		// TODO Auto-generated method stub
		// int[] poo = new int[0];
		CourseRecord[] temp = new CourseRecord[this.noc];
		for (int i = 0; i < this.noc; i++) {
			temp[i] = courselist[i];
		}
		return temp;
	}

	public void addCourse(CourseRecord cr) {
		// TODO Auto-generated method stub
		courselist[noc] = cr;
		noc++;
	}

	public String getLetterGradeOf(String s) {
		// TODO Auto-generated method stub
		String grade = null;
		String cn = null;
		int marks = 0;
		for (int i = 0; i < this.noc; i++) {
			cn = this.getCourses()[i].course;
			if (cn == s) {
				marks = this.getCourses()[i].getRawMarks();

				if (marks >= 90) {
					grade = "A+";
				} else if (marks >= 80) {
					grade = "A";
				} else if (marks >= 70) {
					grade = "B";
				} else if (marks >= 60) {
					grade = "C";
				} else if (marks >= 50) {
					grade = "D";
				} else {
					grade = "F";
				}
				return grade;
			}
		}
		return grade;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || obj.getClass() == null || obj.getClass() != this.getClass()) {
			return false;
		} else if (this.noc != ((Student) obj).noc) {
			return false;
		} else {
			for (int i = 0; i < this.noc; i++) {
				if (this.getCourses()[i].equals(((Student) obj).getCourses()[i])) {
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
