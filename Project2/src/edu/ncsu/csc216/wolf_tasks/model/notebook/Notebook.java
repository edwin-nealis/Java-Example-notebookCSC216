package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.io.NotebookWriter;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

/**
 * class for the NoteBook object it has a constructor
 * with one parameter note book name it has a setter and getter for that param.
 * class also contains a method to save a notebook to a file to check if the 
 * note book has been changed and to set the isChanged field. There are also methods
 * for adding a task list getting the names of all task lists removing a task list and 
 * editing a task list name. there are also methods to add a task and edit a task
 * as well as methods to set and get the current task list.
 * @author edwin
 *
 */
public class Notebook {
	/** note book name */
	private String notebookName;
	/** boolean for if notebook is changed */
	private boolean isChanged;
	/** holds current task list */
	private AbstractTaskList currentTaskList;
	/** holds task lists */
	public SortedList<TaskList> taskLists;
	/** holds active task list */
	private ActiveTaskList activeTaskList;
	/**
	 * constructor for notebook sets the name and 
	 * taskList is constructed as a sorted list and
	 * active task list is constructed and set to current taskl list
	 * is changed is initialized to true. 
	 * @param notebookName notebook name
	 */
	public Notebook(String notebookName) {
		setNotebookName(notebookName);
		taskLists = new SortedList<TaskList>();
		activeTaskList = new ActiveTaskList();
		currentTaskList = activeTaskList;
		setChanged(true);
	}
	/**
	 * saves the notebook to a file
	 * @param notebookFile file to be saved to
	 */
	public void saveNotebook(File notebookFile) {
		NotebookWriter.writeNotebookFile(notebookFile, notebookName, taskLists);
		setChanged(false);
	}
	
	/**
	 * gets notebook name
	 * @return notebook name
	 */
	public String getNotebookName() {
		return notebookName;
	}
	/**
	 * sets the notebooks name
	 * @param notebookName note book name
	 * @throws IllegalArgumentException if notebook name is null empty or equal to active tasks name
	 */
	private void setNotebookName(String notebookName) {
		if (notebookName == null || "".equals(notebookName) || notebookName.equals(ActiveTaskList.ACTIVE_TASKS_NAME)) {
			throw new IllegalArgumentException();
		}
		this.notebookName = notebookName;
	}
	/**
	 * checks if notebook is changed
	 * @return true if changed false if not
	 */
	public boolean isChanged() {
		return isChanged;
	}
	
	/**
	 * sets if not book is changed
	 */
	public void setChanged(boolean changed) {
		isChanged = changed;
	}
	/**
	 * adds a tasklist
	 * @param taskList task list to be added
	 */
	public void addTaskList(TaskList taskList) {
		if (taskList.getTaskListName().equals(ActiveTaskList.ACTIVE_TASKS_NAME)) {
			throw new IllegalArgumentException();
		}
		taskLists.add(taskList);
		getActiveTaskList();
	}
	
	/**
	 * gets task lists names as a string array
	 * @return task lists names as string array
	 */
	public String[] getTaskListsNames() {
		String[] array = new String[taskLists.size() + 1];
		array[0] = activeTaskList.getTaskListName();
		for (int i = 1; i <= taskLists.size(); i++) {
			array[i] = taskLists.get(i - 1).getTaskListName();
		}
		return array;
	}
	/**
	 * creates an active task list with all active tasks in the notebook
	 */
	private void getActiveTaskList() {
		activeTaskList.clearTasks();
		for (int i = 0; i < taskLists.size(); i++) {
			for (int j = 0; j < taskLists.get(i).getTasks().size(); j++) {
				if (taskLists.get(i).getTask(j).isActive()) {
					activeTaskList.addTask(taskLists.get(i).getTask(j));
				}
			}
		}
	}
	/**
	 * sets the curret task list
	 * @param taskListName name of task list
	 */
	public void setCurrentTaskList(String taskListName) {
		for (int i = 0; i < taskLists.size(); i++) {
			if (taskLists.get(i).getTaskListName().equals(taskListName)) {
				currentTaskList = taskLists.get(i);
				return;
			}
		}
		currentTaskList = activeTaskList;
	}
	/**
	 * gets the current task list
	 * @return task list
	 */
	public AbstractTaskList getCurrentTaskList() {
		return currentTaskList;
	}
	/**
	 * edits the task list name
	 * @param taskListName task list name
	 */
	public void editTaskList(String taskListName) {
		if (currentTaskList.getTaskListName().equals(ActiveTaskList.ACTIVE_TASKS_NAME) || taskListName.equalsIgnoreCase("Active Tasks")) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < taskLists.size(); i++) {
			if (taskLists.get(i).getTaskListName().equalsIgnoreCase(taskListName)) {
				throw new IllegalArgumentException();
			}
		}
		TaskList temp = (TaskList) currentTaskList;
		for (int i = 0; i < taskLists.size(); i++) {
			if (taskLists.get(i).getTaskListName().equals(currentTaskList.getTaskListName())) {
				taskLists.remove(i);
			}
		}
		temp.setTaskListName(taskListName);
		taskLists.add(temp);
		this.setCurrentTaskList(taskListName);
	}
	/**
	 * removes the current task list
	 */
	public void removeTaskList() {
		if (currentTaskList.getTaskListName().equals(activeTaskList.getTaskListName())) {
			throw new IllegalArgumentException("The Active Tasks list may not be deleted.");
		}
		for (int i = 0; i < taskLists.size(); i++) {
			if (taskLists.get(i).getTaskListName().equals(currentTaskList.getTaskListName())) {
				taskLists.remove(i);
			}
		}
		setChanged(true);
		getActiveTaskList();
	}
	/**
	 * adds a task to current task list
	 * @param t task to be added
	 */
	public void addTask(Task t) {
		if (currentTaskList.getClass().equals(TaskList.class)) {
			currentTaskList.addTask(t);
			if (t.isActive()) {
				getActiveTaskList();
			}
			setChanged(true);
		}
	}
	/**
	 * edits a task at index
	 * @param idx index
	 * @param taskName name of task
	 * @param taskDescription description of task
	 * @param recurring if task is recurring
	 * @param active if task is active
	 */
	public void editTask(int idx, String taskName, String taskDescription, boolean recurring, boolean active) {
		if (currentTaskList.getClass().equals(TaskList.class)) {
			currentTaskList.getTask(idx).setActive(active);
			currentTaskList.getTask(idx).setRecurring(recurring);
			currentTaskList.getTask(idx).setTaskName(taskName);
			currentTaskList.getTask(idx).setTaskDescription(taskDescription);
			if (active) {
				getActiveTaskList();
			}
			setChanged(true);
		}
	}
}
