package edu.ncsu.csc216.wolf_tasks.model.util;
/**
 * sorted list creates a sorted linked list that implements IsortedList interface
 * class has methods to add and remove and element as well as methods to check if an element is contained
 * in the list and to get an element specified by an index from the list. There is also a method that returns the lists size.
 * class also has an inner class ListNode.
 * @author edwin
 *
 * @param <E> type for SortedList: must implement Comparable
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {
	/** holds size of list */
	private int size;
	
	private ListNode front;

	/**
	 * adds an element to the list in sorted order
	 * @param element element to be added
	 */
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
	}

	/**
	 * removes an element form the list at the index provided
	 * @param idx index
	 * @return element that was removed
	 */
	@Override
	public E remove(int idx) {
		return null;
	}
	/**
	 * helper method to see if an index is valid
	 * @param idx index
	 */
	private void checkIndex(int idx) {
		
	}

	/**
	 * checks if list contains element given as parameter
	 * @param element element to be check
	 * @return false if element is not in list true if is
	 */
	@Override
	public boolean contains(E element) {
		return false;
	}
	

	/**
	 * gets an element based on the provided index
	 * @param idx index
	 * @return element at given index
	 */
	@Override
	public E get(int idx) {
		return null;
	}

	/**
	 * returns the size of the list
	 * @return the size
	 */
	@Override
	public int size() {
		return 0;
	}
	/**
	 * inner class that creates an object list node that has two fields data and nextnode
	 * 
	 * @author edwin
	 *
	 */
	public class ListNode {
		/** data to be held by List node*/
		public E data;
		/**
		 * constructor of ListNode sets data and the nextNode in list
		 * @param data data
		 * @param nextNode next node
		 */
		public ListNode(E data, ListNode nextNode) {
			
		}
	}
}
