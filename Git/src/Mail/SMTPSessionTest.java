package Mail;

import static org.junit.Assert.*;

import org.junit.Test;

public class SMTPSessionTest {

	@Test
	public void testLogin() {
		SMTPSession j = new SMTPSession();
		j.getUsername();
	}

}
