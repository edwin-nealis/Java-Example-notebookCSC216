package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * tests the abstract task list class
 * @author edwin
 *
 */
public class AbstractTaskListTest {

	/**
	 * test by removing and adding task as well as completing task
	 */
	@Test
	public void testAbstractTaskList() {
		AbstractTaskList tl = new TaskList("list 1", 0);
		Task t = new Task("name", "description", false, true);
		Task t2 = new Task("name 2", "description", false, true);
		tl.addTask(t);
		assertEquals(t.getTaskName(), tl.getTask(0).getTaskName());
		assertEquals(t.getTaskDescription(), tl.getTask(0).getTaskDescription());
		assertEquals(t.isActive(), tl.getTask(0).isActive());
		assertEquals(t.isRecurring(), tl.getTask(0).isRecurring());
		tl.completeTask(t);
		assertEquals(tl.getCompletedCount(), 1);
		assertEquals(tl.getTasks().size(), 0);
		tl.addTask(t);
		tl.addTask(t2);
		tl.removeTask(1);
		assertEquals(t.getTaskName(), tl.getTask(0).getTaskName());
		assertEquals(t.getTaskDescription(), tl.getTask(0).getTaskDescription());
		assertEquals(t.isActive(), tl.getTask(0).isActive());
		assertEquals(t.isRecurring(), tl.getTask(0).isRecurring());
		assertEquals(tl.getTasks().size(), 1);
		//test invalid construction
		TaskList tl2 = null;
		try {
			tl2 = new TaskList(null, 0);
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(tl2);
		}
		try {
			tl2 = new TaskList("valid name", -9);
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(tl2);
		}
	}

}
