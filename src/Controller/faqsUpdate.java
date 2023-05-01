package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.faqsBean;
import Utility.DBConnectionUtil;



public class faqsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		connection = DBConnectionUtil.getDBConnection();
	}  
    public faqsUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		if(faqsBean.isAFAQS(connection, id)){
			String[] fields = request.getParameterValues("fields");
			if(fields != null){
				HashMap<String, String> map = new HashMap<String, String>();
				for(int i = 0; i < fields.length; i++){
					switch(fields[i]){
						case "Faqs_Question":{
							String question = request.getParameter("Faqs_Question");
							map.put(fields[i], question);
							break;
						}
						case "Faqs_Answer":{
							String answer = request.getParameter("Faqs_Answer");
							map.put(fields[i], answer);
							break;
						}
					}
				}
				new faqsBean().update(connection, map, fields, id);
				response.sendRedirect("faqsResult.html");
			}
			else{
				request.setAttribute("errorMessage", "Error! at least one field should be checked to perform that update.");
				request.getRequestDispatcher("updateFAQs.jsp").forward(request, response);
			}
		}
		else{
			request.setAttribute("errorMessage", "Error! the faqs record does not exist in the inventory.");
			request.getRequestDispatcher("updateFAQs.jsp").forward(request, response);
		}
	}

}
