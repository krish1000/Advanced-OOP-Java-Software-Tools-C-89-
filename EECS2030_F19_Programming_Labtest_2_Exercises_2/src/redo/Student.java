package redo;

public class Student {

	Course[] courseList;
	int noc;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
		courseList = new Course[100];
		
	}

	public Course[] getCourses() {
		// TODO Auto-generated method stub
		Course[] temp = new Course[this.noc];
		
		for(int i = 0; i < this.noc; i++) {
			temp[i] = this.courseList[i];
		}
		
		
		return temp;
	}

	public double getTuition() {
		// TODO Auto-generated method stub
		int total = 0;
		for(int i = 0; i < this.noc; i++) {
			total += courseList[i].getFee();
		}
		
		return total;
	}

	public void register(Course courseObj) {
		// TODO Auto-generated method stub
		//if predefined object array was given, make new arr size+1 of that obj
		//add that array to the new big array
		//and then add this to the end of that array ez
		
		this.courseList[this.noc++] = courseObj;
		
	}

	public void drop(Course courseObj) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < this.noc; i++) {
			if(this.courseList[i] == courseObj) {
				this.courseList[i] = null;
				
				for(int j = i; j < this.noc-1; j++) {
					this.courseList[i] = this.courseList[i+1];
				}
				this.noc--;
				break;
			}
		}
	}

}
