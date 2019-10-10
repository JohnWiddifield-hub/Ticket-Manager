package edu.ncsu.csc216.ticket_manager.model.command;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.ticket_manager.model.command.Command.CancellationCode;
import edu.ncsu.csc216.ticket_manager.model.command.Command.CommandValue;
import edu.ncsu.csc216.ticket_manager.model.command.Command.FeedbackCode;
import edu.ncsu.csc216.ticket_manager.model.command.Command.ResolutionCode;

/**
 * This class tests the Command class for proper functionality and correct implementation
 * as per the requirements
 * 
 * @author John Widdifield
 *
 */
public class CommandTest {

	/**Variable for the CommandValue to be used for tests set to a default value*/
	private CommandValue cV = CommandValue.PROCESS;
	/**Variable for the FeedbackCode to be used for tests set to a default value*/
	private FeedbackCode fC = FeedbackCode.AWAITING_CALLER;
	/**Variable for the ResolutionCode to be used for tests set to a default value*/
	private ResolutionCode rC = ResolutionCode.NOT_COMPLETED;
	/**Variable for the CancellationCode to be used for tests set to a default value*/
	private CancellationCode cC = CancellationCode.DUPLICATE;
	/**Variable for the ownerId to be used for tests set to a default value*/
	private String owner = "jdsmith1";
	/**Variable for the note to be used for tests set to a default value*/
	private String note = "My computer is on fire!";
	
	/**
	 * Tests the Command method for proper implementation based on the requirements
	 */
	@Test
	public void testCommand() {
		Command c = null;
		
		try {
			c = new Command(null, owner, fC, rC, cC, note);
			fail();
			} catch (IllegalArgumentException e) {
			assertTrue(c == null);
		}
		try {
			c = new Command(CommandValue.CANCEL, owner, fC, rC, null, note);
			fail();
			} catch (IllegalArgumentException e) {
				assertTrue(c == null);
			}
		try {
			c = new Command(CommandValue.CONFIRM, owner, fC, rC, null, note);
			} catch (IllegalArgumentException e) {
				fail();
			}
		
		c = null;
		
		try {
			c = new Command(CommandValue.RESOLVE, owner, fC, null, cC, note);
			fail();
			} catch (IllegalArgumentException e) {
				assertTrue(c == null);
			}
		try {
			c = new Command(CommandValue.PROCESS, owner, fC, null, cC, note);
			} catch (IllegalArgumentException e) {
				fail();
			}
		
		c = null;
		
		try {
			c = new Command(CommandValue.FEEDBACK, owner, null, rC, cC, note);
			fail();
			} catch (IllegalArgumentException e) {
				assertTrue(c == null);
			}
		try {
			c = new Command(CommandValue.CONFIRM, owner, null, rC, cC, note);
			} catch (IllegalArgumentException e) {
			fail();
			}
		
		c = null;
		
		try {
			c = new Command(CommandValue.PROCESS, null, fC, rC, cC, note);
			fail();
			} catch (IllegalArgumentException e) {
				assertTrue(c == null);
			}
		try {
			c = new Command(cV, "", fC, rC, cC, note);
			fail();
			} catch (IllegalArgumentException e) {
				assertTrue(c == null);
			}
		try {
			c = new Command(cV, owner, fC, rC, cC, null);
			fail();
			} catch (IllegalArgumentException e) {
				assertTrue(c == null);
			}
		try {
			c = new Command(cV, owner, fC, rC, cC, "");
			fail();
			} catch (IllegalArgumentException e) {
				assertTrue(c == null);
			}
		try {
			c = new Command(cV, owner, fC, rC, cC, note);
			} catch (IllegalArgumentException e) {
				fail();
			}
		try {
			c = new Command(CommandValue.FEEDBACK, owner, fC, rC, cC, note);
			} catch (IllegalArgumentException e) {
				fail();
			}
		try {
			c = new Command(CommandValue.RESOLVE, owner, fC, rC, cC, note);
			} catch (IllegalArgumentException e) {
				fail();
			}
		try {
			c = new Command(CommandValue.CANCEL, owner, fC, rC, cC, note);
			} catch (IllegalArgumentException e) {
				fail();
			}
		
		
	}

	/**
	 * Tests the getOwnerId method for proper implementation based on the requirements
	 */
	@Test
	public void testGetOwnerId() {
		Command c = new Command(CommandValue.PROCESS, owner, fC, rC, cC, note);
		assertEquals(owner, c.getOwnerId());
	}

	/**
	 * Tests the getNote method for proper implementation based on the requirements
	 */
	@Test
	public void testGetNote() {
		Command c = new Command(CommandValue.PROCESS, owner, fC, rC, cC, note);
		assertEquals(note, c.getNote());
	}

	/**
	 * Tests the getCommand method for proper implementation based on the requirements
	 */
	@Test
	public void testGetCommand() {
		Command c = new Command(CommandValue.PROCESS, owner, fC, rC, cC, note);
		assertEquals(CommandValue.PROCESS, c.getCommand());
	}

	/**
	 * Tests the getResolutionCode method for proper implementation based on the requirements
	 */
	@Test
	public void testGetResolutionCode() {
		Command c = new Command(CommandValue.PROCESS, owner, fC, rC, cC, note);
		assertEquals(c.getResolutionCode(), rC);
	}

	/**
	 * Tests the getFeedbackCode method for proper implementation based on the requirements
	 */
	@Test
	public void testGetFeedbackCode() {
		Command c = new Command(CommandValue.PROCESS, owner, fC, rC, cC, note);
		assertEquals(c.getFeedbackCode(), fC);
	}

	/**
	 * Tests the getCancellationCode method for proper implementation based on the requirements
	 */
	@Test
	public void testGetCancellationCode() {
		Command c = new Command(CommandValue.PROCESS, owner, fC, rC, cC, note);
		assertEquals(cC, c.getCancellationCode());
	}

}
