package edu.ncsu.csc216.ticket_manager.model.ticket;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

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
		note.add("-Me have bad computer\n");
		note.add("-Me want bigger computer\n");
		note.add("-Me need u get me this computer\n");
		notesStr.concat(note.get(0));
		notesStr.concat(note.get(1));
		notesStr.concat(note.get(2));
		
		Ticket t = new Ticket(1, "New", "Request", "Me want new computer", "jfwiddif", "Hardware", 
				"High", "bbaggins", null, note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "New");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getTicketTypeString(), "Request");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "High");
		assertEquals(t.getTicketId(), "1");
		assertEquals(t.getCategory(), "Hardware");
		
		t = new Ticket(2, "New", "Incident", "Me want new computer", "jfwiddif", "Software", 
				"Medium", "bbaggins", null, note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "New");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Medium");
		assertEquals(t.getTicketId(), "2");
		assertEquals(t.getCategory(), "Software");
		
		
		t = new Ticket(3, "New", "Incident", "Me want new computer", "jfwiddif", "Database", 
				"Low", null, "", note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "New");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "3");
		assertEquals(t.getCategory(), "Database");
		
		t = new Ticket(4, "New", "Request", "Me want new computer", "jfwiddif", "Inquiry", 
				"Urgent", "", "", note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "New");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Request");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Urgent");
		assertEquals(t.getTicketId(), "4");
		assertEquals(t.getCategory(), "Inquiry");
		
		
		t = new Ticket(4, "New", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "", "", note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "New");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "4");
		assertEquals(t.getCategory(), "Network");
		
		t = new Ticket(5, "Working", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "", note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Working");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "5");
		assertEquals(t.getCategory(), "Network");
		
		try {
			t = new Ticket(6, "Working", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "", "", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "5");
		}
		
		try {
			t = new Ticket(6, "Bebop", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "bbaggins", "", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "5");
		}
		
		try {
			t = new Ticket(6, "Working", "Beboop", "Me want new computer", "jfwiddif", "Network", 
					"Low", "bbaggins", "", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "5");
		}
		
		try {
			t = new Ticket(6, "Working", "Incident", "Me want new computer", "jfwiddif", "Beboop", 
					"Boopbeep", "bbaggins", "", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "5");
		}
		
		try {
			t = new Ticket(6, "Working", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "bbaggins", "beepboop", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "5");
		}
		
		try {
			t = new Ticket(6, "Working", "Incident", "", "jfwiddif", "Network", 
					"Low", "bbaggins", "", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "5");
		}
		
		try {
			t = new Ticket(6, "Working", "Incident", "Me want new computer", "", "Network", 
					"Low", "bbaggins", "", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "5");
		}
		
		try {
			t = new Ticket(6, "Feedback", "Incident", "Me want new computer", "", "Network", 
					"Low", "bbaggins", "Awaiting Caller", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "5");
		}
		
		try {
			t = new Ticket(6, "Resolved", "Incident", "Me want new computer", "", "Network", 
					"Low", "bbaggins", "Completed", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "5");
		}
		
		try {
			t = new Ticket(6, "Closed", "Incident", "Me want new computer", "", "Network", 
					"Low", "bbaggins", "Completed", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "5");
		}
		
		t = new Ticket(6, "Canceled", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Duplicate", note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Canceled");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "6");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getCancellationCode(), "Duplicate");
		
		
		t = new Ticket(7, "Canceled", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Inappropriate", note);
		
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Canceled");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "7");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		
		try {
			t = new Ticket(8, "Canceled", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "bbaggins", "Awaiting Caller", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "7");
		}
		
		try {
			t = new Ticket(-1, "Canceled", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "bbaggins", "Inappropriate", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "7");
		}
		
		try {
			t = new Ticket(8, "Canceled", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"beeboop", "bbaggins", "Inappropriate", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "7");
		}
		
		t = new Ticket(8, "Feedback", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Awaiting Provider", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Feedback");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "8");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getFeedbackCode(), "Awaiting Provider");
		
		try {
			t = new Ticket(9, "Feedback", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "", "Awaiting Provider", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "8");
		}
		
		t = new Ticket(9, "Feedback", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Awaiting Caller", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Feedback");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "9");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getFeedbackCode(), "Awaiting Caller");
		
		t = new Ticket(10, "Feedback", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Awaiting Change", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Feedback");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "10");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getFeedbackCode(), "Awaiting Change");
		
		try {
			t = new Ticket(11, "Feedback", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "bbaggins", "berpderp", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "10");
		}
		
		try {
			t = new Ticket(11, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "", "Workaround", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "10");
		}
		
		try {
			t = new Ticket(11, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
					"Low", "", "Not Solved", note);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "10");
		}
		
		t = new Ticket(11, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Not Completed", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Resolved");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "11");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Not Completed");
		
		t = new Ticket(12, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Solved", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Resolved");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "12");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Solved");

		t = new Ticket(13, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Not Solved", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Resolved");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "13");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Not Solved");

		t = new Ticket(14, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Workaround", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Resolved");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "14");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Workaround");
		
		t = new Ticket(15, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Caller Closed", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Resolved");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "15");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Caller Closed");
		
		t = new Ticket(16, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Completed", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Resolved");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "16");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Completed");
		
		t = new Ticket(17, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Not Completed", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Closed");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "17");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Not Completed");
		
		t = new Ticket(18, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Solved", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Closed");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "18");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Solved");

		t = new Ticket(19, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Not Solved", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Closed");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "19");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Not Solved");

		t = new Ticket(20, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Workaround", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Closed");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "20");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Workaround");
		
		t = new Ticket(21, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Caller Closed", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Closed");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "21");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Caller Closed");
		
		t = new Ticket(22, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "Completed", note);
			
		assertEquals(t.getCaller(), "jfwiddif");
		assertEquals(t.getState(), "Closed");
		assertEquals(t.getNotes(), notesStr);
		assertEquals(t.getTicketTypeString(), "Incident");
		assertEquals(t.getSubject(), "Me want new computer");
		assertEquals(t.getPriority(), "Low");
		assertEquals(t.getTicketId(), "22");
		assertEquals(t.getCategory(), "Network");
		assertEquals(t.getOwner(), "bbaggins");
		assertEquals(t.getResolutionCode(), "Completed");
		
		try {
			
			t = new Ticket(23, "Closed", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "", note);
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "22");
		}
		
		try {
			
			t = new Ticket(23, "Resolved", "Incident", "Me want new computer", "jfwiddif", "Network", 
				"Low", "bbaggins", "", note);
		} catch (IllegalArgumentException e) {
			assertEquals(t.getTicketId(), "22");
		}
	}
	
	

	/**
	 * Tests the short constructor for Ticket
	 */
	@Test
	public void testTicketTicketTypeStringStringCategoryPriorityString() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the incrementCounter method for correct implemintation
	 */
	@Test
	public void testIncrementCounter() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the setCounter method for correct implemintation
	 */
	@Test
	public void testSetCounter() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getCaller method for correct implemintation
	 */
	@Test
	public void testGetCaller() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getCancellationCode method for correct implemintation
	 */
	@Test
	public void testGetCancellationCode() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getCategory method for correct implemintation
	 */
	@Test
	public void testGetCategory() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getFeedbackCode method for correct implemintation
	 */
	@Test
	public void testGetFeedbackCode() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getNotes method for correct implemintation
	 */
	@Test
	public void testGetNotes() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getOwner method for correct implemintation
	 */
	@Test
	public void testGetOwner() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getPriority method for correct implemintation
	 */
	@Test
	public void testGetPriority() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getResolutionCode method for correct implemintation
	 */
	@Test
	public void testGetResolutionCode() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getState method for correct implemintation
	 */
	@Test
	public void testGetState() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getSubject method for correct implemintation
	 */
	@Test
	public void testGetSubject() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getTicketId method for correct implemintation
	 */
	@Test
	public void testGetTicketId() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getTicketType method for correct implemintation
	 */
	@Test
	public void testGetTicketType() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getTicketTypeString method for correct implemintation
	 */
	@Test
	public void testGetTicketTypeString() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the toString method for correct implemintation
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the update method for correct implemintation
	 */
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
