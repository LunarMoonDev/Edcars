package Utility;
import javax.servlet.http.Part;

import Model.sendModel;

public class sendMailFactory {
	
	public static void createSellerEmailBean(String username, String password, String fromMail, String toMail,
									   String subject,  String message, String host, String name, String phone, String specs, Part image){
		
		String formattedMessage;
		
		formattedMessage = "Name: "+name+"\n"+
						   "Phone number: "+phone+"\n"+
						   "Message: "+message+"\n"+
						   "Car specifications: " + specs+"\n";
		sendModel model = new sendModel();
		model.setFromMail(fromMail);
		model.setToMail(toMail);
		model.setSubject(subject);
		model.setTextMessage(formattedMessage);
		model.setUsername(username);
		model.setPassword(password);
		model.setHost(host);
		model.setImages(image);
		model.sendSellerEmail();
	}
	public static sendModel createBuyerEmailBean(String username, String password, String fromMail, String toMail,
											String subject, String message, String host, String name, String phone, String time, String carSpecs ,String date){
		String formattedMessage;
		
		formattedMessage = "Name: "+name+"\n"+
						   "Phone number: "+phone+"\n"+
						   "Date: "+date+"\n"+
						   "Time: "+time+"\n"+
						   "Car specs: \n"+carSpecs+"\n"+
						   "\t\t"+message;
		
		sendModel model = new sendModel();
		model.setFromMail(fromMail);
		model.setToMail(toMail);
		model.setSubject(subject);
		model.setTextMessage(formattedMessage);
		model.setUsername(username);
		model.setPassword(password);
		model.setHost(host);
		model.sendBuyerEmail();
		
		return null;
	}
	
}
