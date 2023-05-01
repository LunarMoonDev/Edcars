package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class passwordBean {
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static boolean matchPassword(Connection connection, String password){
		ResultSet a = null;
		String oldPass = "";
		try{
			String sql = "SELECT Password FROM account WHERE Username = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, "edcarsAdmin");
			a = prdstmt.executeQuery();
			a.next();
			oldPass = a.getString("Password");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return (password.equals(oldPass));
	}
	public void updatePassword(Connection connection){
		try{
			String sql = "UPDATE account SET Password = ? WHERE Username = "+(char)39+"edcarsAdmin"+(char)39;
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, password);
			prdstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
