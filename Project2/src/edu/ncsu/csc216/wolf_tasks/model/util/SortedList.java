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
	/** keeps track of the first node in list */
	private ListNode front;
	
	public SortedList() {
		front = new ListNode(null, null);
		size =0;
	}

	/**
	 * adds an element to the list in sorted order
	 * @param element element to be added
	 */
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		ListNode check = front;
		for (int i = 0; i < size; i++) {
			if (element.equals(check.data)) {
				throw new IllegalArgumentException("Cannot add duplicate element");
			}
		}
		if (size == 0) {
			front = new ListNode(element, null);
			size++;
			return;
		}
		if (size == 1) {
			if (front.data.compareTo(element) >= 0) {
				front = new ListNode(element, front);
				size++;
				return;
			}
			else {
				if (front.data.equals(element)) {
					throw new IllegalArgumentException("Cannot add duplicate element");
				}
				front.next = new ListNode(element, null);
				size++;
				return;
			}
		}
		ListNode current = front;
		ListNode next = current.next;
		while (next != null) {
			if (current.data.equals(element)) {
				throw new IllegalArgumentException("Cannot add duplicate element");
			}
			next = next.next;
			current = current.next;
		}
		current = front;
		next = current.next;
		while (next != null) {
			if (next.data.compareTo(element) >= 0) {
				current.next = new ListNode(element, next);
				size++;
				return;
			}
			current = current.next;
			next = next.next;
		}
		next = new ListNode(element, null);
		current.next = next;
		size++;
	}

	/**
	 * removes an element form the list at the index provided
	 * @param idx index
	 * @return element that was removed
	 */
	@Override
	public E remove(int idx) {
		checkIndex(idx);
		E rtrn = null;
		if (idx == 0) {
			rtrn = front.data;
			front = front.next;
			size--;
			return rtrn;
		}
		ListNode curr = front;
		for (int i = 0; i < idx - 1; i++) {
			curr = curr.next;
		}
		rtrn = curr.next.data;
		curr.next = curr.next.next;
		size--;
		return rtrn;
	}
	/**
	 * helper method to see if an index is valid
	 * @param idx index
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}

	/**
	 * checks if list contains element given as parameter
	 * @param element element to be check
	 * @return false if element is not in list true if is
	 */
	@Override
	public boolean contains(E element) {
		ListNode curr = front;
		for (int i = 0; i < size; i++) {
			if (curr.data.compareTo(element) == 0) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}
	

	/**
	 * gets an element based on the provided index
	 * @param idx index
	 * @return element at given index
	 */
	@Override
	public E get(int idx) {
		checkIndex(idx);
		ListNode curr = front;
		for (int i = 0; i < idx; i++) {
			curr = curr.next;
		}
		return curr.data;
	}

	/**
	 * returns the size of the list
	 * @return the size
	 */
	@Override
	public int size() {
		return size;
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
		/** next list node */
		public ListNode next;
		/**
		 * constructor of ListNode sets data and the nextNode in list
		 * @param data data
		 * @param nextNode next node
		 */
		public ListNode(E data, ListNode nextNode) {
			this.data = data;
			next = nextNode;
		}
	}
}
