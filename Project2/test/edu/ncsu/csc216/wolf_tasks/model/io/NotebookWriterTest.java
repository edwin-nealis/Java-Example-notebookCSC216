package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
/**
 * tests the notebook writer class
 * @author edwin
 *
 */
public class NotebookWriterTest {
	/** holds export file */
	private File export = new File("test-files/export.txt");
	
	/**
	 * tests write notebook file
	 */
	@Test
	public void testWriteNotebookFile() {
		Notebook nb = new Notebook("notebook name");
		TaskList tl1 = new TaskList("list 1", 22);
		TaskList tl2 = new TaskList("list 2", 0);
		Task t1 = new Task("task 1", "description", false, false);
		Task t2 = new Task("task 2", "description", true, true);
		Task t3 = new Task("task 3", "description", false, true);
		nb.addTaskList(tl2);
		nb.addTaskList(tl1);
		tl1.addTask(t1);
		tl1.addTask(t2);
		tl2.addTask(t3);
		try {
			NotebookWriter.writeNotebookFile(export, "notebook name", nb.taskLists);
			checkFiles("test-files/expected.txt", "test-files/export.txt");
		}
		catch (IllegalArgumentException e) {
			fail("unable to wirte to file");
		}
	}
	/**
	 * Helper method to compare two files for the same contents
	 * 
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new FileInputStream(expFile));
				Scanner actScanner = new Scanner(new FileInputStream(actFile));) {

			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}

			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}

}
