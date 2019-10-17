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
		try {
		String validTestFile = "test-files/ticket2.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
		String validTestFile = "test-files/ticket1.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
		String validTestFile = "test-files/ticket3.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		
	}

}
