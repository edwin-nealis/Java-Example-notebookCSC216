package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * tests swap list class
 * @author edwin
 *
 */
public class SwapListTest {

	/**
	 * tests swap list
	 */
	@Test
	public void testAddAndRemove() {
		SwapList<String> list = new SwapList<String>();
		list.add("a");
		assertEquals(list.size(), 1);
		
		
		
	}

}
