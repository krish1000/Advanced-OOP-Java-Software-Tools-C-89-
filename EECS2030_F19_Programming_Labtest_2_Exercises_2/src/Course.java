
public class Course {

	String courseName;
	double courseFee;
	//double fee;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String string, double d) {
		// TODO Auto-generated constructor stub
		this.courseName = string;
		this.courseFee = d;
	}

	public double getFee() {
		// TODO Auto-generated method stub
		return this.courseFee;
	}

}
