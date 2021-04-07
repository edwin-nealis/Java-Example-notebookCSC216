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
public class SwapList<E extends Comparable<E>> implements ISwapList<E> {
	/** initial capacity */
	private static final int INITIAL_CAPACIRY = 10;
	/** holds list */
	private E[] list;
	/**holds size of list */
	private int size;
	/**
	 * constructor for list creats an array for the list and sets size to 0.
	 */
	SwapList() {
		
	}
	/**
	 * addes an element to the list
	 * @param element element to be added
	 */
	@Override
	public void add(E element) {
		
	}

	/**
	 * helper method that checks if a capacity is valid
	 * @param capacity capacity to be checked
	 */
	private void checkCapacity(int capacity) {
		
	}
	/**
	 * removes an element from the list at given index
	 * @param idx index
	 * @return element removed
	 */
	@Override
	public E remove(int idx) {
		return null;
	}
	
	/**
	 * helper method that checks if an index is valid
	 * @param idx index
	 */
	private void checkIndex(int idx) {
		
	}

	/**
	 * moves element at specified index up one in list
	 * @param idx index
	 */
	@Override
	public void moveUp(int idx) {
		
	}

	/**
	 * moves element at specified index down one in list
	 * @param idx index
	 */
	@Override
	public void moveDown(int idx) {
		
	}

	/**
	 * moves element at specified index to front of list
	 * @param idx index
	 */
	@Override
	public void moveToFront(int idx) {
		
	}

	/**
	 * moves element at specified index to back of list 
	 * @param idx index
	 */
	@Override
	public void moveToBack(int idx) {
		
	}

	/**
	 * gets element at specified index
	 * @param idx index
	 * @return element at index
	 */
	@Override
	public E get(int idx) {
		return null;
	}

	/**
	 * returns size
	 * @return size as int
	 */
	@Override
	public int size() {
		return 0;
	}

}
