package Thumbtack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/*
 * A simple in-memory database named SimpleDatabase
 */
public class SimpleDatabase {

	// Map to hold variables and their values
	private Map<String, LinkedList<String>> database;
	// Command log to keep track of BEGIN, SET and UNSET commands
	private LinkedList<String> log;
	// Set to keep track of modified variables
	private Set<String> change;
	// Indicate of transaction blocks are in process
	private boolean isBegin;
	// Count number of transaction blocks
	private int nestedCounter;

	/*
	 * SimpleDatabase Constructor Initialize fields
	 */
	public SimpleDatabase() {
		database = new HashMap<String, LinkedList<String>>();
		log = new LinkedList<String>();
		change = new HashSet<String>();
		isBegin = false;
		nestedCounter = 0;
	}

	/*
	 * Activate the transaction block
	 */
	public void begin() {
		// Flag isBegin
		if (isBegin == false)
			isBegin = true;
		// Increment transaction block counter
		nestedCounter++;
		// Add to log
		log.add("BEGIN");
	}

	/*
	 * Set a variable to a value
	 * 
	 * @param name: name of variable
	 * 
	 * @param value: value to set
	 */
	public void set(String name, String value) {
		// If transaction block is process
		if (isBegin == true) {
			// Keep track of commands and variable changes
			log.add(name);
			change.add(name);
			// If variable already exits
			if (database.containsKey(name)) {
				database.get(name).add(value);
			} else {
				// Add new variable to database
				LinkedList<String> newList = new LinkedList<String>();
				newList.add(value);
				database.put(name, newList);
			}
		} else {
			if (database.containsKey(name)) {
				database.get(name).removeLast();
				database.get(name).add(value);
			} else {
				LinkedList<String> newList = new LinkedList<String>();
				newList.add(value);
				database.put(name, newList);
			}
		}
	}

	/*
	 * Get a variable to a value
	 * 
	 * @param name: name of variable
	 */
	public void get(String name) {
		// Check if variable exits in DB
		if (database.containsKey(name)) {
			if (database.get(name).isEmpty()) {
				System.out.println("NULL");
			} else
				System.out.println(database.get(name).getLast());
		} else
			// Print NULL if variable doesn't exit in database
			System.out.println("NULL");
	}

	/*
	 * Unset a variable to a value
	 * 
	 * @param name: name of variable
	 */
	public void unset(String name) {
		// If transaction block is in process
		if (isBegin == true) {
			// Keep track of commands and variable changes
			change.add(name);
			log.add(name);
			// Add NULL to variable's list of values
			if (database.containsKey(name)) {
				database.get(name).add("NULL");
			}
		} else {
			if (database.containsKey(name)) {
				// Remove the last entry and add NULL
				database.get(name).removeLast();
				database.get(name).add("NULL");
			}
		}
	}

	/*
	 * Count the number of variable equals to value
	 * 
	 * @param value: name of value to search
	 */
	public void numEqualTo(String num) {
		int counter = 0;
		// Go through the map and check if the any variables equal to value
		for (Map.Entry<String, LinkedList<String>> entry : database.entrySet()) {
			if (entry.getValue().getLast().equals(num)) {
				// Increment counter if found
				counter++;
			}
		}
		// Print out the counter
		System.out.println(counter);
	}

	/*
	 * Rollback the changes in the most recent
	 * transaction block. 
	 */
	public void rollback() {
		// If no block is in process, print NO TRANSACTION
		if (isBegin == false) {
			System.out.println("NO TRANSACTION");
		} else {
			String temp;
			while (nestedCounter > 0) {
				// Pop the command log one by one
				temp = log.removeLast();
				// If the command log entry is BEGIN, then we are done
				if (temp.equals("BEGIN")) {
					// Decrement nestedCounter
					nestedCounter--;
					// If nestedCounter is 0, all block are done
					// So de-flag the isBegin
					if (nestedCounter == 0)
						isBegin = false;
					break;
				} else {
					// Remove the last entry in variable's list of value
					database.get(temp).removeLast();
				}
			}
		}
	}

	/*
	 * Commit the changes in all open transaction blocks. 
	 */
	public void commit() {
		// Check the command log has any transactions
		if (log.isEmpty()) {
			System.out.println("NO TRANSACTION");
		} else {
			// Return all fields back to default values
			isBegin = false;
			nestedCounter = 0;
			// Discard the old log and get a new log
			log = new LinkedList<String>();
			// Go through the change log to commit the modified variables
			for (String str : change) {
				// Replace the list of values with a new list of only committed value
				LinkedList<String> newList = new LinkedList<String>();
				newList.add(database.get(str).getLast());
				database.put(str, newList);
			}
			change = new HashSet<String>();
		}

		/*
		 * Now, the map (database) is updated.
		 * You can save/transmit database somewhere else for storage or backup.
		 * Otherwise, database is lost after JAVA program exits.
		 */
	}

}
