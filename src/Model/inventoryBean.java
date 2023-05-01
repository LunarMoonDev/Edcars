package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.io.InputStream;
import java.sql.Connection;

public class inventoryBean {

	private String id;
	private String carBrand;
	private String carModel;
	private String carType;
	private int carYear;
	private String carStatus;
	private double carPrice;
	private String carColor;
	private InputStream carImage;
	private String motorNo;
	private String serialNo;
	private String fileNo;
	private String crNo;
	
	
	public String getMotorNo() {
		return motorNo;
	}
	public void setMotorNo(String motorNo) {
		this.motorNo = motorNo;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getCrNo() {
		return crNo;
	}
	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getCarYear() {
		return carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	public String getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}
	public double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	public InputStream getCarImage() {
		return carImage;
	}
	public void setCarImage(InputStream carImage) {
		this.carImage = carImage;
	}
	
	public void insert(Connection connection){
		try{
			String sql = "insert into inventory(plateNumber,carBrand, carModel, carType, carColour, carYear, carStatus, carPrice, carImage, motorNo, serialNo, fileNo, crNo) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, id);
			prdstmt.setString(2, carBrand);
			prdstmt.setString(3, carModel);
			prdstmt.setString(4, carType);
			prdstmt.setString(5, carColor);
			prdstmt.setInt(6, carYear);
			prdstmt.setString(7, carStatus);
			prdstmt.setDouble(8, carPrice);
			prdstmt.setBlob(9, carImage);
			prdstmt.setString(10, motorNo);
			prdstmt.setString(11, serialNo);
			prdstmt.setString(12, fileNo);
			prdstmt.setString(13, crNo);
			prdstmt.execute();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public ResultSet getAll(Connection connection){
		ResultSet a = null;
		try{
			String sql = "select * from inventory";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			
			a = prdstmt.executeQuery();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return a;
	}
	public void update(Connection connection, HashMap<String, Object> updateRequests, String []fields, String id){
		int i;
		for(i = 0; i<fields.length ; i++){
			updateStatement(connection, fields[i], updateRequests.get(fields[i]), id);
		}
	}
	public void updateStatement(Connection connection, String field, Object value, String id){
		try{
			String sql = "UPDATE inventory SET "+field+" = ? WHERE plateNumber = "+(char)39+id+(char)39 ;
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			if(field.equals("carImage")){
				InputStream image = (InputStream) value;
				prdstmt.setBlob(1, image);
			}
			else if(field.equals("carYear")){
				Integer year = (Integer) value;
				prdstmt.setInt(1, year.intValue());
			}
			else if(field.equals("carPrice")){
				Double price = (Double) value;
				prdstmt.setDouble(1, price.doubleValue());
			}
			else{
				String dataValue = (String)value;
				prdstmt.setString(1, dataValue);
			}
			prdstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void delete(Connection connection, String[] id){
		for(int i = 0; i < id.length; i++){
			deleteStatement(connection, id[i]);
		}
	}
	public void deleteStatement(Connection connection, String id){
		try{
			String sql = "DELETE FROM inventory WHERE plateNumber = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, id);
			
			
			prdstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public ResultSet view(Connection connection){
		ResultSet a = null;
		try{
			String sql = "select * from inventory where carStatus= ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, "Available");
			a = prdstmt.executeQuery();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return a;
	}
	public ResultSet getACar(Connection connection){
		ResultSet a = null;
		try{
			String sql = "SELECT * FROM inventory WHERE carBrand = ? AND carModel = ? AND carColour = ? AND carYear = ? AND carStatus = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, carBrand);
			prdstmt.setString(2, carModel);
			prdstmt.setString(3, carColor);
			prdstmt.setInt(4, carYear);
			prdstmt.setString(5, carStatus);

			a = prdstmt.executeQuery();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return a;
	}
	public static boolean isACar(Connection connection, String plateNumber){
		ResultSet a = null;
		boolean car = false;
		try{
			String sql = "SELECT * FROM inventory WHERE plateNumber = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, plateNumber);

			a = prdstmt.executeQuery();
			car = a.next();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return (car == true)? true: false;
	}
	public static boolean isACar(Connection connection, String carBrand, String carModel, String carColour, int year){
		ResultSet a = null;
		boolean car = false;
		try{
			String sql = "SELECT * FROM inventory WHERE carBrand = ? AND carModel = ? AND carColour = ? AND carYear = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, carBrand);
			prdstmt.setString(2, carModel);
			prdstmt.setString(3, carColour);
			prdstmt.setInt(4, year);

			a = prdstmt.executeQuery();
			car = a.next();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return (car == true)? true: false;
	}
	public static boolean isAvailable(Connection connection, String carBrand, String carModel, String carColour, int year){
		ResultSet a = null;
		String status = "";
		try{
			String sql = "SELECT * FROM inventory WHERE carBrand = ? AND carModel = ? AND carColour = ? AND carYear = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, carBrand);
			prdstmt.setString(2, carModel);
			prdstmt.setString(3, carColour);
			prdstmt.setInt(4, year);

			a = prdstmt.executeQuery();
			while(a.next()){
			status = a.getString("carStatus");
			break;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return (status.equals("Available"))? true: false;
	}
}
