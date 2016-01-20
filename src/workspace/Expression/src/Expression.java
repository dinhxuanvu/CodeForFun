/* 
 * Expression.java 
 * 
 * Version: 
 *     $Id: Expression.java,v 1.1 2013/04/18 16:35:58 vxd9797 Exp $ 
 * 
 * Revisions: 
 *     $Log: Expression.java,v $
 *     Revision 1.1  2013/04/18 16:35:58  vxd9797
 *     Initial Version - Checked.
 *
 */

/**
 * Expression Interface
 * 
 * @author Vu Dinh (vxd9797)	
 *
 */

public interface Expression {
	
	/**
	 *	Generates code for an expression.
	 *
	 */
	public String emit();
	
	/**
	 *	Causes evaluation of an expression.
	 *
	 */
	public Integer evaluate();
}
