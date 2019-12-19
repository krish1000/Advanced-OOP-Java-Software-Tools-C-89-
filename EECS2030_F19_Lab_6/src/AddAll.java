
public class AddAll extends ExpressionCollector {

	public AddAll() {
		super.value1 = 0;
	}

	boolean isTypeCorrect() {

		for (int i = 0; i < super.getExpressions().length; i++) {
			super.getExpressions()[i].evaluate();
			if (!((super.getExpressions()[i].getValue()) instanceof Integer)) {
				// System.out.println(super.earr[i].getValue());
				return false;
			}
		}
		return true;
	}

	void evaluate() {
		// int i = super.earr.size();
//		int total = 0;
//		for(int i = 0; i < super.earr.size(); i++) {
//			total += (Integer) earr.get(i).getValue();
//		}
//		super.value1 = total;
		int total = 0;
		for (int i = 0; i < super.getExpressions().length; i++) {
			super.getExpressions()[i].evaluate();
			// System.out.println(super.earr[i].getValue());
			total += (Integer) (super.getExpressions()[i].getValue());
		}
		super.value1 = total;
	}

}
