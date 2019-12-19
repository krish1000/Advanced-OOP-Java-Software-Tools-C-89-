package redo;

public class ResidentStudent extends Student{

	String name;
	double premRate;
	
	public ResidentStudent(String string) {
		// TODO Auto-generated constructor stub
		this.name = string;
	}

	public void setPremiumRate(double d) {
		// TODO Auto-generated method stub
		this.premRate = d;
	}

	public double getPremiumRate() {
		// TODO Auto-generated method stub
		return this.premRate;
	}

	public double getTuition() {
		return super.getTuition()*getPremiumRate();
	}
	
}
