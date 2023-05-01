package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Utility.DBConnectionUtil;
import Utility.carInsertionBeanFactory;


@MultipartConfig
public class inventoryInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		connection = DBConnectionUtil.getDBConnection();
	}
	
    public inventoryInsert() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String carBrand = request.getParameter("brand");
		String carModel = request.getParameter("model");
		String carType = request.getParameter("type");
		String carColor = request.getParameter("colour");
		int carYear = Integer.parseInt(request.getParameter("year"));
		String carStatus = request.getParameter("status");
		double carPrice = Double.parseDouble(request.getParameter("price"));
		Part imageFile = request.getPart("image");
		InputStream carImage = imageFile.getInputStream();
		String motorNo = request.getParameter("motorNo");
		String serialNo = request.getParameter("serialNo");
		String fileNo = request.getParameter("fileNo");
		String crNo = request.getParameter("crNo");
		
		
		carInsertionBeanFactory.getBean(connection, id,carBrand, carModel, carType, carColor, carYear, carStatus, carPrice, carImage, motorNo, serialNo, fileNo, crNo);
		response.sendRedirect("generateTables.html");
	}

}
