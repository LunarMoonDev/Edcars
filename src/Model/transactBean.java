package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class transactBean {
	
	private int id;
	private int amount;
	private String type;
	private String car_id;
	private String dlicense_number;
	private String firstName;
	private String middleName;
	private String lastName;
	private String houseSubDivision;
	private String zipCode;
	private String houseNumber;
	private double totalFee;
	
	
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getHouseSubDivision() {
		return houseSubDivision;
	}
	public void setHouseSubDivision(String houseSubDivision) {
		this.houseSubDivision = houseSubDivision;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public String getDlicense_number() {
		return dlicense_number;
	}
	public void setDlicense_number(String dlicense_number) {
		this.dlicense_number = dlicense_number;
	}
	
	public void insert(Connection connection){
		try{
			
			// insert to client also 
			if(isNotMember(connection, dlicense_number)){
				String sql = "insert into client(DLicense_Number, First_Name, Middle_Name, Last_Name, House_Subdivision, ZIP_Code, House_Number) values(?,?,?,?,?,?,?)";
				PreparedStatement prdstmt = connection.prepareStatement(sql);
				prdstmt.setString(1, dlicense_number);
				prdstmt.setString(2, firstName);
				prdstmt.setString(3, middleName);
				prdstmt.setString(4, lastName);
				prdstmt.setString(5, houseSubDivision);
				prdstmt.setString(6, zipCode);
				prdstmt.setString(7, houseNumber);
				
				prdstmt.execute();
			}
			
			String sql2 = "insert into transaction(Amount, totalFee, Type, Car_ID, Client_ID) values (?,?,?,?,?)";
			PreparedStatement prdstmt2 = connection.prepareStatement(sql2);
			prdstmt2.setInt(1, amount);
			prdstmt2.setDouble(2, getTotalFee(connection, car_id));
			prdstmt2.setString(3, type);
			prdstmt2.setString(4, car_id);
			prdstmt2.setString(5, dlicense_number);
			prdstmt2.execute();
						
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public ResultSet getAll(Connection connection){
		ResultSet a = null;
		try{
			String sql = "select * from transaction";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			
			a = prdstmt.executeQuery();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return a;
	}
	public void update(Connection connection, HashMap<String, Object> updateRequests, String []fields, int id){
		int i;
		for(i = 0; i<fields.length ; i++){
			updateStatement(connection, fields[i], updateRequests.get(fields[i]), id);
		}
	}
	public void updateStatement(Connection connection, String field, Object value, int id){
		try{
			String sql = "UPDATE transaction SET "+field+" = ? WHERE id = "+(char)39 +id+(char)39;
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			if(field.equals("Amount") || field.equals("totalFee") ){
				Double amount = (Double)value;
				prdstmt.setDouble(1, amount.doubleValue());
			}
			else if(field.equals("Type")){
				String type = (String) value;
				prdstmt.setString(1, type);
			}
			else if(field.equals("Car_ID")){
				String carID = (String) value;
				prdstmt.setString(1, carID);
			}
			else{
				String dlicense = (String)value;
				prdstmt.setString(1, dlicense);
			}
			prdstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void delete(Connection connection, int[] id, String Did[], String cid[]){
		for(int i = 0; i < id.length; i++){
			deleteStatement(connection, id[i]);
			new inventoryBean().updateStatement(connection, "carStatus", "Available", cid[i]);
			if(isNotRelated(connection, Did[i]))
				deleteStatement(connection, Did[i]);
		}
	}
	public void deleteStatement(Connection connection, int id){
		try{
			String sql = "DELETE FROM transaction WHERE id = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setInt(1, id);
			
			
			prdstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteStatement(Connection connection, String id){
		try{
			String sql = "DELETE FROM client WHERE DLicense_Number = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, id);
			
			
			prdstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void updateClient(Connection connection, HashMap<String, String> updateRequests, String []fields, String id){
		int i;
		for(i = 0; i<fields.length ; i++){
			updateStatementClient(connection, fields[i], updateRequests.get(fields[i]), id);
		}
	}
	public void updateStatementClient(Connection connection, String field, String value, String id){
		try{
			String sql = "UPDATE client SET "+field+" = ? WHERE DLicense_Number = "+(char)39 +id+(char)39;
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, value);
			prdstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public ResultSet getAllClient(Connection connection){
		ResultSet a = null;
		try{
			String sql = "select * from client";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			
			a = prdstmt.executeQuery();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return a;
	}
	public boolean isNotRelated(Connection connection, String driverLicense){
		ResultSet a = null;
		boolean b = false;
		try{
			String sql = "SELECT DLicense_Number FROM transaction A, client B WHERE A.Client_ID = B.DLicense_Number AND B.DLicense_Number = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			
			a = prdstmt.executeQuery();
			b = a.next();
		}
		catch(SQLException e){
			
		}
		return (b == false)? true: false;
	}
	public boolean isNotMember(Connection connection, String driverID){
		ResultSet a = null;
		boolean isNotMem = false;
		try{
			String sql = "SELECT DLicense_Number FROM client WHERE DLicense_Number = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, driverID);
			
			a = prdstmt.executeQuery();
			isNotMem = a.next();
		}
		catch(SQLException e){
			
		}
		return (isNotMem == false) ? true: false;
	}
	
	public double getTotalFee(Connection connection, String id){
		ResultSet a = null;
		double totalFee = 0;
		try{
			String sql = "SELECT carPrice FROM inventory WHERE plateNumber = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, id);
			
			a = prdstmt.executeQuery();
			while(a.next()){
			totalFee = a.getDouble("carPrice");
			break;
			}
		}
		catch(SQLException e){
			
		}
		return totalFee;
	}
	
	public static boolean isATransaction(Connection connection, int id){
		ResultSet a = null;
		boolean car = false;
		try{
			String sql = "SELECT * FROM transaction WHERE ID = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setInt(1, id);

			a = prdstmt.executeQuery();
			car = a.next();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return (car == true)? true: false;
	}
	public static boolean isAClient(Connection connection, String Driver_License){
		ResultSet a = null;
		boolean car = false;
		try{
			String sql = "SELECT * FROM client WHERE DLicense_Number = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, Driver_License);

			a = prdstmt.executeQuery();
			car = a.next();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return (car == true)? true: false;
	}
}
