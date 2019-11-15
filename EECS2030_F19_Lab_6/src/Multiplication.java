
public class Multiplication extends Expression {

	public Multiplication(int i, int j) {
		// TODO Auto-generated constructor stub
		super(i,j);
	}

	void evaluate() {
		
		super.value = super.left * super.right;
	}

}
