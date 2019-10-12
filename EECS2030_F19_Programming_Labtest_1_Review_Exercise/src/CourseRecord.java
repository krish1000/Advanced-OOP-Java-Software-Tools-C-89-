/******************KRIZIHZZIHZ*********/

public class CourseRecord {

	String course;
	int creditstotal;
	int markstotal;

	public CourseRecord(String course1) {
		this.course = course1;
	}

	public CourseRecord(String course1, int x) {
		this.course = course1;
		this.creditstotal = x;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return this.course;
	}

	public int getNumberOfCredits() {
		// TODO Auto-generated method stub
		return this.creditstotal;
	}

	public int getRawMarks() {
		// TODO Auto-generated method stub
		return this.markstotal;
	}

	public void setRawMarks(int marks) {
		// TODO Auto-generated method stub
		this.markstotal = marks;
	}

	public void setNumberOfCredits(int credits) {
		// TODO Auto-generated method stub
		this.creditstotal = credits;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((course == null) ? 0 : course.hashCode());
//		result = prime * result + creditstotal;
//		result = prime * result + markstotal;
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj.getClass() == null || this.getClass() != obj.getClass()) {
			return false;
		}
		if (this.course.equals(((CourseRecord) obj).course) && this.creditstotal == ((CourseRecord) obj).creditstotal
				&& this.markstotal == ((CourseRecord) obj).markstotal)
			return true;
		return false;
	}
	
	// learn how to autoadd equals
	// ctrl+space once you write equals
//	@Override
//	public boolean equals(Object obj) {
//
//		/*DONT FORGET THE 2nd ELSE IF, or else it screws everythign else*/
//		if (this == obj) {
//			return true;
//		} else if (obj == null || obj.getClass() == null || obj.getClass() != CourseRecord.class) {
//			return false;
//		} else if (this.course.equals(((CourseRecord) obj).course) && this.markstotal == ((CourseRecord) obj).getRawMarks()
//				&& this.creditstotal == ((CourseRecord) obj).getNumberOfCredits()) {
//			return true;
//		}
//		return false;
//	}

}
//else if (this.markstotal == ((CourseRecord) obj).getRawMarks()) {
//m = true;
//} else if (this.creditstotal == ((CourseRecord) obj).getNumberOfCredits()) {
//c = true;
//}
//
//if (c == true && m == true && t == true) {
//return true;
//}
