/* 
 * AddExpression.java 
 * 
 * Version: 
 *     $Id: MulExpression.java,v 1.1 2013/04/18 16:35:57 vxd9797 Exp $ 
 * 
 * Revisions: 
 *     $Log: MulExpression.java,v $
 *     Revision 1.1  2013/04/18 16:35:57  vxd9797
 *     Initial Version - Checked.
 *
 */

/**
 * Multiply two integers to generate the result and form the expression.
 * 
 * @author Vu Dinh (vxd9797)	
 *
 */

public class MulExpression implements Expression {

	private Expression exp1, exp2;
	
	/**
	 *	Construct a Multiply expression from the supplied subexpression
	 *
	 */
	public MulExpression(Expression exp1, Expression exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
	/**
	 *	Generates code for an Mul expression.
	 *	Each subexpression is surrounded by parentheses with a multiply sign in between.
	 *	Return an integer, the multiplication of the values of the sub-expressions.
	 *
	 */
	@Override
	public String emit() {
		String str1, str2;
		if (exp1 == null) {
			str1 = "";
		}
		else
			str1 = exp1.emit();
		if (exp2 == null) {
			str2 = "";
		}
		else str2 = exp2.emit();
		return "(" + str1 + " * " + str2 + ")";
	}

	/**
	 *	Causes evaluation of an Mul expression. 
	 *	The value is the product of the values of the subexpressions.
	 *	Return an Integer, the product of the values of the sub-expression.
	 */
	@Override
	public Integer evaluate() {
		if (exp1 == null || exp2 == null) {
			return null;
		}	
		if (exp1.evaluate() == null || exp2.evaluate() == null) {
			return null;
		}
		return exp1.evaluate() * exp2.evaluate();
	}

}
