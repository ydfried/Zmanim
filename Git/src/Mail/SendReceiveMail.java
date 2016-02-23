package Mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendReceiveMail {
	private String username;
	private SubFile mailList = new SubFile();
	private StringBuilder sb = new StringBuilder(mailList.match());
	private String subs = sb.toString();
	private SMTPSession email = new SMTPSession();
	private Message message = new MimeMessage(email.getSession());
	
	
	public SendReceiveMail(String subject, String messageBody) {

		try {

			
			message.setFrom(new InternetAddress(username + "@gmail.com"));
			message.setRecipients(Message.RecipientType.BCC,
					InternetAddress.parse(subs));
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
