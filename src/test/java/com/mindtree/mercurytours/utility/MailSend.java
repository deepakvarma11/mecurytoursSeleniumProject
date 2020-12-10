package com.mindtree.mercurytours.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class MailSend {

	
	public MailSend() {
		super();
	}

	// method to send extent report
	public static void send() throws IOException, AddressException, MessagingException {
		Properties prop = new Properties();
		String propFile = "./mail.properties";
		FileInputStream input = new FileInputStream(propFile);
		prop.load(input);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", prop.getProperty("host"));
		prop.put("mail.smtp.user", prop.getProperty("from"));
		prop.put("mail.smtp.password", prop.getProperty("password"));
		prop.put("mail.smtp.port", prop.getProperty("port"));
		prop.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(prop);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(prop.getProperty("from")));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(prop.getProperty("to")));
		message.setSubject("Report on testing");

		BodyPart body = new MimeBodyPart();
		body.setText("sending an extent report");
		
		Multipart multipart = new MimeMultipart();
		
		MimeBodyPart messagebody = new MimeBodyPart();
		DataSource source = new FileDataSource(ExtentReport.sendEmail());
		messagebody.setDataHandler(new DataHandler(source));
		messagebody.setFileName(ExtentReport.sendEmail());
		multipart.addBodyPart(messagebody);
		
		
		MimeBodyPart messagebody2 = new MimeBodyPart();
		DataSource source2 = new FileDataSource(PdfUtility.sendPdfEmail());
		messagebody2.setDataHandler(new DataHandler(source2));
		messagebody2.setFileName(PdfUtility.sendPdfEmail());
		multipart.addBodyPart(messagebody2);


		message.setContent(multipart);


		Transport transport = session.getTransport("smtp");
		transport.connect(prop.getProperty("host"), prop.getProperty("from"), prop.getProperty("password"));
		transport.sendMessage(message, message.getAllRecipients());

		Log.info("Mail Sent");

		transport.close();

	}
	
}
