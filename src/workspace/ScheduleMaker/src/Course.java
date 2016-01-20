/**
 *
 * Course.java
 * 
 * $Id: Course.java,v 1.3 2013/09/18 04:31:26 vxd9797 Exp $
 *
 * $Log: Course.java,v $
 * Revision 1.3  2013/09/18 04:31:26  vxd9797
 * Changed some comments
 *
 * Revision 1.2  2013/09/18 04:28:39  vxd9797
 * Final Version
 *
 * Revision 1.1  2013/09/18 04:13:11  vxd9797
 * Initial Revision
 *
 *
 */

import java.util.ArrayList;

/**
 * 
 * Represents a single course, including name, days and time scheduled. Assumes
 * that all courses start and end on the hour.
 * 
 * @author vxd9797
 */
public class Course {

	// Constant value
	public static String dayString = "MTWRF";

	// Instance variables
	private String name;
	private ArrayList<Boolean> days;
	private int start;
	private int end;

	/**
	 * Constructor
	 * 
	 * @param name, days, starting time and end time of course
	 * 
	 */
	public Course(String n, ArrayList<Boolean> days, int start, int end) {
		name = n;
		this.days = days;
		this.start = start;
		this.end = end;
	}

	/**
	 * Test for equality of two objects
	 * 
	 * @param Object other - Object to be tested against
	 * @return True if the object passed in is a Course with the same name,
	 *         days, start and end time as this Course
	 */
	public boolean equals(Object other) {

		// If two objects are equal
		if (this == other) {
			return true;
		}

		// If other is empty
		if (other == null) {
			return false;
		}
		
		// If other is a Course, then compare the attributes
		if (other instanceof Course) {
			Course myCourse = (Course) other;
			if (name != myCourse.name) {
				return false;
			} else if (days != myCourse.days) {
				return false;
			} else if (start != myCourse.start) {
				return false;
			} else if (end != myCourse.end) {
				return false;
			} else
				return true;
		} else
			return false;
	}

	/**
	 * Returns a string representing the time this course meets on the given
	 * day.
	 * 
	 * @param day - Day of the week, where 0 = Monday ... 4 = Friday
	 * @return String representation or the empty String if the course does not
	 *         meet on the given day.
	 */
	public String inDay(int day) {

		if (days.get(day) == true) {
			return start + "-" + end + ": " + name;
		}

		return "";
	}

	/**
	 * Test for scheduling conflict.
	 * 
	 * @param Course other - Course to test against
	 * @return True if the passed-in Course overlaps in time with this Course.
	 */
	public boolean isConflict(Course other) {

		for (int i = 0; i < other.days.size(); i++) {
			if (days.get(i) == other.days.get(i)) {
				if (start < other.end && end > other.start) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * String representation of the course, in the form Name: days at start-end.
	 * 
	 * @return String representation of the course
	 */
	public String toString() {

		String day = "";

		for (int i = 0; i < days.size(); i++) {
			
			if (days.get(i) == true) {
				day += dayString.substring(i, i + 1);
			}
		}

		return name + ": " + day + " at " + start + "-" + end;
	}

}
