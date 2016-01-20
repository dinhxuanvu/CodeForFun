/**
 * DoMagic.java
 * 
 * File:
 * 		$Id: DoMagic.java,v 1.1 2013/11/05 20:05:24 vxd9797 Exp $
 * 
 * Revisions:
 * 		$Log: DoMagic.java,v $
 * 		Revision 1.1  2013/11/05 20:05:24  vxd9797
 * 		Final version. Commented.
 *
 * 
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Essentially a test program for the MagicBag.
 * 
 * @author vxd9797
 */

public class DoMagic {
	
	// DoMagic constructor
	public DoMagic() {
	}

	/**
	 * Main method does all testing.
	 * @param <E>
	 * @param args (unused)
	 */
	public static void main(String[] args) {
		
		// Create an Magic Bag
		MagicBag<String> bag = new MagicBag<String>();
		
		// Add item one by one to the magic bag
		System.out.println("Putting newt in the bag.");
		bag.add("newt");
		System.out.println("Bag has " + bag.size() + " items in it.");

		System.out.println("Putting eyeball in the bag.");
		bag.add("eyeball");
		System.out.println("Bag has " + bag.size() + " items in it.");
		
		System.out.println("Putting dragon tooth in the bag.");
		bag.add("dradon tooth");
		System.out.println("Bag has " + bag.size() + " items in it.");

		System.out.println("Putting newt in the bag.");
		bag.add("newt");
		System.out.println("Bag has " + bag.size() + " items in it.");

		System.out.println("Putting snakeskin in the bag.");
		bag.add("snakeskin");
		System.out.println("Bag has " + bag.size() + " items in it.");

		System.out.println("Putting newt in the bag.");
		bag.add("newt");
		System.out.println("Bag has " + bag.size() + " items in it.");
		
		System.out.println("Putting toad in the bag.");
		bag.add("toad");
		System.out.println("Bag has " + bag.size() + " items in it.");

		System.out.println("Putting eyeball in the bag.");
		bag.add("eyeball");
		System.out.println("Bag has " + bag.size() + " items in it.");

		System.out.println("Putting spider in the bag.");
		bag.add("spider");
		System.out.println("Bag has " + bag.size() + " items in it.");
		
		System.out.println("");

		// Testing the pull function
		System.out.println("Testing pull():");
		
		// Pull everything out of the magic one by one until the magic bag is empty
		while (bag.isEmpty() != true) {
			System.out.println("I got " + bag.pull() + ", bag now has " + bag.size() + " items in it.");
		}
		
		System.out.println("");
		
		// Test the iteration function
		System.out.println("Testing iteration:");
		
		// Asking user for the item that want to find
		System.out.println("What would you like from the bag?");
		
		// Get the input string from the user
		Scanner sc = new Scanner(System.in);
		
		String stringInput = sc.next();
		
		// Add a bunch of items into a list
		List<String> newList = new ArrayList<String>();
		newList.add("toad");
		newList.add("eyeball");
		newList.add("newt");
		newList.add("spider");
		newList.add("dragon tooth");
		newList.add("newt");
		newList.add("toad");

		// Add the list of items into the bag
		bag.addAll(newList);
		
		// Iterate through the list until found the item the user wanted
		Iterator<String> iter = bag.iterator();
		while (iter.hasNext() != false) {
			String newStr = iter.next();
			System.out.println("Got " + newStr);
			if (newStr.equals(stringInput)) {
				System.out.println("Here you go!");
				bag.magicList.remove(newStr);
				System.out.println("Bag has " + bag.size() + " items in it.");
				break;
			}
			System.out.println("We'll keep looking...");
		}
	}

}
