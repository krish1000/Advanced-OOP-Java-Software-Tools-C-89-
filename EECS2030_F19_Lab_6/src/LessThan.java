
public class LessThan extends Expression {

	LessThan(int left, int right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}
	
	void evaluate() {
		super.value = (super.left < super.right);
	}

}
