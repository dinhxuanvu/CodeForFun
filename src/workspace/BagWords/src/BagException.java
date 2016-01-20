/**
 *
 * BagException.java
 * 
 * $Id: BagException.java,v 1.2 2013/11/20 05:31:47 vxd9797 Exp $
 *
 * $Log: BagException.java,v $
 * Revision 1.2  2013/11/20 05:31:47  vxd9797
 * Final Version. Commented and tested.
 *
 * Revision 1.1  2013/11/20 02:53:12  vxd9797
 * Initial Revision
 *
 * 
 */

/**
 * 
 * Simple class to represent issues with bags of words.
 * 
 * @author vxd9797
 */

public class BagException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor, simply calls appropriate superclass constructor.
	 * @param msg - Exception message
	 */
	public BagException(String msg) {
		super(msg);
	}
}
