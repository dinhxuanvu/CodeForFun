/**
 * TernaryHeap.java
 * 
 * $Id: TernaryHeap.java,v 1.4 2013/10/23 03:08:13 vxd9797 Exp $
 *
 * $Log: TernaryHeap.java,v $
 * Revision 1.4  2013/10/23 03:08:13  vxd9797
 * Final Version.
 *
 * Revision 1.3  2013/10/23 03:07:39  vxd9797
 * Checked.
 *
 * Revision 1.2  2013/10/23 03:06:01  vxd9797
 * Final Version
 *
 * Revision 1.1  2013/10/22 22:46:50  vxd9797
 * Initial Revision
 *
 * 
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * The standard Ternary Heap.
 * Using a natural ordering to place elements.
 * 
 * @author vxd9797
 *
 */

public class TernaryHeap <T extends Comparable<T>> {

	// The arraylist presents the heap
	private ArrayList<T> ternaryHeap;
	
	// Counter for swaps
	private int swaps;

	// Constructor for heap
	public TernaryHeap() {
		ternaryHeap = new ArrayList<T>();
	}

	/**
	 * Removes and returns minimum element in the heap.
	 *
	 * @return minimal element, or null if empty heap.
	 */
	public T removeMin() {
		if (ternaryHeap.isEmpty())
			return null;
		// keep the top of the heap to return later
		T toReturn = ternaryHeap.get(0);
		// if that wasn't the last one, take the end of the heap to the
		// root and bubble it down.
		if (ternaryHeap.size() > 1) {
			ternaryHeap.set(0,ternaryHeap.remove(ternaryHeap.size()-1));
			int minElement,location = 0;
			while ((minElement = minChild(location)) != location) {
				// bubbling down
				T temp = ternaryHeap.get(location);
				ternaryHeap.set(location, ternaryHeap.get(minElement));
				ternaryHeap.set(minElement, temp);
				location = minElement;
				swaps++;
			}
		} else {
			// simply remove the root and be happy!
			ternaryHeap.remove(0);
		}
		return toReturn;
	}

	/**
	 * Computes the smallest of the node and two children.
	 * 
	 * @param index
	 * @return index of element with smallest value
	 */
	private int minChild(int index) {
		int min = index;
		// children of index are 3*index+1, 3*index+2, 3*index+3
		// if first child exists, is it smaller than me?
		if (3*index+1 < ternaryHeap.size()) {
			if (ternaryHeap.get(3*index+1).compareTo(ternaryHeap.get(index)) < 0) {
				min = 3*index+1;
			}
			// how about a second child?  Compare to whichever of the
			// parent and first child was smaller.
			if (3*index+2 < ternaryHeap.size()) {
				if (ternaryHeap.get(3*index+2).compareTo(ternaryHeap.get(min)) < 0) {
					min = 3*index+2;
				}
			}
			// how about a third child?  Compare to whichever of the
			// parent and first child was smaller.
			if (3*index+3 < ternaryHeap.size()) {
				if (ternaryHeap.get(3*index+3).compareTo(ternaryHeap.get(min)) < 0) {
					min = 3*index+3;
				}
			}
		}
		return min;
	}

	/**
	 * Inserts an element into the heap.
	 *
	 * @param toInsert Item to insert
	 */
	public void insert(T toInsert) {
		// put at the end and bubble up!
		ternaryHeap.add(toInsert);
		int location = ternaryHeap.size()-1;
		int parentLoc = (location - 1)/3;
		if (parentLoc < 0) {
			parentLoc = 0;
		}
		// bubble if I am not root and am smaller than my parent.
		while ((location > 0) && 
				(ternaryHeap.get(location).compareTo(ternaryHeap.get(parentLoc)) < 0)) {
			T temp = ternaryHeap.get(location);
			ternaryHeap.set(location, ternaryHeap.get(parentLoc));
			ternaryHeap.set(parentLoc,temp);			
			location = parentLoc;
			swaps++;
			parentLoc = (int) (Math.ceil(location/3) - 1);
			if (parentLoc < 0) {
				parentLoc = 0;
			}
		}
	}

	/**
	 * Is the heap empty?
	 *
	 * @return Whether the heap is empty
	 */
	public boolean isEmpty() {
		return ternaryHeap.isEmpty();
	}

	/**
	 * Number of swaps counted since last reset.
	 *
	 * @return number of swaps.
	 */
	public int numSwaps() {
		return swaps;
	}

	/**
	 * Resets swap counter.
	 */
	public void reset() {
		swaps = 0;
	}
	
	/**
	 * Clear the heap.
	 */
	public void clear() {
		ternaryHeap.clear();
	}

	/**
	 * 
	 * Pretty-prints the heap. All elements are assumed to be three characters wide. 
	 * Elements in the lowest level of the heap are separated by a single space. 
	 * Elements above the lowest level are evenly spaced such that each element appears 
	 * above the middle of its three children
	 *
	 */
	public void printHeap() {
		
		// Number of row
		int row = (int) Math.ceil(Math.log10(2*ternaryHeap.size() + 1)/Math.log10(3));
		int location = 0;
		int preSpaces = 0;
		int rowCount = row - 1;

		for (int i = 0; i < row; i++) {
			
			// Number of maximum elements for current row
			int numElement = (int) Math.pow(3, i);

			// Number of spaces in front of first element of each row
			preSpaces = (int) (2*(Math.pow(3, rowCount) - 1));

			// Add spaces
			for (int y = 0; y <preSpaces; y++) {
				System.out.print(" ");
			}

			rowCount--;

			for (int x = 0; x < numElement; x++) {

				// Print out the element in heap
				System.out.print(ternaryHeap.get(location) + " ");

				// Add spaces between two elements
				for (int y = 0; y < (preSpaces*2); y++) {
					System.out.print(" ");
				}
				
				location++;
				
				// Check if the heap is empty
				if (location >= ternaryHeap.size()) {
					break;
				}

			}
			System.out.print('\n');
			preSpaces = 0;
		}
	}

	/**
	 * A very simple test.
	 *
	 * @param args Command line args (unused)
	 */
	public static void main(String[] args) {
		
		TernaryHeap<Integer> h = new TernaryHeap<Integer>();

		// Add random numbers with 3 digits into the heap
		Random r = new Random();
		for (int i = 0; i < 27; i++) {
			h.insert(r.nextInt(900) + 100);
		}
		
		// Pretty print heap
		h.printHeap();
				
		// Number of swaps
		System.out.println("Number of swaps: " + h.numSwaps());
		
		// Sort heap
		while(!h.isEmpty()) {
			System.out.print(h.removeMin() + " ");
		}
		
		System.out.print('\n');
		
		// Number of swaps after remove
		System.out.println("Number of swaps after remove: " + h.numSwaps());
		
		// Clear the heap
		h.clear();
		
		// Reset swaps counter
		h.reset();
		
		// Test the number of sways for different number of elements
		for (int i = 0; i < 5000; i++) {
			h.insert(r.nextInt(9999));
		}
		
		System.out.println("Number of swaps: " + h.numSwaps());
		
	}

}
