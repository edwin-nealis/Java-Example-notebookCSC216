package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * tests the sorted list class
 * @author edwin
 *
 */
public class SortedListTest {

	/**
	 * tests add and remove methods
	 */
	@Test
	public void testAddAndRemove() {
		SortedList <String> list = new SortedList<String>();
		list.add("a");
		list.add("d");
		list.add("c");
		list.add("b");
		assertEquals(list.get(0), "a");
		assertEquals(list.get(1), "b");
		assertEquals(list.get(2), "c");
		assertEquals(list.get(3), "d");
		assertEquals(list.size(), 4);
		list = new SortedList<String>();
		list.add("d");
		list.add("a");
		list.add("c");
		list.add("b");
		assertEquals(list.size(), 4);
		assertEquals(list.get(0), "a");
		assertEquals(list.get(1), "b");
		assertEquals(list.get(2), "c");
		assertEquals(list.get(3), "d");
		try {
			list.add("a");
			fail();
		}
		catch (IllegalArgumentException e) {
			assertEquals(list.size(), 4);
			assertEquals(list.get(0), "a");
			assertEquals(list.get(1), "b");
			assertEquals(list.get(2), "c");
			assertEquals(list.get(3), "d");
		}
		list.remove(0);
		assertEquals(list.size(), 3);
		assertEquals(list.get(0), "b");
		assertEquals(list.get(1), "c");
		assertEquals(list.get(2), "d");
		list.remove(1);
		assertEquals(list.size(), 2);
		assertEquals(list.get(0), "b");
		assertEquals(list.get(1), "d");
		list.remove(1);
		assertEquals(list.size(), 1);
		assertEquals(list.get(0), "b");
		try {
			list.remove(5);
			fail();
		}
		catch (IndexOutOfBoundsException e) {
			assertEquals(list.size(), 1);
			assertEquals(list.get(0), "b");
		}
		try {
			list.add(null);
			fail();
		}
		catch (NullPointerException e) {
			assertEquals(list.size(), 1);
			assertEquals(list.get(0), "b");
		}
		list.add("a");
		list.add("e");
		list.add("c");
		assertEquals(list.size(), 4);
		assertEquals(list.get(0), "a");
		assertEquals(list.get(1), "b");
		assertEquals(list.get(2), "c");
		assertEquals(list.get(3), "e");
		list.remove(2);
		list.add("c");
		list.add("d");
		list.add("f");
		list.remove(4);
		assertEquals(list.size(), 5);
		assertEquals(list.get(0), "a");
		assertEquals(list.get(1), "b");
		assertEquals(list.get(2), "c");
		assertEquals(list.get(3), "d");
		assertEquals(list.get(4), "f");
		
	}
	/**
	 * tests the contains method 
	 */
	@Test
	public void testContains() {
		SortedList <String> list = new SortedList<String>();
		list.add("a");
		list.add("d");
		list.add("c");
		list.add("b");
		assertEquals(list.get(0), "a");
		assertEquals(list.get(1), "b");
		assertEquals(list.get(2), "c");
		assertEquals(list.get(3), "d");
		assertEquals(list.size(), 4);
		assertTrue(list.contains("a"));
		assertFalse(list.contains("e"));
	}

}
