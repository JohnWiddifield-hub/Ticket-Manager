package edu.ncsu.csc216.ticket_manager.model.command;
 /**
  * This class is used for representing a command that a user may make that may initiate a state
  * for a ticket object.  It is also used for encapsulating the information about these commands.
  * 
  * @author John Widdifield
  *
  */
public class Command {
	/**A constant String representation of state for FeedbackCode*/
	public static final String F_CALLER = "Awaiting Caller";
	/**A constant String representation of state for FeedbackCode*/
	public static final String F_CHANGE = "Awaiting Change";
	/**A constant String representation of state for FeedbackCode*/
	public static final String F_PROVIDER = "Awaiting Provider";
	/**A constant String representation of state for ResolutionCode*/
	public static final String RC_COMPLETED = "Completed";
	/**A constant String representation of state for ResolutionCode*/
	public static final String RC_NOT_COMPLETED = "Not Completed";
	/**A constant String representation of state for ResolutionCode*/
	public static final String RC_SOLVED = "Solved";
	/**A constant String representation of state for ResolutionCode*/
	public static final String RC_WORKAROUND = "Workaround";
	/**A constant String representation of state for ResolutionCode*/
	public static final String RC_NOT_SOLVED = "Not Solved";
	/**A constant String representation of state for ResolutionCode*/
	public static final String RC_CALLER_CLOSED = "Caller Closed";
	/**A constant String representation of state for CancellationCode*/
	public static final String CC_DUPLICATE = "Duplicate";
	/**A constant String representation of state for CancellationCode*/
	public static final String CC_INAPPROPRIATE = "Inappropriate";
	
	/** The owners ID */
	private String ownerId;
	/** The note brought by the user */
	private String note;

	/** The enumeration for all possible values for a CommandValue */
	public enum CommandValue { PROCESS, FEEDBACK, RESOLVE, CONFIRM, REOPEN, CANCEL }
	/** The enumeration for all possible values for a FeedbackCode */
	public enum FeedbackCode { AWAITING_CALLER, AWAITING_CHANGE, AWAITING_PROVIDER }
	/** The enumeration for all possible values for a ResolutionCode */
	public enum ResolutionCode { COMPLETED, NOT_COMPLETED, SOLVED, WORKAROUND, NOT_SOLVED, CALLER_CLOSED }
	/** The enumeration for all possible values for a CancellationCode */
	public enum CancellationCode { DUPLICATE, INAPPROPRIATE }
	/** The current CommandValue of the command */
	private CommandValue cV;
	/** The current FeedbackCode of the command */
	private FeedbackCode fC;
	/** The current ResolutionCode of the command */
	private ResolutionCode rC;
	/** The current CancellationCode of the command */
	private CancellationCode cC;
	
	/**
	 * Constructs a command for a transition of state.
	 * @param cV				CommandValue of the command
	 * @param ownerId			The owner's Id 
	 * @param fC				FeedbackCode of the command
	 * @param rC				ResolutionCode of the command
	 * @param cC				CancellationCode of the command
	 * @param note				Added notes for the command
	 * @throws IllegalArgumentException if there are two commands which cannot be executed at the same time such as
	 * 			having a CommandValue of FEEDBACK with a null feedbackCode.
	 */
	public Command(CommandValue cV, String ownerId, FeedbackCode fC, ResolutionCode rC, CancellationCode cC, String note) {
		if(cV == null) {
			throw new IllegalArgumentException();
		} else if(cV == CommandValue.PROCESS && (ownerId.isEmpty() || ownerId == null)) {
			throw new IllegalArgumentException();
		} else if(cV == CommandValue.FEEDBACK && fC == null) {
			throw new IllegalArgumentException();
		} else if(cV == CommandValue.RESOLVE && rC == null) {
			throw new IllegalArgumentException();
		} else if(cV == CommandValue.CANCEL && cC == null) {
			throw new IllegalArgumentException();
		} else if(note.isEmpty() || note == null) {
			throw new IllegalArgumentException();
		}
		
		this.cV = cV;
		this.fC = fC;
		this.rC = rC;
		this.cC = cC;
		this.ownerId = ownerId;
		this.note = note;
	}
	
	/** 
	 * This gets the owner's ID.
	 * @return owner's ID
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * This gets the note for the command.
	 * @return note for command
	 */
	public String getNote() {
		return note;
	}
	
	/**
	 * This gets the CommandValue for the command.
	 * @return CommandValue of Command
	 */
	public CommandValue getCommand() {
		return this.cV;
	}
	
	/**
	 * This gets the ResolutionCode for the Command
	 * @return ResolutionCode for Command
	 */
	public ResolutionCode getResolutionCode() {
		return this.rC
	}
	
	/**
	 * This gets the FeedbackCode for the Command
	 * @return FeedbackCode for Command
	 */
	public FeedbackCode getFeedbackCode() {
		return this.fC;
	}
	
	/**
	 * This gets the CancellationCode for the Command
	 * @return CancellationCode for the Command
	 */
	public CancellationCode getCancellationCode() {
		return this.cC;
	}
	
	
	
}

