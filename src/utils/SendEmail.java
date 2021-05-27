package utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

	public static void main(String[] args) {

		final String userName = "mdinc@amaxinsurance.com";
		final String passWord = "Jacob2017";
		String fromEmail = "mdinc@amaxinsurance.com";
		String toEmail = "mdinc@amaxinsurance.com";

		
		String from = "mdinc@amaxinsurance.com";
		// String from = "mdinc@amaxinsurance.com";
		// Mention the SMTP server address. Below Gmail's SMTP server is being used to
		// send email
		String host = "smtp.gmail.com";
		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		
		
//		Properties properties = new Properties();
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.starttls.eanble", "true");
//		properties.put("mail.smtp.host", "smtp.mail.gmail.com");
//		properties.put("mail.smtp.port", "465");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// return new PasswordAuthentication("dincmurad@gmail.com", "J@cob2017");
				return new PasswordAuthentication(userName,passWord);

			}
		});
		
		
		
		try {
			MimeMessage message = new MimeMessage(session);
			// Create a default MimeMessage object.
			
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(fromEmail));
			// Set To: header field of the header.
			// message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

//						message.addRecipient(Message.RecipientType.TO, new InternetAddress("dmcdonald@amaxinsurance.com"));
//						message.addRecipient(Message.RecipientType.TO, new InternetAddress("afarooqui@amaxinsurance.com"));
//						message.addRecipient(Message.RecipientType.TO, new InternetAddress("mozcan@amaxinsurance.com"));
//				        message.addRecipient(Message.RecipientType.TO, new InternetAddress("dincim@hotmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			//message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Subject Line");
			message.setText("Email body text");
			
			Multipart emailContent = new MimeMultipart();
			
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("My multipart text");
			
			
			//Attachement body part.
			MimeBodyPart textAttachement = new MimeBodyPart();
			textAttachement.attachFile("C:\\SeleniumPractice\\Test123.txt");
			//
			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(textAttachement);
			
			//Attach multipart to message
			message.setContent(emailContent);
			Transport.send(message);
			System.out.println("Sent message");

		} catch (

		Exception e) {
			// TODO: handle exception
		}
	}
}
//	public static void sendEmail(String m, String s) {
//
//		// Mention the Sender's email address
//		String from = "mdinc@amaxinsurance.com";
//		// String from = "mdinc@amaxinsurance.com";
//		// Mention the SMTP server address. Below Gmail's SMTP server is being used to
//		// send email
//		String host = "smtp.gmail.com";
//		// Get system properties
//		Properties properties = System.getProperties();
//		// Setup mail server
//		properties.put("mail.smtp.host", host);
//		properties.put("mail.smtp.port", "465");
//		properties.put("mail.smtp.ssl.enable", "true");
//		properties.put("mail.smtp.auth", "true");
//		// Get the Session object.// and pass username and password
//		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				// return new PasswordAuthentication("dincmurad@gmail.com", "J@cob2017");
//				return new PasswordAuthentication("mdinc@amaxinsurance.com", "Jacob2017");
//			}
//		});
//
//		// Used to debug SMTP issues
//		session.setDebug(true);
//		try {
//			// Create a default MimeMessage object.
//			MimeMessage message = new MimeMessage(session);
//			// Set From: header field of the header.
//			message.setFrom(new InternetAddress(from));
//			// Set To: header field of the header.
//			// message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
////			message.addRecipient(Message.RecipientType.TO, new InternetAddress("dmcdonald@amaxinsurance.com"));
////			message.addRecipient(Message.RecipientType.TO, new InternetAddress("afarooqui@amaxinsurance.com"));
////			message.addRecipient(Message.RecipientType.TO, new InternetAddress("mozcan@amaxinsurance.com"));
////	        message.addRecipient(Message.RecipientType.TO, new InternetAddress("dincim@hotmail.com"));
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress("mdinc@amaxinsurance.com"));
//			
//			Multipart emailContent = new MimeMultipart();
//			
//			//Text body part
//			MimeBodyPart textBodyPart = new MimeBodyPart();
//			textBodyPart.setText("My multipart text");
//			
//			//Attachement body part.
//			MimeBodyPart textAttachement = new MimeBodyPart();
//			textAttachement.setText("C:\\Users\\Murat Dinc\\eclipse-workspace\\seleniumPractices\\out.txt");
//			emailContent.addBodyPart(textBodyPart);
//			emailContent.addBodyPart(textAttachement);
//			
//			//Attach multipart to message
//			message.setContent(emailContent);
//			
//
//			// Set Subject: header field
//			// message.setSubject("Daily Automated Test Results!");
//			message.setSubject(s);
//			// Now set the actual message
//			message.setText(m);
//			System.out.println("sending...");
//			// Send message
//			Transport.send(message);
//			System.out.println("Sent message successfully....");
//		} catch (MessagingException mex) {
//			mex.printStackTrace();
//		}
//	}
//	}	
