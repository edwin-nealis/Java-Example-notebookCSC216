package edu.ncsu.csc216.wolf_tasks.model.tasks;

public class TaskList extends AbstractTaskList implements Comparable<TaskList>{

	public TaskList(String taskListName, int completedTasks) {
		super(taskListName, completedTasks);
	}
	
	public String [][] getTasksAsArray() {
		return null;
	}
	
	public int compareTo(TaskList tl) {
		return 0;
	}

}
