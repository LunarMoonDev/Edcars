package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.inventoryBean;
import Model.transactBean;
import Utility.DBConnectionUtil;

public class managementInventoryResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		connection = DBConnectionUtil.getDBConnection();
	}
    public managementInventoryResult() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet sets3 = new transactBean().getAll(connection);
		request.setAttribute("sets3", sets3);
		
		ResultSet sets1 = new inventoryBean().getAll(connection);
		request.setAttribute("sets1", sets1);
		
		ResultSet sets4 = new transactBean().getAllClient(connection);
		request.setAttribute("sets4", sets4);
		
		request.getRequestDispatcher("manageinventory.jsp").forward(request, response);
	}

}
