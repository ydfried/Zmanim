package Mail;

import java.util.*;
//import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

	public static void main(String[] args) {
		SubFile mailList = new SubFile();
		StringBuilder sb = new StringBuilder(mailList.match());
		String subs = sb.toString();
		final String username = "zmanimproject@gmail.com";
		System.out.println("Enter password:");
		Scanner input = new Scanner(System.in);
		final String password = input.next();

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		
		
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("zmanimproject@gmail.com"));
			message.setRecipients(Message.RecipientType.BCC,
				InternetAddress.parse(subs));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}