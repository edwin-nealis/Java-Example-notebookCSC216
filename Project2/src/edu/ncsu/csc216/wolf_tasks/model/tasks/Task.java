package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * task is an object with fields task name, task descripition, recurring, and active
 * task has a constructor that sets all fields task also has getters and setters for all fields.
 * there is also a method to complete a task, a method to get the name of the task list the task is in, and 
 * a method that adds task to a task list.
 * task also includes a colne and to string method.
 * @author edwin
 *
 */
public class Task {
	/** holds tasks name */
	private String taskName;
	
	/** holds task description */
	private String taskDescription;
	
	/** holds if task is recurring or not */
	private boolean recurring;
	
	/** holds if task is active or not */
	private boolean active;
	/** list of tasklists*/
	private SwapList<AbstractTaskList> taskLists;
	/**
	 * constructor for task sets all fields 
	 * @param taskName name of task
	 * @param taskDescription description of task
	 * @param recurring if recurring
	 * @param active if active
	 */
	public Task(String taskName, String taskDescription, boolean recurring, boolean active) {
		setTaskName(taskName);
		setTaskDescription(taskDescription);
		setActive(active);
		setRecurring(recurring);
		taskLists = new SwapList<AbstractTaskList>();
	}

	/**
	 * completes a task
	 * @throws CloneNotSupportedException if clone cant not be done
	 */
	public void completeTask()  {
		for (int i = 0; i < taskLists.size(); i++) {
			taskLists.get(i).completeTask(this);
			if (this.isRecurring()) {
					Task t;
					try {
						t = (Task) this.clone();
						taskLists.get(i).addTask(t);
					} catch (CloneNotSupportedException e) {
						throw new IllegalArgumentException();
					}
		}
	}
	}

	/**
	 * returns the task name
	 * @return task name
	 */
	public String getTaskName() {
		return taskName;
	}
	
	/**
	 * sets the tasks name
	 * @param taskName name to be set
	 */
	public void setTaskName(String taskName) {
		if (taskName == null || "".equals(taskName)) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskName = taskName;
	}

	/**
	 * returns the task description
	 * @return task description
	 */
	public String getTaskDescription() {
		return taskDescription;
	}
	
	/**
	 * sets tasks description
	 * @param taskDescription tasks description
	 */
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskDescription = taskDescription;
	}
	
	/**
	 * checks if task is active 
	 * @return true if active false if not
	 */
	public boolean isActive() {
		return this.active;
	}
	
	/**
	 * sets if task is active or not
	 * @param active if task is active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * checks if task is recurring
	 * @return true if recurring false if not
	 */
	public boolean isRecurring() {
		return this.recurring;
	}
	
	/**
	 * sets if task is recurring or not
	 * @param recurring if task is recurring
	 */
	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}
	
	/**
	 * returns the task lists name
	 * @return task lists name
	 */
	public String getTaskListName() {
		try {
			return this.taskLists.get(0).getTaskListName();
		}
		catch (IndexOutOfBoundsException e) {
			return "";
		}
	}
	/**
	 * adds a task list
	 * @param atl task list to be added
	 */
	public void addTaskList(AbstractTaskList atl) {
		if (atl == null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		for (int i = 0; i < taskLists.size(); i++) {
			if (taskLists.get(i).getTaskListName().equals(atl.getTaskListName())) {
				return;
			}
		}
		taskLists.add(atl);
	}
	
	/**
	 * clones object
	 * @throws CloneNotSupportedException if clone can not be done
	 * @return clone of object
	 */
	public Object clone() throws CloneNotSupportedException {
		if (taskLists.size() == 0) {
			throw new CloneNotSupportedException("Cannot clone.");
		}
		SwapList<AbstractTaskList> temp = this.taskLists;
		Task tempT = new Task(this.taskName, this.taskDescription, this.recurring, this.active);
		tempT.taskLists = temp;
		return tempT;
	}
	/**
	 * makes task into a string
	 * @return String with task info
	 */
	public String toString() {
		String s = "";
		String r = "";
		String a = "";
		if (isRecurring()) {
			r = ",recurring";
		}
		if (isActive()) {
			a = ",active";
		}
		s = "* " + getTaskName() + r + a + "\n" + getTaskDescription();
		return s;
	}
	
	
}
