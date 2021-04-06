package edu.ncsu.csc216.wolf_tasks.model.tasks;

public class Task {
	/** holds tasks name */
	private String taskName;
	
	/** holds task description */
	private String taskDescription;
	
	/** holds if task is recurring or not */
	private boolean recurring;
	
	/** holds if task is active or not */
	private boolean active;
	
	public Task(String taskName, String taskDescription, boolean recurring, boolean active) {

	}

	public void completeTask() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * returns the task name
	 * @return task name
	 */
	public String getTaskName() {
		return null;
	}
	
	/**
	 * sets the tasks name
	 */
	public void setTaskName() {
		
	}

	/**
	 * returns the task description
	 * @return task description
	 */
	public String getTaskDescription() {
		return null;
	}
	
	/**
	 * sets tasks description
	 */
	public void setTaskDescription() {
		
	}
	
	/**
	 * checks if task is active 
	 * @return true if active false if not
	 */
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * sets if task is active or not
	 */
	public void setActive() {
		
	}

	/**
	 * checks if task is recurring
	 * @return true if recurring false if not
	 */
	public boolean isRecurring() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * sets if task is recurring or not
	 */
	public void setRecurring() {
		
	}
	
	/**
	 * returns the task lists name
	 * @return task lists name
	 */
	public String getTaskListName() {
		return null;
	}
	/**
	 * adds a task list
	 * @param atl task list to be added
	 */
	public void addTaskList(AbstractTaskList atl) {
		
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	/**
	 * makes task into a string
	 * @return String with task info
	 */
	public String toString() {
		return null;
	}
	
	
}
