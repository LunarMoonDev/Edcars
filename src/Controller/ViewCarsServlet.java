package Controller;


import java.io.IOException;
import java.io.OutputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utility.DBConnectionUtil;

/**
 * Servlet implementation class ViewCarsServlet
 */
@WebServlet("/ViewCarsServlet")
public class ViewCarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("your_id");
		Connection con = DBConnectionUtil.getDBConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		OutputStream oImage;
		
		try {
		pstmt = con.prepareStatement("select carImage from inventory where  plateNumber = ? AND carStatus = ?");
		pstmt.setString(1,id);
		pstmt.setString(2, "Available");
		rs = pstmt.executeQuery();
		    if(rs.next()) {
		        byte barray[] = rs.getBytes("carImage");
		        response.setContentType("image/png");
		        oImage=response.getOutputStream();
		        oImage.write(barray);
		        oImage.flush();
		        oImage.close();
		    }
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			}
	
}


