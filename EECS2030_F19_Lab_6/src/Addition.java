
public class Addition extends Expression {

	public Addition(int i, int j) {
		// TODO Auto-generated constructor stub
		// super = expression
		super(i, j);
	}

	void evaluate() {
		value = left +  right;
	}

}
