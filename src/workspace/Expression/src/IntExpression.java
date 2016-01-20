/* 
 * AddExpression.java 
 * 
 * Version: 
 *     $Id: IntExpression.java,v 1.1 2013/04/18 16:35:59 vxd9797 Exp $ 
 * 
 * Revisions: 
 *     $Log: IntExpression.java,v $
 *     Revision 1.1  2013/04/18 16:35:59  vxd9797
 *     Initial Version - Checked.
 *
 */

/**
 * Display the integer and form the expression.
 * 
 * @author Vu Dinh (vxd9797)	
 *
 */

public class IntExpression implements Expression {

	private int exp1;
	
	/**
	 *	Construct an Int expression from the supplied string.
	 *
	 */
	public IntExpression(String valString) {
		this.exp1 = Integer.parseInt(valString);
	}
	
	/**
	 *	Generates code for an Int expression. 
	 *  The code is the valString of the int.
	 *  Return a string that represents the code for the expression.
	 *
	 */
	@Override
	public String emit() {
		return "" + exp1;
	}

	/**
	 * 	Causes evaluation of an Int expression. The value is its number.
	 *	Return an Integer, the value of the expression.
	 *
	 */
	@Override
	public Integer evaluate() {
		return exp1;
	}

}
