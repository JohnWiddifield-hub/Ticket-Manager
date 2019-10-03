package edu.ncsu.csc216.ticket_manager.model.manager;

import java.util.List;

import edu.ncsu.csc216.ticket_manager.model.command.Command;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Category;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Priority;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.TicketType;

public class TicketList {

	public TicketList() {
		
	}
	
	public int addTicket(TicketType ticketType, String subject, String caller, Category category,
			Priority priority, String note) {
		return 0;
	}
	
	public void addTickets(List<Ticket> list) {
		
	}
	
	public List<Ticket> getTickets(){
		return null;
	}
	
	public List<Ticket> getTicketsByType(TicketType type){
		return null;
	}
	
	public Ticket getTicketById(int id) {
		return null;
	}
	
	public void executeCommand(int id, Command command) {
		
	}
	
	public void deleteTicketById(int id) {
		
	}
	
}
