package Utility;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnectionUtil {
	public static Connection  getDBConnection() {
		Connection connection = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)
				initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)
				envContext.lookup("jdbc/DATABASE");
			connection = ds.getConnection();
		} catch (NamingException ne) {
			ne.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return connection;
	}
}
