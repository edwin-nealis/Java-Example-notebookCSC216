package edu.ncsu.csc216.wolf_tasks.model.tasks;


/**
 * active task list is a object that creates an active task list to hold active task
 * class has a constructor and methods to add a task clear tasks and set the task list name. class also has 
 * a method that returns the task as a 2d array of strings.
 * @author edwin
 *
 */
public class ActiveTaskList extends AbstractTaskList {
	/** name of active task list */
	public static final String ACTIVE_TASKS_NAME = "Active Tasks";

	
	
	/**
	 * constructor for active task list sets name of task list to active task list as well as
	 * creates said list.
	 */
	public ActiveTaskList() {
		super(ACTIVE_TASKS_NAME, 0);
	}
	
	/**
	 * adds task to the list
	 * @param t task to be added
	 */
	public void addTask(Task t) {
		if (!t.isActive()) {
			throw new IllegalArgumentException("Cannot add task to Active Tasks.");
		}
		super.addTask(t);
	}
	/**
	 * sets the task lists name
	 * @param taskListName task lists name
	 */
	public void setTaskListName(String taskListName) {
		if (taskListName != "Active Tasks") {
			throw new IllegalArgumentException("The Active Tasks list may not be edited.");
		}
		super.setTaskListName(taskListName);
	}
	/**
	 * gets the tasks as a 2d array of strings
	 * @return 2d array of strings containing tasks
	 */
	public String[][] getTasksAsArray() {
		String[][] array = new String[super.getTasks().size()][2];
		for (int i = 0; i < super.getTasks().size(); i++) {
			for (int j = 0 ; j < 2; j++) {
				if (j == 0) {
					array[i][j] = "Active Tasks";
				}
				if (j == 1) {
					array[i][j] = super.getTask(i).getTaskName();
				}
			}
		}
		return array;
	}
	/**
	 * clears all tasks
	 */
	public void clearTasks() {
		new ActiveTaskList();
	}


}
