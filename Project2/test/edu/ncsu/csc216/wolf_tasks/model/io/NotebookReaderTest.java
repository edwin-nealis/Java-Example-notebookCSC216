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
	/** valid tests file patch */
	private File file = new File("test-file/notebook1.txt");
	/** holds array of taskLists names in array form*/
	String[] taskLists = new String[] { "CSC 216", "CSC 226", "Habits" };

	@Test
	public void testReadNoteBookFile() {
		Notebook nb = NotebookReader.readNodebookFile(file);
		assertEquals(nb.getNotebookName(), "School");
		assertEquals(nb.getTaskListsNames()[0],taskLists[0]);
		assertEquals(nb.getTaskListsNames()[1],taskLists[1]);
		assertEquals(nb.getTaskListsNames()[2],taskLists[2]);
		nb.getCurrentTaskList().getTasksAsArray();
	}

}
