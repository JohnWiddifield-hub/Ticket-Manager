package edu.ncsu.csc216.ticket_manager.model.io;

import java.util.ArrayList;

import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket;

/**
 * This class reads a ticket from a file containing tokens that have a Ticket's fields.
 * 
 * @author John Widdifield
 *
 */
public class TicketReader {
	
	/**
	 * Reads a Ticket object from a File in specific formatting as such (each new ticket is on a new line)
	 * *id#state#ticket-type#subject#caller#category#priority#owner#code-appropriate-for-state
	 * -note
	 * -note
	 * @param fileName			Name of the file to read from.
	 * @return 					An ArrayList of tickets that were read from the file.
	 * @throws IllegalArgumentException if there are problems processing the file.
	 * 		   Message will be "Unable to load file."
	 */
	public static ArrayList<Ticket> readTicketFile(String fileName){
		return null;
	}
}
