

import java.util.*;
//import java.util.Properties;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
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
		login();
		/**System.out.println("Opening SMTP Session...\n\nEnter Username:");
		Scanner input = new Scanner(System.in);
		username = input.next() + "@gmail.com";
		System.out.println("Enter password:");
		input = new Scanner(System.in);
		password = input.next();
		input.close();**/
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
	public void login() {
		 final JFrame frame = new JFrame("Gmail Login");
	        //String label =
	        
	        
	                        LoginDialogue loginDlg = new LoginDialogue(frame);
	                        loginDlg.setVisible(true);
	                        // if logon successfully
	                        if(loginDlg.isSucceeded()){
	                        		                        	                           
	                        }
	                    
	                    
	                
	        setUsername(loginDlg.getUsername());
	        setPassword(loginDlg.getPassword());
	        System.out.println(getUsername());
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(300, 100);
	        frame.setLayout(new FlowLayout());
	       // frame.getContentPane().add(btnLogin);
	        frame.setVisible(true);
	        
	}
	protected void setUsername(String string) {
		this.username = string;
		
	}
	public String getUsername() {
		return username;
	}
	protected void setPassword(String string) {
		this.password = string;
		
	}
	public String getPassword() {
		return password;
	}
	public Session getSession() {
		return session;
	}
}