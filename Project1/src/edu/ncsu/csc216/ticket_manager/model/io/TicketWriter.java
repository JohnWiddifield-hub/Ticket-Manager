package edu.ncsu.csc216.ticket_manager.model.io;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket;

/**
 * This class allows for writing Tickets into a file.
 * 
 * @author John Widdifield
 *
 */
public class TicketWriter {

	/**
	 * This writes Ticket objects from a List of Tickets into a specified file with a specific formatting
	 * to be used with reading the file later using TicketReader.java
	 * @param fileName			File name of the file to write to
	 * @param tickets			List of Ticket objects you would like to write to a file
	 * @throws IOException when a file cannot be created
	 * @throws IllegalArgumentException if there are any errors with the message "Unable to save file"
	 */
	public static void writeTicketFile(String fileName, List<Ticket> tickets) {
		try {
		 PrintStream fileWriter = new PrintStream(new File(fileName));
		
		 
	        for (int i = 0; i < tickets.size(); i++) {
	        	Ticket t = tickets.get(i);
	            fileWriter.println(t.toString());
	        }
	        
	        fileWriter.close();
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}
}
