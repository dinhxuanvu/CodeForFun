/*
 * SIS.java
 *
 * Version:
 * $Id: SIS.java,v 1.2 2013/10/15 23:09:47 vxd9797 Exp $
 *
 * Revisions:
 * $Log: SIS.java,v $
 * Revision 1.2  2013/10/15 23:09:47  vxd9797
 * Final Version
 *
 * Revision 1.1  2013/10/15 09:54:04  vxd9797
 * Initial Revision
 *
 */

import java.util.Scanner;
import java.io.*;

/**
 * Main method using different ChainedHashMaps.
 * 
 * @author zjb
 * @author vxd9797
 */
public class SIS {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            First argument should be a filename containing student data
	 */
	public static void main(String[] args) {

		ChainedMap<String, Student> byName = new ChainedMap<String, Student>();
		ChainedMap<Integer, Student> byId = new ChainedMap<Integer, Student>();

		try {
			Scanner filein = new Scanner(new File(args[0]));
			while (filein.hasNextLine()) {
				Student s = new Student(filein.nextLine());
				System.out.println(s);
				byName.put(s.getName(), s);
				byId.put(s.getId(), s);
			}
		} catch (IOException e) {
			System.err.println("Sorry, error opening data file.");
			System.exit(0);
		}

		Scanner in = new Scanner(System.in);
		int response = -1;
		while (response != 5) {
			System.out.println("\nWhat do you want to do?");
			System.out.println("1. Query by name");
			System.out.println("2. Query by ID");
			System.out.println("3. Add a student");
			System.out.println("4. Remove by ID");
			System.out.println("5. Quit");
			System.out.print("Enter 1-5: ");
			response = in.nextInt();
			Student found;
			switch (response) {
			case 1:
				System.out.print("Enter student's name: ");
				Scanner in1 = new Scanner(System.in);
				String name = in1.nextLine();
				//
				// Should query user for a name, look it up in the
				// appropriate map and print the student record or
				// an error message if not present. Note that since
				// a name may contain spaces, use in.nextLine() to
				// read the entire input.
				//
				if (byName.get(name) != null) {
					System.out.println(byName.get(name).toString());
				}
				else
					System.out.println("Student is not found.");
				break;

			case 2:
				//
				// Should query user for an ID, look it up in the
				// appropriate map and print the student record or
				// an error message if not present.
				//
				System.out.print("Enter student's ID: ");
				Scanner in2 = new Scanner(System.in);
				int id = in2.nextInt();
				if (byId.get(id) != null) {
					System.out.println(byId.get(id).toString());
				}
				else
					System.out.println("Student is not found.");
				break;

			case 3:
				Scanner in3 = new Scanner(System.in);
				System.out.print("Enter name: ");
				String newname = in3.nextLine();
				System.out.print("Enter major: ");
				String newmajor = in3.nextLine();
				System.out.print("Enter year: ");
				int newyear = in3.nextInt();
				System.out.print("Enter ID: ");
				int newid = in3.nextInt();
				//
				// Create student object and add to both hash maps
				//
				Student student = new Student(newname, newmajor, newyear, newid);
				byId.put(student.getId(), student);
				byName.put(student.getName(), student);
				break;
			case 4:
				//
				// Query user for ID number, look it up in the appropriate
				// table. If it exists, remove the student from BOTH tables.
				// Otherwise print an error message.
				//
				System.out.print("Enter student's ID: ");
				Scanner in4 = new Scanner(System.in);
				int removeId = in4.nextInt();
				found = byId.get(removeId);
				if (found != null)
				{
					byId.remove(removeId);
					byName.remove(found.getName());
					System.out.println(found.toString());
				}
				else
				{
					System.out.println("Student is not found.");
				}				
				break;
			case 5:
				break;
			default:
				System.out.println("Sorry, not a valid option.");
			}
		}

	}

}