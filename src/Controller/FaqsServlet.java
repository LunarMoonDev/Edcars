package Controller;


import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utility.DBConnectionUtil;

@WebServlet("/FaqsServlet")
public class FaqsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("your_id");
		Connection con = DBConnectionUtil.getDBConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
		pstmt = con.prepareStatement("select *from faqs");
		rs = pstmt.executeQuery();
		    
		}
		catch(Exception ex){
		    ex.printStackTrace();
		}finally {
		    try{
		    if(con!=null)
		       con.close();
		    }catch(Exception ex){
		       ex.printStackTrace();
		    }
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}


