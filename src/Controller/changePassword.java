package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.passwordBean;
import Utility.DBConnectionUtil;
import Utility.changePasswordFactoryBean;


public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		connection = DBConnectionUtil.getDBConnection();
	}
    public changePassword() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		String reTypedPass = request.getParameter("reTypedPass");
		boolean matched = passwordBean.matchPassword(connection, oldPass);
		if(matched && isMatch(newPass, reTypedPass) && isCorrectPassword(newPass)){
			changePasswordFactoryBean.setAndUpdatePasswordBean(connection, newPass);
			response.sendRedirect("faqsResult.html");
		}
		else if(matched && isMatch(newPass, reTypedPass) && (isCorrectPassword(newPass) == false)){
			request.setAttribute("errorMessage", "Error! your new password is too weak. It should have at least one Upper case letter, one number, and one lower case letter.");
			request.getRequestDispatcher("changePassForm.jsp").forward(request, response);
		}
		else if(matched && (isMatch(newPass, reTypedPass) == false)){
			request.setAttribute("errorMessage", "Error! new password and the re typed new pass word are not matched.");
			request.getRequestDispatcher("changePassForm.jsp").forward(request, response);
		}
		else{
			request.setAttribute("errorMessage", "Error! the old password does not match.");
			request.getRequestDispatcher("changePassForm.jsp").forward(request, response);
		}
	}
	public boolean isMatch(String newPass, String reTypedNewPass){
		return newPass.equals(reTypedNewPass);
	}
	public boolean isCorrectPassword(String pass){
		boolean sameUsername = pass.equalsIgnoreCase("edcarsAdmin");
		String letters = "abcdefghijklmnopqrstuvwxyz";
		String capsLetters = letters.toUpperCase();
		String numbers = "0123456789";
		boolean hasLowLetters = false;
		boolean hasNumbers = false;
		boolean hasCapsLetters = false;
		for(int i = 0, j = 0; i < letters.length() && j < capsLetters.length(); i++,j++){
			if(pass.indexOf(letters.charAt(i)) > -1){
				hasLowLetters = true;
			}
			else if(pass.indexOf(capsLetters.charAt(j)) > -1){
				hasCapsLetters = true;
			}
			if(hasLowLetters && hasNumbers && hasCapsLetters){
				break;
			}
		}
		for(int k = 0; k <numbers.length(); k++){
			if(pass.indexOf(numbers.charAt(k)) > -1){
				hasNumbers = true;
			}
			if(hasNumbers){
				break;
			}
		}
		
		return ((sameUsername == false ) && hasNumbers && hasCapsLetters && hasLowLetters);
	}
}
