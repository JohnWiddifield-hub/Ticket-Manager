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
		@SuppressWarnings("unused")
		TicketReader reader = new TicketReader();
		try {
		String validTestFile = "test-files/ticket2.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
		String validTestFile = "test-files/ticket1.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getCaller(), "sesmith5");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
		String validTestFile = "test-files/ticket3.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket4.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket5.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket6.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket7.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket8.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket9.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket10.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket11.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket12.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket13.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket14.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket15.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket16.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket17.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket18.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket19.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		try {
		String validTestFile = "test-files/ticket20.txt";
		ArrayList<Ticket> tickets = TicketReader.readTicketFile(validTestFile);
		assertEquals(tickets.get(0).getOwner(), "owner");
		fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Unable to load file.");
		}
		
		
	}

}
