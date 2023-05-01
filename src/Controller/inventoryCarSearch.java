package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.inventoryBean;
import Utility.DBConnectionUtil;
import Utility.SingleCarResultFactoryBean;

public class inventoryCarSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		connection = DBConnectionUtil.getDBConnection();
	}
    public inventoryCarSearch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carBrand = request.getParameter("Brand");
		String carModel = request.getParameter("Model");
		String carColour = request.getParameter("Colour");
		int carYear = Integer.parseInt(request.getParameter("Year"));
		
		if(inventoryBean.isACar(connection, carBrand, carModel, carColour, carYear)){
			if(inventoryBean.isAvailable(connection, carBrand, carModel, carColour, carYear)){
			inventoryBean bean = SingleCarResultFactoryBean.getBean(connection, carBrand, carModel, carColour, carYear);
			ResultSet a = bean.getACar(connection);
			String car = "";
			String total = "";
			String carModelS = "";
			String carYearS = "";
			String plateNumber = "";
			String carBrandS = "";
			String bodyType = "";
			String motorNo = "";
			String serialNo = "";
			String fileNo = "";
			String crNo = "";
			try{
				while(a.next()){
					car = a.getString("plateNumber") +", " +a.getString("carBrand") +", " +a.getString("carModel") +", "+a.getString("carType")+", " +a.getString("carColour")+", "
							+a.getInt("carYear");
					total = a.getDouble("carPrice") +"";
					carModelS = a.getString("carModel");
					carYearS = a.getInt("carYear") +"";
					plateNumber = a.getString("plateNumber");
					carBrandS = a.getString("carBrand");
					bodyType = a.getString("carType");
					motorNo = a.getString("motorNo");
					serialNo = a.getString("serialNo");
					fileNo = a.getString("fileNo");
					crNo = a.getString("crNo");
					break;
				}
			}
			catch(SQLException e){
				
			}	
			request.setAttribute("car", car);
			request.setAttribute("totalFee", total);
			request.setAttribute("carModel", carModelS);
			request.setAttribute("carYear", carYearS);
			request.setAttribute("plateNumber", plateNumber);
			request.setAttribute("carBrand", carBrandS);
			request.setAttribute("bodyType", bodyType);
			request.setAttribute("motorNo", motorNo);
			request.setAttribute("serialNo", serialNo);
			request.setAttribute("fileNo", fileNo);
			request.setAttribute("crNo", crNo);
			request.getRequestDispatcher("transaction.jsp").forward(request, response);
			}
			else{
				request.setAttribute("errorMessage", "Error! the car is not available");
				request.getRequestDispatcher("searchCar.jsp").forward(request, response);
			}
		}
		else{
			request.setAttribute("errorMessage", "Error! the car does not exist in the inventory");
			request.getRequestDispatcher("searchCar.jsp").forward(request, response);
		}
		
	}

}
