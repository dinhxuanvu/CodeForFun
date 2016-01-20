/* 
 * Interp.java 
 * 
 * Version: 
 *     $Id: Parse.java,v 1.1 2013/04/18 16:35:58 vxd9797 Exp $ 
 * 
 * Revisions: 
 *     $Log: Parse.java,v $
 *     Revision 1.1  2013/04/18 16:35:58  vxd9797
 *     Initial Version - Checked.
 *
 */

/**
 * A container for the static methods to parse interp expressions
 * 
 * @author Vu Dinh (vxd9797)	
 *
 */
public class Parse {

	/**
	 *	Constructor Parse()
	 *
	 */
	public Parse() {}
	
	/**
	 *	Parse a prefix expression.
	 *	Return a Expression tree representing the token stream or null.
	 *
	 */
	public static Expression parseString(String s) {
		String[] s1 = s.split("\\s+");	
		return parseExp(s1,0);
	}
	
	/**
	 *	Parse the expression in add, subtract and multiply.
	 *	Return the expression.
	 *
	 */
	private static Expression parseExp(String[] s, int i) {
		if (i >= s.length || i < 0) {
			return null;
		}
		if (s[i].matches("\\d+")) {
			return new IntExpression(s[i]);
		}
		else if (s[i].equals("+")) {
			Expression e1 = parseExp(s,i+1);
			int index1 = getIndex(s,i+1);
			return new AddExpression(e1, parseExp(s,index1));
		}
		else if (s[i].equals("-")) {
			Expression e2 = parseExp(s,i+1);
			int index2 = getIndex(s,i+1);
			return new SubExpression(e2, parseExp(s,index2));
		}
		else if (s[i].equals("*")) {
			Expression e3 = parseExp(s,i+1);
			int index3 = getIndex(s,i+1);
			return new MulExpression(e3, parseExp(s,index3));
		}
		else
			return null;
	}

	/**
	 *	Return the index of the expression starting at index i.
	 */
	private static int getIndex(String[] s, int i) {
		if (i >= s.length) {
			return -1;
		}
		if (s[i].matches("\\d+")) {
			return i+1;
		}
		else if (s[i].equals("+")) {
			int index1 = getIndex(s,i+1);
			return getIndex(s,index1);
		}
		else if (s[i].equals("-")) {
			int index2 = getIndex(s,i+1);
			return getIndex(s,index2);
		}
		else if (s[i].equals("*")) {
			int index3 = getIndex(s,i+1);
			return getIndex(s,index3);
		}
		else
			return -1;
	}
	
}
