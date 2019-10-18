package edu.ncsu.csc216.ticket_manager.model.manager;

import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc216.ticket_manager.model.command.Command;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Category;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Priority;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.TicketType;
/**
 * This Concrete Class keeps a list of Tickets and allows for adding, removing, getting, and excecuting Commands on 
 * the Tickets from the list.
 * 
 * @author John Widdifield
 *
 */
public class TicketList {
	
	/** The list of tickets. */
	private ArrayList<Ticket> tickets;
	
	/**
	 * This is the default constructor which creates an empty list
	 */
	public TicketList() {
		tickets = new ArrayList<Ticket>();
		Ticket.setCounter(1);
	}
	
	/**
	 * This adds a Ticket to the list.
	 * @param ticketType			TicketType enum that represents the type of ticket
	 * @param subject				Ticket's subject
	 * @param caller				Ticket's caller's name
	 * @param category				Category enum that represents the type of Category
	 * @param priority				Priority enum that represents the type of Priority
	 * @param note					Note provided by user about the Ticket
	 * @return 1 if Ticket is added successfully, -1 if unsuccessful
	 */
	public int addTicket(TicketType ticketType, String subject, String caller, Category category,
			Priority priority, String note) {
		try {
		tickets.add(new Ticket(ticketType, subject, caller, category, priority, note));
		return tickets.get(tickets.size()-1).getTicketId();
		} catch (Exception e) {
			return -1;
		}
	}
	
	/**
	 * Adds a list of Tickets to the list
	 * @param list			List<Ticket> List of tickets to add
	 */
	public void addTickets(List<Ticket> list) {
		int max = 0;
		tickets.clear();
		
		for(int i = 0; i < list.size(); i++) {
			tickets.add(list.get(i));
			if(list.get(i).getTicketId() > max) {
				max = list.get(i).getTicketId();
			}
		}
		Ticket.setCounter(max + 1);
		
	}
	
	/**
	 * Gets Tickets from the list
	 * @return List<Ticket> list of Tickets
	 */
	public List<Ticket> getTickets(){
		return tickets;
	}
	
	/**
	 * Gets the Tickets from the list based on Type
	 * @param type	Ticket Type to receive from the list
	 * @return	list of tickets partaining to the specific type
	 */
	public List<Ticket> getTicketsByType(TicketType type){
		ArrayList<Ticket> filtered = new ArrayList<Ticket>();
		for(int i = 0; i < tickets.size(); i++) {
			if(tickets.get(i).getTicketType() == type) {
				filtered.add(tickets.get(i));
			}
		}
		return filtered;
	}
	
	/**
	 * Gets the Ticket by the Ticket's ID
	 * @param id		ID of the Ticket to get
	 * @return Ticket matching the id
	 */
	public Ticket getTicketById(int id) {
		for(int i = 0; i < tickets.size(); i++) {
			if(tickets.get(i).getTicketId() == id) {
				return tickets.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Executes a Command on a Ticket inside of the list
	 * @param id			ID of the Ticket to Execute a Command
	 * @param command		Command to execute on the Ticket
	 */
	public void executeCommand(int id, Command command) {
		getTicketById(id).update(command);
	}
	
	/**
	 * Deletes the Ticket matching the ID you pass
	 * @param id			ID of the Ticket to delete
	 */
	public void deleteTicketById(int id) {
		for(int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getTicketId() == id) {
				tickets.remove(i);
			}
		}
	}
	
}
