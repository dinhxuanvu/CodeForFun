/**
 * MagicBag.java
 * 
 * File:
 * 		$Id: MagicBag.java,v 1.1 2013/11/05 20:05:24 vxd9797 Exp $
 * 
 * Revisions:
 * 		$Log: MagicBag.java,v $
 * 		Revision 1.1  2013/11/05 20:05:24  vxd9797
 * 		Final version. Commented.
 *
 * 
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Implementation of Magic Bag which could do magic with added items.
 * 
 * @author vxd9797
 */

public class MagicBag<E> implements Collection<E> {
	
	// The List contains the items in MagicBag
	List<E> magicList = new LinkedList<E>();
	
	/**
	 * MagicBag constructor.
	 */
	public MagicBag() {
		
	}

	/**
	 * Adds the given item to the bag.
	 * @param E item - Item to be added
	 * @return true if the item is added successfully
	 */
	@Override
	public boolean add(E item) {
		
		for (E e : magicList) {
			if (e.equals(item)) {
				magicList.remove(e);
				return false;
			}
		}
		magicList.add(item);
		return true;
	}

	/**
	 *  Adds all the given items into the bag, one at a time.
	 * @param Collection c - Items to be added
	 * @return true if the items are added successfully
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		
		boolean check = false;
		int count = 0;
		E e;
		
		// List of items
		List<E> list = new LinkedList<E>();
		
		// List of duplicates
		List<E> duplicates = new LinkedList<E>();

		list.addAll(c);
		
		// Find duplicates and add to the dupicate List
		for (int i = 0; i < list.size(); i++) {
			e = list.remove(0);
			if (list.contains(e)) {
				duplicates.add(e);
				count++;
			}
		}
		
		// TreeSet to eliminate the duplicates (keep one copy)
		Set<E> s = new TreeSet<E>();
		s.addAll(c);
		
		// Remove the duplicates out of the list
		for (E idup : duplicates) {
			s.remove(idup);
		}

		// Check if there are duplicates in MagicBag from duplicate List
		for (E item : duplicates) {
			for (E magic : magicList) {
				if (magic.equals(item)) {
					magicList.remove(magic);
					count++;
					break;
				}
			}
		}
		
		// Check if there are duplicates in MagicBag from item List
		for (E ileft : s) {
			for (E magic : magicList) {
				if (magic.equals(ileft)) {
					magicList.remove(magic);
					count++;
					check = true;
					break;
				}	
			}
			if (check == false) {
				magicList.add(ileft);
			}
			check = false;
		}
		
		if (count == 0) {
			return true;
		}
		else
			return false;
	}


	/**
	 *  The magic bag is more than happy to make its contents vanish.
	 *  Remove everything out of the magic bag.
	 */
	@Override
	public void clear() {
		magicList.clear();
	}

	/**
	 *  The magic bag does not easily reveal its secrets.
	 *  Return false always.
	 */
	@Override
	public boolean contains(Object o) {
		return false;
	}

	/**
	 *  The magic bag does not easily reveal its secrets.
	 *  Return false always.
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}
	
	/**
	 *  As far as we can tell, all MagicBags are equivalent to one another, regardless of contents.
	 *  Return true always.
	 */
	public boolean equals(Object o) {
		return true;
		
	}

	/**
	 * Whether the bag is empty.
	 * @return true if the bag is empty
	 */
	@Override
	public boolean isEmpty() {
		if (magicList.isEmpty() == true) {
			return true;
		}
		else
			return false;
	}

	/**
	 * Makes and returns a fresh iterator for this magic bag.
	 * @return iterator
	 */
	@Override
	public Iterator<E> iterator() {
		Iterator<E> in = magicList.iterator();
		return in;
	}
	
	/**
	 * Randomizes (shuffles) the contents of the bag and gives you one back.
	 * @return A random item from the bag
	 */
	public E pull() {
		Random random = new Random();
		int i = random.nextInt(magicList.size());
		return magicList.remove(i);
	}

	/**
	 *  The magic bag does not let you remove items like that.
	 * @exception UnsupportedOperationException - for all cases
	 */
	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException("Invalid operation.");
	}

	/**
	 *  The magic bag does not let you remove items like that.
	 * @exception UnsupportedOperationException - for all cases
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("Invalid operation.");
	}

	/**
	 *  The magic bag does not let you retain items like that.
	 * @exception UnsupportedOperationException - for all cases
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("Invalid operation.");
	}

	/**
	 * How many items in magic bag
	 * @return  number of items in bag
	 */
	@Override
	public int size() {
		return magicList.size();
	}

	/**
	 * Won't allow this operation
	 * @return null - always
	 */
	@Override
	public Object[] toArray() {
		return null;
	}

	/**
	 * Won't allow this operation
	 * @return null - always
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}
	
	/**
	 *  An iterator over MagicBags. 
	 *  Doesn't behave nicely, but rather continually gives random items 
	 *  from the bag forever (as long as the bag is not empty).
	 */
	protected class BagIterator implements Iterator<E> {

		E e;
		
		/**
		 * Since the iterator will run forever, this is true unless its bag is empty.
		 * @return true if the bag is not empty
		 */
		@Override
		public boolean hasNext() {
			if (magicList.isEmpty() != true) {
				return true;
			}
			else
				return false;
		}

		/**
		 * The next (randomly-chosen) item from the bag.
		 * @return the next item in the bag
		 */
		@Override
		public E next() {
			Random random = new Random();
			int i = random.nextInt(magicList.size());
			e = magicList.get(i);
			return e;
		}

		/**
		 *  Actually removes the item most recently returned from next().
		 */
		@Override
		public void remove() {
			magicList.remove(e);
		}
		
	}

}
