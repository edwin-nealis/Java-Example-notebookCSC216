package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * class contains a method and two helper methods that take a file and return a
 * notebook as described in the file. class also has a constructor which does
 * nothing.
 * 
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
	 * specified by the file uses two helper methods in the creation of the
	 * notebook.
	 * 
	 * @param file file to be processed
	 * @return notebook that is outlined in file
	 */
	public static Notebook readNodebookFile(File file) {
		String notebookName;
		String inputString = "";
		String taskListToken = "";
		Scanner input;
		Notebook nb = null;
		try {
			input = new Scanner(file);
			while (input.hasNext()) {
				inputString += input.nextLine() + "\n";
			}
			input.close();
			if (!inputString.substring(0, 1).equals("!")) {
				throw new IllegalArgumentException("Unable to load file.");
			}
			Scanner taskList = new Scanner(inputString);
			taskList.useDelimiter("\\r?\\n?[#]");
			notebookName = taskList.next();
			notebookName = notebookName.substring(1);
			notebookName = notebookName.trim();
			nb = new Notebook(notebookName);

			while (taskList.hasNext()) {
				try {
					taskListToken = taskList.next();
					TaskList tl = processTaskList(taskListToken);
					nb.addTaskList(tl);
				} catch (IllegalArgumentException e) {
					// blank on propose
				}
			}
			taskList.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		nb.setCurrentTaskList(ActiveTaskList.ACTIVE_TASKS_NAME);
		return nb;
	}

	/**
	 * helper method that processes a string containing a task list
	 * 
	 * @param s string to be processed
	 * @return TaskList created from string
	 * @throws IllegalArgumentException if string can not be processed
	 */
	private static TaskList processTaskList(String s) {
		String task;
		String taskListName;
		int completedCount;
		Scanner in = new Scanner(s);
		in.useDelimiter("\\r?\\n?[*]");
		String temp = in.next();
		Scanner taskList = new Scanner(temp);
		taskList.useDelimiter(",");
		try {
		taskListName = taskList.next();
		taskListName = taskListName.substring(1);
		taskListName = taskListName.trim();
		completedCount = taskList.nextInt();
		taskList.close();
	}
		catch (NoSuchElementException e) {
			in.close();
			throw new IllegalArgumentException();
		}
		TaskList tl = new TaskList(taskListName, completedCount);
			while (in.hasNext()) {
				try {
					task = in.next();
				task = task.trim();
				Task t = processTask(tl, task);
				tl.addTask(t);
		} catch (IllegalArgumentException e) {
			// blank on purpose
		}
			}
			in.close();
			return tl;
	}

	/**
	 * helper method that processes a string to get a task
	 * 
	 * @param ats list to add task too
	 * @param s   string to be processed
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
				taskDescription = s.substring(firstLine.length());
			Scanner task = new Scanner(firstLine);
			task.useDelimiter(",");
			while (task.hasNext()) {
				String temp = task.next();
				if ("recurring".equals(temp)) {
					recurring = true;
				} else if ("active".equals(temp)) {
					active = true;
				} else
					taskName = temp;
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
		return task;
	}

}
