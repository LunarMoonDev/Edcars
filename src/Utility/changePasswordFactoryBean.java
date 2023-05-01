package Utility;

import java.sql.Connection;

import Model.passwordBean;

public class changePasswordFactoryBean {
	public static void setAndUpdatePasswordBean(Connection connection, String password){
		passwordBean bean = new passwordBean();
		bean.setPassword(password);
		bean.updatePassword(connection);
	}
}
