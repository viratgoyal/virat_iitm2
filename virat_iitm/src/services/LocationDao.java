package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LocationDao {

	private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/db";
	private static String dbUsername = "root";
	private static String dbPassword = "virat8536";

	Connection connection = null;
	Statement stmt = null;
	
	public LocationDao() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			System.out.println("connection created");
			//connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterCustomerCordinates(String latitude, String longitude, String orderId) throws SQLException
	{
		
		stmt = connection.createStatement();
	      
	      String sql = "INSERT INTO customer_coordinate " +
	                   "VALUES ("+orderId+", '"+latitude+"', '"+longitude+"')";
	      stmt.executeUpdate(sql);
	}
	
	public String getRiderContact(String orderId) throws SQLException
	{
		String riderContact="";
		stmt = connection.createStatement();
	      
	      String sql = "Select rider_contact from order_details " +"where (order_id="+orderId+")";
	      ResultSet rs = stmt.executeQuery(sql);
	      rs.next();
	      riderContact = rs.getString(1);
	      System.out.println("riderContact = "+riderContact);
	      return riderContact;
	}
	
	public void enterRiderCordinates(String latitude, String longitude, String riderId) throws SQLException
	{
		
		stmt = connection.createStatement();
	      
	      String sql = "INSERT INTO rider_coordinate " +
	                   "VALUES ("+riderId+", '"+latitude+"', '"+longitude+"')";
	      stmt.executeUpdate(sql);
	}

	public String getCustomerNumber(String orderId) throws SQLException
	{
		String customerNumber="";
		stmt = connection.createStatement();
	      
	      String sql = "Select customer_contact from order_details " +"where (order_id="+orderId+")";
	      ResultSet rs = stmt.executeQuery(sql);
	      rs.next();
	      customerNumber = rs.getString(1);
	      System.out.println("riderId = "+customerNumber);
	      return customerNumber;
	}
	
	public String getRiderCoordinates(String riderId) throws SQLException
	{
		String latitude="";
		String longitude="";
		stmt = connection.createStatement();
	      
	      String sql = "Select latitude,longitude from rider_coordinate " +"where (rider_id="+riderId+")";
	      ResultSet rs = stmt.executeQuery(sql);
	      while(rs.next());
	      rs.previous();
	      latitude = rs.getString(1);
	      longitude = rs.getString(2);
	      
	      return latitude+" "+longitude;
	}
}
