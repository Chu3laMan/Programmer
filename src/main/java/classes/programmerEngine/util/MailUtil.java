package classes.programmerEngine.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//MailUtil class used to send email confirmation once the client has been registered successfully
//Furthermore, it uses GMAIL SMTP, note that you can configure it to whatever you want i.e Outlook or YAHOO, make some changes on mail.smtps.host and port
//in addition, the class accepts either plain/text and HTML messages
public class MailUtil {
	
	public static void sendEmail(String to, String from, String subject, String body, boolean bodyisHTML) throws MessagingException {
		//get a mail session
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.port", 465);
		props.put("mail.smtps.auth", "true");
		props.put("mail.smtps.quitwait", "false");
         Session session = Session.getInstance(props);
		session.setDebug(true);
		
		//create a message 
		Message message = new MimeMessage(session);
		message.setSubject(subject);
		if(bodyisHTML) 
			message.setContent(body, "text/html");
		else
			message.setText(body);
		
		//address the message
		Address fromAddress = new InternetAddress(from);
		Address toAddress = new InternetAddress(to);
		message.setFrom(fromAddress);
		message.setRecipient(Message.RecipientType.TO, toAddress);
		
		//send the message
		Transport transport = session.getTransport();
		transport.connect("smtp.gmail.com", "youremail", "yourpassword");
		Transport.send(message, message.getAllRecipients());
		transport.close();
    }
	
	
}
