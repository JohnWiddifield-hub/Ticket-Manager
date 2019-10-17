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
	public void testReadTicketFile() {
		/** Valid ticket records */
		String validTestFile = "test-files/ticket2.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		Ticket t1 = tickets.get(0);
		assertEquals(t1.getTicketId(), 3);
		assertEquals(t1.getState(), "Closed");
		assertEquals(t1.getTicketTypeString(), "Request");
		assertEquals(t1.getSubject(), "Subject line");
		assertEquals(t1.getCaller(), "caller");
		assertEquals(t1.getCategory(), "Inquiry");
		assertEquals(t1.getPriority(), "Medium");
		assertEquals(t1.getResolutionCode(), "Not Completed");
	}

}
