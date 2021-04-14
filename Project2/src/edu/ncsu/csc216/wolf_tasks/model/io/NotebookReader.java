package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
/**
 * class contains a method and two helper methods that take a file and return a notebook as described in the file.
 * class also has a constructor which does nothing.
 * @author edwin 
 *
 */
public class NotebookReader {
	/**
	 * constructor for Notebook reader
	 */
	public NotebookReader() {
		// left blank on purpose
	}
	
	/**
	 * method takes a file as input and returns a notebook with tasklist and task
	 * specified by the file uses two helper methods in the creation of the notebook. 
	 * @param file file to be processed
	 * @return notebook that is outlined in file
	 */
	public static Notebook readNodebookFile(File file) {
		return null;
	}
	/**
	 * helper method that processes a string containing a task list
	 * @param s string to be processed
	 * @return TaskList created from string
	 */
	private static TaskList processTaskList(String s) {
		return null;
	}
	
	/**
	 * helper method that processes a string to get a task
	 * @param ats list to add task too
	 * @param s string to be processed
	 * @return Task created from string
	 */
	private static Task processTask(AbstractTaskList ats, String s) {
		String firstLine;
		String taskName = null;
		String taskDescription = null;
		boolean active = false;
		boolean recurring = false;
		Scanner in = new Scanner(s);
		try {
			firstLine = in.nextLine();
			while (in.hasNext()) {
				taskDescription = in.nextLine();
			}
			Scanner task = new Scanner(firstLine);
			task.useDelimiter(",");
			while (task.hasNext()) {
				String temp = task.next();
				if (temp.equals("recurring")) {
					recurring = true;
				}
				else if (temp.equals("active")) {
					active = true;
				}
				else taskName = temp;
			}
			task.close();
			
		} catch (InputMismatchException e) {
		in.close();
		throw new IllegalArgumentException();
		} catch (NoSuchElementException e) {
		in.close();
		throw new IllegalArgumentException();
	}
		Task task = new Task(taskName, taskDescription, recurring, active);
		task.addTaskList(ats);
		in.close();
		return null;
	}

}
