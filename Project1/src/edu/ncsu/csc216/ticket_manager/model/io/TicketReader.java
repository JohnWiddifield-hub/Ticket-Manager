package edu.ncsu.csc216.ticket_manager.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

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
	 * @throws FileNotFoundException 	if the file is nowhere to be found.
	 * @throws IllegalArgumentException if there are problems processing the file.
	 * 		   Message will be "Unable to load file."
	 */
	public static ArrayList<Ticket> readTicketFile(String fileName) throws FileNotFoundException{
		/*
    	String ticketId, state, ticketType, subject, caller, category, priority, owner, 
    	code;
    	ArrayList<String> notes = new ArrayList<String>();
	    ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	    Scanner fileReader = new Scanner(new FileInputStream(fileName));

	    while(fileReader.hasNextLine()) {
	    	
	    }
	    
	    private static String readTicketLine(String nextLine) {
	    	String ticketId, state, ticketType, subject, caller, category, priority, owner, 
	    	code;
	    
			if(nextLine.startsWith("*")) {
			String strFaux = nextLine.replaceFirst("*", "");
			String str = strFaux.replace("\n", "");
	    	Scanner lineReader = new Scanner(str);
	    	String strCln = str;
	    	
	    	//make sure right amount of tokens
	    	int cntr = 0;  
	    	for (int i = 0; i < strCln.length(); i++) {
	    	    if (strCln.charAt(i) == '#') {
	    	        cntr++;
	    	    }
	    	}
	    	
	    	//check for wrong amount of tokens
	    	if(cntr != 8) {
	    		lineReader.close();
	    		throw new IllegalArgumentException("Unable to load file.");
	    		
	    	}
	    	
	    	lineReader.useDelimiter("#");
	    	
	    	ticketId = lineReader.next();
	    	state = lineReader.next();
	    	ticketType = lineReader.next();
	    	subject = lineReader.next();
	    	caller = lineReader.next();
	    	category = lineReader.next();
	    	priority = lineReader.next();
	    	owner = lineReader.next();
	    	code = lineReader.next();
	    	
	    	String output = ticketId + "#" + state + "#" + ticketType + "#" + subject + 
	    			"#" + caller + "#" + category + "#" + priority + "#" + owner + "#" +
	    			code;
	    	lineReader.close();
	    	return output;
			} else if (nextLine.startsWith("-")){
				return nextLine;   
			}
			return "Mess-up";*/ return null;
	}
}
