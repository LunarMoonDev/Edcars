package Utility;

import java.io.InputStream;
import java.sql.Connection;

import Model.inventoryBean;


public class carInsertionBeanFactory {

	public static void getBean(Connection connection, String id,String carBrand, String carModel, String carType, String carColor, int carYear, String carStatus,
										double carPrice, InputStream carImage, String motorNo, String serialNo, String fileNo, String crNo){
		inventoryBean bean = new inventoryBean();
		bean.setId(id);
		bean.setCarBrand(carBrand);
		bean.setCarModel(carModel);
		bean.setCarType(carType);
		bean.setCarColor(carColor);
		bean.setCarYear(carYear);
		bean.setCarStatus(carStatus);
		bean.setCarPrice(carPrice);
		bean.setCarImage(carImage);
		bean.setMotorNo(motorNo);
		bean.setSerialNo(serialNo);
		bean.setFileNo(fileNo);
		bean.setCrNo(crNo);
		
		bean.insert(connection);
	}
}
