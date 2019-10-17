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
	private ArrayList<String> notes = new ArrayList<String>();
	/** The State of the Ticket */
	private TicketState state;
	/** The TicketType of the Ticket */
	private TicketType ticketType;
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
	public final NewState newState = new NewState();
	/** Instance of the concrete inner TicketState class WorkingState */
	public final WorkingState workingState = new WorkingState();
	/** Instance of the concrete inner TicketState class FeedbackState */
	public final FeedbackState feedbackState = new FeedbackState();
	/** Instance of the concrete inner TicketState class ResolvedState */
	public final ResolvedState resolvedState = new ResolvedState();
	/** Instance of the concrete inner TicketState class ClosedState */
	public final ClosedState closedState = new ClosedState();
	/** Instance of the concrete inner TicketState class CanceledState */
	public final CanceledState canceledState = new CanceledState();
	
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
		
		if(id >= 0) {
			this.ticketId = id;
		} else throw new IllegalArgumentException();
		
		if(state.equals("Resolved") && code.equals("Not Completed") && ticketType.equals("Request")) {
			throw new IllegalArgumentException();
		} else if(state.equals("Resolved") && code.equals("Solved") && ticketType.equals("Incident"))
			
		if(state.contentEquals("New")) {
			this.setState(state);
		} else if (state.contentEquals("Working")) {
			this.setState(state);
		} else if (state.contentEquals("Feedback")) {
			this.setState(state);
		} else if (state.contentEquals("Resolved")) {
			this.setState(state);
		} else if (state.contentEquals("Closed")) {
			this.setState(state);
		} else if (state.contentEquals("Canceled")) {
			this.setState(state);
		} else throw new IllegalArgumentException();
		
		if(ticketType.contentEquals(TT_INCIDENT)) {
			this.setTicketType(ticketType);
		} else if(ticketType.contentEquals(TT_REQUEST)) {
			this.setTicketType(ticketType);
		} else throw new IllegalArgumentException();
		
		if(category.contentEquals(C_SOFTWARE)) {
			this.setCategory(C_SOFTWARE);
		} else if(category.contentEquals(C_HARDWARE)) {
			this.setCategory(C_HARDWARE);
		} else if(category.contentEquals(C_INQUIRY)) {
			this.setCategory(C_INQUIRY);
		} else if(category.contentEquals(C_DATABASE)) {
			this.setCategory(C_DATABASE);
		} else if(category.contentEquals(C_NETWORK)) {
			this.setCategory(C_NETWORK);
		} else throw new IllegalArgumentException();
		
		if(priority == null) {
			throw new IllegalArgumentException();
		} else if(priority.contentEquals(P_HIGH)) {
			this.setPriority(P_HIGH);
		} else if(priority.contentEquals(P_MEDIUM)) {
			this.setPriority(P_MEDIUM);
		} else if(priority.contentEquals(P_LOW)) {
			this.setPriority(P_LOW);
		} else if(priority.contentEquals(P_URGENT)) {
			this.setPriority(P_URGENT);
		} else throw new IllegalArgumentException();
		
		if(owner != null) {
			if(owner.isEmpty() && state.equals("Working")) {
			throw new IllegalArgumentException();
			} else if(owner.isEmpty() && state.equals("Feedback")) {
			throw new IllegalArgumentException();
			} else if(owner.isEmpty() && state.equals("Resolved")) {
			throw new IllegalArgumentException();
			} else if(owner.isEmpty() && state.equals("Closed")) {
				throw new IllegalArgumentException();
			}
		}
		
		if(state.equals("Feedback") && code.equals("Awaiting Provider")) {
			this.setFeedbackCode("Awaiting Provider");
		} else if(state.equals("Feedback") && code.equals("Awaiting Caller")) {
			this.setFeedbackCode("Awaiting Caller");
		} else if(state.equals("Feedback") && code.equals("Awaiting Change")) {
			this.setFeedbackCode("Awaiting Change");
		} else if(state.equals("Feedback") && code == null) {
			this.setFeedbackCode(null);
		} else if(state.equals("Feedback")) {
			throw new IllegalArgumentException();
		}
		
		if(state.equals("Resolved") && code.equals("Completed")) {
			this.setResolutionCode("Completed");
		} else if(state.equals("Resolved") && code.equals("Not Completed")) {
			this.setResolutionCode("Not Completed");
		} else if(state.equals("Resolved") && code.equals("Solved")) {
			this.setResolutionCode("Solved");
		} else if(state.equals("Resolved") && code.equals("Workaround")) {
			this.setResolutionCode("Workaround");
		} else if(state.equals("Resolved") && code.equals("Not Solved")) {
			this.setResolutionCode("Not Solved");
		} else if(state.equals("Resolved") && code.equals("Caller Closed")) {
			this.setResolutionCode("Caller Closed");
		} else if(state.equals("Resolved")) {
			throw new IllegalArgumentException();
		}
		
		if(state.equals("Closed") && code.equals("Completed")) {
			this.setResolutionCode("Completed");
		} else if(state.equals("Closed") && code.equals("Not Completed")) {
			this.setResolutionCode("Not Completed");
		} else if(state.equals("Closed") && code.equals("Solved")) {
			this.setResolutionCode("Solved");
		} else if(state.equals("Closed") && code.equals("Workaround")) {
			this.setResolutionCode("Workaround");
		} else if(state.equals("Closed") && code.equals("Not Solved")) {
			this.setResolutionCode("Not Solved");
		} else if(state.equals("Closed") && code.equals("Caller Closed")) {
			this.setResolutionCode("Caller Closed");
		} else if(state.equals("Closed")) {
			throw new IllegalArgumentException();
		}
		
		if(code != null) {
			if(ticketType.contentEquals(TT_INCIDENT) && code.contentEquals("Caller Closed")) {
				this.setResolutionCode("Caller Closed");
			} else if(ticketType.contentEquals(TT_INCIDENT) && code.contentEquals("Solved")) {
				this.setResolutionCode("Solved");
			} else if(ticketType.contentEquals(TT_INCIDENT) && code.contentEquals("Workaround")) {
				this.setResolutionCode("Workaround");
			} else if(ticketType.contentEquals(TT_INCIDENT) && code.contentEquals("Not Solved")) {
				this.setResolutionCode("Not Solved");
			} else if(ticketType.contentEquals(TT_INCIDENT) && code.contentEquals("Duplicate")) {
				this.setCancellationCode("Duplicate");
			} else if(ticketType.contentEquals(TT_INCIDENT) && code.contentEquals("Inappropriate")) {
				this.setCancellationCode("Inappropriate");
			} else if(ticketType.contentEquals(TT_INCIDENT) && code.contentEquals("Awaiting Provider")) {
				this.setFeedbackCode("Awaiting Provider");
			} else if(ticketType.contentEquals(TT_INCIDENT) && code.contentEquals("Awaiting Caller")) {
				this.setFeedbackCode("Awaiting Caller");
			} else if(ticketType.contentEquals(TT_INCIDENT) && code.contentEquals("Awaiting Change")) {
				this.setFeedbackCode("Awaiting Change");
			} else if(ticketType.contentEquals(TT_INCIDENT) && code.contentEquals("Completed")) {
				this.setResolutionCode("Completed");
			} else if(ticketType.contentEquals(TT_INCIDENT) && code.contentEquals("Not Completed")) {
				this.setResolutionCode("Not Completed");
			} else if(ticketType.contentEquals(TT_INCIDENT) && !code.isEmpty()) {
				throw new IllegalArgumentException();
			}
		} 
		
		if(state.contentEquals("Canceled") && code.equals("Duplicate")) {
			this.setCancellationCode("Duplicate");
		} else if(state.equals("Canceled") && code.equals("Inappropriate")) {
			this.setCancellationCode("Inappropriate");
		} else if(state.equals("Canceled")) {
			throw new IllegalArgumentException();
		}
		
		this.setSubject(subject);
		this.setCaller(caller);
		this.setOwner(owner);
	
		for (int i = 0; i < notes.size(); i++) {
			this.notes.add(notes.get(i));
		}
		
		if(id > counter) {
		setCounter(id + 1);
		}
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
		if(ticketType == null) {
			throw new IllegalArgumentException();
		} else if(ticketType == TicketType.INCIDENT) {
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
		} else throw new IllegalArgumentException();
		
		if(priority == null) {
			throw new IllegalArgumentException();
		} else if(priority == Priority.HIGH) {
			this.setPriority(P_HIGH);
		} else if(priority == Priority.LOW) {
			this.setPriority(P_LOW);
		} else if(priority == Priority.MEDIUM) {
			this.setPriority(P_MEDIUM);
		} else if(priority == Priority.URGENT) {
			this.setPriority(P_URGENT);
		}
		
		if(note == null) {
			throw new IllegalArgumentException();
		} else if(note.isEmpty()){
			throw new IllegalArgumentException();
		} else {
			this.notes.add(note);
		}
		
		this.state = newState;
		this.owner = "";
		this.ticketId = counter;
		Ticket.incrementCounter();
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
		if(cntr < 1) {
			throw new IllegalArgumentException("Ticket id must be a value greater than 0.");
		}
		counter = cntr;
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
		if(cancellationCode == CancellationCode.DUPLICATE){
			return "Duplicate";
		} else if(cancellationCode == CancellationCode.INAPPROPRIATE) {
			return "Inappropriate";
		} else return null;
	}
	
	/**
	 * This gets the Category for the Ticket
	 * @return			The Ticket's Category
	 */
	public String getCategory() {
		if(category == Category.DATABASE) {
			return "Database";
		} else if(category == Category.HARDWARE) {
			return "Hardware";
		} else if(category == Category.INQUIRY) {
			return "Inquiry";
		} else if(category == Category.NETWORK) {
			return "Network";
		} else return "Software";
	}
	
	/**
	 * This gets the FeedbackCode for the Ticket
	 * @return			The Ticket's Feedback Code 
	 */
	public String getFeedbackCode() {
		if(feedbackCode == FeedbackCode.AWAITING_CALLER) {
			return "Awaiting Caller";
		} else if(feedbackCode== FeedbackCode.AWAITING_CHANGE) {
			return "Awaiting Change";
		} else if(feedbackCode == FeedbackCode.AWAITING_PROVIDER) {
			return "Awaiting Provider";
		} else return null;
		
	}
	
	/**
	 * This gets the Notes for the Ticket 
	 * @return		String representation of the Ticket's notes
	 */
	public String getNotes() {
		int size = notes.size();
		String output = "";
		
		if(size == 1) {
			output = output.concat("-");
			output = output.concat(notes.get(0));
			output = output.concat("\n");
			return output;
		} else {
			for(int i = 0; i < notes.size(); i++) {
				output = output.concat("-");
				output = output.concat(notes.get(i));
				output = output.concat("\n");
			}
		}
		return output;
	}
	
	/**
	 * This gets the Owner of the Ticket
	 * @return		Owner of the Ticket
	 */
	public String getOwner() {
		return owner;
	}
	
	/** 
	 * This gets the Priority of the Ticket
	 * @return 	Priority of the Ticket
	 */
	public String getPriority() {
		if(priority == Priority.HIGH) {
			return "High";
		} else if(priority == Priority.LOW) {
			return "Low";
		} else if(priority == Priority.MEDIUM) {
			return "Medium";
		} else return "Urgent";
	}
	
	/**
	 * This gets the ResolutionCode for the Ticket
	 * @return		ResolutionCode of the Ticket
	 */
	public String getResolutionCode() {
		if(resolutionCode == ResolutionCode.CALLER_CLOSED) {
			return "Caller Closed";
		} else if(resolutionCode == ResolutionCode.COMPLETED) {
			return "Completed";
		} else if(resolutionCode == ResolutionCode.NOT_COMPLETED) {
			return "Not Completed";
		} else if(resolutionCode == ResolutionCode.NOT_SOLVED) {
			return "Not Solved";
		} else if(resolutionCode == ResolutionCode.SOLVED) {
			return "Solved";
		} else if(resolutionCode == ResolutionCode.WORKAROUND){
			return "Workaround";
		} else return null;
	}
	
	/**
	 * This gets the state that the Ticket is in
	 * @return		Ticket's state as a String
	 */
	public String getState() {
		return this.state.getStateName();
	}
	
	/**
	 * This gets the Ticket's Subject
	 * @return 	Ticket's Subject
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * This gets the Ticket's ID
	 * @return	ID of the Ticket
	 */
	public int getTicketId() {
		
		return this.ticketId;
	}
	
	/**
	 * This gets the Ticket's Type 
	 * @return	The TicketType for the Ticket
	 */
	public TicketType getTicketType() {
		return ticketType;
	}
	
	/**
	 * This gets the Tickets type as a String
	 * @return A String representation of the Ticket's type
	 */
	public String getTicketTypeString() {
		if(ticketType == TicketType.INCIDENT) {
			return "Incident";
		} else return "Request";
	}
	
	/**
	 * This sets the Caller of the Ticket
	 * @param caller	String to set the caller's name equal to
	 */
	private void setCaller(String caller) {
		if(caller == null) {
			throw new IllegalArgumentException();
		} else if(caller.isEmpty()) {
			throw new IllegalArgumentException();
		} else this.caller = caller;
	}
	
	/**
	 * This sets the CancellationCode for the Ticket
	 * @param cancellationCode 		The String representation of the CancellationCode to set for the Ticket
	 */
	private void setCancellationCode(String cancellationCode) {
		if(cancellationCode.contentEquals("Duplicate")) {
			this.cancellationCode = CancellationCode.DUPLICATE;
		} else if(cancellationCode.contentEquals("Inappropriate")) {
			this.cancellationCode = CancellationCode.INAPPROPRIATE;
		} else throw new IllegalArgumentException();
	}
	
	/**
	 * This sets the Category for the Ticket
	 * @param category		Category to set the Ticket to
	 */
	private void setCategory(String category) {
		if(category.contentEquals("Software")) {
			this.category = Category.SOFTWARE;
		} else if(category.contentEquals("Hardware")) {
			this.category = Category.HARDWARE;
		} else if(category.contentEquals("Network")) {
			this.category = Category.NETWORK;
		} else if(category.contentEquals("Inquiry")) {
			this.category = Category.INQUIRY;
		} else if(category.contentEquals("Database")) {
			this.category = Category.DATABASE;
		} else throw new IllegalArgumentException();
	}
	
	/**
	 * This sets the Owner of the Ticket 
	 * @param owner			Owner to set for the Ticket
	 */
	private void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * This sets the FeedbackCode for the Ticket
	 * @param feedbackCode			feedbackCode to set for the Ticket
	 */
	private void setFeedbackCode(String feedbackCode) {
		if(feedbackCode == null) {
			this.feedbackCode = null;
		} else if(feedbackCode.contentEquals("Awaiting Caller")) {
			this.feedbackCode = FeedbackCode.AWAITING_CALLER;
		} else if(feedbackCode.contentEquals("Awaiting Provider")) {
			this.feedbackCode = FeedbackCode.AWAITING_PROVIDER;
		} else if(feedbackCode.contentEquals("Awaiting Change")) {
			this.feedbackCode = FeedbackCode.AWAITING_CHANGE;
		} else throw new IllegalArgumentException();
			
	}
	
	/**
	 * This sets the Priority for the Ticket
	 * @param priority
	 */
	private void setPriority(String priority) {
		if(priority.contentEquals("High")) {
			this.priority = Priority.HIGH;
		} else if(priority.contentEquals("Low")) {
			this.priority = Priority.LOW;
		} else if(priority.contentEquals("Medium")) {
			this.priority = Priority.MEDIUM;
		} else if(priority.contentEquals("Urgent")) {
			this.priority = Priority.URGENT;
		} else throw new IllegalArgumentException();
	}
	
	/**
	 * This sets the resolutionCode for the Ticket
	 * @param resolutionCode		ResolutionCode to set for the Ticket
	 */
	private void setResolutionCode(String resolutionCode) {
		if(resolutionCode.contentEquals("Completed")) {
			this.resolutionCode = ResolutionCode.COMPLETED;
		} else if(resolutionCode.contentEquals("Not Completed")) {
			this.resolutionCode = ResolutionCode.NOT_COMPLETED;
		} else if(resolutionCode.contentEquals("Solved")) {
			this.resolutionCode = ResolutionCode.SOLVED;
		} else if(resolutionCode.contentEquals("Not Solved")) {
			this.resolutionCode = ResolutionCode.NOT_SOLVED;
		} else if(resolutionCode.contentEquals("Workaround")) {
			this.resolutionCode = ResolutionCode.WORKAROUND;
		} else if(resolutionCode.contentEquals("Caller Closed")) {
			this.resolutionCode = ResolutionCode.CALLER_CLOSED;
		} else throw new IllegalArgumentException();
	}
	
	/**
	 * This sets the state for the Ticket
	 * @param state		State the Ticket should be in
	 */
	private void setState(String state) {
		if (state.contentEquals(CANCELED_NAME)) {
			this.state = canceledState;
		} else if(state.contentEquals(WORKING_NAME)) {
			this.state = workingState;
		} else if(state.contentEquals(CLOSED_NAME)) {
			this.state = closedState;
		} else if(state.contentEquals(FEEDBACK_NAME)) {
			this.state = feedbackState;
		} else if(state.contentEquals(NEW_NAME)) {
			this.state = newState;
		} else if(state.contentEquals(RESOLVED_NAME)) {
			this.state = resolvedState;
		} else return;
	}
	
	/**
	 * This sets the subject of the Ticket
	 * @param subject		Subject for the Ticket
	 */
	private void setSubject(String subject) {
		if(subject == null) {
			throw new IllegalArgumentException();
		} else if(subject.isEmpty()) {
			throw new IllegalArgumentException();
		} else this.subject = subject;
	}
	
	/**
	 * This sets the TicketType for the Ticket
	 * @param ticketType		TicketType to set the ticket to
	 */
	private void setTicketType(String ticketType) {
		if(ticketType.contentEquals(TT_INCIDENT)) {
			this.ticketType = TicketType.INCIDENT;
		} else if(ticketType.contentEquals(TT_REQUEST)) {
			this.ticketType = TicketType.REQUEST;
		} else throw new IllegalArgumentException();
	}
	
	/**
	 * This creates a representation of a Ticket used in File saving and reading 
	 * @return String representation of a Ticket
	 */
	public String toString() {
		
		String output = "*" + ticketId + "#" + state.getStateName() + "#"  + this.getTicketTypeString() + "#" + subject + "#" + caller + "#" + getCategory()
		 + "#" + getPriority() + "#" + getOwner() + "#";

		if (getState().contentEquals(CANCELED_NAME)) {
			output = output + this.getCancellationCode();
		} else if(getState().contentEquals(CLOSED_NAME)) {
			output = output + this.getResolutionCode();
		} else if(getState().contentEquals(FEEDBACK_NAME)) {
			output = output + this.getFeedbackCode();
		} else if(getState().contentEquals(RESOLVED_NAME)) {
			output = output + this.getResolutionCode();
		} 
		output = output + "\n";
		output = output + this.getNotes();
		
		return output;
		
	}
	
	/**
	 * This updates the Ticket through the use of a Command
	 * @param command		Command to execute on the Ticket
	 */
	public void update(Command command) {
		state.updateState(command);
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
			return CANCELED_NAME;
		}
		
		/**
		 * This updates the State to the State indicated by the command passed
		 * @param command		Command you would like to execute on the state
		 */
		public void updateState(Command command) {
			throw new UnsupportedOperationException();
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
			return WORKING_NAME;
		}
		
		/**
		 * This updates the State to the State indicated by the command passed
		 * @param command		Command you would like to execute on the state
		 */
		public void updateState(Command command) {
			if(command.getCommand() == Command.CommandValue.FEEDBACK) {
				state = feedbackState;
				feedbackCode = command.getFeedbackCode();
				notes.add(command.getNote());
			} else if(command.getCommand() == Command.CommandValue.RESOLVE) {
				if(getTicketType() == TicketType.INCIDENT) {
					if(command.getResolutionCode() == ResolutionCode.COMPLETED) {
						throw new UnsupportedOperationException();
					} else if(command.getResolutionCode() == ResolutionCode.NOT_COMPLETED) {
						throw new UnsupportedOperationException();
					}
				} else if(command.getCommand() == Command.CommandValue.RESOLVE) {
					if(getTicketType() == TicketType.REQUEST) {
						if(command.getResolutionCode() == ResolutionCode.SOLVED) {
							throw new UnsupportedOperationException();
						} else if(command.getResolutionCode() == ResolutionCode.NOT_SOLVED) {
							throw new UnsupportedOperationException();
						} else if(command.getResolutionCode() == ResolutionCode.WORKAROUND) {
							throw new UnsupportedOperationException();
						}
					}
				}
				state = resolvedState;
				resolutionCode = command.getResolutionCode();
				notes.add(command.getNote());
			} else if(command.getCommand() == Command.CommandValue.CANCEL) {
				state = canceledState;
				cancellationCode = command.getCancellationCode();
				notes.add(command.getNote());
			} else throw new UnsupportedOperationException();
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
			return NEW_NAME;
		}
		
		/**
		 * This updates the State to the State indicated by the command passed
		 * @param command		Command you would like to execute on the state
		 */
		public void updateState(Command command) {
			if(command.getCommand() == Command.CommandValue.PROCESS) {
				state = workingState;
				owner = command.getOwnerId();
				notes.add(command.getNote());
			} else if(command.getCommand() == Command.CommandValue.CANCEL) {
				state = canceledState;
				cancellationCode = command.getCancellationCode();
				notes.add(command.getNote());
			} else throw new UnsupportedOperationException();
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
			return RESOLVED_NAME;
		}
		
		/**
		 * This updates the State to the State indicated by the command passed
		 * @param command		Command you would like to execute on the state
		 */
		public void updateState(Command command) {
			if(command.getCommand() == Command.CommandValue.FEEDBACK) {
				state = feedbackState;
				resolutionCode = null;
				feedbackCode = command.getFeedbackCode();
				notes.add(command.getNote());
			} else if(command.getCommand() == Command.CommandValue.REOPEN) {
				state = workingState;
				resolutionCode = null;
				notes.add(command.getNote());
			} else if(command.getCommand() == Command.CommandValue.CONFIRM) {
				state = closedState;
				notes.add(command.getNote());
			} else throw new UnsupportedOperationException();
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
			return CLOSED_NAME;
		}
		
		/**
		 * This updates the State to the State indicated by the command passed
		 * @param command		Command you would like to execute on the state
		 */
		public void updateState(Command command) {
			if(command.getCommand() == Command.CommandValue.REOPEN) {
				state = workingState;
				resolutionCode = null;
				cancellationCode = null;
				notes.add(command.getNote());
			} else throw new UnsupportedOperationException();
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
			return FEEDBACK_NAME;
		}
		
		/**
		 * This updates the State to the State indicated by the command passed
		 * @param command		Command you would like to execute on the state
		 */
		public void updateState(Command command) {
			if(command.getCommand() == Command.CommandValue.REOPEN) {
				feedbackCode = null;
				state = workingState;
				notes.add(command.getNote());
			} else if(command.getCommand() == Command.CommandValue.RESOLVE) {
				if(getTicketType() == TicketType.INCIDENT) {
					if(command.getResolutionCode() == ResolutionCode.COMPLETED) {
						throw new UnsupportedOperationException();
					} else if(command.getResolutionCode() == ResolutionCode.NOT_COMPLETED) {
						throw new UnsupportedOperationException();
					}
				} else if(getTicketType() == TicketType.REQUEST) {
					if(command.getResolutionCode() == ResolutionCode.NOT_SOLVED) {
						throw new UnsupportedOperationException();
					} else if(command.getResolutionCode() == ResolutionCode.SOLVED) {
						throw new UnsupportedOperationException();
					} else if(command.getResolutionCode() == ResolutionCode.WORKAROUND) {
						throw new UnsupportedOperationException();
					}
				}
				state = resolvedState;
				feedbackCode = null;
				resolutionCode = command.getResolutionCode();
				notes.add(command.getNote());
			} else if(command.getCommand() == Command.CommandValue.CANCEL) {
				state = canceledState;
				cancellationCode = command.getCancellationCode();
				feedbackCode = null;
				notes.add(command.getNote());
			} else throw new UnsupportedOperationException();
		}
	}
	
}
