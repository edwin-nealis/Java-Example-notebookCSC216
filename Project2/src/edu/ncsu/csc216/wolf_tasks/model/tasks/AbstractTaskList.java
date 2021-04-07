package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
/**
 * abstract task list is an abstract class that represents a task list object 
 * class has one abstract method that get tasks as a 2d array. the class has two fields task list name, and completed
 * task count both are set by the constructor. class also contains getters for both fields an a setter for name.
 * class also has methods to add and remove a task as well as complete a task. There is also a method that 
 * gets tasks as an ISwapList of tasks.
 * @author edwin
 *
 */
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
	/**
	 * gets task as a list of type ISwapList
	 * @return list contaning all tasks
	 */
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

	/**
	 * adds a task to the task list
	 * @param t task to be added
	 */
	public void addTask(Task t) {
		
	}
	
	/**
	 * removes a task from the task list
	 * @param idx index
	 * @return task that was removed
	 */
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
	/**  
	 * gets the tasks as a 2d array of objects
	 * @return 2d array of tasks
	 */
	public abstract String[][] getTasksAsArray();
	

}
