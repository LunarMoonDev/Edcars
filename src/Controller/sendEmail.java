package Controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Utility.sendMailFactory;


public class sendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fromEmail;
	private String username;
	private String password;
	private String toEmail;
	private String host;
    public void init(ServletConfig config)throws ServletException{
    	super.init(config);
        fromEmail = config.getServletContext().getInitParameter("fromEmail");
        username = config.getServletContext().getInitParameter("userName");
        password = config.getServletContext().getInitParameter("password");
        toEmail = config.getServletContext().getInitParameter("toEmail");
        host = config.getServletContext().getInitParameter("host");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		String specs = request.getParameter("specs");
		Part filePart = request.getPart("image");
		
		sendMailFactory.createSellerEmailBean(username, password, fromEmail , toEmail, "Client-Buyer", message, host,name,phone,specs,filePart);
		
		
		request.getRequestDispatcher("formsent.html").forward(request, response);
	}

}
