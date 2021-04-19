package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * tests the TaskList class
 * @author edwin
 *
 */
public class TaskListTest {

	/**
	 * tests the compareTo method 
	 */
	@Test
	public void testCompareTo() {
		TaskList tl1 = new TaskList("a", 0);
		TaskList tl2 = new TaskList("b", 0);
		TaskList tl3 = new TaskList("a", 0);
		assertEquals(tl1.compareTo(tl3), 0);
		assertTrue(tl1.compareTo(tl2) < 0);
		assertTrue(tl2.compareTo(tl3) > 0);
		
	}
	/**
	 * tests get tasks as array method
	 */
	@Test
	public void testGetTasksAsArray() {
		TaskList tl1 = new TaskList("a", 0);
		Task t = new Task("task 1", "description", false, false);
		Task t2 = new Task("task 2", "description", false, false);
		Task t3 = new Task("task 3", "description", false, false);
		tl1.addTask(t3);
		tl1.addTask(t2);
		tl1.addTask(t);
		String[][] array = new String[][] { { "1", "task 3" }, { "2", "task 2" }, { "3", "task 1" } };
		assertEquals(tl1.getTasksAsArray()[0][0], array[0][0]);
		assertEquals(tl1.getTasksAsArray()[0][1], array[0][1]);
		assertEquals(tl1.getTasksAsArray()[1][0], array[1][0]);
		assertEquals(tl1.getTasksAsArray()[1][1], array[1][1]);
		assertEquals(tl1.getTasksAsArray()[2][0], array[2][0]);
		assertEquals(tl1.getTasksAsArray()[2][1], array[2][1]);
	}

}
