package restapi.test.automation;

import javax.mail.MessagingException;

public class test {

	public static void main(String[] args) throws MessagingException {
		
		MailLib m = new MailLib();
		
		m.sendmailwithattachment();
	}

}
