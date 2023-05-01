package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utility.DBConnectionUtil;
import Model.inventoryBean;

public class inventoryDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		connection = DBConnectionUtil.getDBConnection();
	}
    public inventoryDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String records[] = request.getParameterValues("inventoryRecords");
		if(records != null){
			new inventoryBean().delete(connection, records);
			response.sendRedirect("generateTables.html");
		}
		else{
			request.setAttribute("errorMessage", "Error! please select at least one record first in the inventory table before you delete.");
			request.getRequestDispatcher("generateTables.html").forward(request, response);
		}
	}
}
