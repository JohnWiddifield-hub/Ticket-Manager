package edu.ncsu.csc216.ticket_manager.model.io;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

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
	public static ArrayList<Ticket> readTicketFile(String fileName) {
	    ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		try {
    	String ticketId, state, ticketType, subject, caller, category, priority, owner, code;
    	ticketId = null;
    	state = "";
    	ticketType = "";
    	subject = "";
    	caller = "";
    	category = "";
    	priority = "";
    	owner = "";
    	code = "";
    	
    	ArrayList<String> notes = new ArrayList<String>();
    	String note = "";
	    Scanner fileReader = new Scanner(new FileInputStream(fileName));

	    while(fileReader.hasNextLine()) {
	    	String line = fileReader.nextLine();
	    	if(line.startsWith("*")) {
	    		if(!note.isEmpty()) {
	    			notes.add(note);
	    			note = "";
	    		}
	    		if(ticketId != null) {
	    			ticketId = ticketId.replace("*", "");
	    			int id = Integer.parseInt(ticketId);
	    			Ticket t = new Ticket(id, state, ticketType, subject, caller, category, priority,
	    					 owner, code, notes);
	    			notes = new ArrayList<String>();
	    			tickets.add(t);
	    		}
	    		Scanner lineReader = new Scanner(line);
	    		line = line.trim();
	    		line = line.replace("*", "");
	    		lineReader.useDelimiter("#");
	    		
	    		ticketId = lineReader.next();
	    		state = lineReader.next();
	    		ticketType = lineReader.next();
	    		subject = lineReader.next();
	    		caller = lineReader.next();
	    		category = lineReader.next();
	    		priority = lineReader.next();
	    		owner = lineReader.next();
	    		if(lineReader.hasNext()) {
	    			code = lineReader.next();
	    		} else code = "";
	    		
	    		if(state.equals("Working") && code.contentEquals("Awaiting Caller")) {
	    			lineReader.close();
	    			throw new IllegalArgumentException();
	    		} else if(state.equals("Working") && code.contentEquals("Solved")) {
	    			lineReader.close();
	    			throw new IllegalArgumentException();
	    		} else if(state.equals("Working") && code.contentEquals("Duplicate")) {
	    			lineReader.close();
	    			throw new IllegalArgumentException();
	    		} else if(state.equals("Resolved") && code.equals("Not Completed") && ticketType.equals("Incident")) {
	    			lineReader.close();	
	    			throw new IllegalArgumentException();
	    		} else if(state.equals("Resolved") && code.equals("Solved") && ticketType.equals("Request")) {
	    			lineReader.close();
	    			throw new IllegalArgumentException();
	    		}
	    		
	    		lineReader.close();
	    		
	    	} else if(line.startsWith("-")) {

	    		if(!note.isEmpty()) {
	    			notes.add(note);
	    			note = "";
	    		}
	    		line = line.replace("-", "");
	    		note = note + line;
	    	} else if(!line.startsWith("-") && !line.startsWith("*")) {
	    		
	    		note = note + "\n" + line;
	    	}
	    }
		if(!note.isEmpty()) {
			notes.add(note);
			note = "";
		}
		ticketId = ticketId.replace("*", "");
		int id = Integer.parseInt(ticketId);
		if(notes.isEmpty()) {
			fileReader.close();
			throw new IllegalArgumentException("Unable to load file.");
		}
		Ticket t = new Ticket(id, state, ticketType, subject, caller, category, priority,
				 owner, code, notes);
		notes = new ArrayList<String>();
		tickets.add(t);
	    fileReader.close();
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
			return tickets;
	}
}
