package edu.ncsu.csc216.ticket_manager.model.manager;

import java.util.ArrayList;

import edu.ncsu.csc216.ticket_manager.model.command.Command;
import edu.ncsu.csc216.ticket_manager.model.io.TicketReader;
import edu.ncsu.csc216.ticket_manager.model.io.TicketWriter;
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
	
	private static TicketManager instance;
	private TicketList list = new TicketList();
	private TicketList typeList = new TicketList();

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
		if (instance == null) {
			instance = new TicketManager();
			}
			return instance;
	}
	
	/**
	 * This saves the Tickets to a File 
	 * @param fileName			Name of the file to write the Tickets to
	 */
	public void saveTicketsToFile(String fileName) {
		
		TicketWriter.writeTicketFile(fileName, list.getTickets());
		
	}
	
	/**
	 * This loads Tickets from a File
	 * @param fileName		Name of the file to load from
	 */
	public void loadTicketsFromFile(String fileName) {
		
		ArrayList<Ticket> tempLoadedList;
		tempLoadedList = TicketReader.readTicketFile(fileName);
		list.addTickets(tempLoadedList);
		
	}
	
	/**
	 * Creates a new TicketList
	 */
	public void createNewTicketList() {
		list = new TicketList();
	}
	
	/**
	 * This gets the Tickets into a format for displaying
	 * @return		2D String array for displaying the Tickets
	 */
	public String[][] getTicketsForDisplay(){
		String[][] display = new String[list.getTickets().size()][6];
		for(int i = 0; i < list.getTickets().size(); i++) {
			display[i][0] = Integer.toString(list.getTicketById(i + 1).getTicketId());
			display[i][1] = list.getTicketById(i + 1).getTicketTypeString();
			display[i][2] = list.getTicketById(i + 1).getState();
			display[i][3] = list.getTicketById(i + 1).getSubject();
			display[i][4] = list.getTicketById(i + 1).getCategory();
			display[i][5] = list.getTicketById(i + 1).getPriority();
			
		}
		return display;
	}
	
	/**
	 * This gets the Tickets (By Type of Ticket) into a format for displaying
	 * @param ticketType			The Type of ticket you would like to have displayed in the Array
	 * @return		2D String array for displaying the Tickets
	 */
	public String[][] getTicketsForDisplayByType(TicketType ticketType) {
		if(ticketType == null) {
			throw new IllegalArgumentException();
		}
		
		ArrayList<Ticket> tempTypeList;
		tempTypeList = list.getTicketsByType(ticketType);
		typeList.addTickets(tempTypeList);
		
		String[][] display = new String[typeList.getTickets().size()][6];
		for(int i = 0; i < typeList.getTickets().size(); i++) {
			display[i][0] = Integer.toString(tempTypeList.get(i).getTicketId());
			display[i][1] = tempTypeList.get(i).getTicketTypeString();
			display[i][2] = tempTypeList.get(i).getState();
			display[i][3] = tempTypeList.get(i).getSubject();
			display[i][4] = tempTypeList.get(i).getCategory();
			display[i][5] = tempTypeList.get(i).getPriority();
		}
		
		return display;
	}
	
	/**
	 * This gets a Ticket from the list by its unique ID
	 * @param id			ID of the Ticket to get
	 * @return				Ticket with matching ID
	 */
	public Ticket getTicketById(int id) {
		return list.getTicketById(id);
	}
	
	/**
	 * This executes a Command on a Ticket in the list with the matching ID
	 * @param id			ID of the Ticket to Command
	 * @param command		Command to perform on the Ticket
	 */
	public void executeCommand(int id, Command command) {
		list.executeCommand(id, command);
	}
	
	/**
	 * This deletes a Ticket in the List by its ID
	 * @param id			ID of the Ticket to delete
	 */
	public void deleteTicketById(int id) {
		list.deleteTicketById(id);
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
		list.addTicket(ticketType, subject, caller, category, priority, note);
	}
}
