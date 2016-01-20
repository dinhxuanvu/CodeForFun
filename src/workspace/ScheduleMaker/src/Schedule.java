/**
 *
 * Schedule.java
 * 
 * $Id: Schedule.java,v 1.3 2013/09/18 04:31:26 vxd9797 Exp $
 *
 * $Log: Schedule.java,v $
 * Revision 1.3  2013/09/18 04:31:26  vxd9797
 * Changed some comments
 *
 * Revision 1.2  2013/09/18 04:28:39  vxd9797
 * Final Version
 *
 * Revision 1.1  2013/09/18 04:13:12  vxd9797
 * Initial Revision
 *
 *
 */

import java.util.ArrayList;

/**
 * Class that holds a number of courses that do not conflict and can print out a
 * simple day-by-day schedule.
 * 
 * @author vxd9797
 */
public class Schedule {

	/** CoursesSchudule is s an ArrayList of Course objects. */
	private ArrayList<Course> CourseSchedule = new ArrayList<Course>();

	// Constructor
	public Schedule() {
	}

	/**
	 * Adds the given course to schedule if it is not in conflict with courses
	 * currently on the schedule.
	 * 
	 * @param Course c - Course object
	 * @return True if the course was successfully added
	 */
	public boolean add(Course c) {

		// Check if the course is in conflict
		for (int i = 0; i < CourseSchedule.size(); i++) {
			if (CourseSchedule.get(i).isConflict(c)) {
				return false;
			}
		}

		// Add course into schedule
		CourseSchedule.add(c);
		return true;
	}

	/**
	 * Tests whether a given Course is currently on the schedule.
	 * 
	 * @param Course c - Course object
	 * @return True if the course is on the schedule.
	 */
	public boolean contains(Course c) {

		if (CourseSchedule.contains(c)) {
			return true;
		} else
			return false;
	}

	/**
	 * 
	 * Prints a day-by-day schedule (Monday to Friday).
	 * 
	 */
	public void prettyPrint() {

		// String ArrayList of all days from Monday to Friday
		ArrayList<String> dayList = new ArrayList<String>();
		dayList.add("----Monday----");
		dayList.add("----Tuesday----");
		dayList.add("----Wednesday----");
		dayList.add("----Thursday----");
		dayList.add("----Friday----");

		// Compare the days for each course in ScheduleCourse
		for (int i = 0; i < 5; i++) {
			System.out.println(dayList.get(i));
			for (int x = 0; x < CourseSchedule.size(); x++) {
				String courseString = CourseSchedule.get(x).inDay(i);
				if (!courseString.isEmpty())
					System.out.println(courseString);
			}
		}

	}

	/**
	 * String representation: "Schedule with n courses" where n is the number of
	 * courses on the schedule
	 * 
	 * @return String representation: "Schedule with n courses"
	 */
	public String toString() {

		return "Schedule with " + CourseSchedule.size() + " courses.";
	}
}
