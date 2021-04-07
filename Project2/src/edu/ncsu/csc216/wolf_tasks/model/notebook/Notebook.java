package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

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
	/**
	 * constructor for notebook sets the name and 
	 * taskList is constructed as a sorted list and
	 * active task list is constructed and set to current taskl list
	 * is changed is initialized to true. 
	 * @param notebookName notebook name
	 */
	public Notebook(String notebookName) {
		
	}
	/**
	 * saves the notebook to a file
	 * @param notebookFile file to be saved to
	 */
	public void saveNotebook(File notebookFile) {
		
	}
	
	/**
	 * gets notebook name
	 * @return notebook name
	 */
	public String getNotebookName() {
		return null;
	}
	/**
	 * sets the notebooks name
	 * @param notebookName note book name
	 */
	private void setNotebookName(String notebookName) {
		
	}
	/**
	 * checks if notebook is changed
	 * @return true if changed false if not
	 */
	public boolean isChanged() {
		return false;
	}
	
	/**
	 * sets if not book is changed
	 */
	public void setChanged() {
		
	}
	/**
	 * adds a tasklist
	 * @param taskList task list to be added
	 */
	public void addTaskList(TaskList taskList) {
		
	}
	
	/**
	 * gets task lists names as a string array
	 * @return task lists names as string array
	 */
	public String[] getTaskListsNames() {
		return null;
	}
	/**
	 * returns the active task list
	 * @return task list active task list
	 */
	private TaskList getActiveTaskList() {
		return null;
	}
	/**
	 * sets the current task list
	 * @param taskListName name of task list
	 */
	public void setCurrentTaskList(String taskListName) {
		
	}
	/**
	 * gets the current task list
	 * @return task list
	 */
	public AbstractTaskList getCurrentTaskList() {
		return null;
	}
	/**
	 * edits the task list name
	 * @param taskListName task list name
	 */
	public void editTaskList(String taskListName) {
		
	}
	/**
	 * removes the current task list
	 */
	public void removeTaskList() {
		
	}
	/**
	 * adds a task to current task list
	 * @param t task to be added
	 */
	public void addTask(Task t) {
		
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
		
	}
}
