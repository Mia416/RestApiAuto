package restapi.test.automation;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class MailLib {
	
	public  void sendmail() throws MessagingException
	{
		String to ="3411379@qq.com";
		String from = "3411379@qq.com";
		String password = "qatxubywfazgbhej";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.qq.com"); 
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true"); 		 
		props.setProperty("mail.debug", "true");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.password",password);  
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");         
        props.put("mail.smtp.socketFactory.port", "465"); 
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		session.setDebug(true);
		
		MimeMessage mimeMessage = new MimeMessage(session);
		InternetAddress from_address =new InternetAddress(from);
		mimeMessage.setFrom(from_address);
		InternetAddress to_address=new InternetAddress(to); 
		mimeMessage.setRecipient(Message.RecipientType.TO,to_address);
        mimeMessage.setSentDate(new Date());  
        mimeMessage.setSubject("subject"); 
        mimeMessage.setText("java test"); 
        BodyPart bodyPart=new MimeBodyPart();
        bodyPart.setContent("body", "text/html;charset= GB2312");	
        Multipart multipart=new MimeMultipart();

        multipart.addBodyPart(bodyPart);       

        mimeMessage.setContent(multipart);
        mimeMessage.saveChanges();        
        Transport transport=session.getTransport("smtp");
        transport.connect("smtp.qq.com",from,password);       

        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());

        transport.close();
	}

}
