package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * test swap list class
 * @author edwin
 *
 */
public class SwapListTest {

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
		list.add("10");
		assertEquals(list.size(), 11);
		for (int i =0; i < 10; i++) {
			assertEquals(list.get(i), String.valueOf(i));
		}
		assertEquals(list.remove(5), "5");
	}

}
