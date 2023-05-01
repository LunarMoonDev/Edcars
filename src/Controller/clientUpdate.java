package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.transactBean;
import Utility.DBConnectionUtil;


public class clientUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		connection = DBConnectionUtil.getDBConnection();
	}  
    public clientUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(transactBean.isAClient(connection, id)){
			String[] fields = request.getParameterValues("fields");
			if(fields != null){
				HashMap<String, String> map = new HashMap<String, String>();
				for(int i = 0; i < fields.length; i++){
					switch(fields[i]){
					case "DLicense_Number":{
						String DLicense_Number = request.getParameter("dLicense");
						map.put(fields[i], DLicense_Number);
						break;
					}
					case "First_Name":{
						String First_Name = request.getParameter("firstName");
						map.put(fields[i], First_Name);
						break;
					}
					case "Middle_Name":{
						String Middle_Name = request.getParameter("middleName");
						map.put(fields[i], Middle_Name);
						break;
					}
					case "Last_Name":{
						String Last_Name = request.getParameter("lastName");
						map.put(fields[i], Last_Name);
						break;
					}
					case "House_Subdivision":{
						String House_Subdivision = request.getParameter("houseDivision");
						map.put(fields[i], House_Subdivision);
						break;
					}
					case "ZIP_Code":{
						String ZIP_Code = request.getParameter("zipCode");
						map.put(fields[i], ZIP_Code);
						break;
					}
					case "House_Number":{
						String House_Number = request.getParameter("houseNumber");
						map.put(fields[i], House_Number);
						break;
					}
					}
				}
				new transactBean().updateClient(connection, map, fields, id);
				response.sendRedirect("generateTables.html");
			}
			else{
				request.setAttribute("errorMessage", "Error! At least one field should be be checked if you want to update.");
				request.getRequestDispatcher("updateClient.jsp").forward(request, response);
			}
		}
		else{
			request.setAttribute("errorMessage", "Error! the client does not exist in the inventory.");
			request.getRequestDispatcher("updateClient.jsp").forward(request, response);
		}
	}

}
