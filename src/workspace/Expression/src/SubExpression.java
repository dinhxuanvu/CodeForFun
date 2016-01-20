/* 
 * AddExpression.java 
 * 
 * Version: 
 *     $Id: SubExpression.java,v 1.1 2013/04/18 16:35:57 vxd9797 Exp $ 
 * 
 * Revisions: 
 *     $Log: SubExpression.java,v $
 *     Revision 1.1  2013/04/18 16:35:57  vxd9797
 *     Initial Version - Checked.
 *
 */

/**
 * Subtract two integers to generate the result and form the expression.
 * 
 * @author Vu Dinh (vxd9797)	
 *
 */

public class SubExpression implements Expression {

	private Expression exp1, exp2;
	
	/**
	 *	Construct a Subtract expression from the supplied subexpression
	 *
	 */
	public SubExpression(Expression exp1, Expression exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
	/**
	 *	Generates code for a Sub expression.
	 *	Each subexpression is surrounded by parentheses with a minus sign in between.
	 *	Return an integer, the  of the values of the sub-expressions. 
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
		return "(" + str1 + " - " + str2 + ")";
	}

	/**
	 *	Causes evaluation of an Sub expression. 
	 *	The value is the difference of the values of the subexpressions.
	 *	Return a string that represents the code for the expression.
	 *
	 */
	@Override
	public Integer evaluate() {
		if (exp1 == null || exp2 == null) {
			return null;
		}	
		if (exp1.evaluate() == null || exp2.evaluate() == null) {
			return null;
		}
		return exp1.evaluate() - exp2.evaluate();
	}

}
