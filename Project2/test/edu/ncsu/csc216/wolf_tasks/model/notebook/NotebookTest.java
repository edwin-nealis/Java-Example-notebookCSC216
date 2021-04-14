package edu.ncsu.csc216.wolf_tasks.model.notebook;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
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
	public void testAddTasksAndTaskListAndRemoveTaskLists() {
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
		TaskList tl3 = new TaskList("list 3", 14);
		TaskList tl4 = new TaskList("list 4", 90);
		TaskList tl5 = new TaskList("list 5", 23);
		TaskList tl6 = new TaskList("list 6", 2);
		nb.addTaskList(tl1); // tests add task list
		nb.addTaskList(tl2);
		nb.addTaskList(tl3);
		nb.addTaskList(tl4);
		nb.addTaskList(tl5);
		nb.addTaskList(tl6);
		assertEquals(nb.getTaskListsNames()[0], "Active Tasks");
		assertEquals(nb.getTaskListsNames()[1], "list 1");
		assertEquals(nb.getTaskListsNames()[2], "list 2");
		assertEquals(nb.getTaskListsNames()[3], "list 3");
		assertEquals(nb.getTaskListsNames()[4], "list 4");
		assertEquals(nb.getTaskListsNames()[5], "list 5");
		assertEquals(nb.getTaskListsNames()[6], "list 6");
		nb.setCurrentTaskList("list 6");//tests remove task list and set current task
		nb.removeTaskList();
		nb.setCurrentTaskList("list 1");
		nb.removeTaskList();
		nb.setCurrentTaskList("not a list");
		assertEquals(nb.getCurrentTaskList().getTaskListName(), "Active Tasks");
		nb.setCurrentTaskList("list 3");
		nb.removeTaskList();
		assertEquals(nb.getTaskListsNames()[0], "Active Tasks");
		assertEquals(nb.getTaskListsNames()[1], "list 2");
		assertEquals(nb.getTaskListsNames()[2], "list 4");
		assertEquals(nb.getTaskListsNames()[3], "list 5");
		Task t1 = new Task("task 1", "descrption", false, true);
		Task t2 = new Task("task 2", "descrption", false, true);
		Task t3 = new Task("task 3", "descrption", true, true);
		Task t4 = new Task("task 4", "descrption", false, true);
		Task t5 = new Task("task 5", "descrption", true, false);
		Task t6 = new Task("task 6", "descrption", false, true);
		nb.setCurrentTaskList("list 2"); //tests add task 
		nb.addTask(t1);
		nb.addTask(t2);
		nb.addTask(t3);
		nb.addTask(t4);
		nb.addTask(t5);
		nb.addTask(t6);
		String[][] array = new String[][] { { "list 2", "task 1" }, { "list 2", "task 2" }, { "list 2", "task 3" }, { "list 2", "task 4" }, {"list 2", "task 5" }, { "list 2", "task 6" } };
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][0], array[0][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][1], array[0][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][0], array[1][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][1], array[1][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[2][0], array[2][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[2][1], array[2][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[3][0], array[3][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[3][1], array[3][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[4][0], array[4][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[4][1], array[4][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[5][0], array[5][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[5][1], array[5][1]);
		nb.setCurrentTaskList("Active Tasks"); //test get active tasks
		String[][] array2 = new String[][] { { "Active Tasks", "task 1" }, { "Active Tasks", "task 2" }, { "Active Tasks", "task 3" }, { "Active Tasks", "task 4" }, { "Active Tasks", "task 6" } };
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][0], array2[0][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][1], array2[0][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][0], array2[1][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][1], array2[1][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[2][0], array2[2][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[2][1], array2[2][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[3][0], array2[3][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[3][1], array2[3][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[4][0], array2[4][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[4][1], array2[4][1]);
		
		
		
	}
	/**
	 * tests the editTask and editTaskList methods 
	 */
	@Test
	public void testEditTaskList() {
		Notebook nb = new Notebook("notebook 1");
		TaskList tl1 = new TaskList("list 1", 7);
		TaskList tl2 = new TaskList("list 2", 0);
		TaskList tl3 = new TaskList("list 3", 14);
		nb.addTaskList(tl1);
		nb.addTaskList(tl2);
		nb.addTaskList(tl3);
		nb.setCurrentTaskList("list 2");
		nb.editTaskList("list 0");
		assertEquals(nb.getCurrentTaskList().getTaskListName(), "list 0");
		assertEquals(nb.getTaskListsNames()[0], "Active Tasks");
		assertEquals(nb.getTaskListsNames()[1], "list 0");
		assertEquals(nb.getTaskListsNames()[2], "list 1");
		assertEquals(nb.getTaskListsNames()[3], "list 3");
	}
	/**
	 * tests the edit task method
	 */
	@Test
	public void testEditTask() {
		Notebook nb = new Notebook("notebook 1");
		TaskList tl1 = new TaskList("list 1", 7);
		TaskList tl2 = new TaskList("list 2", 0);
		TaskList tl3 = new TaskList("list 3", 14);
		nb.addTaskList(tl1);
		nb.addTaskList(tl2);
		nb.addTaskList(tl3);
		Task t1 = new Task("task 1", "descrption", false, true);
		Task t2 = new Task("task 2", "descrption", false, true);
		Task t3 = new Task("task 3", "descrption", true, true);
		nb.setCurrentTaskList("list 2");
		nb.addTask(t1);
		nb.addTask(t2);
		nb.addTask(t3);
		String[][] array = new String[][] { { "list 2", "task 1" }, { "list 2", "task 2" }, { "list 2", "task 3" } };
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][0], array[0][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][1], array[0][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][0], array[1][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][1], array[1][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[2][0], array[2][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[2][1], array[2][1]);
		nb.editTask(1, "new task 2", " new decription", true, false);
		String[][] array2 = new String[][] { { "list 2", "task 1" }, { "list 2", "new task 2" }, { "list 2", "task 3" } };
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][0], array2[0][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][1], array2[0][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][0], array2[1][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][1], array2[1][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[2][0], array2[2][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[2][1], array2[2][1]);
		
	}
}
