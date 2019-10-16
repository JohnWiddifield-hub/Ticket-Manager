package edu.ncsu.csc216.ticket_manager.model.ticket;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.ncsu.csc216.ticket_manager.model.command.Command;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Category;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.Priority;
import edu.ncsu.csc216.ticket_manager.model.ticket.Ticket.TicketType;

/**
 * This class tests the Ticket class for correct method implementation and for
 * proper functionality.
 * 
 * @author John Widdifield
 *
 */
public class TicketTest {

	/**
	 * Tests the long constructor for the Ticket class
	 */
	@Test
	public void testTicketIntStringStringStringStringStringStringStringStringArrayListOfString() {
		ArrayList<String> note = new ArrayList<String>();
		String notesStr = "";
		note.add("-Me have bad computer");
		note.add("-Me want bigger computer");
		note.add("-Me need u get me this computer");
		notesStr = notesStr.concat(note.get(0));
		//notesStr = notesStr.concat("\n");
		notesStr = notesStr.concat(note.get(1));
		//notesStr = notesStr.concat("\n");
		notesStr = notesStr.concat(note.get(2));
		//notesStr = notesStr.concat("\n");
		
		ArrayList<String> note2 = new ArrayList<String>();
		String notr = "-a note";
		notr = notr.concat("\n");
		note2.add(notr);
		
		Ticket t = new Ticket(1, "New", "Request", "Me want new computer", "jfwiddif", "Hardware", 
				"High", "bbaggins", null, note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "New");
		//assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getTicketTypeString(), "Request");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "High");
		assertEquals(t.getTicketId(), 1);
		assertEquals(t.getCategory(), "Hardware");
		
		t = new Ticket(2, "New", "Incident", "Me want new computer", "jfwiddif", "Software", 
				"Medium", "bbaggins", null, note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "New");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Medium");
		assertEquals(t.getTicketId(), 2);
		assertEquals(t.getCategory(), "Software");
		
		
		t = new Ticket(3, "New", "Incident", "Me want new computer", "jfwiddif", "Database", 
				"Low", null, "", note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "New");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 3);
		assertEquals(t.getCategory(), "Database");
		
		t = new Ticket(4, "New", "Request", "Me want new computer", "jfwiddif", "Inquiry", 
				"Urgent", "", "", note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "New");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Request");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Urgent");
		assertEquals(t.getTicketId(), 4);
		assertEquals(t.getCategory(), "Inquiry");
		
		
		t = new Ticket(4, "New", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "", "", note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "New");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 4);
		assertEquals(t.getCategory(), "Network");
		
		t = new Ticket(5, "Working", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "", note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Working");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 5);
		assertEquals(t.getCategory(), "Network");
		
		try {
			t = new Ticket(6, "Working", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "", "", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 5);
		}
		
		try {
			t = new Ticket(6, "Bebop", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "bbaggins", "", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 5);
		}
		
		try {
			t = new Ticket(6, "Working", "Beboop", "Me want new computer", "jfwiddif", "Network", 
					"Low", "bbaggins", "", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 5);
		}
		
		try {
			t = new Ticket(6, "Working", "Incident", "Me want new computer", "jfwiddif", "Beboop", 
					"Boopbeep", "bbaggins", "", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 5);
		}
		
		try {
			t = new Ticket(6, "Working", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "bbaggins", "beepboop", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 5);
		}
		
		try {
			t = new Ticket(6, "Working", "Incident", "", "jfwiddif", "Network", 
					"Low", "bbaggins", "", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 5);
		}
		
		try {
			t = new Ticket(6, "Working", "Incident", "Me want new computer", "", "Network", 
					"Low", "bbaggins", "", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 5);
		}
		
		try {
			t = new Ticket(6, "Feedback", "Incident", "Me want new computer", "", "Network", 
					"Low", "bbaggins", "Awaiting Caller", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 5);
		}
		
		try {
			t = new Ticket(6, "Resolved", "Incident", "Me want new computer", "", "Network", 
					"Low", "bbaggins", "Completed", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 5);
		}
		
		try {
			t = new Ticket(6, "Closed", "Incident", "Me want new computer", "", "Network", 
					"Low", "bbaggins", "Completed", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 5);
		}
		
		t = new Ticket(6, "Canceled", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Duplicate", note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Canceled");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 6);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getCancellationCode(), "Duplicate");
		
		
		t = new Ticket(7, "Canceled", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Inappropriate", note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Canceled");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 7);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		
		try {
			t = new Ticket(8, "Canceled", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "bbaggins", "Awaiting Caller", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 7);
		}
		
		try {
			t = new Ticket(-1, "Canceled", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "bbaggins", "Inappropriate", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 7);
		}
		
		try {
			t = new Ticket(8, "Canceled", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"beeboop", "bbaggins", "Inappropriate", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 7);
		}
		
		t = new Ticket(8, "Feedback", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Awaiting Provider", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Feedback");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 8);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getFeedbackCode(), "Awaiting Provider");
		
		try {
			t = new Ticket(9, "Feedback", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "", "Awaiting Provider", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 8);
		}
		
		t = new Ticket(9, "Feedback", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Awaiting Caller", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Feedback");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 9);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getFeedbackCode(), "Awaiting Caller");
		
		t = new Ticket(10, "Feedback", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Awaiting Change", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Feedback");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 10);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getFeedbackCode(), "Awaiting Change");
		
		try {
			t = new Ticket(11, "Feedback", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "bbaggins", "berpderp", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 10);
		}
		
		try {
			t = new Ticket(11, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "", "Workaround", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 10);
		}
		
		try {
			t = new Ticket(11, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "", "Not Solved", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 10);
		}
		
		t = new Ticket(11, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Not Completed", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Resolved");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 11);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Not Completed");
		
		t = new Ticket(12, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Solved", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Resolved");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 12);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Solved");

		t = new Ticket(13, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Not Solved", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Resolved");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 13);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Not Solved");

		t = new Ticket(14, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Workaround", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Resolved");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 14);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Workaround");
		
		t = new Ticket(15, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Caller Closed", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Resolved");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 15);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Caller Closed");
		
		t = new Ticket(16, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Completed", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Resolved");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 16);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Completed");
		
		t = new Ticket(17, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Not Completed", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Closed");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 17);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Not Completed");
		
		t = new Ticket(18, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Solved", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Closed");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 18);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Solved");

		t = new Ticket(19, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Not Solved", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Closed");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 19);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Not Solved");

		t = new Ticket(20, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Workaround", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Closed");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 20);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Workaround");
		
		t = new Ticket(21, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Caller Closed", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Closed");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 21);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Caller Closed");
		
		t = new Ticket(22, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Completed", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Closed");
	//	assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 22);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Completed");
		
		try {
			
			t = new Ticket(23, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "", note);
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 22);
		}
		
		try {
			
			t = new Ticket(23, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "", note);
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), 22);
		}
		
		t = new Ticket(22, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Completed", note2);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Closed");
	//	assertEquals(t.getNotes(), notr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), 22);
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Completed");
	//	assertEquals(t.getNotes(), note2.get(0));
	}
	
	

	/**
	 * Tests the short constructor for Ticket
	 */
	@Test
	public void testTicketTicketTypeStringStringCategoryPriorityString() {
		
		Ticket ticket = new Ticket(TicketType.INCIDENT, "subject", "caller", 
				Category.DATABASE, Priority.HIGH, "note");
		
		assertEquals(ticket.getTicketType(), TicketType.INCIDENT);
		assertEquals(ticket.getSubject(), "subject");
		assertEquals(ticket.getCaller(), "caller");
		assertEquals(ticket.getCategory(), "Database");
		assertEquals(ticket.getPriority(), "High");
		
		try {
			ticket = new Ticket(null, "subject", "caller", 
					Category.DATABASE, Priority.HIGH, "note");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(ticket.getTicketType(), TicketType.INCIDENT);
		}
		
		try {
			new Ticket(TicketType.INCIDENT, "subject", "caller", null, 
					Priority.URGENT, "note");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(ticket.getTicketType(), TicketType.INCIDENT);
		}
		
				
	}

	/**
	 * Tests the toString method for correct implemintation
	 */
	@Test
	public void testToString() {
		ArrayList<String> note = new ArrayList<String>();
		note.add("Me have bad computer");
		note.add("Me want bigger computer");
		note.add("Me need u get me this computer");
		
		Ticket t = new Ticket(1, "New", "Request", "Me want new computer", "jfwiddif", "Hardware", 
				"High", "bbaggins", null, note);
		
		String truString = "*1#New#Request#Me want new computer#jfwiddif#Hardware#High#bbaggins#"
				+ "\n-Me have bad computer\n-Me want bigger computer\n-Me need u get me this computer\n";
		assertEquals(t.toString(), truString);

	}
	
	/**
	 * Tests the getNotes method for proper returning of notes.
	 */
	@Test
	public void testGetNotes() {
		ArrayList<String> note = new ArrayList<String>();
		note.add("Me have bad computer");
		note.add("Me want bigger computer");
		note.add("Me need u get me this computer");
		
		Ticket t = new Ticket(1, "New", "Request", "Me want new computer", "jfwiddif", "Hardware", 
				"High", "bbaggins", null, note);
		
		assertEquals(t.getNotes(), "-Me have bad computer\n-Me want bigger computer\n-Me need u get me this computer\n");
		
		ArrayList<String> note2 = new ArrayList<String>();
		note2.add("Me need u get me this computer");
		
		t = new Ticket(1, "New", "Request", "Me want new computer", "jfwiddif", "Hardware", 
				"High", "bbaggins", null, note2);
		
		assertEquals(t.getNotes(), "-Me need u get me this computer\n");
	}
	
	@Test
	public void testStatePattern() {
		Ticket t = new Ticket(TicketType.INCIDENT, "subject", "caller", 
				Category.NETWORK, Priority.HIGH, "note");
		Command c;
		
		assertEquals(t.getState(), "New");
		c = new Command(Command.CommandValue.PROCESS, "ownerId", null, null, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Working");
		assertEquals(t.getOwner(), "ownerId");
		
		c = new Command(Command.CommandValue.RESOLVE, null, null, Command.ResolutionCode.SOLVED, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Resolved");
		assertEquals(t.getOwner(), "ownerId");
		assertEquals(t.getResolutionCode(), "Solved");
		
		c = new Command(Command.CommandValue.FEEDBACK, null, Command.FeedbackCode.AWAITING_CALLER, null, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Feedback");
		assertEquals(t.getOwner(), "ownerId");
		assertEquals(t.getFeedbackCode(), "Awaiting Caller");
		
		
		t = new Ticket(TicketType.INCIDENT, "subject", "caller", 
				Category.NETWORK, Priority.HIGH, "note");
		c = new Command(Command.CommandValue.PROCESS, "ownerId2", null, null, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Working");
		assertEquals(t.getOwner(), "ownerId2");
		
		c = new Command(Command.CommandValue.RESOLVE, null, null, Command.ResolutionCode.COMPLETED, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Resolved");
		assertEquals(t.getOwner(), "ownerId2");
		assertEquals(t.getResolutionCode(), "Completed");
		
		c = new Command(Command.CommandValue.CONFIRM, null, null, null, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Closed");
		assertEquals(t.getOwner(), "ownerId2");
		assertEquals(t.getResolutionCode(), "Completed");
		
		c = new Command(Command.CommandValue.REOPEN, "ownerId2", null, null, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Working");
		assertEquals(t.getOwner(), "ownerId2");
		
		t = new Ticket(TicketType.REQUEST, "subject", "caller", 
				Category.NETWORK, Priority.HIGH, "note");
		c = new Command(Command.CommandValue.CANCEL, null, null, null, Command.CancellationCode.DUPLICATE, "a note");
		t.update(c);
		assertEquals(t.getState(), "Canceled");
		assertEquals(t.getCancellationCode(), "Duplicate");
		
		t = new Ticket(TicketType.REQUEST, "subject", "caller", 
				Category.NETWORK, Priority.HIGH, "note");
		c = new Command(Command.CommandValue.CANCEL, null, null, null, Command.CancellationCode.INAPPROPRIATE, "a note");
		t.update(c);
		assertEquals(t.getState(), "Canceled");
		assertEquals(t.getCancellationCode(), "Inappropriate");
		
		t = new Ticket(TicketType.REQUEST, "subject", "caller", 
				Category.NETWORK, Priority.HIGH, "note");
		c = new Command(Command.CommandValue.PROCESS, "owner", null, null, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Working");
		assertEquals(t.getOwner(), "owner");
		
		c = new Command(Command.CommandValue.CANCEL, null, null, null, Command.CancellationCode.DUPLICATE, "a note");
		t.update(c);
		assertEquals(t.getState(), "Canceled");
		assertEquals(t.getCancellationCode(), "Duplicate");
		
		t = new Ticket(TicketType.REQUEST, "subject", "caller", 
				Category.NETWORK, Priority.HIGH, "note");
		c = new Command(Command.CommandValue.PROCESS, "owner", null, null, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Working");
		assertEquals(t.getOwner(), "owner");
		
		c = new Command(Command.CommandValue.CANCEL, null, null, null, Command.CancellationCode.INAPPROPRIATE, "a note");
		t.update(c);
		assertEquals(t.getState(), "Canceled");
		assertEquals(t.getCancellationCode(), "Inappropriate");
		
		t = new Ticket(TicketType.REQUEST, "subject", "caller", 
				Category.NETWORK, Priority.HIGH, "note");
		c = new Command(Command.CommandValue.PROCESS, "owner", null, null, null, "a note");
		t.update(c);
		
		c = new Command(Command.CommandValue.RESOLVE, null, null, Command.ResolutionCode.SOLVED, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Resolved");
		assertEquals(t.getOwner(), "owner");
		assertEquals(t.getResolutionCode(), "Solved");
		
		c = new Command(Command.CommandValue.FEEDBACK, null, Command.FeedbackCode.AWAITING_CALLER, null, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Feedback");
		assertEquals(t.getOwner(), "owner");
		assertEquals(t.getFeedbackCode(), "Awaiting Caller");
		
		c = new Command(Command.CommandValue.REOPEN, null, null, null, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Working");
		assertEquals(t.getOwner(), "owner");
		
		c = new Command(Command.CommandValue.FEEDBACK, null, Command.FeedbackCode.AWAITING_CHANGE, null, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Feedback");
		assertEquals(t.getOwner(), "owner");
		assertEquals(t.getFeedbackCode(), "Awaiting Change");
		
		c = new Command(Command.CommandValue.RESOLVE, null, null, Command.ResolutionCode.SOLVED, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Resolved");
		assertEquals(t.getOwner(), "owner");
		assertEquals(t.getResolutionCode(), "Caller Closed");
		
		c = new Command(Command.CommandValue.FEEDBACK, null, Command.FeedbackCode.AWAITING_CALLER, null, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Feedback");
		assertEquals(t.getOwner(), "owner");
		assertEquals(t.getFeedbackCode(), "Awaiting Caller");
		
		c = new Command(Command.CommandValue.CANCEL, null, null, null, Command.CancellationCode.DUPLICATE, "a note");
		t.update(c);
		assertEquals(t.getState(), "Canceled");
		assertEquals(t.getOwner(), "owner");
		
		try {
			c = new Command(Command.CommandValue.REOPEN, null, null, null, null, "a note");
			t.update(c);
			fail();
		} catch (UnsupportedOperationException e) {
			assertEquals(t.getState(), "Canceled");
		}
		
		t = new Ticket(TicketType.REQUEST, "subject", "caller", 
				Category.NETWORK, Priority.HIGH, "note");
		c = new Command(Command.CommandValue.PROCESS, "owner", null, null, null, "a note");
		t.update(c);
		
		c = new Command(Command.CommandValue.RESOLVE, null, null, Command.ResolutionCode.NOT_COMPLETED, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Resolved");
		assertEquals(t.getOwner(), "owner");
		assertEquals(t.getResolutionCode(), "Not Completed");
		
		c = new Command(Command.CommandValue.REOPEN, null, null, null, null, "a note");
		t.update(c);
		assertEquals(t.getState(), "Working");
		assertEquals(t.getOwner(), "owner");
	}


}
