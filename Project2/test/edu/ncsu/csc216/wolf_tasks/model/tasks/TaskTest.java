package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;


import org.junit.Test;
/**
 * tests the task class
 * @author edwin
 *
 */
public class TaskTest {

	/**
	 * tests the add task list method
	 */
	@Test
	public void testAddTaskList() {
		Task t = new Task("name", "description", false, true);
		TaskList tl = new TaskList("list 1", 0);
		TaskList tl2 = new TaskList("list 2", 0);
		t.addTaskList(tl);
		assertEquals(t.getTaskListName(), "list 1");
		t.addTaskList(tl2);
		assertEquals(t.getTaskListName(), "list 1");
		try {
			t.addTaskList(null);
			fail();
		}
		catch (IllegalArgumentException e) {
			assertEquals(t.getTaskListName(), "list 1");
			assertEquals(e.getMessage(), "Incomplete task information.");
		}
		
	}
	/**
	 * tests the clone method
	 */
	@Test
	public void testCone() {
		Task t = new Task("name", "description", false, true);
		TaskList tl = new TaskList("list 1", 0);
		Task tClone = null;
		try {
			tClone = (Task) t.clone();
			fail();
		}
		catch (CloneNotSupportedException e) {
			assertNull(tClone);
		}
		t.addTaskList(tl);
		try {
			tClone = (Task) t.clone();
			assertEquals(tClone.getTaskName(), "name");
			assertEquals(tClone.getTaskDescription(), "description");
			assertTrue(tClone.isActive());
			assertFalse(tClone.isRecurring());
			assertEquals(tClone.getTaskListName(), "list 1");
		} catch (CloneNotSupportedException e) {
			fail();
		}
	}
	
	/**
	 * tests the toString method
	 */
	@Test
	public void testToString() {
		Task t = new Task("name", "description", false, true);
		Task t2 = new Task("name", "description", true, true);
		Task t3 = new Task("name", "description", false, false);
		Task t4 = new Task("name", "description", true, false);
		assertEquals(t.toString(), "* name,active\ndescription");
		assertEquals(t2.toString(), "* name,recurring,active\ndescription");
		assertEquals(t3.toString(), "* name\ndescription");
		assertEquals(t4.toString(), "* name,recurring\ndescription");
	}
	
	/**
	 * tests the complete task method
	 */
	@Test
	public void testCompleteTask() {
		Task t = new Task("name", "description", false, true);
		Task t2 = new Task("name", "description", true, true);
		TaskList tl = new TaskList("list 1", 0);
		TaskList tl2 = new TaskList("list 2", 0);
		tl.addTask(t);
		tl2.addTask(t2);
		try {
			t.completeTask();
			assertEquals(tl.getCompletedCount(), 1);
			assertEquals(tl.getTasks().size(), 0);
		} catch (IllegalArgumentException e) {
			fail();
		}
		try {
			t2.completeTask();
			assertEquals(tl2.getCompletedCount(), 1);
			assertEquals(tl2.getTasks().size(), 1);
			String[][] array = new String[][] { {"1", "name"} };
			assertEquals(tl2.getTasksAsArray()[0][0], array[0][0]);
			assertEquals(tl2.getTasksAsArray()[0][1], array[0][1]);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
	}
	/**
	 * tests invalid construction
	 */
	@Test
	public void testInvalidConstruction() {
		Task t = null;
		try {
			t = new Task("valid", null, false, false);
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(t);
		}
		try {
			t = new Task("", "valid", false, false);
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(t);
		}
	}

}
