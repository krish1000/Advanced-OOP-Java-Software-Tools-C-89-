
public class Student {

	Course[] courseList;
	int noc;
	
	public Student() {
		this.courseList = new Course[100];
	}
	
	public Course[] getCourses() {
		// TODO Auto-generated method stub
		Course[] newCourseList = new Course[noc];
		
		for(int i = 0; i< this.noc; i++) {
				newCourseList[i] = courseList[i];
		}
		
		return newCourseList;
	}

	public double getTuition() {
		// TODO Auto-generated method stub
		double total = 0;
		Course[] temp = getCourses();
		for(int i = 0; i< temp.length;  i++) {
			total += temp[i].getFee();
		}
		
		return total;
	}

	public void register(Course course) {
		// TODO Auto-generated method stub
		this.courseList[noc++] = course;
	}

	public void drop(Course course) {
		// TODO Auto-generated method stub
		
		//just make it null for now (temp soln)
		for(int i = 0; i<noc; i++) {
			//compares by string name
			if(this.courseList[i].courseName == course.courseName) {
				this.courseList[i] = null;
				
				for(int j = i; j<noc-1; j++) {
					this.courseList[j] = this.courseList[j+1];
				}
				noc--;
				break;
			}
		}
	}

}
