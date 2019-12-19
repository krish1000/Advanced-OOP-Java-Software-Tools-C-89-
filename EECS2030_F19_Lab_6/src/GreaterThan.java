
public class GreaterThan extends Expression {

	GreaterThan(int left, int right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	void evaluate() {
		super.value = (super.left > super.right);
	}

}
