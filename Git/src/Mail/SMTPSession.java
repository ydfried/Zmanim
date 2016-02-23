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

public class SMTPSession {
	private String username;
	private String password;
	private Session session;
	
	public SMTPSession() {
		
		System.out.println("Opening SMTP Session...\n\nEnter Username:");
		Scanner input = new Scanner(System.in);
		username = input.next() + "@gmail.com";
		System.out.println("Enter password:");
		input = new Scanner(System.in);
		password = input.next();
		input.close();
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
	}

	public String getUsername() {
		return username;
	}
	
	public Session getSession() {
		return session;
	}
}