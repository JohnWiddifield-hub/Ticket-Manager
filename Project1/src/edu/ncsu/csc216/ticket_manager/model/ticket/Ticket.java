package edu.ncsu.csc216.ticket_manager.model.ticket;

import java.util.ArrayList;

import edu.ncsu.csc216.ticket_manager.model.command.Command;
import edu.ncsu.csc216.ticket_manager.model.command.Command.CancellationCode;
import edu.ncsu.csc216.ticket_manager.model.command.Command.FeedbackCode;
import edu.ncsu.csc216.ticket_manager.model.command.Command.ResolutionCode;

/**
 * This concrete Class represents the state of the Ticket and allows for keeping track of state and
 * all ticket information.  Also, encapsulates all 6 state classes for a Ticket.
 * 
 * @author John Widdifield
 *
 */
public class Ticket {
	/**A constant String representation of state for TicketType*/
	public static final String TT_REQUEST = "Request";
	/**A constant String representation of state for TicketType*/
	public static final String TT_INCIDENT = "Incident";
	/**A constant String representation of state for Category*/
	public static final String C_INQUIRY = "Inquiry";
	/**A constant String representation of state for Category*/
	public static final String C_SOFTWARE = "Software";
	/**A constant String representation of state for Category*/
	public static final String C_HARDWARE = "Hardware";
	/**A constant String representation of state for Category*/
	public static final String C_NETWORK = "Network";
	/**A constant String representation of state for Category*/
	public static final String C_DATABASE = "Database";
	/**A constant String representation of state for Priority*/
	public static final String P_URGENT = "Urgent";
	/**A constant String representation of state for Priority*/
	public static final String P_HIGH = "High";
	/**A constant String representation of state for Priority*/
	public static final String P_MEDIUM = "Medium";
	/**A constant String representation of state for Priority*/
	public static final String P_LOW = "Low";
	/**A constant String representation of state for Ticket*/
	public static final String NEW_NAME = "New";
	/**A constant String representation of state for Ticket*/
	public static final String WORKING_NAME = "Working";
	/**A constant String representation of state for Ticket*/
	public static final String FEEDBACK_NAME = "Feedback";
	/**A constant String representation of state for Ticket*/
	public static final String RESOLVED_NAME = "Resolved";
	/**A constant String representation of state for Ticket*/
	public static final String CLOSED_NAME = "Closed";
	/**A constant String representation of state for Ticket*/
	public static final String CANCELED_NAME = "Canceled";
	
	/** Counter which keeps track of the ID value that should be given to the next Ticket created. */
	private static int counter = 1;
	/** The ID of the Ticket */
	private int ticketId;
	/** The Subject for the Ticket */
	private String subject;
	/** The Caller of the Ticket */
	private String caller;
	/** The Owner of the Ticket */
	private String owner;
	/** An ArrayList of notes associated with the Ticket */
	private ArrayList<String> notes;
	/** The State of the Ticket */
	private TicketState state;
	/** The Category for the Ticket */
	private Category category;
	/** The Priority for the Ticket */
	private Priority priority;
	
	/** The FeedbackCode for the Ticket */
	private FeedbackCode feedbackCode;
	/** The ResolutionCode for the Ticket */
	private ResolutionCode resolutionCode;
	/** The CancellationCode for the Ticket */
	private CancellationCode cancellationCode;
	
	/** Category Enumeration for all possible Categories for a Ticket */
	public enum Category { INQUIRY, SOFTWARE, HARDWARE, NETWORK, DATABASE }
	/** Priority Enumeration for all possible Priorities of a Ticket */
	public enum Priority { URGENT, HIGH, MEDIUM, LOW }
	/** TicketType Enumeration for all possible Types of a Ticket */
	public enum TicketType { REQUEST, INCIDENT }
	
	/** Instance of the concrete inner TicketState class NewState */
	public final NewState newState = null;
	/** Instance of the concrete inner TicketState class WorkingState */
	public final WorkingState workingState = null;
	/** Instance of the concrete inner TicketState class FeedbackState */
	public final FeedbackState feedbackState = null;
	/** Instance of the concrete inner TicketState class ResolvedState */
	public final ResolvedState resolvedState = null;
	/** Instance of the concrete inner TicketState class ClosedState */
	public final ClosedState closedState = null;
	/** Instance of the concrete inner TicketState class CanceledState */
	public final CanceledState canceledState = null;
	
/*	/** This holds the Ticket type for the Ticket 
	private TicketType tT;
	/** This holds the Priority type for the Ticket 
	private Priority prior;
	/** This holds the Category type for the Ticket 
	private Category categ; */
	
	
	/**
	 * Constructs a Ticket object based on the Parameters
	 * @param id			ID of the ticket
	 * @param state			The state for the Ticket
	 * @param ticketType	The Type of the Ticket
	 * @param subject		The Ticket's Subject
	 * @param caller		The Ticket's Caller
	 * @param category		The Ticket's Category
	 * @param priority		The Ticket's Priority
	 * @param owner			The Ticket's Owner
	 * @param code			The Ticket's code
	 * @param notes			ArrayList of Strings for the Ticket's notes
	 * @throws IllegalArgumentException if there are problems with the input 
	 */
	public Ticket(int id, String state, String ticketType, String subject, String caller, String category, 
			String priority, String owner, String code, ArrayList<String> notes) {
		
	}
	
	/**
	 * Constructs a Ticket object based on the Parameters
	 * 
	 * @param ticketType	Type of Ticket for the Ticket
	 * @param subject		Subject of the Ticket	
	 * @param caller		Caller of the Ticket
	 * @param category		Category for the Ticket
	 * @param priority		Priority of the Ticket
	 * @param note			Note for the Ticket
	 * @throws IllegalArgumentException if any of the Params are null or empty Strings
	 */
	public Ticket(TicketType ticketType, String subject, String caller, Category category, Priority priority, String note) {
		this.setCaller(caller);
		this.setSubject(subject);
		
		if(ticketType == TicketType.INCIDENT) {
			this.setTicketType(TT_INCIDENT);
		} else if(ticketType == TicketType.REQUEST) {
			this.setTicketType(TT_REQUEST);
		}
		
		if(category == Category.DATABASE) {
			this.setCategory(C_DATABASE);
		} else if(category == Category.HARDWARE) {
			this.setCategory(C_HARDWARE);
		} else if(category == Category.INQUIRY) {
			this.setCategory(C_INQUIRY);
		} else if(category == Category.NETWORK) {
			this.setCategory(C_NETWORK);
		} else if(category == Category.SOFTWARE) {
			this.setCategory(C_SOFTWARE);
		}
		
		if(priority == Priority.HIGH) {
			this.setPriority(P_HIGH);
		} else if(priority == Priority.LOW) {
			this.setPriority(P_LOW);
		} else if(priority == Priority.MEDIUM) {
			this.setPriority(P_MEDIUM);
		} else if(priority == Priority.URGENT) {
			this.setPriority(P_URGENT);
		}
		
		this.notes.add(note);
		
		incrementCounter();
	}
	
	/**
	 * Increments the Counter used for determining the ID for a Ticket
	 */
	public static void incrementCounter() {
		counter++;
	}
	
	/**
	 * sets the Counter used for determining the ID for a Ticket
	 * @param cntr		ID to set the Counter to
	 */
	public static void setCounter(int cntr) {
		
	}

	/**
	 * This gets the Caller of the Ticket
	 * @return		Name of the Caller
	 */
	public String getCaller() {
		return this.caller;
	}
	
	/**
	 * This gets the CancellationCode for the Ticket
	 * @return 			The Ticket's CancellationCode
	 */
	public String getCancellationCode() {
		if(cancellationCode == CancellationCode.DUPLICATE) {
			return C_DUPLICATE;
		}
	}
	
	/**
	 * This gets the Category for the Ticket
	 * @return			The Ticket's Category
	 */
	public String getCategory() {
		return null;
	}
	
	/**
	 * This gets the FeedbackCode for the Ticket
	 * @return			The Ticket's Feedback Code 
	 */
	public String getFeedbackCode() {
		return null;
	}
	
	/**
	 * This gets the Notes for the Ticket 
	 * @return		String representation of the Ticket's notes
	 */
	public String getNotes() {
		return null;
	}
	
	/**
	 * This gets the Owner of the Ticket
	 * @return		Owner of the Ticket
	 */
	public String getOwner() {
		return null;
	}
	
	/** 
	 * This gets the Priority of the Ticket
	 * @return 	Priority of the Ticket
	 */
	public String getPriority() {
		return null;
	}
	
	/**
	 * This gets the ResolutionCode for the Ticket
	 * @return		ResolutionCode of the Ticket
	 */
	public String getResolutionCode() {
		return null;
	}
	
	/**
	 * This gets the state that the Ticket is in
	 * @return		Ticket's state as a String
	 */
	public String getState() {
		return null;
	}
	
	/**
	 * This gets the Ticket's Subject
	 * @return 	Ticket's Subject
	 */
	public String getSubject() {
		return null;
	}
	
	/**
	 * This gets the Ticket's ID
	 * @return	ID of the Ticket
	 */
	public String getTicketId() {
		return null;
	}
	
	/**
	 * This gets the Ticket's Type 
	 * @return	The TicketType for the Ticket
	 */
	public TicketType getTicketType() {
		return null;
	}
	
	/**
	 * This gets the Tickets type as a String
	 * @return A String representation of the Ticket's type
	 */
	public String getTicketTypeString() {
		return null;
	}
	
	/**
	 * This sets the Caller of the Ticket
	 * @param caller	String to set the caller's name equal to
	 */
	private void setCaller(String caller) {
		
	}
	
	/**
	 * This sets the CancellationCode for the Ticket
	 * @param cancellationCode 		The String representation of the CancellationCode to set for the Ticket
	 */
	private void setCancellationCode(String cancellationCode) {
		
	}
	
	/**
	 * This sets the Category for the Ticket
	 * @param category		Category to set the Ticket to
	 */
	private void setCategory(String category) {
		
	}
	
	/**
	 * This sets the Owner of the Ticket 
	 * @param owner			Owner to set for the Ticket
	 */
	private void setOwner(String owner) {
		
	}
	
	/**
	 * This sets the FeedbackCode for the Ticket
	 * @param feedbackCode			feedbackCode to set for the Ticket
	 */
	private void setFeedbackCode(String feedbackCode) {
	
	}
	
	/**
	 * This sets the Priority for the Ticket
	 * @param priority
	 */
	private void setPriority(String priority) {
		
	}
	
	/**
	 * This sets the resolutionCode for the Ticket
	 * @param resolutionCode		ResolutionCode to set for the Ticket
	 */
	private void setResolutionCode(String resolutionCode) {
		
	}
	
	/**
	 * This sets the state for the Ticket
	 * @param state		State the Ticket should be in
	 */
	private void setState(String state) {
		
	}
	
	/**
	 * This sets the subject of the Ticket
	 * @param subject		Subject for the Ticket
	 */
	private void setSubject(String subject) {
		
	}
	
	/**
	 * This sets the TicketType for the Ticket
	 * @param ticketType		TicketType to set the ticket to
	 */
	private void setTicketType(String ticketType) {
		
	}
	
	/**
	 * This creates a representation of a Ticket used in File saving and reading 
	 * @return String representation of a Ticket
	 */
	public String toString() {
		return null;
	}
	
	/**
	 * This updates the Ticket through the use of a Command
	 * @param command		Command to execute on the Ticket
	 */
	public void update(Command command) {
		
	}
	
	/**
	 * This is the state that a ticket is in after it is canceled.  It may never leave this state.
	 * 
	 * @author John Widdifield
	 *
	 */
	public class CanceledState implements TicketState {
		
		/**
		 * Constructs the canceled state object for the Ticket
		 */
		private CanceledState() {
			
		}
		
		/**
		 * This gets the name of the State
		 * @return 			String representing the state
		 */
		public String getStateName() {
			return null;
		}
		
		/**
		 * This updates the State to the State indicated by the command passed
		 * @param command		Command you would like to execute on the state
		 */
		public void updateState(Command command) {
			
		}
	}
	
	/**
	 * This is the state that a ticket is in once someone is working on it.
	 * 
	 * @author John Widdifield
	 *
	 */
	public class WorkingState implements TicketState {
		private WorkingState() {
			
		}
		
		/**
		 * This gets the name of the State
		 * @return 			String representing the state
		 */
		public String getStateName() {
			return null;
		}
		
		/**
		 * This updates the State to the State indicated by the command passed
		 * @param command		Command you would like to execute on the state
		 */
		public void updateState(Command command) {
			
		}
	}
	
	/**
	 * This is the state that a new ticket is in before any interaction.
	 * 
	 * @author John Widdifield
	 *
	 */
	public class NewState implements TicketState {
		private NewState() {
			
		}
		
		/**
		 * This gets the name of the State
		 * @return 			String representing the state
		 */
		public String getStateName() {
			return null;
		}
		
		/**
		 * This updates the State to the State indicated by the command passed
		 * @param command		Command you would like to execute on the state
		 */
		public void updateState(Command command) {
			
		}
	}
	
	/**
	 * This is the state that a ticket is in once someone is finished working on it and 
	 * it has been resolved.
	 * 
	 * @author John Widdifield
	 *
	 */
	public class ResolvedState implements TicketState {
		private ResolvedState() {
			
		}
		
		/**
		 * This gets the name of the State
		 * @return 			String representing the state
		 */
		public String getStateName() {
			return null;
		}
		
		/**
		 * This updates the State to the State indicated by the command passed
		 * @param command		Command you would like to execute on the state
		 */
		public void updateState(Command command) {
			
		}
	}
	
	/**
	 * This is the state that a ticket is in once the IT staff and the client have agreed 
	 * that the Ticket is Complete (for now).
	 * 
	 * @author John Widdifield
	 *
	 */
	public class ClosedState implements TicketState {
		private ClosedState() {
			
		}
		
		/**
		 * This gets the name of the State
		 * @return 			String representing the state
		 */
		public String getStateName() {
			return null;
		}
		
		/**
		 * This updates the State to the State indicated by the command passed
		 * @param command		Command you would like to execute on the state
		 */
		public void updateState(Command command) {
			
		}
	}
	
	/**
	 * This is the state that a ticket is in while it is awaiting feedback from someone
	 * 
	 * @author John Widdifield
	 *
	 */
	public class FeedbackState implements TicketState {
		private FeedbackState() {
			
		}
		
		/**
		 * This gets the name of the State
		 * @return 			String representing the state
		 */
		public String getStateName() {
			return null;
		}
		
		/**
		 * This updates the State to the State indicated by the command passed
		 * @param command		Command you would like to execute on the state
		 */
		public void updateState(Command command) {
			
		}
	}
	
}
