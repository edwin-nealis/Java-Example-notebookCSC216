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
		assertEquals(t.toString(), "* name,active\ndescription\n");
		assertEquals(t2.toString(), "* name,recurring,active\ndescription\n");
		assertEquals(t3.toString(), "* name\ndescription\n");
		assertEquals(t4.toString(), "* name,recurring\ndescription\n");
	}

}
