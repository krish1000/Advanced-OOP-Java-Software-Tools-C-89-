
/*
 * Your Tasks:
 * 1. Read the problem description and inheritance hierarchy diagram in the instructions.
 * 2. Add the necessary subclasses and implement the required methods.
 * 3. Study tests in TestExpressions.java to understand what's required to help your implementation. 
 */

public class ExpressionCollector {

	/*
	 * Your Task: Declare attribute(s) to store the list of Expression objects of
	 * this collector.
	 */
	Object value1;

//	Expression[] earr = new Expression[100];
	// ArrayList<Expression> earr;
	Expression[] earr;
	Expression exp;
	int counter = 0;

	/**
	 * Initialize an expression collector which stores an empty collection of
	 * expressions.
	 */
	ExpressionCollector() {
		/* Your Task */
		// this.earr.add();
		this.earr = new Expression[100];
		// this.earr = new ArrayList<Expression>();
	}

	/**
	 * Add a new expression.
	 * 
	 * @param e an expression
	 */
	void addExpression(Expression e) {
		/* Your Task */
		// this.earr.add(e);
		this.earr[counter] = e;
		counter++;
	}

	/**
	 * Add a new expression.
	 * 
	 * @param left  integer value of the left operand
	 * @param op    operator (i.e., "+", "-", "*", ">", "<", "==")
	 * @param right integer value of the right operand
	 */
	void addExpression(int left, String op, int right) {
		/* Your Task */
		// Hint: Depending on the operator given (e.g., +), create the corresponding
		// expression object
		// (e.g., Addition) and add it to the collector.

		if (op == "+") {
			addExpression(new Addition(left, right));
		} else if (op == "-") {
			addExpression(new Subtraction(left, right));
		} else if (op == "*") {
			addExpression(new Multiplication(left, right));
		} else if (op == ">") {
			addExpression(new GreaterThan(left, right));
		} else if (op == "<") {
			addExpression(new LessThan(left, right));
		} else if (op == "==") {
			addExpression(new Equal(left, right));
		}

	}

	/**
	 * If this collector is AddAll or TimesAll, then all stored expressions must be
	 * integer expressions (i.e., Addition, Subtraction, Multiplication). If this
	 * collection is ConjoinAll or DisjoinAll, then all stored expressions must be
	 * boolean expressions (i.e., GreaterThan, LessThan, Equal)
	 * 
	 * @return whether it is possible to evaluate the stored collection of
	 *         expressions.
	 */
	boolean isTypeCorrect() {
		/* Your Task */

		// Maybe need to override iztypecorrect for each ting?
		// *******************************************/

		// boolean check = true;

//		for(int i = 0; i < earr.size(); i++) {
//			
//			if(earr.get(i) == null || earr.get(i).getClass() == null) {
//				return false;
//			} else if (earr.get(i).getValue() instanceof Integer) {
//				return true;
//			}
//			
//		}
		return false;
	}

	/**
	 * Given that this expression collector is type correct (see `isTypeCorrect()`),
	 * evaluate it. Store the evaluation result so that it can be returned by
	 * `getValue()`.
	 */
	void evaluate() {
		/* Your Task */
		// Hint: Leave this empty and override it in all subclasses such as AddAll and
		// ConjoinAll.
	}

	/**
	 * Get the result of the latest evaluation (i.e., after the latest call to
	 * `evaluate()`).
	 * 
	 * @return the last evaluation result.
	 */
	Object getValue() {
		/* Your Task */

		if (value1 instanceof Integer) {
			return (Integer) value1;
		} else if (value1 instanceof Boolean) {
			return (Boolean) value1;
		}
		return value1;
	}

	/**
	 * Obtain the list of stored expressions.
	 * 
	 * @return all stored expressions as an array
	 */
	Expression[] getExpressions() {
		/* Your Task */
		if (counter == 0) {
//			Expression[] z = {};
			return new Expression[0];
		}

		Expression[] newarr = new Expression[counter];

		for (int i = 0; i < counter; i++) {
			newarr[i] = this.earr[i];
		}

		return newarr;
	}

	/**
	 * Override the equals method. Two expression collectors are equals if: 1) They
	 * are both type correct 2) Their evaluation results are identical
	 * 
	 * @return whether or not the two expression collectors are equal.
	 */
	@Override
	public boolean equals(Object obj) {
		/* Your Task */
//this.value1 instanceof Boolean && ((ExpressionCollector) (obj)).getValue() instanceof Boolean)
		if (!(this.value1 instanceof Integer && ((ExpressionCollector) (obj)).getValue() instanceof Integer
				|| this.value1 instanceof Boolean && ((ExpressionCollector) (obj)).getValue() instanceof Boolean)) {
			return false;
		} else if (this.value1 == ((ExpressionCollector) obj).getValue()) {
			return true;
		}

			return false;
	}
}
