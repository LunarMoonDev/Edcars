package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.faqsBean;
import Utility.DBConnectionUtil;

public class faqsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		connection = DBConnectionUtil.getDBConnection();
	}
    public faqsDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String records[] = request.getParameterValues("faqsRecords");
		if(records != null){
			int ids[] = convertStringAToIntA(records);
			new faqsBean().delete(connection, ids);
			response.sendRedirect("faqsResult.html");
		}
		else{
			request.setAttribute("errorMessage", "Error! please select at least one record first in the faqs table before you delete.");
			request.getRequestDispatcher("faqsResult.html").forward(request, response);
		}
		
	}
	public int[] convertStringAToIntA(String A[]){
		int C[] = new int[A.length];
		for(int t = 0; t<A.length; t++){
			C[t] = Integer.parseInt(A[t]);
		}
		return C;
	}

}
