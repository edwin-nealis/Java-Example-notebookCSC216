package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;
/**
 * notebook writer writes notebook to a provided file. Has a constructor that does nothings
 * and one method to do the write. 
 * @author edwin
 *
 */
public class NotebookWriter {
	/**
	 * constructor for notebook writer
	 */
	public NotebookWriter() {
		//left black on purpose
	}
	/**
	 * writes notebook to the povided file
	 * @param f file 
	 * @param s notebook name
	 * @param sortedList list of TaskLists
	 */
	public static void writeNotebookFile(File f, String s, ISortedList<TaskList> sortedList) {
		
	}
}
