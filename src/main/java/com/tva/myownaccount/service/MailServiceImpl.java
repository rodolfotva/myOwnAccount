package com.tva.myownaccount.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.mail.smtp.SMTPTransport;

@Service("mailService")
@Transactional
public class MailServiceImpl implements MailService {

	private static final Logger logger = LogManager.getLogger(MailServiceImpl.class.getName());

	
	// for example, smtp.mailgun.org
    private static final String SMTP_SERVER = "smtp.gmail.com";
    private static final String USERNAME = "myownaccwarning@gmail.com";
    private static final String PASSWORD = "*Rtva007";

    private static final String EMAIL_FROM = "myownaccwarning@gmail.com";

    @Override
	public void sendEmailForNemLineItem(String emailTo, String nameTo, String accountName) {
    	
    	logger.info("Sending email to " + emailTo);
    	
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTP_SERVER);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);
        SMTPTransport smtpTrens = null;
        StringBuilder strBuilider = new StringBuilder();
        try {
        	strBuilider.append("Hello ");
        	strBuilider.append(nameTo);
        	strBuilider.append("\n\n\n");
        	strBuilider.append("You have a new entry in your account ");
        	strBuilider.append(accountName);
        	strBuilider.append("\n\n");
        	strBuilider.append("Please access the link below to see more details ");
        	strBuilider.append("\n");
        	strBuilider.append("http://myownaccount.herokuapp.com/");
        	strBuilider.append("\n\n");
        	strBuilider.append("Thanks");
        	
            msg.setFrom(new InternetAddress(EMAIL_FROM));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo, false));
            msg.setSubject("You have a new entry in your account");
            msg.setText(strBuilider.toString());
            msg.setSentDate(new Date());
            
            smtpTrens = (SMTPTransport) session.getTransport("smtp");
            smtpTrens.connect(SMTP_SERVER, USERNAME, PASSWORD);
            smtpTrens.sendMessage(msg, msg.getAllRecipients());
            
            logger.info("Response: " + smtpTrens.getLastServerResponse());
        	
            smtpTrens.close();
        } catch (MessagingException mex) {
            logger.error("Error sending email", mex);
        }
	}

}
