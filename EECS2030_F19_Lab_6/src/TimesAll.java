
public class TimesAll extends ExpressionCollector {

	public TimesAll() {
		super.value1 = 1;
	}
	
	boolean isTypeCorrect() {
		for(int i = 0; i < super.getExpressions().length; i++) {
			super.getExpressions()[i].evaluate();
			if(!((super.getExpressions()[i].getValue()) instanceof Integer)) {
				//System.out.println(super.earr[i].getValue());
				return false;
			} 
		}
		return true;
	}
	
	void evaluate() {
		
		int total = 1;
		for(int i = 0; i < super.getExpressions().length; i++) {
			super.getExpressions()[i].evaluate();
			//System.out.println(super.earr[i].getValue());
			total *= (Integer)(super.getExpressions()[i].getValue());
		}
		super.value1 = total;
	}
	
	
	
}
