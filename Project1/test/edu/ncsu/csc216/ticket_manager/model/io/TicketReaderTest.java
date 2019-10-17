package edu.ncsu.csc216.ticket_manager.model.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket;

/**
 * This class tests the TicketReader class for correct method implementation.
 * 
 * @author John Widdifield
 *
 */
public class TicketReaderTest {

	/**
	 * Tests the ticketReadFile method for correct reading from a file.
	 * @throws FileNotFoundException if the file cannot be found
	 */
	@Test
	public void testReadTicketFile() throws FileNotFoundException {
		/** Valid ticket records */
		String validTestFile = "test-files/ticket1.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		Ticket t1 = tickets.get(0);
		assertEquals(t1.getTicketId(), 1);
		assertEquals(t1.getState(), "New");
		assertEquals(t1.getTicketTypeString(), "Incident");
		assertEquals(t1.getSubject(), "Github down");
		assertEquals(t1.getCaller(), "sesmith5");
		assertEquals(t1.getCategory(), "Software");
		assertEquals(t1.getPriority(), "Urgent");
		assertEquals(t1.getNotes(), "-GitHub is not responding when I navigate to github.ncsu.edu");
	}

}
