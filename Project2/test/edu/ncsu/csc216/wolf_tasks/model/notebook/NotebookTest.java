package edu.ncsu.csc216.wolf_tasks.model.notebook;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
/**
 * tests notebook class
 * @author edwin
 *
 */
public class NotebookTest {
	/**
	 * tests the constructor for notebook
	 */
	@Test
	public void testConstructor() {
		Notebook nb = new Notebook("notebook 1");
		assertTrue(nb.isChanged());
		assertEquals(nb.getCurrentTaskList().getTaskListName(), "Active Tasks");
		assertEquals(nb.getNotebookName(), "notebook 1");
		Notebook nb2 = null;
		try {
			nb2 = new Notebook("Active Tasks");
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(nb2);
		}
		TaskList tl1 = new TaskList("list 1", 7);
		TaskList tl2 = new TaskList("list 2", 0);
		TaskList tl3 = null;
		nb.addTaskList(tl1);
		nb.addTaskList(tl2);
		assertEquals(nb.getTaskListsNames()[0], "Active Tasks");
		assertEquals(nb.getTaskListsNames()[1], "list 2");
		assertEquals(nb.getTaskListsNames()[2], "list 1");
		
	}

}
