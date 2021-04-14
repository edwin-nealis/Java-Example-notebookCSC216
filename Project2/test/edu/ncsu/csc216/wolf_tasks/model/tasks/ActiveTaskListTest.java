package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * tests active task list class
 * @author edwin
 *
 */
public class ActiveTaskListTest {

	/**
	 * tests get task as array method
	 */
	@Test
	public void testGetTasksAsArray() {
		ActiveTaskList tl1 = new ActiveTaskList();
		Task t = new Task("task 1", "description", false, true);
		Task t2 = new Task("task 2", "description", false, true);
		Task t3 = new Task("task 3", "description", false, true);
		tl1.addTask(t3);
		tl1.addTask(t2);
		tl1.addTask(t);
		String[][] array = new String[][] { { "Active Tasks", "task 3" }, { "Active Tasks", "task 2" }, { "Active Tasks", "task 1" } };
		assertEquals(tl1.getTasksAsArray()[0][0], array[0][0]);
		assertEquals(tl1.getTasksAsArray()[0][1], array[0][1]);
		assertEquals(tl1.getTasksAsArray()[1][0], array[1][0]);
		assertEquals(tl1.getTasksAsArray()[1][1], array[1][1]);
		assertEquals(tl1.getTasksAsArray()[2][0], array[2][0]);
		assertEquals(tl1.getTasksAsArray()[2][1], array[2][1]);
	}
	/**
	 * tests the clearTasks method
	 */
	@Test
	public void testClearTasks() {
		ActiveTaskList tl1 = new ActiveTaskList();
		Task t = new Task("task 1", "description", false, true);
		Task t2 = new Task("task 2", "description", false, true);
		Task t3 = new Task("task 3", "description", false, true);
		tl1.addTask(t3);
		tl1.addTask(t2);
		tl1.addTask(t);
		tl1.clearTasks();
		assertEquals(tl1.getTasks().size(), 0);
	}

}
