package Thumbtack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Program {
	
	// The database to be used
	protected static SimpleDatabase db;
	
	/*
	 * The main program to run the database
	 * The program can either read commands from text file or from stdIn
	 */
	public static void main(String[] args) {
		// Check to see there are any parameters in command line
		if (args.length > 0) {
			try {
				// File Input and Reader to read text file
				FileInputStream in = new FileInputStream(args[0]);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				// Input string
				String str;
				// Command array
				String[] arr;
				// Initialize the database
				db = new SimpleDatabase();
				// Read the file line by line
				while ((str = br.readLine()) != null) {
					// Parse the command
					arr = str.split(" ");
					// Print command
					System.out.println(str);
					// Check if END command
					if (arr[0].equals("END")) {
						// Exit program if END command is used
						break;
					} else
						// Pass command string to commandHandler method
						commandHandler(arr);
				}
				// Close BufferedReader and InputStream
				br.close();
				in.close();

			} catch (IOException e) {
				System.err.println("File is not found.");
			}
		} else {
			// Scanner for input
			Scanner input = new Scanner(System.in);
			String str;
			String[] arr;
			// Initialize database
			db = new SimpleDatabase();
			// Wait for new input
			while (input.hasNext()) {
				// Get the input
				str = input.nextLine();
				// Parse input to get command
				arr = str.split(" ");
				if (arr[0].equals("END")) {
					break;
				} else
					commandHandler(arr);
			}
			// Close scanner input
			input.close();
		}
	}

	/*
	 * A method to handle different commands for the database
	 */
	private static void commandHandler(String[] arr) {
		if (arr[0].equals("BEGIN")) {
			db.begin();
		} else if (arr[0].equals("GET")) {
			if (arr.length == 2) {
				db.get(arr[1]);
			} else
				System.out.println("INVALID COMMAND");
		} else if (arr[0].equals("SET")) {
			if (arr.length == 3) {
				db.set(arr[1], arr[2]);
			} else
				System.out.println("INVALID COMMAND");
		} else if (arr[0].equals("UNSET")) {
			if (arr.length == 2) {
				db.unset(arr[1]);
			} else
				System.out.println("INVALID COMMAND");
		} else if (arr[0].equals("NUMEQUALTO")) {
			if (arr.length == 2) {
				db.numEqualTo(arr[1]);
				;
			} else
				System.out.println("INVALID COMMAND");
		} else if (arr[0].equals("ROLLBACK")) {
			db.rollback();
		} else if (arr[0].equals("COMMIT")) {
			db.commit();
		} else {
			System.out.println("INVALID COMMAND");
		}
	}
}
