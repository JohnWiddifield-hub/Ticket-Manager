package edu.ncsu.csc216.ticket_manager.model.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket;
/**
 * This class tests the TicketWriter class for proper functionality and implementation
 * based on the requirements.
 * 
 * @author John Widdifield
 *
 */
public class TicketWriterTest {

	/**
	 * This method tests the writeTicketFile for proper writing of tickets to a file.
	 * @throws IOException if file cannot be written to
	 */
	@Test
	public void testWriteTicketFile() throws IOException {
		@SuppressWarnings("unused")
		TicketWriter writer = new TicketWriter();
		ArrayList<String> note = new ArrayList<String>();
		note.add("a note");
		note.add("a second note");
		
		Ticket t = new Ticket(1, "New", "Request", "Me want new computer", "jfwiddif", "Hardware", 
				"High", "bbaggins", null, note);
		Ticket t2 = new Ticket(2, "New", "Request", "Me want new computer", "jfwiddif", "Inquiry", 
				"Urgent", "", "", note);
		Ticket t3 = new Ticket(3, "New", "Incident", "Me want new computer", "jfwiddif", "Software", 
				"Urgent", "", "", note);
		Ticket t4 = new Ticket(4, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Workaround", note);
		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets.add(t);
		tickets.add(t2);
		tickets.add(t3);
		tickets.add(t4);
		
		TicketWriter.writeTicketFile("test-files/created_file.txt", tickets);
		checkFiles("test-files/created_file.txt", "test-files/expected_file.txt");
		
		try {
			TicketWriter.writeTicketFile(null, tickets);
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to save file.");
		}
		
		
		
	}
	
	private void checkFiles(String expFile, String actFile) {
		try {
			Scanner expScanner = new Scanner(new File (expFile));
			Scanner actScanner = new Scanner(new File(actFile));
			
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
