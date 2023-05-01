package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.inventoryBean;
import Model.transactBean;
import Utility.DBConnectionUtil;
import Utility.transactionBeanFactoryInsertion;

public class transactionInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		connection = DBConnectionUtil.getDBConnection();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dlicense_number  = request.getParameter("dLicense");
		String firstName        = request.getParameter("firstName");
		String middleName       = request.getParameter("middleName");
		String lastName         = request.getParameter("lastName");
		String houseSubDivision = request.getParameter("houseDivision");
		String zipCode          = request.getParameter("zipCode");
		String houseNumber      = request.getParameter("houseNumber");
		
		int amount             = Integer.parseInt(request.getParameter("amount"));
		String type			   = request.getParameter("type");
		String car_id			   = request.getParameter("carId");
		boolean goCar = inventoryBean.isACar(connection, car_id);
		if(goCar){
			new inventoryBean().updateStatement(connection, "carStatus", "Unavailable", car_id);
			transactionBeanFactoryInsertion.store(dlicense_number, firstName, middleName, lastName, houseSubDivision, zipCode, houseNumber, amount, type, car_id, connection);	
			response.sendRedirect("generateTables.html");
		}
		else{
			request.setAttribute("errorMessage", "Error! the car does not exist in the inventory.");
			request.getRequestDispatcher("insertTransaction.jsp").forward(request,  response);
		}
	}
}
