

import static org.junit.Assert.*;

import java.util.TimeZone;

import org.junit.Ignore;
import org.junit.Test;

public class EmailMessageTest {

	

	@Test
	public void testGetS() {
		EmailMessage m = new EmailMessage(40.6928, -73.9903, TimeZone.getDefault());
		System.out.println(m.getMessage());
		assertTrue(m.getMessage() instanceof String);
	}

}
