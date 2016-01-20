/* 
 * AddExpression.java 
 * 
 * Version: 
 *     $Id: AddExpression.java,v 1.1 2013/04/18 16:35:57 vxd9797 Exp $ 
 * 
 * Revisions: 
 *     $Log: AddExpression.java,v $
 *     Revision 1.1  2013/04/18 16:35:57  vxd9797
 *     Initial Version - Checked.
 *
 */

/**
 * Add two integers to generate the result and form the expression.
 * 
 * @author Vu Dinh (vxd9797)	
 *
 */


public class AddExpression implements Expression {

	private Expression exp1, exp2;
	
	/**
	 *	Construct an Add expression from the supplied subexpression.
	 *
	 */
	public AddExpression(Expression exp1, Expression exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
	/**
	 *	Generates code for an Add expression.
	 *	Each subexpression is surrounded by parentheses with a plus sign in between.
	 *	Return a string that represents the code for the expression.
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
		return "(" + str1 + " + " + str2 + ")";
	}

	/**
	 *	Generates code for an Add expression.
	 *	Return an integer, the sum of the values of the sub-expressions.
	 */
	@Override
	public Integer evaluate() {
		if (exp1 == null || exp2 == null) {
			return null;
		}	
		if (exp1.evaluate() == null || exp2.evaluate() == null) {
			return null;
		}
		return exp1.evaluate() + exp2.evaluate();
	}

}
