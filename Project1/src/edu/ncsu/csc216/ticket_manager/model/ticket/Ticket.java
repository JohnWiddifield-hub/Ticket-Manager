package edu.ncsu.csc216.ticket_manager.model.ticket;

import java.util.ArrayList;

import edu.ncsu.csc216.ticket_manager.model.command.Command;
import edu.ncsu.csc216.ticket_manager.model.command.Command.CancellationCode;
import edu.ncsu.csc216.ticket_manager.model.command.Command.FeedbackCode;
import edu.ncsu.csc216.ticket_manager.model.command.Command.ResolutionCode;

public class Ticket {
	public static final String TT_REQUEST = "Request";
	public static final String TT_INCIDENT ="Incident";
	public static final String C_INQUIRY = "Inquiry";
	public static final String C_SOFTWARE = "Software";
	public static final String C_HARDWARE = "Hardware";
	public static final String C_NETWORK = "Network";
	public static final String C_DATABASE = "Database";
	public static final String P_URGENT = "Urgent";
	public static final String P_HIGH = "High";
	public static final String P_MEDIUM = "Medium";
	public static final String P_LOW = "Low";
	public static final String NEW_NAME = "New";
	public static final String WORKING_NAME = "Working";
	public static final String FEEDBACK_NAME = "Feedback";
	public static final String RESOLVED_NAME = "Resolved";
	public static final String CLOSED_NAME = "Closed";
	public static final String CANCELED_NAME = "Canceled";
	
	private static int counter = 1;
	private int ticketId;
	private String subject;
	private String caller;
	private String owner;
	private ArrayList<String> notes;
	private TicketState state;
	private Category category;
	private Priority priority;
	
	private FeedbackCode feedbackCode;
	private ResolutionCode resolutionCode;
	private CancellationCode cancellationCode;
	
	public enum Category { INQUIRY, SOFTWARE, HARDWARE, NETWORK, DATABASE }
	public enum Priority { URGENT, HIGH, MEDIUM, LOW }
	public enum TicketType { REQUEST, INCIDENT }
	
	public final NewState newState = null;
	public final WorkingState workingState = null;
	public final FeedbackState feedbackState = null;
	public final ResolvedState resolvedState = null;
	public final ClosedState closedState = null;
	public final CanceledState canceledState = null;
	
	public Ticket(int id, String state, String ticketType, String subject, String caller, String category, 
			String priority, String owner, String code, ArrayList<String> notes) {
		
	}
	
	public Ticket(TicketType ticketType, String subject, String caller, Category category, Priority priority, String note) {
		/*this.setCaller(caller);
		this.setSubject(subject);
		this.setTicketType(ticketType);
		this.setCategory(category);
		this.setPriority(priority);
		this.notes.add(note);*/
	}
	
	public static void incrementCounter() {
		counter++;
	}
	
	public static void setCounter(int cntr) {
		
	}

	public String getCaller() {
		return null;
	}
	
	public String getCancellationCode() {
		return null;
	}
	
	public String getCategory() {
		return null;
	}
	
	public String getFeedbackCode() {
		return null;
	}
	
	public String getNotes() {
		return null;
	}
	
	public String getOwner() {
		return null;
	}
	
	public String getPriority() {
		return null;
	}
	
	public String getResolutionCode() {
		return null;
	}
	
	public String getState() {
		return null;
	}
	
	public String getSubject() {
		return null;
	}
	
	public String getTicketId() {
		return null;
	}
	
	public String getTicketType() {
		return null;
	}
	
	public String getTicketTypeString() {
		return null;
	}
	
	private void setCaller(String caller) {
		
	}
	
	private void setCancellationCode(String cancellationCode) {
		
	}
	
	private void setCategory(String category) {
		
	}
	
	private void setOwner(String owner) {
		
	}
	
	private void setFeedbackCode(String feedbackCode) {
	
	}
	
	private void setPriority(String priority) {
		
	}
	
	private void setResolutionCode(String resolutionCode) {
		
	}
	
	private void setState(String state) {
		
	}
	
	private void setSubject(String subject) {
		
	}
	
	private void setTicketType(String ticketType) {
		
	}
	
	public String toString() {
		return null;
	}
	
	public void update(Command command) {
		
	}
	
	public class CanceledState implements TicketState{
		private CanceledState() {
			
		}
		
		public String getStateName() {
			return null;
		}
		
		public void updateState(Command command) {
			
		}
	}
	
	public class WorkingState implements TicketState{
		private WorkingState() {
			
		}
		
		public String getStateName() {
			return null;
		}
		
		public void updateState(Command command) {
			
		}
	}
	
	public class NewState implements TicketState{
		private NewState() {
			
		}
		
		public String getStateName() {
			return null;
		}
		
		public void updateState(Command command) {
			
		}
	}
	
	public class ResolvedState implements TicketState{
		private ResolvedState() {
			
		}
		
		public String getStateName() {
			return null;
		}
		
		public void updateState(Command command) {
			
		}
	}
	
	public class ClosedState implements TicketState{
		private ClosedState() {
			
		}
		
		public String getStateName() {
			return null;
		}
		
		public void updateState(Command command) {
			
		}
	}
	
	public class FeedbackState implements TicketState{
		private FeedbackState() {
			
		}
		
		public String getStateName() {
			return null;
		}
		
		public void updateState(Command command) {
			
		}
	}
	
}
