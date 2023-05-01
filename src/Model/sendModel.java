package Model;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.Part;

public class sendModel {
	private String toMail;
	private String fromMail;
	private String subject;
	private String textMessage;
	private String username;
	private String name;
	private String phone;
	private String password;
	private String host;
	private Part images;
	
	public Part getImages() {
		return images;
	}
	public void setImages(Part images) {
		this.images = images;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToMail() {
		return toMail;
	}
	public void setToMail(String toMail) {
		this.toMail = toMail;
	}
	public String getFromMail() {
		return fromMail;
	}
	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTextMessage() {
		return textMessage;
	}
	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}
	public void sendBuyerEmail(){
		
		  Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "465");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	      
	      Session session = Session.getInstance(props,
	    	         new javax.mail.Authenticator() {
	    	            protected PasswordAuthentication getPasswordAuthentication() {
	    	               return new PasswordAuthentication(username, password);
	    		   }
	    	         });
	      
	      try{
	    	  Message bodyMessage = new MimeMessage(session);
	    	  bodyMessage.setFrom(new InternetAddress(fromMail));
	    	  bodyMessage.setRecipients(Message.RecipientType.TO,
	                  InternetAddress.parse(toMail));
	    	  bodyMessage.setSubject(subject);
	    	  bodyMessage.setText(textMessage);
	    	  Transport.send(bodyMessage);
	      }
	      catch (MessagingException e){
	    	  throw new RuntimeException(e);
	      }
	}
	public void sendSellerEmail(){		
		  Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "465");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	      
	      Session session = Session.getInstance(props,
	    	         new javax.mail.Authenticator() {
	    	            protected PasswordAuthentication getPasswordAuthentication() {
	    	               return new PasswordAuthentication(username, password);
	    		   }
	    	         });
	      
	      try{
	    	  Message bodyMessage = new MimeMessage(session);
	    	  bodyMessage.setFrom(new InternetAddress(fromMail));
	    	  bodyMessage.setRecipients(Message.RecipientType.TO,
	                  InternetAddress.parse(toMail));
	    	  bodyMessage.setSubject(subject);
	    	  
	    	  BodyPart textMessagePart = new MimeBodyPart();
	    	  textMessagePart.setText(textMessage);
	    	  
	    	  BodyPart imageMessagePart =new MimeBodyPart();
	    	  
	    	  try{
	    		  ByteArrayDataSource ds = new ByteArrayDataSource(images.getInputStream(), images.getContentType());
	    		  imageMessagePart.setDataHandler(new DataHandler(ds));
	    	  }
	    	  catch(IOException e){
	    		  
	    	  }
	    	  Multipart multipart = new MimeMultipart();
	    	  multipart.addBodyPart(textMessagePart);
	    	  multipart.addBodyPart(imageMessagePart);
	    	  
	    	  bodyMessage.setContent(multipart);
	    	  Transport.send(bodyMessage);
	      }
	      catch (MessagingException e){
	    	  throw new RuntimeException(e);
	      }
	}
	
}
