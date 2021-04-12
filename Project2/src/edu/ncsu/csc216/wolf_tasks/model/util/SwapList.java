package edu.ncsu.csc216.wolf_tasks.model.util;
/**
 * Swap list extends implements ISwapList. swapList sets up an array list with fields list and size.
 * it has a constructor that creates an array for list and sets size to 0. There is a method to get size
 * as well as methods to add and remove from the list. There are also methods for moving up, down, to front, and to back
 * of the list as well as a method that gets a list element at a given index.
 * @author edwin
 *
 * @param <E> type for SwapList: must implement Comparable
 */
public class SwapList<E> implements ISwapList<E> {
	/** initial capacity */
	private static final int INITIAL_CAPACITY = 10;
	/** holds list */
	private E[] list;
	/**holds size of list */
	private int size;
	
	/** stores the capacity */
	private int capacity = 10;
	/**
	 * constructor for list creates an array for the list and sets size to 0.
	 */
	@SuppressWarnings("unchecked")
	public SwapList() {
		list = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}
	/**
	 * Adds an element to the list
	 * @param element element to be added
	 */
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		checkCapacity(capacity);
		list[size] = element;
		size++;
	}

	/**
	 * helper method that checks if a capacity is valid
	 * @param capacity capacity to be checked
	 */
	@SuppressWarnings("unchecked")
	private void checkCapacity(int capacity) {
		if (size == capacity) {
			E[] temp = list;
			list = (E[]) new Object[capacity * 2];
			this.capacity = capacity * 2;
			for (int i = 0; i < size; i++) {
				list[i] = temp[i];
			}
		}
	}
	/**
	 * removes an element from the list at given index
	 * @param idx index
	 * @return element removed
	 */
	@Override
	public E remove(int idx) {
		checkIndex(idx);
		return list[idx];
	}
	
	/**
	 * helper method that checks if an index is valid
	 * @param idx index
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid Index.");
		}
	}

	/**
	 * moves element at specified index up one in list
	 * @param idx index
	 */
	@Override
	public void moveUp(int idx) {
		checkIndex(idx);
	}

	/**
	 * moves element at specified index down one in list
	 * @param idx index
	 */
	@Override
	public void moveDown(int idx) {
		checkIndex(idx);
	}

	/**
	 * moves element at specified index to front of list
	 * @param idx index
	 */
	@Override
	public void moveToFront(int idx) {
		checkIndex(idx);
	}

	/**
	 * moves element at specified index to back of list 
	 * @param idx index
	 */
	@Override
	public void moveToBack(int idx) {
		checkIndex(idx);
	}

	/**
	 * gets element at specified index
	 * @param idx index
	 * @return element at index
	 */
	@Override
	public E get(int idx) {
		checkIndex(idx);
		return list[idx];
	}

	/**
	 * returns size
	 * @return size as int
	 */
	@Override
	public int size() {
		return size;
	}

}
