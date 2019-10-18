package edu.ncsu.csc216.ticket_manager.model.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Category;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Priority;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.TicketType;

/**
 * This tests the TicketManager class for proper implementation and functionality based on the requirements
 * as well as the API for the TicketManager Class.
 * 
 * @author John Widdifield
 *
 */
public class TicketManagerTest {
	/**
	 * Tests the getInstance method for properly retrieving the instance.
	 */
	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the saveTicketsToFile method for proper saving of tickets to a file.
	 */
	@Test
	public void testSaveTicketsToFile() {
		TicketManager.getInstance().createNewTicketList();
		TicketManager.getInstance().addTicketToList(TicketType.REQUEST, "subject", "caller", Category.DATABASE, Priority.HIGH, "a note");
		TicketManager.getInstance().addTicketToList(TicketType.INCIDENT, "subject2", "caller2", Category.SOFTWARE, Priority.MEDIUM, "a note");
		TicketManager.getInstance().addTicketToList(TicketType.REQUEST, "subject3", "caller3", Category.HARDWARE, Priority.LOW, "a note");
		try {
		TicketManager.getInstance().saveTicketsToFile("test-files/created_file.txt");
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Tests the loadTicketsFromFile for proper loading of tickets from a file. 
	 */
	@Test
	public void testLoadTicketsFromFile() {
		fail("Not yet implemented");
	}
	
	/**
	 * Tests the getTicketsForDisplay method for proper retrieval of Tickets for displayment.
	 */
	@Test
	public void testGetTicketsForDisplay() {
		fail("Not yet implemented");
	}
	/**
	 * Tests the getTicketsForDisplayByType method for proper retrieval of 
	 * multiple tickets for displayment by type.
	 */
	@Test
	public void testGetTicketsForDisplayByType() {
		TicketManager.getInstance().createNewTicketList();
		
		TicketManager.getInstance().addTicketToList(TicketType.REQUEST, "subject", "caller", Category.DATABASE, Priority.HIGH, "a note");
		TicketManager.getInstance().addTicketToList(TicketType.INCIDENT, "subject2", "caller2", Category.SOFTWARE, Priority.MEDIUM, "a note");
		TicketManager.getInstance().addTicketToList(TicketType.REQUEST, "subject3", "caller3", Category.HARDWARE, Priority.LOW, "a note");
		
		String[][] array = TicketManager.getInstance().getTicketsForDisplayByType(TicketType.REQUEST);
		assertTrue(array[0][0].contentEquals("1"));
		assertTrue(array[0][1].contentEquals("Request"));
		assertTrue(array[0][2].contentEquals("New"));
		assertTrue(array[0][3].contentEquals("subject"));
		assertTrue(array[0][4].contentEquals("Database"));
		assertTrue(array[0][5].contentEquals("High"));
		assertTrue(array[1][0].contentEquals("3"));
		assertTrue(array[1][1].contentEquals("Request"));
		assertTrue(array[1][2].contentEquals("New"));
		assertTrue(array[1][3].contentEquals("subject3"));
		assertTrue(array[1][4].contentEquals("Hardware"));
		assertTrue(array[1][5].contentEquals("Low"));
	}

	/**
	 * Tests the getTicketById method for retrieving a ticket by its ID.
	 */
	@Test
	public void testGetTicketById() {
		fail("Not yet implemented");
	}

	/** 
	 * Tests the executeCommand method for proper execution of a command.
	 */
	@Test
	public void testExecuteCommand() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the deleteTicketById method for proper deletion of a ticket by its ID.
	 */
	@Test
	public void testDeleteTicketById() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the addTicketToList method for proper addition of a ticket to a list.
	 */
	@Test
	public void testAddTicketToList() {
		fail("Not yet implemented");
	}

}
