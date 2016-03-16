

import static org.junit.Assert.*;

import java.util.TimeZone;

import org.junit.Ignore;
import org.junit.Test;

public class EmailMessageTest {

	

	@Test
	public void testGetS() {
		String timeZone = TimeZoneMapper.latLngToTimezoneString(40.6928, -73.9903);
		EmailMessage m = new EmailMessage("ydfried@gmail.com", 40.6928, -73.9903, TimeZone.getTimeZone(timeZone));
		System.out.println(m.getMessage());
		assertTrue(m.getMessage() instanceof String);
	}

}
