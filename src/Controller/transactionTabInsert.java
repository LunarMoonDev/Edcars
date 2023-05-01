package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.inventoryBean;
import Utility.DBConnectionUtil;
import Utility.transactionBeanFactoryInsertion;

public class transactionTabInsert extends HttpServlet {
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
		String houseDivisionParts[] = houseSubDivision.split(",");
		String houseDiv1 = houseDivisionParts[0];
		String houseDiv2 = houseDivisionParts[1];
		String address = houseNumber+" "+houseDiv1+", "+zipCode+" "+houseDiv2;
		
		int amount             = Integer.parseInt(request.getParameter("amount"));
		String type			   = request.getParameter("type");
		
		String car_id		    = request.getParameter("carId");
		String make				= request.getParameter("make");
		String series			= request.getParameter("series");
		String bodyType			= request.getParameter("bodyType");
		String yearModel		= request.getParameter("yearModel");
		String MotorNo			= request.getParameter("motorNo");
		String chasisNo			= request.getParameter("chassisNo");
		String fileNo			= request.getParameter("fileNo");
		String crNo				= request.getParameter("crNo");
		String totalFee         = request.getParameter("totalFee");
		
		long fee = (long)Double.parseDouble(totalFee);
		String moneyWord = Utility.moneyToWord.convert(fee);
		
		new inventoryBean().updateStatement(connection, "carStatus", "Unavailable", car_id);
		transactionBeanFactoryInsertion.store(dlicense_number, firstName, middleName, lastName, houseSubDivision, zipCode, houseNumber, amount, type, car_id, connection);	
		
		request.setAttribute("nameSeller", "Viray, Edgardo");
		request.setAttribute("addressSeller", "8 Domingo St., Carmel Subdivision, Quezon City, Philippines");
		
		request.setAttribute("plateNumber", car_id);
		request.setAttribute("make", make);
		request.setAttribute("seriesNo", series);
		request.setAttribute("bodyType", bodyType);
		request.setAttribute("yearModel", yearModel);
		request.setAttribute("motorNo", MotorNo);
		request.setAttribute("chassisNo", chasisNo);
		request.setAttribute("fileNo", fileNo);
		request.setAttribute("crNo", crNo);
		
		request.setAttribute("nameBuyer", lastName+", "+firstName+" "+middleName);
		request.setAttribute("addressBuyer", address);
		
		request.setAttribute("moneyWord", moneyWord);
		request.setAttribute("fee", fee);
		
		request.getRequestDispatcher("transactiondeed.jsp").forward(request, response);
	}
}
