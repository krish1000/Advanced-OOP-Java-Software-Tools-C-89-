
public class Equal extends Expression {

	public Equal(int i, int j) {
		// TODO Auto-generated constructor stub
		super(i, j);
	}

	void evaluate() {

		super.value = (super.left == super.right);
	}
}