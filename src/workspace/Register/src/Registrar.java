/**
 *
 * Registrar.java
 * 
 * $Id: Registrar.java,v 1.1 2013/09/25 05:13:20 vxd9797 Exp $
 *
 * $Log: Registrar.java,v $
 * Revision 1.1  2013/09/25 05:13:20  vxd9797
 * Initial Revision
 *
 *
 */

import java.util.Scanner;

/**
 * 
 * The program adds or removes students from the list based on their priority.
 * The priority of a student would be determined by his/her GPA and year level.
 * 
 * @author vxd9797
 */
public class Registrar {
	
	private static LinkedQueue<Student> queue = new LinkedQueue<Student>();

	/**
	 * 
	 * Menu to allow user to select the options to add or remove students.
	 * User enters student's name, year and GPA.
	 * Student is added to or removed from the queue based on priority.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Student information variables
		String studentName;
		int studentYear;
		double studentGPA;
		
		// Student objects
		Student newStudent;
		Student firstStudent;
		
		// Scanner
		Scanner in = new Scanner(System.in);
		
		boolean quit = false;
		
		while (!quit) {
			// Menu options
		    System.out.println("Enter an option");
		    System.out.println("1 to Add a student to the queue");
		    System.out.println("2 to Remove and print the first student");
		    System.out.println("3 to quit");
		    System.out.print("Your choice: ");
		    
		    int choice = in.nextInt();
	            
		    if (choice == 1) {
		    	System.out.print("Student name: ");
		    	studentName = in.next();
		    	
		    	System.out.print("Year: ");
		    	studentYear = in.nextInt();
		    	
		    	System.out.print("GPA: ");
		    	studentGPA = in.nextDouble();
		    	
		    	// New student
		    	newStudent = new Student(studentName, studentYear, studentGPA);
		    	// Add new student to the queue
		    	queue.insert(newStudent);
		    } 
		    else if (choice == 2) {
		    	if (!queue.isEmpty()) {
		    		// Dequeue the first student
		    		firstStudent = queue.dequeue();
		    		// Print out removed student's information
		    		System.out.println("Registering " + firstStudent.getName() + " in year " + 
		    		firstStudent.getYear() + " with GPA " + firstStudent.getGPA());
		    	}
		    	else
		    		// Queue is empty
		    		System.out.println("Queue is empty.");
		    } 
		    else if (choice == 3) {
		    	quit = true;
		    } 
		    else {
		    	System.out.println("Not a valid option, please try again.");
		    }
		}
	}
}
