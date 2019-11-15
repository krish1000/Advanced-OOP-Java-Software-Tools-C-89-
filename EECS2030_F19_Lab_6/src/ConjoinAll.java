
public class ConjoinAll extends ExpressionCollector {

	public ConjoinAll() {
		super.value1 = true;
	}

	boolean isTypeCorrect() {
		for(int i = 0; i < super.getExpressions().length; i++) {
			super.getExpressions()[i].evaluate();
			if(!((super.getExpressions()[i].getValue()) instanceof Boolean)) {
				//System.out.println(super.earr[i].getValue());
				return false;
			} 
		}
		return true;
	}

	void evaluate() {

		if (super.getExpressions().length == 0) {
			/** do nothing **/
		} else if (super.getExpressions().length == 1) {
			super.getExpressions()[0].evaluate();
			super.value1 = super.getExpressions()[0].getValue();
		} else {

			Boolean total = true;
			for (int i = 0; i < super.getExpressions().length-1; i++) {
				super.getExpressions()[i].evaluate();
				super.getExpressions()[i+1].evaluate();
				// System.out.println(super.earr[i].getValue());
				total = (Boolean) (super.getExpressions()[i].getValue()) && total && (Boolean) (super.getExpressions()[i+1].getValue());
			}
			super.value1 = total;
		}
	}
}
