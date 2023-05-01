package Utility;
import java.sql.Connection;

import Model.inventoryBean;

public class SingleCarResultFactoryBean {
	public static inventoryBean getBean(Connection connection, String carBrand, String carModel, String carColour, int carYear){
		inventoryBean bean = new inventoryBean();
		bean.setCarBrand(carBrand);
		bean.setCarModel(carModel);
		bean.setCarColor(carColour);
		bean.setCarYear(carYear);
		bean.setCarStatus("Available");
		
		return bean;
	}
}
