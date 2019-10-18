package edu.ncsu.csc216.ticket_manager.model.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Category;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Priority;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.TicketType;
/**
 * This class tests the TicketList class for proper implementation and functionality
 * based on the requirements as well as TicketList's API
 * 
 * @author John Widdifield
 *
 */
public class TicketListTest {

	/**
	 * Tests the ticketList Constructor for proper construction of a list able to
	 * contain tickets.
	 */
	@Test
	public void testTicketList() {
		TicketList list = new TicketList();
		
		list.getTickets();
		
	}

	/**
	 * Tests the addTicket method for proper adding of tickets to the list.
	 */
	@Test
	public void testAddTicket() {
		TicketList list = new TicketList();
		
		list.addTicket(TicketType.INCIDENT, "subject", "caller", Category.NETWORK, Priority.HIGH, "note");
		list.addTicket(TicketType.INCIDENT, "subject", "caller", Category.HARDWARE, Priority.LOW, "note");
		
		assertTrue(list.getTicketById(2).getCategory().contentEquals("Hardware"));
		
		
	}

	/**
	 * Tests the addTickets() method for proper adding of multiple tickets at a time
	 * to the list.
	 */
	@Test
	public void testAddTickets() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getTickets method for proper returning of tickets.
	 */
	@Test
	public void testGetTickets() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getTicketsByType method for proper returning of tickets
	 * based on their type
	 */
	@Test
	public void testGetTicketsByType() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getTicketById method for proper returning of tickets
	 * by their ID.
	 */
	@Test
	public void testGetTicketById() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the executeCommand method for proper execution of commands.
	 */
	@Test
	public void testExecuteCommand() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the deleteTicketById for proper deletion/removal of a ticket from the
	 * list based on their ID.
	 */
	@Test
	public void testDeleteTicketById() {
		fail("Not yet implemented");
	}

}
