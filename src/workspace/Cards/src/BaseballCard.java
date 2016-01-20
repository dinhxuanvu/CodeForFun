/**
 * File:
 *   $Id: BaseballCard.java,v 1.1 2013/04/16 20:31:31 vxd9797 Exp $
 *   
 * Revisions:
 *   $Log: BaseballCard.java,v $
 *   Revision 1.1  2013/04/16 20:31:31  vxd9797
 *   Initial Version
 *
 */

/**
 * Dealer implements the Dealer class.
 * 
 * @author Vu Dinh
 *
 */

public class BaseballCard {
	
	private int homers;
	private String name;
	
	/**
	 * Constructor
	 */
	public BaseballCard(BaseballCard bc) {
		this.homers = bc.homers;
		this.name = bc.name;
		
	}
	
	/**
	 * Constructor
	 */
	public BaseballCard(String name, int homers) {
		this.name = name;
		this.homers = homers;
	}
	
	/**
	 * Method to compare two BaseballCard objects based on home runs, then name.
	 * Return the result of comparison.
	 */
	public int compareTo(BaseballCard bc) {
		
		if (homers == bc.homers) {
			return name.compareTo(bc.name);
		}	
		else
			return homers - bc.homers;
	}
	
	/**
	 * Method to test equality of two BaseballCard objects by name and home runs.
	 * Return the boolean result of the equality test.
	 */
	public boolean equals(Object o) {
		if (!(o instanceof BaseballCard)) {
			return false;
		}
		else
			return this.compareTo((BaseballCard) o) == 0;
	}
	
	/**
	 * Method to get home runs of player associated with current BaseballCard object.
	 * Return the integer value of home runs.
	 */
	public int getHomeRuns() {
		return homers;
		
	}
	
	/**
	 * Method to get name of player associated with current BaseballCard object.
	 * Return the name of object.
	 */
	public String getPlayerName() {
		return name;
		
	}
	
	/**
	 * Method to compute hashCode for BaseballCard object.
	 * Return the hashcode value for the object.
	 */
	public int hashCode() {
		return name.hashCode() + new Integer(homers).hashCode();
		
	}
	
	/**
	 * Method to convert a BaseballCard object to a String.
	 * Return the string result of the object.
	 */
	public String toString() {
		return name + ":" + homers;
		
	}

}
