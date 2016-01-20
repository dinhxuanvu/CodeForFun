/**
 *
 * Student.java
 * 
 * $Id: Student.java,v 1.1 2013/09/25 05:13:21 vxd9797 Exp $
 *
 * $Log: Student.java,v $
 * Revision 1.1  2013/09/25 05:13:21  vxd9797
 * Initial Revision
 *
 *
 */

/**
 * 
 * Student class implements Prioritizable interface.
 * The class contains student's information such as name, year and GPA.
 * 
 * @author vxd9797
 */
public class Student implements Prioritizable {

	// Variables field
	private String studentName;
	private int studentYear;
	private double studentGPA;
	private double studentPriority;
	
	/**
	 * 
	 * Student constructor accepts 3 parameters.
	 * Calculate student's priority = (year*10) + GPA;
	 * 
	 * @param String name - Student's name
	 * @param int year - Student's year level
	 * @param double GPA - Student's GPA
	 * 
	 */
	public Student(String name, int year, double GPA) {
		studentName = name;
		studentYear = year;
		studentGPA = GPA;
		studentPriority = (year * 10) + GPA;
	}
	
	/**
	 * Return student's name
	 * @return studentName
	 */
	public String getName() {
		return studentName;
	}
	
	/**
	 * Return student's year
	 * @return studentYear
	 */
	public int getYear() {
		return studentYear;
	}
	
	/**
	 * Return student's GPA
	 * @return studentGPA
	 */
	public double getGPA() {
		return studentGPA;
	}
	
	/**
	 * Return student's priority
	 * @return studentPriotiry
	 */
	public double getPriority() {
		return studentPriority;
	}
	
}
