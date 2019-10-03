package edu.ncsu.csc216.ticket_manager.model.manager;

import edu.ncsu.csc216.ticket_manager.model.command.Command;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Category;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Priority;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.TicketType;

public class TicketManager {

	private TicketManager() {
		
	}
	
	public static TicketManager getInstance() {
		return null;
	}
	
	public void saveTicketsToFile(String fileName) {
		
	}
	
	public void loadTicketsFromFile(String fileName) {
		
	}
	
	public void createNewTicketList() {
		
	}
	
	public String[][] getTicketsForDisplay(){
		return null;
	}
	
	public String[][] getTicketsForDisplayByType(TicketType ticketType){
		return null;
	}
	
	public Ticket getTicketById(int id) {
		return null;
	}
	
	public void executeCommand(int id, Command command) {
		
	}
	
	public void deleteTicketById(int id) {
		
	}
	
	public void addTicketToList(TicketType ticketType, String subject, String caller, Category category,
			Priority priority, String note) {
		
	}
}
