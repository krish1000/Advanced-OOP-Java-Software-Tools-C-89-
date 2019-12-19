
public class ResidentStudent extends Student{

	double premiumRate;
	String name;
	public ResidentStudent() {
		// TODO Auto-generated constructor stub
	}

	public ResidentStudent(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public void setPremiumRate(double pRate) {
		// TODO Auto-generated method stub
		this.premiumRate = pRate;
	}

	public double getPremiumRate() {
		// TODO Auto-generated method stub
		return this.premiumRate;
	}
	
	public double getTuition() {
		// TODO Auto-generated method stub
		return super.getTuition()*getPremiumRate();
	}

}
