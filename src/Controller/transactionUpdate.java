package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.inventoryBean;
import Model.transactBean;
import Utility.DBConnectionUtil;


public class transactionUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		connection = DBConnectionUtil.getDBConnection();
	}  
   
    public transactionUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean goClient = false;
		boolean goCar = false;
		if(transactBean.isATransaction(connection, id)){
			String[] fields = request.getParameterValues("fields");
			if(fields != null){
				
					HashMap<String, Object> map = new HashMap<String, Object>();
					for(int i = 0; i < fields.length; i++){
						switch(fields[i]){
						case "Amount":{
							Double amount = Double.parseDouble(request.getParameter("amount"));
							map.put(fields[i], amount);
							break;
						}
						case "totalFee":{
							Double totalFee = Double.parseDouble(request.getParameter("totalFee"));
							map.put(fields[i], totalFee);
							break;
						}
						case "Type":{
							String type = request.getParameter("type");
							map.put(fields[i], type);
							break;
						}
						case "Car_ID":{
							String carID= request.getParameter("carId");
							goCar = inventoryBean.isACar(connection, carID);
							if(goCar){
								map.put(fields[i], carID);
							}
							else
								break;
						}
						case "Client_ID":{
							String dLicense = request.getParameter("Client_ID");
							goClient = transactBean.isAClient(connection, dLicense);
							if(goClient)
								map.put(fields[i], dLicense);
							else
								break;
						}
						}
					}
					if(goCar && goClient){
						new transactBean().update(connection, map, fields, id);
						response.sendRedirect("generateTables.html");
					}
					else if((goCar == false)){
						request.setAttribute("errorMessage", "Error! the car id does not exist in the inventory.");
						request.getRequestDispatcher("updateTransaction.jsp").forward(request, response);
					}
					else if((goClient == false)){
						request.setAttribute("errorMessage", "Error! the client id does not exist in the inventory.");
						request.getRequestDispatcher("updateTransaction.jsp").forward(request, response);
					}
			}
			else{
				request.setAttribute("errorMessage", "Error! At least one field should be be checked if you want to update.");
				request.getRequestDispatcher("updateTransaction.jsp").forward(request, response);
			}
		}
		else{
			request.setAttribute("errorMessage", "Error! the transaction does not exist in the inventory.");
			request.getRequestDispatcher("updateTransaction.jsp").forward(request, response);
		}
	}

}
