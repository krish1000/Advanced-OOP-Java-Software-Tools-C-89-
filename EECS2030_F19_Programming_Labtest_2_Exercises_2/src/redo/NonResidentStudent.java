package redo;

public class NonResidentStudent extends Student{

	
	double discRate;
	String name;
	
	public NonResidentStudent() {
		// TODO Auto-generated constructor stub
	}

	public NonResidentStudent(String string) {
		// TODO Auto-generated constructor stub
		this.name = string;
	}

	public void setDiscountRate(double d) {
		// TODO Auto-generated method stub
		this.discRate = d;
	}

	public double getDiscountRate() {
		// TODO Auto-generated method stub
		return this.discRate;
	}
	
	public double getTuition() {
		return super.getTuition()*getDiscountRate();
	}

}
