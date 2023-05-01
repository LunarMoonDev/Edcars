package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class faqsBean {
	private String questionFaqs;
	private String answerFaqs;
	public String getQuestionFaqs() {
		return questionFaqs;
	}
	public void setQuestionFaqs(String questionFaqs) {
		this.questionFaqs = questionFaqs;
	}
	public String getAnswerFaqs() {
		return answerFaqs;
	}
	public void setAnswerFaqs(String answerFaqs) {
		this.answerFaqs = answerFaqs;
	}
	
	public void insert(Connection connection){
		try{
			String sql ="INSERT into faqs(Faqs_Question, Faqs_Answer)  values (?,?)";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, questionFaqs);
			prdstmt.setString(2, answerFaqs);
			
			prdstmt.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public ResultSet getAll(Connection connection){
		ResultSet table = null;
		try{
			String sql = "select * from faqs";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			
			table = prdstmt.executeQuery();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return table;
	}
	public void update(Connection connection, HashMap<String, String> updateRequests, String []fields, int id){
		int i;
		for(i = 0; i<fields.length ; i++){
			updateStatement(connection, fields[i], updateRequests.get(fields[i]), id);
		}
	}
	public void updateStatement(Connection connection, String field, String value, int id){
		try{
			String sql = "UPDATE faqs SET "+field+" = ? WHERE id = "+(char)39 +id+(char)39;
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, value);
			prdstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void delete(Connection connection, int[] id){
		for(int i = 0; i < id.length; i++){
			deleteStatement(connection, id[i]);
		}
	}
	public void deleteStatement(Connection connection, int id){
		try{
			String sql = "DELETE FROM faqs WHERE id = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setInt(1, id);
			
			
			prdstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static boolean isAFAQS(Connection connection, int id){
		ResultSet a = null;
		boolean faqs = false;
		try{
			String sql = "SELECT * FROM faqs WHERE id = ?";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setInt(1, id);

			a = prdstmt.executeQuery();
			faqs = a.next();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return (faqs == true)? true: false;
	}
	public ResultSet view(Connection connection){
		ResultSet a = null;
		try{
			String sql = "select * from faqs";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			a = prdstmt.executeQuery();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return a;
	}
}
