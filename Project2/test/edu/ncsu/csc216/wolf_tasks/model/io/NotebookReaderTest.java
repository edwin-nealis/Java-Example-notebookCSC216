package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
/**
 * tests the notebookReader class
 * @author edwin
 *
 */
public class NotebookReaderTest {
	/** valid tests file full */
	private File file1 = new File("test-files/notebook1.txt");
	/** holds a test file with a notebook with just a name */
	private File file2 = new File("test-files/notebook0.txt");
	/** valid test file items missing */
	private File file3 = new File("test-files/notebook2.txt");
	/** invalid test file missing ! */
	private File file4 = new File("test-files/notebook3.txt");
	/** valid test file missing completed task info */
	private File file5 = new File("test-files/notebook4.txt");
	/** valid test file missing task list names */
	private File file6 = new File("test-files/notebook5.txt");
	/** valid test file negative completed tasks */
	private File file7 = new File("test-files/notebook6.txt");
	/** valid test file missing task name */
	private File file8 = new File("test-files/notebook7.txt");
	/** holds array of taskLists names in array form*/
	String[] taskLists = new String[] { "CSC 216", "CSC 226", "Habits" };
	/** holds expected task values for CSCS 216*/
	String[][] array = new String[][] { { "CSC 216", "Read Project 2 requirements"}, 
		{ "CSC 216", "Create CRC Cards to UMLetino" }, { "CSC 216", "Transfer CRC Cards to UMLetino" },
		{ "CSC 216", "Download design proposal and rational template" }, { "CSC 216", "Write design proposal and rationale" },
		{ "CSC 216", "Identify 5 system tests" }, { "CSC 216", "Watch lecture video" },
		{ "CSC 216", "Complete exercises" }, { "CSC 216", "Complete quizzes" } };
	/** holds the expected task values for CSC 226 */ 
	String [][] array2 = new String[][] { { "CSC 226", "Homework 7" }, { "CSC 226", "Homework 8" }, { "CSC 226", "Homework 9" }, 
		{ "CSC 226", "Homework 10" }, { "CSC 226", "Watch lectures" } }; 
	/** holds the expected task values for Habits */
	String[][] array3 = new String[][] { { "Habits", "Excercise" }, { "Habits", "Floss" } };
		

	/** 
	 * tests the note book reader from file
	 */
	@Test
	public void testReadNoteBookFileValid() {
		Notebook nb = NotebookReader.readNodebookFile(file1);
		Notebook nb2 = NotebookReader.readNodebookFile(file2);
		Notebook nb3 = NotebookReader.readNodebookFile(file3);
		Notebook nb4 = NotebookReader.readNodebookFile(file5);
		Notebook nb5 = NotebookReader.readNodebookFile(file6);
		Notebook nb6 = NotebookReader.readNodebookFile(file7);
		Notebook nb7 = NotebookReader.readNodebookFile(file8);
		assertEquals(nb2.getNotebookName(), "Summer Plans");
		assertEquals(nb2.getTaskListsNames().length, 1);
		assertEquals(nb3.getNotebookName(), "School");
		assertEquals(nb3.getTaskListsNames().length, 4);
		nb3.setCurrentTaskList("CSC 216");
		assertEquals(nb3.getCurrentTaskList().getTasks().size(), 0);
		assertEquals(nb3.getTaskListsNames().length, 4);
		nb3.setCurrentTaskList("CSC 226");
		assertEquals(nb3.getCurrentTaskList().getTasks().size(), 5);
		assertEquals(nb4.getNotebookName(), "Personal");
		assertEquals(nb4.getTaskListsNames().length, 1);
		assertEquals(nb5.getNotebookName(), "Personal");
		assertEquals(nb5.getTaskListsNames().length, 1);
		assertEquals(nb6.getNotebookName(), "Personal");
		assertEquals(nb6.getTaskListsNames().length, 1);
		
		assertEquals(nb7.getNotebookName(), "Personal");
		assertEquals(nb7.getTaskListsNames()[1], "Habits");
		nb7.setCurrentTaskList("Habits");
		assertEquals(nb7.getCurrentTaskList().getCompletedCount(), 3);
		assertEquals(nb7.getCurrentTaskList().getTasksAsArray()[0][0], "Habits");
		assertEquals(nb7.getCurrentTaskList().getTasksAsArray()[0][1], "Floss");
		assertEquals(nb7.getCurrentTaskList().getTasks().size(), 1);

		nb.setCurrentTaskList("CSC 16");
		assertEquals(nb.getNotebookName(), "School");
		assertEquals(nb.getTaskListsNames()[1], taskLists[0]);
		assertEquals(nb.getTaskListsNames()[2], taskLists[1]);
		assertEquals(nb.getTaskListsNames()[3], taskLists[2]);
		assertEquals(nb.getCurrentTaskList().getTasks().size(), 9);
		assertEquals(nb.getCurrentTaskList().getCompletedCount(), 35);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][0], array[0][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][1], array[0][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][0], array[1][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][1], array[1][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[2][0], array[2][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[2][1], array[2][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[3][0], array[3][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[3][1], array[3][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[4][0], array[4][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[4][1], array[4][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[5][0], array[5][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[5][1], array[5][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[6][0], array[6][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[6][1], array[6][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[7][0], array[7][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[7][1], array[7][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[8][0], array[8][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[8][1], array[8][1]);
		nb.setCurrentTaskList("CSC 226");
		assertEquals(nb.getCurrentTaskList().getTasks().size(), 6);
		assertEquals(nb.getCurrentTaskList().getCompletedCount(), 23);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][0], array2[0][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][1], array2[0][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][0], array2[1][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][1], array2[1][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[2][0], array2[2][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[2][1], array2[2][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[3][0], array2[3][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[3][1], array2[3][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[4][0], array2[4][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[4][1], array2[4][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[5][0], array2[5][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[5][1], array2[5][1]);
		nb.setCurrentTaskList("Habits");
		assertEquals(nb.getCurrentTaskList().getTasks().size(), 2);
		assertEquals(nb.getCurrentTaskList().getCompletedCount(), 0);
		assertEquals(nb.getCurrentTaskList().getCompletedCount(), 35);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][0], array3[0][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[0][1], array3[0][1]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][0], array3[1][0]);
		assertEquals(nb.getCurrentTaskList().getTasksAsArray()[1][1], array3[1][1]);
		
	}
	/**
	 * tests read from file with invalid file
	 */
	@Test
	public void testInvalidFiles() {
		Notebook nb = null;
		try {
			nb = NotebookReader.readNodebookFile(file4);
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(nb);
		}
	}

}
