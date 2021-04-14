package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * test swap list class
 * @author edwin
 *
 */
public class SwapListTest {

	/**
	 * tests add and remove function of swap list
	 */
	@Test
	public void testAddAndRemove() {
		SwapList<String> list = new SwapList<String>();
		try {
			list.add(null);
			fail();
		}
		catch (NullPointerException e) {
			assertEquals(list.size(), 0);
		}
		list.add("0");
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		assertEquals(list.size(), 10);
		list.add("10"); //checks increase capacity
		assertEquals(list.size(), 11);
		for (int i = 0; i < 11; i++) {
			assertEquals(list.get(i), String.valueOf(i));
		}
		assertEquals(list.remove(0), "0");
		assertEquals(list.remove(4), "5");
		assertEquals(list.remove(8), "10");
		assertEquals(list.size(), 8);
		assertEquals(list.get(0), "1");
		assertEquals(list.get(1), "2");
		assertEquals(list.get(2), "3");
		assertEquals(list.get(3), "4");
		assertEquals(list.get(4), "6");
		assertEquals(list.get(5), "7");
		assertEquals(list.get(6), "8");
		assertEquals(list.get(7), "9");
	}
	/**
	 * tests move up, down, to front, and to back
	 */
	@Test
	public void testMoveMethods() {
		SwapList<String> list = new SwapList<String>();
		list.add("0");
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		assertEquals(list.size(), 10);
		list.moveDown(0);
		assertEquals(list.get(0), "1");
		assertEquals(list.get(1), "0");
		list.moveUp(1);
		assertEquals(list.get(0), "0");
		assertEquals(list.get(1), "1");
		list.moveToBack(0);
		assertEquals(list.get(0), "1");
		assertEquals(list.get(1), "2");
		assertEquals(list.get(2), "3");
		assertEquals(list.get(3), "4");
		assertEquals(list.get(4), "5");
		assertEquals(list.get(5), "6");
		assertEquals(list.get(6), "7");
		assertEquals(list.get(7), "8");
		assertEquals(list.get(8), "9");
		assertEquals(list.get(9), "0");
		list.moveToFront(9);
		assertEquals(list.get(0), "0");
		assertEquals(list.get(1), "1");
		assertEquals(list.get(2), "2");
		assertEquals(list.get(3), "3");
		assertEquals(list.get(4), "4");
		assertEquals(list.get(5), "5");
		assertEquals(list.get(6), "6");
		assertEquals(list.get(7), "7");
		assertEquals(list.get(8), "8");
		assertEquals(list.get(9), "9");
		list.moveToFront(0);
		assertEquals(list.get(0), "0");
		assertEquals(list.get(1), "1");
		assertEquals(list.get(2), "2");
		assertEquals(list.get(3), "3");
		assertEquals(list.get(4), "4");
		assertEquals(list.get(5), "5");
		assertEquals(list.get(6), "6");
		assertEquals(list.get(7), "7");
		assertEquals(list.get(8), "8");
		assertEquals(list.get(9), "9");
		list.moveToBack(9);
		assertEquals(list.get(0), "0");
		assertEquals(list.get(1), "1");
		assertEquals(list.get(2), "2");
		assertEquals(list.get(3), "3");
		assertEquals(list.get(4), "4");
		assertEquals(list.get(5), "5");
		assertEquals(list.get(6), "6");
		assertEquals(list.get(7), "7");
		assertEquals(list.get(8), "8");
		assertEquals(list.get(9), "9");
		try {
			list.moveDown(12);
			fail();
		}
		catch (IndexOutOfBoundsException e) {
			assertEquals(list.get(0), "0");
			assertEquals(list.get(1), "1");
			assertEquals(list.get(2), "2");
			assertEquals(list.get(3), "3");
			assertEquals(list.get(4), "4");
			assertEquals(list.get(5), "5");
			assertEquals(list.get(6), "6");
			assertEquals(list.get(7), "7");
			assertEquals(list.get(8), "8");
			assertEquals(list.get(9), "9");
		}
		
	}

}
