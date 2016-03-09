package Mail;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class EmailMessageTest {

	@Test
	public void testConvert() {
		
			System.out.println("test");
			EmailMessage m = new EmailMessage("t");
			String test = "06:19:26 am";
			
			assertEquals("00:00:00 Am/Pm expected", test, m.convert(m.s, "am"));
		
	}

	@Test
	public void testGetS() {
		EmailMessage m = new EmailMessage();
		assertTrue(m.getMessage() instanceof String);
	}

}
