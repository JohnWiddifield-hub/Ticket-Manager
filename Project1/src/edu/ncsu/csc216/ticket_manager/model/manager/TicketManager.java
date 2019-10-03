package edu.ncsu.csc216.ticket_manager.model.manager;

import edu.ncsu.csc216.ticket_manager.model.command.Command;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Category;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Priority;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.TicketType;

/**
 * This Concrete Class maintains the TicketList and handles Commands from the GUI using many 
 * different generic functions for managing Tickets.  It is also implementing the singleton 
 * design pattern.
 * 
 * @author John Widdifield
 *
 */
public class TicketManager {

	/**
	 * Constructs the only TicketManager Object
	 */
	private TicketManager() {
		
	}
	
	/**
	 * This gets the instance of the TicketManager
	 * @return TicketManager object for the instance
	 */
	public static TicketManager getInstance() {
		return null;
	}
	
	/**
	 * This saves the Tickets to a File 
	 * @param fileName			Name of the file to write the Tickets to
	 */
	public void saveTicketsToFile(String fileName) {
		
	}
	
	/**
	 * This loads Tickets from a File
	 * @param fileName		Name of the file to load from
	 */
	public void loadTicketsFromFile(String fileName) {
		
	}
	
	/**
	 * Creates a new TicketList
	 */
	public void createNewTicketList() {
		
	}
	
	/**
	 * This gets the Tickets into a format for displaying
	 * @return		2D String array for displaying the Tickets
	 */
	public String[][] getTicketsForDisplay(){
		return null;
	}
	
	/**
	 * This gets the Tickets (By Type of Ticket) into a format for displaying
	 * @param ticketType
	 * @return		2D String array for displaying the Tickets
	 */
	public String[][] getTicketsForDisplayByType(TicketType ticketType){
		return null;
	}
	
	/**
	 * This gets a Ticket from the list by its unique ID
	 * @param id			ID of the Ticket to get
	 * @return				Ticket with matching ID
	 */
	public Ticket getTicketById(int id) {
		return null;
	}
	
	/**
	 * This executes a Command on a Ticket in the list with the matching ID
	 * @param id			ID of the Ticket to Command
	 * @param command		Command to perform on the Ticket
	 */
	public void executeCommand(int id, Command command) {
		
	}
	
	/**
	 * This deletes a Ticket in the List by its ID
	 * @param id			ID of the Ticket to delete
	 */
	public void deleteTicketById(int id) {
		
	}
	
	/**
	 * Adds a Ticket to the list.
	 * @param ticketType		TicketType of the Ticket to add
	 * @param subject			Subject of the Ticket to add
	 * @param caller			Caller of the Ticket to add
	 * @param category			Category of the Ticket to add
	 * @param priority			Priority of the Ticket to add
	 * @param note				Note for the Ticket to add
	 */
	public void addTicketToList(TicketType ticketType, String subject, String caller, Category category,
			Priority priority, String note) {
		
	}
}
