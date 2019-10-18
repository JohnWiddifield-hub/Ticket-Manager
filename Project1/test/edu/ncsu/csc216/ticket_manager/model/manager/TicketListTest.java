package edu.ncsu.csc216.ticket_manager.model.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.ncsu.csc216.ticket_manager.model.command.Command;
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
	TicketList list = new TicketList();

	/**
	 * Tests the ticketList Constructor for proper construction of a list able to
	 * contain tickets.
	 */
	@Test
	public void testTicketList() {
		list = new TicketList();
		TicketList list2 = new TicketList();
		assertEquals(list.getTickets(), list2.getTickets());
		list.getTickets();
		
	}

	/**
	 * Tests the addTicket method for proper adding of tickets to the list.
	 */
	@Test
	public void testAddTicket() {
		
		list.addTicket(TicketType.INCIDENT, "subject", "caller", Category.NETWORK, Priority.HIGH, "note");
		list.addTicket(TicketType.INCIDENT, "subject", "caller", Category.HARDWARE, Priority.LOW, "note");
		
		assertTrue(list.getTicketById(2).getCategory().contentEquals("Hardware"));
		assertTrue(list.getTicketById(1).getCategory().contentEquals("Network"));
		
		assertEquals(list.addTicket(TicketType.INCIDENT, null, "ID10T", Category.INQUIRY, Priority.URGENT, "oh no!"), -1);
		
	}

	/**
	 * Tests the addTickets() method for proper adding of multiple tickets at a time
	 * to the list.
	 */
	@Test
	public void testAddTickets() {
		ArrayList<Ticket> newlist = new ArrayList<Ticket>();
		newlist.add(new Ticket(TicketType.INCIDENT, "subject", "caller", Category.SOFTWARE, Priority.LOW, "note"));
		newlist.add(new Ticket(TicketType.INCIDENT, "subject", "caller", Category.DATABASE, Priority.HIGH, "note"));
		
		list.addTickets(newlist);
		
		assertTrue(list.getTicketById(1).getCategory().equals("Software"));
		assertTrue(list.getTicketById(2).getCategory().equals("Database"));
		
		newlist.clear();
		list.addTickets(newlist);
		assertTrue(list.getTickets().isEmpty());
		
	}

	/**
	 * Tests the getTicketsByType method for proper returning of tickets
	 * based on their type
	 */
	@Test
	public void testGetTicketsByType() {
		try {
			list.getTicketsByType(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(list.getTickets().isEmpty());
		}
		list.addTicket(TicketType.INCIDENT, "subject", "caller", Category.NETWORK, Priority.HIGH, "note");
		list.addTicket(TicketType.REQUEST, "subject", "caller", Category.DATABASE, Priority.HIGH, "note");
		
		ArrayList<Ticket> incidents = new ArrayList<Ticket>();
		incidents = list.getTicketsByType(TicketType.INCIDENT);
		assertEquals(incidents.size(), 1);
	}

	/**
	 * Tests the getTicketById method for proper returning of tickets
	 * by their ID.
	 */
	@Test
	public void testGetTicketById() {
		
		assertTrue(list.getTicketById(10) == null);
	}

	/**
	 * Tests the executeCommand method for proper execution of commands.
	 */
	@Test
	public void testExecuteCommand() {
		list.addTicket(TicketType.REQUEST, "subject", "caller", Category.DATABASE, Priority.HIGH, "note");
		list.executeCommand(1, new Command(Command.CommandValue.PROCESS, "owner", null, null, null, "a note"));
		assertEquals(list.getTicketById(1).getState(), "Working");
		
		try {
		ArrayList<Ticket> newlist2 = new ArrayList<Ticket>();
		list.addTickets(newlist2);
		list.executeCommand(1, new Command(Command.CommandValue.PROCESS, "owner", null, null, null, "a note"));
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Tests the deleteTicketById for proper deletion/removal of a ticket from the
	 * list based on their ID.
	 */
	@Test
	public void testDeleteTicketById() {
		list.addTicket(TicketType.REQUEST, "subject", "caller", Category.DATABASE, Priority.HIGH, "note");
		list.deleteTicketById(1);
		assertTrue(list.getTickets().isEmpty());
	}

}
