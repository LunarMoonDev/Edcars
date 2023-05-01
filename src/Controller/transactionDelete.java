package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.transactBean;
import Utility.DBConnectionUtil;


public class transactionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		connection = DBConnectionUtil.getDBConnection();
	}
    public transactionDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String records[] = request.getParameterValues("transactionRecords");
		String carRecords[] = request.getParameterValues("carRecords");
		if(records != null){
			String transactIds[] = new String[records.length];
			String driverLicense[] = new String[records.length];
			for(int i = 0; i < records.length; i++){
				String a[] = records[i].split("~");
				transactIds[i] = a[0];
				driverLicense[i] = a[1];
			}
			int ids[] = convertStringAToIntA(transactIds);
			new transactBean().delete(connection, ids,driverLicense,carRecords);
			response.sendRedirect("generateTables.html");
		}
		else{
			request.setAttribute("errorMessage", "Error! please select at least one record first in the transaction table before you delete.");
			request.getRequestDispatcher("generateTables.html").forward(request, response);
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
