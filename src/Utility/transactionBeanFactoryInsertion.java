package Utility;
import java.sql.Connection;

import Model.transactBean;


public class transactionBeanFactoryInsertion {

	public static void store(String dlicense_number,String firstName,String middleName, String lastName,
							 String houseSubDivision, String zipCode, String houseNumber, int amount,
							 String type, String car_id, Connection connection){
		transactBean bean = new transactBean();
		bean.setDlicense_number(dlicense_number);
		bean.setFirstName(firstName);
		bean.setMiddleName(middleName);
		bean.setLastName(lastName);
		bean.setHouseSubDivision(houseSubDivision);
		bean.setZipCode(zipCode);
		bean.setHouseNumber(houseNumber);
		bean.setCar_id(car_id);
		bean.setAmount(amount);
		bean.setType(type);
		
		bean.insert(connection);
	}
}
