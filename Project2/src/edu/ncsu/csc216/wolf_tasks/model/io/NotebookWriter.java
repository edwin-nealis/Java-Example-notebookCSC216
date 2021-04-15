package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

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
	 * writes notebook to the provided file
	 * @param f file 
	 * @param notebookName notebook name
	 * @param sortedList list of TaskLists
	 */
	public static void writeNotebookFile(File f, String notebookName, ISortedList<TaskList> sortedList) {
		PrintStream fileWriter;
		try {
			fileWriter = new PrintStream(f);
			fileWriter.println("! " + notebookName);
			for (int i = 0; i < sortedList.size(); i++) {
				fileWriter.println("# " + sortedList.get(i).getTaskListName() + "," + String.valueOf(sortedList.get(i).getCompletedCount()));
				for (int j = 0; j < sortedList.get(i).getTasks().size(); j++) {
					fileWriter.print(sortedList.get(i).getTask(j).toString());
				}
			}
			fileWriter.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}
}
