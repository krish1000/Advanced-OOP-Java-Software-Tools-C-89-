import static org.junit.Assert.*;

import org.junit.Test;

public class TestExpressions {

	/*
	 * Section 1
	 * Tests for testing basic integer expressions: 
	 * Addition, Subtraction, and Multiplication.
	 */
	@Test
	public void test01() {
		// Build the expression: 3 + 2
		// Here the static type of `add` is Expression,
		// and the dynamic type is Addition (which should be a child class of Expression).
		Expression add = new Addition(3, 2);
		// Evaluate the expression.
		add.evaluate(); 
		// Get the evaluation result as an integer.
		Object o = add.getValue();
		Integer addVal = (Integer) o;
		assertEquals(new Integer(5), addVal);
	}

	@Test
	public void test02() {
		// Build the expression: 3 - 2
		// Here the static type of `sub` is Expression,
		// and the dynamic type is Subtraction (which should be a child class of Expression).
		Expression sub = new Subtraction(3, 2);
		// Evaluate the expression.
		sub.evaluate();
		// Get the evaluation result as an integer.
		Integer subVal = (Integer) sub.getValue();
		assertEquals(new Integer(1), subVal);
	}

	@Test
	public void test03() {
		// Build the expression: 3 * 2
		// Here the static type of `mul` is Expression,
		// and the dynamic type is Multiplication (which should be a child class of Expression).
		Expression mul = new Multiplication(3, 2);
		// Evaluate the expression.
		mul.evaluate();
		// Get the evaluation result as an integer.
		Integer mulVal = (Integer) mul.getValue();
		assertEquals(new Integer(6), mulVal);
	}

	/*
	 * Section 2
	 * Tests for testing basic boolean (relational) expressions: 
	 * Equal, GreaterThan, and LessThan.
	 */

	@Test
	public void test04() {
		// Build the expression: 3 = 3
		// Here the static type of `eq` is Expression,
		// and the dynamic type is Equal (which should be a child class of Expression).
		Expression eq = new Equal(3, 3);
		// Evaluate the expression.
		eq.evaluate();
		// Get the evaluation result as a boolean.
		Boolean eqVal = (Boolean) eq.getValue();
		assertEquals(new Boolean(true), eqVal);

		// Rebuild the expression: 3 = 8
		// Here the static type of `eq` is Expression,
		// and the dynamic type is Equal (but a different Equal object).
		eq = new Equal(3, 8);
		// Get the evaluation result as a boolean.
		eqVal = (Boolean) eq.getValue();
		assertFalse(new Boolean(true).equals(eqVal));
	}

	@Test
	public void test05() {
		// Build the expression: 3 > 3
		// Here the static type of `gt` is Expression,
		// and the dynamic type is GreaterThan (which should be a child class of Expression).
		Expression gt = new GreaterThan(3, 3);
		// Evaluate the expression.
		gt.evaluate();
		Boolean gtVal = (Boolean) gt.getValue();		
		assertFalse(new Boolean(true).equals(gtVal));

		// Rebuild the expression: 3 > 8
		// Here the static type of `gt` is Expression,
		// and the dynamic type is GraterThan (but a different GraterThan object).
		gt = new GreaterThan(3, 8);
		// Evaluate the expression.
		gt.evaluate();
		// Get the evaluation result as a boolean.
		gtVal = (Boolean) gt.getValue();		
		assertFalse(new Boolean(true).equals(gtVal));

		// Rebuild the expression: 8 > 3
		// Here the static type of `gt` is Expression,
		// and the dynamic type is GraterThan (but a different GraterThan object).
		gt = new GreaterThan(8, 3);
		// Evaluate the expression.
		gt.evaluate();
		// Get the evaluation result as a boolean.
		gtVal = (Boolean) gt.getValue();		
		assertTrue(new Boolean(true).equals(gtVal));
	}

	@Test
	public void test06() {
		// Build the expression: 3 < 3
		// Here the static type of `lt` is Expression,
		// and the dynamic type is LessThan (which should be a child class of Expression).
		Expression lt = new LessThan(3, 3);
		// Evaluate the expression.
		lt.evaluate();
		Boolean gtVal = (Boolean) lt.getValue();		
		assertFalse(new Boolean(true).equals(gtVal));

		// Rebuild the expression: 3 < 8
		// Here the static type of `lt` is Expression,
		// and the dynamic type is LessThan (but a different LessThan object).
		lt = new LessThan(3, 8);
		// Evaluate the expression.
		lt.evaluate();
		// Get the evaluation result as a boolean.
		gtVal = (Boolean) lt.getValue();		
		assertTrue(new Boolean(true).equals(gtVal));

		// Rebuild the expression: 8 > 3
		// Here the static type of `lt` is Expression,
		// and the dynamic type is LessThan (but a different LessThan object).
		lt = new LessThan(8, 3);
		// Evaluate the expression.
		lt.evaluate();
		// Get the evaluation result as a boolean.
		gtVal = (Boolean) lt.getValue();		
		assertFalse(new Boolean(true).equals(gtVal));
	}

	/*
	 * Section 3.1
	 * Tests for testing empty complex integer expressions: 
	 * AddAll and TimesAll.
	 */

	@Test
	public void test07() {
		// Build the expression which adds up an empty collection of integer expressions.
		// Here the static type of `ec1` is ExpressionCollector,
		// and the dynamic type is AddAll (which should be a child class of ExpressionCollector).
		ExpressionCollector ec1 = new AddAll();
		assertEquals(0, ec1.getExpressions().length);

		// It is type correct if all expressions in the collector are instances of
		// integer expressions (Hint: Section 1).
		assertTrue(ec1.isTypeCorrect());

		// Add up the empty collection of expressions,
		// which should be the unit of addition: 0.
		ec1.evaluate();

		// Get the evaluation result as an integer.
		Integer ec1V = (Integer) ec1.getValue();
		assertEquals(new Integer(0), ec1V);
	}

	@Test
	public void test08() {
		// Build the expression which adds up an empty collection of integer expressions.
		// Here the static type of `ec2` is ExpressionCollector,
		// and the dynamic type is TimesAll (which should be a child class of ExpressionCollector).
		ExpressionCollector ec2 = new TimesAll();
		assertEquals(0, ec2.getExpressions().length);

		// It is type correct if all expressions in the collector are instances of
		// integer expressions (Hint: Section 1).
		assertTrue(ec2.isTypeCorrect());

		// Take the product of the empty collection of expressions,
		// which should be the unit of multiplication: 1.
		ec2.evaluate();

		// Get the evaluation result as an integer.
		Integer ec2V = (Integer) ec2.getValue();
		assertEquals(new Integer(1), ec2V);
	}

	/*
	 * Section 3.2
	 * Tests for testing empty complex boolean expressions: 
	 * CojoinAll and DisjoinAll.
	 */

	@Test
	public void test09() {
		// Build the expression which takes the conjunction of an empty collection of boolean expressions.
		// Here the static type of `ec3` is ExpressionCollector,
		// and the dynamic type is ConjoinAll (which should be a child class of ExpressionCollector).
		ExpressionCollector ec3 = new ConjoinAll();
		assertEquals(0, ec3.getExpressions().length);

		// It is type correct if all expressions in the collector are instances of
		// boolean expressions (Hint: Section 2).
		assertTrue(ec3.isTypeCorrect());

		// Take the conjunction of the empty collection of expressions,
		// which should be the unit of conjunction: true.
		ec3.evaluate();

		// Get the evaluation result as a boolean.
		Boolean ec3V = (Boolean) ec3.getValue();
		assertTrue(ec3V);
	}

	@Test
	public void test10() {
		// Build the expression which takes the disjunction of an empty collection of boolean expressions.
		// Here the static type of `ec4` is ExpressionCollector,
		// and the dynamic type is DisjoinALl (which should be a child class of ExpressionCollector).
		ExpressionCollector ec4 = new DisjoinAll();
		assertEquals(0, ec4.getExpressions().length);

		// It is type correct if all expressions in the collector are instances of
		// boolean expressions (Hint: Section 2).
		assertTrue(ec4.isTypeCorrect());

		// Take the conjunction of the empty collection of expressions,
		// which should be the unit of disjunction: false.
		ec4.evaluate();

		// Get the evaluation result as a boolean.
		Boolean ec4V = (Boolean) ec4.getValue();
		assertFalse(ec4V);
	}

	@Test
	public void test11() {
		ExpressionCollector ec1 = new AddAll(); 
		ExpressionCollector ec2 = new TimesAll(); 
		ExpressionCollector ec3 = new ConjoinAll(); 
		ExpressionCollector ec4 = new DisjoinAll(); 

		// Two expression collections are equal if there are the same type and
		// evaluations of their lists of expressions return the same value.
		assertFalse(ec1.equals(ec2));
		assertFalse(ec3.equals(ec4));
		assertFalse(ec1.equals(ec3));
		assertFalse(ec2.equals(ec4));
	}

	/*
	 * Section 4.1
	 * Tests for testing non-empty complex integer expressions: 
	 * AddAll
	 */

	@Test
	public void test12() {
		ExpressionCollector ec1 = new AddAll(); 
		Expression add = new Addition(3, 2);
		Expression sub = new Subtraction(3, 2);
		Expression mul = new Multiplication(3, 2);

		// Build the expression: (3 + 2) + (3 - 2) + (3 * 2)
		ec1.addExpression(add);
		ec1.addExpression(sub);
		ec1.addExpression(mul);

		Expression[] ec1Expressions = ec1.getExpressions();
		assertEquals(3, ec1Expressions.length);

		// It is type correct because all stored expressions are integer expressions. 
		assertTrue(ec1.isTypeCorrect());

		// Return the evaluation results as an integer. 
		ec1.evaluate();
		Integer ec1V = (Integer) ec1.getValue();
		assertEquals(new Integer(12), ec1V);

		ExpressionCollector ec2 = new AddAll();
		// ec1 and ec2 are the same type of expression collectors (AddAll),
		// but they evaluate to different values.
		assertFalse(ec1.equals(ec2));
	}

	@Test
	public void test13() { 
		ExpressionCollector ec2 = new AddAll(); 
		// Build the expression: (0 + 1) + (7 - 5) + (-4 + 7) + (3 * 4) + (3 - 9)
		ec2.addExpression(0, "+", 1);
		ec2.addExpression(7, "-", 5);
		ec2.addExpression(-4, "+", 7);
		ec2.addExpression(3, "*", 4);
		ec2.addExpression(3, "-", 9);
		assertEquals(5, ec2.getExpressions().length);
		assertTrue(ec2.isTypeCorrect());
		ec2.evaluate();
		Integer ec2V = (Integer) ec2.getValue();
		assertEquals(new Integer(12), ec2V);
	}

	@Test
	public void test14_a() { 
		ExpressionCollector ec1 = new AddAll(); 
		// Build the expression: (3 + 2) + (3 - 2) + (3 * 2)
		Expression add = new Addition(3, 2);
		Expression sub = new Subtraction(3, 2);
		Expression mul = new Multiplication(3, 2);
		ec1.addExpression(add);
		ec1.addExpression(sub);
		ec1.addExpression(mul);

		// Build the expression: (0 + 1) + (7 - 5) + (-4 + 7) + (3 * 4) + (3 - 9)
		ExpressionCollector ec2 = new AddAll(); 
		ec2.addExpression(0, "+", 1);
		ec2.addExpression(7, "-", 5);
		ec2.addExpression(-4, "+", 7);
		ec2.addExpression(3, "*", 4);
		ec2.addExpression(3, "-", 9);

		// They are equal because their stored expressions evaluate to the same value.
		assertEquals(ec1, ec2);
	}

	@Test
	public void test14_b() { 
		ExpressionCollector ec1 = new AddAll(); 
		// Build the expression: (3 + 2) + (3 - 2) + (3 * 2)
		Expression add = new Addition(3, 2);
		Expression sub = new Subtraction(3, 2);
		Expression mul = new Multiplication(3, 2);
		ec1.addExpression(add);
		ec1.addExpression(sub);
		ec1.addExpression(mul);
		ec1.evaluate();
		Integer ec1V = (Integer) ec1.getValue();
		assertEquals(new Integer(12), ec1V);

		// Build the expression: (0 + 1) + (7 - 5) + (-4 + 7) + (3 * 4)
		ExpressionCollector ec2 = new AddAll(); 
		ec2.addExpression(0, "+", 1);
		ec2.addExpression(7, "-", 5);
		ec2.addExpression(-4, "+", 7);
		ec2.addExpression(3, "*", 4);
		ec2.evaluate();
		Integer ec2V = (Integer) ec2.getValue();
		assertEquals(new Integer(18), ec2V);

		// They are not equal because their stored expressions evaluate to different values.
		assertFalse(ec1.equals(ec2));
	}

	/*
	 * Section 4.2
	 * Tests for testing non-empty complex integer expressions: 
	 * TimesAll
	 */

	@Test
	public void test15() {
		ExpressionCollector ec1 = new TimesAll(); 
		Expression add = new Addition(3, 2);
		Expression sub = new Subtraction(7, 3);
		Expression mul = new Multiplication(3, 2);

		// Build the expression: (3 + 2) * (7 - 3) * (3 * 2)
		ec1.addExpression(add);
		ec1.addExpression(sub);
		ec1.addExpression(mul);

		Expression[] ec1Expressions = ec1.getExpressions();
		assertEquals(3, ec1Expressions.length);

		// It is type correct because all stored expressions are integer expressions. 
		assertTrue(ec1.isTypeCorrect());

		// Return the evaluation results as an integer. 
		ec1.evaluate();
		Integer ec1V = (Integer) ec1.getValue();
		assertEquals(new Integer(120), ec1V);

		ExpressionCollector ec2 = new TimesAll();
		// ec1 and ec2 are the same type of expression collectors (AddAll),
		// but they evaluate to different values.
		assertFalse(ec1.equals(ec2));
	}

	@Test
	public void test16() { 
		ExpressionCollector ec2 = new TimesAll(); 
		// Build the expression: (3 * 2) * (4 - 5) * (9 - 7) * (-1 + 6) * (5 - 7)
		ec2.addExpression(3, "*", 2);
		ec2.addExpression(4, "-", 5);
		ec2.addExpression(9, "-", 7);
		ec2.addExpression(-1, "+", 6);
		ec2.addExpression(5, "-", 7);
		assertEquals(5, ec2.getExpressions().length);
		assertTrue(ec2.isTypeCorrect());
		ec2.evaluate();
		Integer ec2V = (Integer) ec2.getValue();
		assertEquals(new Integer(120), ec2V);
	}

	@Test
	public void test17_a() { 
		ExpressionCollector ec1 = new TimesAll(); 
		// Build the expression: (3 + 2) * (7 - 3) * (3 * 2)
		Expression add = new Addition(3, 2);
		Expression sub = new Subtraction(7, 3);
		Expression mul = new Multiplication(3, 2);
		ec1.addExpression(add);
		ec1.addExpression(sub);
		ec1.addExpression(mul);

		ExpressionCollector ec2 = new TimesAll(); 
		// Build the expression: (3 * 2) * (4 - 5) * (9 - 7) * (-1 + 6) * (5 - 7)
		ec2.addExpression(3, "*", 2);
		ec2.addExpression(4, "-", 5);
		ec2.addExpression(9, "-", 7);
		ec2.addExpression(-1, "+", 6);
		ec2.addExpression(5, "-", 7);

		// They are equal because their stored expressions evaluate to the same value.
		assertEquals(ec1, ec2);
	}

	@Test
	public void test17_b() { 
		ExpressionCollector ec1 = new TimesAll(); 
		// Build the expression: (3 + 2) * (7 - 3) * (3 * 2)
		Expression add = new Addition(3, 2);
		Expression sub = new Subtraction(7, 3);
		Expression mul = new Multiplication(3, 2);
		ec1.addExpression(add);
		ec1.addExpression(sub);
		ec1.addExpression(mul);
		ec1.evaluate();
		Integer ec1V = (Integer) ec1.getValue();
		assertEquals(new Integer(120), ec1V);

		ExpressionCollector ec2 = new TimesAll(); 
		// Build the expression: (3 * 2) * (4 - 5) * (9 - 7) * (-1 + 6)
		ec2.addExpression(3, "*", 2);
		ec2.addExpression(4, "-", 5);
		ec2.addExpression(9, "-", 7);
		ec2.addExpression(-1, "+", 6);
		ec2.evaluate();
		Integer ec2V = (Integer) ec2.getValue();
		assertEquals(new Integer(-60), ec2V);

		// They are not equal because their stored expressions evaluate to different values.
		assertFalse(ec1.equals(ec2));
	}

	/*
	 * Section 4.3
	 * Tests for testing non-empty complex integer expressions: 
	 * ConjoinAll
	 */

	@Test
	public void test18() {
		ExpressionCollector ec1 = new ConjoinAll(); 
		Expression eq = new Equal(3, 3);
		Expression gt = new GreaterThan(7, 3);
		Expression lt = new LessThan(7, 3);

		// Build the expression: (3 == 3) && (7 > 3) && (7 < 3)
		ec1.addExpression(eq);
		ec1.addExpression(gt);
		ec1.addExpression(lt);

		Expression[] ec1Expressions = ec1.getExpressions();
		assertEquals(3, ec1Expressions.length);

		// It is type correct because all stored expressions are boolean expressions. 
		assertTrue(ec1.isTypeCorrect());

		// Return the evaluation results as a boolean. 
		ec1.evaluate();
		Boolean ec1V = (Boolean) ec1.getValue();
		assertFalse(ec1V);

		ExpressionCollector ec2 = new ConjoinAll();
		// ec1 and ec2 are the same type of expression collectors (ConjoinAll),
		// but they evaluate to different values.
		assertFalse(ec1.equals(ec2));
	}

	@Test
	public void test19() { 
		ExpressionCollector ec2 = new ConjoinAll(); 
		// Build the expression: (3 > 2) && (4 < 5) && (9 = 9) && (-1 < 6) && (5 > 7)
		ec2.addExpression(3, ">", 2);
		ec2.addExpression(4, "<", 5);
		ec2.addExpression(9, "==", 9);
		ec2.addExpression(-1, "<", 6);
		ec2.addExpression(5, ">", 7);
		assertEquals(5, ec2.getExpressions().length);
		assertTrue(ec2.isTypeCorrect());
		ec2.evaluate();
		Boolean ec2V = (Boolean) ec2.getValue();
		assertFalse(ec2V);
	}

	@Test
	public void test20_a() { 
		ExpressionCollector ec1 = new ConjoinAll(); 
		Expression eq = new Equal(3, 3);
		Expression gt = new GreaterThan(7, 3);
		Expression lt = new LessThan(7, 3); 
		// Build the expression: (3 == 3) && (7 > 3) && (7 < 3)
		ec1.addExpression(eq);
		ec1.addExpression(gt);
		ec1.addExpression(lt);

		ExpressionCollector ec2 = new ConjoinAll(); 
		// Build the expression: (3 > 2) && (4 < 5) && (9 = 9) && (-1 < 6) && (5 > 7)
		ec2.addExpression(3, ">", 2);
		ec2.addExpression(4, "<", 5);
		ec2.addExpression(9, "==", 9);
		ec2.addExpression(-1, "<", 6);
		ec2.addExpression(5, ">", 7);

		// They are equal because their stored expressions evaluate to the same value.
		assertEquals(ec1, ec2);
	}

	@Test
	public void test20_b() { 
		ExpressionCollector ec1 = new ConjoinAll(); 
		Expression eq = new Equal(3, 3);
		Expression gt = new GreaterThan(7, 3);
		Expression lt = new LessThan(7, 3); 
		// Build the expression: (3 == 3) && (7 > 3) && (7 < 3)
		ec1.addExpression(eq);
		ec1.addExpression(gt);
		ec1.addExpression(lt);
		ec1.evaluate();
		Boolean ec1V = (Boolean) ec1.getValue();
		assertEquals(new Boolean(false), ec1V);

		ExpressionCollector ec2 = new ConjoinAll(); 
		// Build the expression: (3 > 2) && (4 < 5) && (9 = 9) && (-1 < 6)
		ec2.addExpression(3, ">", 2);
		ec2.addExpression(4, "<", 5);
		ec2.addExpression(9, "==", 9);
		ec2.addExpression(-1, "<", 6);
		ec2.evaluate();
		Boolean ec2V = (Boolean) ec2.getValue();
		assertEquals(new Boolean(true), ec2V);

		// They are not equal because their stored expressions evaluate to different values.
		assertFalse(ec1.equals(ec2));
	}

	/*
	 * Section 4.4
	 * Tests for testing non-empty complex integer expressions: 
	 * DisjoinAll
	 */

	@Test
	public void test21() {
		ExpressionCollector ec1 = new DisjoinAll(); 
		Expression eq = new Equal(3, 3);
		Expression gt = new GreaterThan(7, 3);
		Expression lt = new LessThan(3, 7);

		// Build the expression: (3 == 3) || (7 > 3) || (3 < 7)
		ec1.addExpression(eq);
		ec1.addExpression(gt);
		ec1.addExpression(lt);

		Expression[] ec1Expressions = ec1.getExpressions();
		assertEquals(3, ec1Expressions.length);

		// It is type correct because all stored expressions are boolean expressions. 
		assertTrue(ec1.isTypeCorrect());

		// Return the evaluation results as a boolean. 
		ec1.evaluate();
		Boolean ec1V = (Boolean) ec1.getValue();
		assertTrue(ec1V);

		ExpressionCollector ec2 = new DisjoinAll();
		// ec1 and ec2 are the same type of expression collectors (ConjoinAll),
		// but they evaluate to different values.
		assertFalse(ec1.equals(ec2));
	}

	@Test
	public void test22() { 
		ExpressionCollector ec2 = new DisjoinAll(); 
		// Build the expression: (3 > 2) || (4 < 5) || (9 = 9) || (-1 < 6) || (7 > 5)
		ec2.addExpression(3, ">", 2);
		ec2.addExpression(4, "<", 5);
		ec2.addExpression(9, "==", 9);
		ec2.addExpression(-1, "<", 6);
		ec2.addExpression(7, ">", 5);
		assertEquals(5, ec2.getExpressions().length);
		assertTrue(ec2.isTypeCorrect());
		ec2.evaluate();
		Boolean ec2V = (Boolean) ec2.getValue();
		assertTrue(ec2V);
	}

	@Test
	public void test23_a() { 
		ExpressionCollector ec1 = new DisjoinAll(); 
		Expression eq = new Equal(3, 3);
		Expression gt = new GreaterThan(7, 3);
		Expression lt = new LessThan(3, 7); 
		// Build the expression: (3 == 3) || (7 > 3) || (3 < 7)
		ec1.addExpression(eq);
		ec1.addExpression(gt);
		ec1.addExpression(lt);

		ExpressionCollector ec2 = new DisjoinAll(); 
		// Build the expression: (3 > 2) || (4 < 5) || (9 = 9) || (-1 < 6) || (7 > 5)
		ec2.addExpression(3, ">", 2);
		ec2.addExpression(4, "<", 5);
		ec2.addExpression(9, "==", 9);
		ec2.addExpression(-1, "<", 6);
		ec2.addExpression(7, ">", 5);

		// They are equal because their stored expressions evaluate to the same value.
		assertEquals(ec1, ec2);
	}

	@Test
	public void test23_b() { 
		ExpressionCollector ec1 = new DisjoinAll(); 
		Expression eq = new Equal(3, 3);
		Expression gt = new GreaterThan(7, 3);
		Expression lt = new LessThan(3, 7); 
		// Build the expression: (3 == 3) || (7 > 3) || (3 < 7)
		ec1.addExpression(eq);
		ec1.addExpression(gt);
		ec1.addExpression(lt);
		ec1.evaluate();
		Boolean ec1V = (Boolean) ec1.getValue();
		assertEquals(new Boolean(true), ec1V);

		ExpressionCollector ec2 = new DisjoinAll(); 
		// Build the expression: (2 > 3) || (5 < 4) || (9 = 6) || (6 < -1)
		ec2.addExpression(2, ">", 3);
		ec2.addExpression(5, "<", 4);
		ec2.addExpression(9, "==", 6);
		ec2.addExpression(6, "<", -1); 
		ec2.evaluate();
		Boolean ec2V = (Boolean) ec2.getValue();
		assertEquals(new Boolean(false), ec2V);

		// They are equal because their stored expressions evaluate to the same value.
		assertFalse(ec1.equals(ec2));
	}

	/*
	 * Section 5
	 * Checking type correctness for complex integer/boolean expressions.
	 */

	@Test
	public void test24() { 
		ExpressionCollector ec1 = new AddAll(); 
		// Build the expression: (3 + 2) + (3 - 2) + (5 > 7) + (3 * 2)
		Expression add = new Addition(3, 2);
		Expression sub = new Subtraction(3, 2);
		Expression gt = new GreaterThan(5, 7);
		Expression mul = new Multiplication(3, 2);
		ec1.addExpression(add);
		ec1.addExpression(sub);
		ec1.addExpression(gt);
		ec1.addExpression(mul);

		// It is not type correct because not all stored expressions are integer expressions.
		assertFalse(ec1.isTypeCorrect());

		// Build the expression: (0 + 1) + (7 - 5) + (-4 + 7) + (7 < 5) + (3 * 4) + (3 - 9)
		ExpressionCollector ec2 = new AddAll(); 
		ec2.addExpression(0, "+", 1);
		ec2.addExpression(7, "-", 5);
		ec2.addExpression(-4, "+", 7);
		ec2.addExpression(7, "<", 5);
		ec2.addExpression(3, "*", 4);
		ec2.addExpression(3, "-", 9);

		// It is not type correct because not all stored expressions are integer expressions.
		assertFalse(ec2.isTypeCorrect());
	}

	@Test
	public void test25() { 
		ExpressionCollector ec1 = new TimesAll(); 
		// Build the expression: (3 + 2) * (7 - 3) * (5 > 7) * (3 * 2)
		Expression add = new Addition(3, 2);
		Expression sub = new Subtraction(7, 3);
		Expression gt = new GreaterThan(5, 7);
		Expression mul = new Multiplication(3, 2);
		ec1.addExpression(add);
		ec1.addExpression(sub);
		ec1.addExpression(gt);
		ec1.addExpression(mul);

		// It is not type correct because not all stored expressions are integer expressions.
		assertFalse(ec1.isTypeCorrect());

		ExpressionCollector ec2 = new TimesAll(); 
		// Build the expression: (3 * 2) * (4 - 5) * (9 - 7) * (7 < 5) * (-1 + 6) * (5 - 7)
		ec2.addExpression(3, "*", 2);
		ec2.addExpression(4, "-", 5);
		ec2.addExpression(9, "-", 7);
		ec2.addExpression(7, "<", 5);
		ec2.addExpression(-1, "+", 6);
		ec2.addExpression(5, "-", 7); 

		// It is not type correct because not all stored expressions are integer expressions.
		assertFalse(ec2.isTypeCorrect());
	}

	@Test
	public void test26() { 
		ExpressionCollector ec1 = new ConjoinAll(); 
		Expression eq = new Equal(3, 3);
		Expression gt = new GreaterThan(7, 3);
		Expression sub = new Subtraction(9, 3);
		Expression lt = new LessThan(7, 3); 
		// Build the expression: (3 == 3) && (7 > 3) && (9 - 3) && (7 < 3)
		ec1.addExpression(eq);
		ec1.addExpression(gt);
		ec1.addExpression(sub);
		ec1.addExpression(lt);

		// It is not type correct because not all stored expressions are boolean expressions.
		assertFalse(ec1.isTypeCorrect());

		ExpressionCollector ec2 = new ConjoinAll(); 
		// Build the expression: (3 > 2) && (4 < 5) && (9 = 9) && (3 * 9) && (-1 < 6) && (5 > 7)
		ec2.addExpression(3, ">", 2);
		ec2.addExpression(4, "<", 5);
		ec2.addExpression(9, "==", 9);
		ec2.addExpression(3, "*", 9);
		ec2.addExpression(-1, "<", 6);
		ec2.addExpression(5, ">", 7);

		// It is not type correct because not all stored expressions are boolean expressions.
		assertFalse(ec2.isTypeCorrect());
	}

	@Test
	public void test27() { 
		ExpressionCollector ec1 = new DisjoinAll(); 
		Expression eq = new Equal(3, 3);
		Expression gt = new GreaterThan(7, 3);
		Expression add = new Subtraction(9, 3);
		Expression lt = new LessThan(3, 7); 
		// Build the expression: (3 == 3) || (7 > 3) || (9 + 3) || (3 < 7)
		ec1.addExpression(eq);
		ec1.addExpression(gt);
		ec1.addExpression(add);
		ec1.addExpression(lt);

		// It is not type correct because not all stored expressions are boolean expressions.
		assertFalse(ec1.isTypeCorrect());

		ExpressionCollector ec2 = new DisjoinAll(); 
		// Build the expression: (3 > 2) || (4 < 5) || (9 = 9) || (3 * 9) || (-1 < 6) || (7 > 5)
		ec2.addExpression(3, ">", 2);
		ec2.addExpression(4, "<", 5);
		ec2.addExpression(9, "==", 9);
		ec2.addExpression(3, "*", 9);
		ec2.addExpression(-1, "<", 6);
		ec2.addExpression(7, ">", 5);

		// It is not type correct because not all stored expressions are boolean expressions.
		assertFalse(ec2.isTypeCorrect());
	}
}
