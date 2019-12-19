
public class NonResidentStudent extends Student{ 

	
	String name;
	double discountRate;
	
	public NonResidentStudent() {
		// TODO Auto-generated constructor stub
	}

	public NonResidentStudent(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public void setDiscountRate(double dR) {
		// TODO Auto-generated method stub
		this.discountRate = dR;
		
	}

	public double getDiscountRate() {
		// TODO Auto-generated method stub
		return this.discountRate;
	}
	
	public double getTuition() {
		return super.getTuition()*getDiscountRate();
	}

}
