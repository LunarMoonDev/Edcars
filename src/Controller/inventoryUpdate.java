package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Utility.DBConnectionUtil;
import Model.inventoryBean;

public class inventoryUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		connection = DBConnectionUtil.getDBConnection();
	}
    public inventoryUpdate() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(inventoryBean.isACar(connection, id)){
			String[] fields = request.getParameterValues("fields");
			if(fields != null){
				HashMap<String, Object> map = new HashMap<String, Object>();
				for(int i = 0; i < fields.length; i++){
					switch(fields[i]){
					case "plateNumber":{
						String plateNumber = request.getParameter("plateNumber");
						map.put(fields[i], plateNumber);
						break;
					}
					case "carBrand":{
						String brand = request.getParameter("carBrand");
						map.put(fields[i], brand);
						break;
					}
					case "carModel":{
						String model = request.getParameter("carModel");
						map.put(fields[i], model);
						break;
					}
					case "carType":{
						String type= request.getParameter("carType");
						map.put(fields[i], type);
						break;
					}
					case "carColour":{
						String colour = request.getParameter("carColour");
						map.put(fields[i], colour);
						break;
					}
					case "carYear":{
						Integer year = Integer.parseInt(request.getParameter("carYear"));
						map.put(fields[i], year);
						break;
					}
					case "carStatus":{
						String status = request.getParameter("carStatus");
						map.put(fields[i], status);
						break;
					}	
					case "carPrice":{
						Double price = Double.parseDouble(request.getParameter("carPrice"));
						map.put(fields[i], price);
						break;
					}
					case "carImage":{
						Part file = request.getPart("carImage");
						InputStream image = file.getInputStream();
						map.put(fields[i], image);
						break;
					}
					case "motorNo":{
						String motorNo = request.getParameter("motorNo");
						map.put(fields[i], motorNo);
						break;
					}
					case "serialNo":{
						String serialNo = request.getParameter("serialNo");
						map.put(fields[i], serialNo);
						break;
					}
					case "fileNo":{
						String fileNo = request.getParameter("fileNo");
						map.put(fields[i], fileNo);
						break;
					}
					case "crNo":{
						String crNo = request.getParameter("crNo");
						map.put(fields[i], crNo);
						break;
					}
					}
				}
				new inventoryBean().update(connection, map, fields, id);
				response.sendRedirect("generateTables.html");
			}
			else{
				request.setAttribute("errorMessage", "Error! At least one field should be be checked if you want to update.");
				request.getRequestDispatcher("updateCar.jsp").forward(request, response);
			}
		}
		else{
			request.setAttribute("errorMessage", "Error! the car does not exist in the inventory.");
			request.getRequestDispatcher("updateCar.jsp").forward(request, response);
		}
		}

}
