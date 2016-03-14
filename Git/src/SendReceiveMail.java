

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendReceiveMail {
	
	public SendReceiveMail(String emailTo, String subject, String messageBody/*, SMTPSession session*/) {
		SMTPSession session = new SMTPSession();
		Message message = new MimeMessage(session.getSession());
		try {

			
			message.setFrom(new InternetAddress(session.getUsername()));
			message.setRecipients(Message.RecipientType.BCC,
					InternetAddress.parse(emailTo));
			message.setSubject(subject);
			message.setContent(messageBody, "text/html");
			//message.setText(messageBody);

			Transport.send(message);

			System.out.println("Done");
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
