package edu.ncsu.csc216.ticket_manager.model.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Category;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Priority;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.TicketType;
import edu.ncsu.csc216.ticket_manager.model.command.Command;
import edu.ncsu.csc216.ticket_manager.model.ticket.*;

/**
 * This tests the TicketManager class for proper implementation and functionality based on the requirements
 * as well as the API for the TicketManager Class.
 * 
 * @author John Widdifield
 *
 */
public class TicketManagerTest {

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
		TicketManager.getInstance().saveTicketsToFile("test-files/created_file2.txt");
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Tests the loadTicketsFromFile for proper loading of tickets from a file. 
	 */
	@Test
	public void testLoadTicketsFromFile() {
		try {
		TicketManager.getInstance().loadTicketsFromFile("test-files/ticket1.txt");
		} catch (Exception e) {
			fail();
		}
		//*1#New#Incident#GitHub down#sesmith5#Software#Urgent##
		Ticket t = TicketManager.getInstance().getTicketById(1);
		assertEquals(t.getState(), "New");
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "GitHub down");
		assertEquals(t.getCaller(), "sesmith5");
		assertEquals(t.getCategory(), "Software");
		assertEquals(t.getPriority(), "Urgent");
		
	}
	
	/**
	 * Tests the getTicketsForDisplay method for proper retrieval of Tickets for displayment.
	 */
	@Test
	public void testGetTicketsForDisplay() {
		TicketManager.getInstance().createNewTicketList();
		
		TicketManager.getInstance().addTicketToList(TicketType.REQUEST, "subject", "caller", Category.DATABASE, Priority.HIGH, "a note");
		TicketManager.getInstance().addTicketToList(TicketType.INCIDENT, "subject2", "caller2", Category.SOFTWARE, Priority.MEDIUM, "a note");
		TicketManager.getInstance().addTicketToList(TicketType.REQUEST, "subject3", "caller3", Category.HARDWARE, Priority.LOW, "a note");
		
		String[][] array = TicketManager.getInstance().getTicketsForDisplay();
		assertTrue(array[0][0].contentEquals("1"));
		assertTrue(array[0][1].contentEquals("Request"));
		assertTrue(array[0][2].contentEquals("New"));
		assertTrue(array[0][3].contentEquals("subject"));
		assertTrue(array[0][4].contentEquals("Database"));
		assertTrue(array[0][5].contentEquals("High"));
		assertTrue(array[1][0].contentEquals("2"));
		assertTrue(array[1][1].contentEquals("Incident"));
		assertTrue(array[1][2].contentEquals("New"));
		assertTrue(array[1][3].contentEquals("subject2"));
		assertTrue(array[1][4].contentEquals("Software"));
		assertTrue(array[1][5].contentEquals("Medium"));
		assertTrue(array[2][0].contentEquals("3"));
		assertTrue(array[2][1].contentEquals("Request"));
		assertTrue(array[2][2].contentEquals("New"));
		assertTrue(array[2][3].contentEquals("subject3"));
		assertTrue(array[2][4].contentEquals("Hardware"));
		assertTrue(array[2][5].contentEquals("Low"));
		
		try {
			TicketManager.getInstance().getTicketsForDisplayByType(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(array[0][0].contentEquals("1"));
		}
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
	 * Tests the executeCommand method for proper execution of a command.
	 */
	@Test
	public void testExecuteCommand() {
		TicketManager.getInstance().createNewTicketList();
		Command c = new Command(Command.CommandValue.PROCESS, "owner", null, null, null, "a note");
		TicketManager.getInstance().addTicketToList(TicketType.REQUEST, "subject", "caller", Category.DATABASE, Priority.HIGH, "a note");
		TicketManager.getInstance().executeCommand(1, c);
		assertEquals(TicketManager.getInstance().getTicketById(1).getState(), "Working");
	}

	/**
	 * Tests the deleteTicketById method for proper deletion of a ticket by its ID.
	 */
	@Test
	public void testDeleteTicketById() {
		
		TicketManager.getInstance().createNewTicketList();
		
		TicketManager.getInstance().addTicketToList(TicketType.REQUEST, "subject", "caller", Category.DATABASE, Priority.HIGH, "a note");
		TicketManager.getInstance().addTicketToList(TicketType.INCIDENT, "subject2", "caller2", Category.SOFTWARE, Priority.MEDIUM, "a note");
		
		TicketManager.getInstance().deleteTicketById(2);
		
			TicketManager.getInstance().getTicketById(2);
			assertEquals(TicketManager.getInstance().getTicketsForDisplay()[0][0], "1");
	}

}
