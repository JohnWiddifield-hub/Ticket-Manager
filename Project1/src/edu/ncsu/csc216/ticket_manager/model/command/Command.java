package edu.ncsu.csc216.ticket_manager.model.command;

public class Command {
	
	public static final String F_CALLER = "Awaiting Caller";
	public static final String F_CHANGE = "Awaiting Change";
	public static final String F_PROVIDER = "Awaiting Provider";
	public static final String RC_COMPLETED = "Completed";
	public static final String RC_NOT_COMPLETED = "Not Completed";
	public static final String RC_SOLVED = "Solved";
	public static final String RC_WORKAROUND = "Workaround";
	public static final String RC_NOT_SOLVED = "Not Solved";
	public static final String RC_CALLER_CLOSED = "Caller Closed";
	public static final String CC_DUPLICATE = "Duplicate";
	public static final String CC_INAPPROPRIATE = "Inappropriate";
	private String ownerId;
	private String note;

	public enum CommandValue { PROCESS, FEEDBACK, RESOLVE, CONFIRM, REOPEN, CANCEL }

	public enum FeedbackCode { AWAITING_CALLER, AWAITING_CHANGE, AWAITING_PROVIDER }

	public enum ResolutionCode { COMPLETED, NOT_COMPLETED, SOLVED, WORKAROUND, NOT_SOLVED, CALLER_CLOSED }

	public enum CancellationCode { DUPLICATE, INAPPROPRIATE }
	
	
	public Command(CommandValue cV, String ownerId, FeedbackCode fC, ResolutionCode rC, CancellationCode cC, String note) {
		
	}
	
	
	public String getOwnerId() {
		return ownerId;
	}


	public String getNote() {
		return note;
	}

	public CommandValue getCommand() {
		return null;
	}
	
	public ResolutionCode getResolutionCode() {
		return null;
	}
	
	public FeedbackCode getFeedbackCode() {
		return null;
	}
	
	public CancellationCode getCancellationCode() {
		return null;
	}
	
	
	
}

