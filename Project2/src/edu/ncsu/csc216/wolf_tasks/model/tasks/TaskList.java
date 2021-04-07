package edu.ncsu.csc216.wolf_tasks.model.tasks;
/**
 * Task List extends abstract task list and implements comparable since it
 * implements comparable it contains the compareTo method which compares task lists by name.
 * class also has a method to get task represented by a 2d array of strings and a constructor.
 * the constructor class the super to set task list name and completed tasks.
 * 
 * @author edwin
 *
 */
public class TaskList extends AbstractTaskList implements Comparable<TaskList> {

	/**
	 * constructor for task list calls super to set name and num of completed tasks
	 * @param taskListName task name
	 * @param completedTasks num of completed tasks
	 */
	public TaskList(String taskListName, int completedTasks) {
		super(taskListName, completedTasks);
	}
	
	/**
	 * returns a 2d array representing a task
	 * @return 2d array
	 */
	public String [][] getTasksAsArray() {
		return null;
	}
	
	/**
	 * compares tasks by name
	 * @return 0 if same 1 if larger -1 if smaller
	 */
	public int compareTo(TaskList tl) {
		return 0;
	}

}
