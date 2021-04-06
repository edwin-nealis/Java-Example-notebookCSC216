package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

public abstract class AbstractTaskList {
	/** name of task list */
	private String taskListName;
	
	/** number of completed tasks */
	private int completedCount;
	/**
	 * constructor for task list set the name and the completed count
	 * @param taskListName task list name
	 * @param completedCount number of completed tasks
	 */
	public AbstractTaskList(String taskListName, int completedCount) {
		
	}
	/**
	 * returns the task list name
	 * @return task list name
	 */
	public String getTaskListName() {
		return null;
	}
	
	/**
	 * sets the task list name
	 */
	public void setTaskListName() {
		
	}
	
	public ISwapList<Task> getTasks() {
		return null;
	}
	
	/**
	 * returns the completed count
	 * @return completed count
	 */
	public int getCompletedCount() {
		return 0;
	}

	public void addTask(Task t) {
		
	}
	
	public Task removeTask(int idx) {
		return null;
	}
	/**
	 * returns the task at index provided
	 * @param idx index
	 * @return task at given index
	 */
	public Task getTask(int idx) {
		return null;
	}
	/**
	 * completes the task
	 * @param t task to be completed
	 */
	public void completeTask(Task t) {
		
	}
	/** gets the tasks as a 2d array of objects */
	public abstract Object[][] getTasksAsArray();
	

}
