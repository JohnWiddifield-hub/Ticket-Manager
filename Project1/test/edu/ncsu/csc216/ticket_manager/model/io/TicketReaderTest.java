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
		ArrayList<Ticket> tickets = null;
		try {
		String validTestFile = "test-files/ticket2.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		tickets = null;
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
		String validTestFile = "test-files/ticket1.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		tickets = null;
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
		String validTestFile = "test-files/ticket3.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket4.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket5.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket6.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket7.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket8.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket9.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket10.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket11.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket12.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket13.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket14.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket15.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket16.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket17.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket18.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket19.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
		
		try {
		String validTestFile = "test-files/ticket20.txt";
		tickets = TicketReader.readTicketFile(validTestFile);
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
			assertTrue(tickets == null);
		}
	}

}
