
public class Subtraction extends Expression {

	public Subtraction(int i, int j) {
		// TODO Auto-generated constructor stub
		super(i,j);
	}

	void evaluate() {
		super.value = super.left - super.right;
	}

}
