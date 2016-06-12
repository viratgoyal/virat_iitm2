package services;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.way2sms.SMS;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Properties;

@Path("/UserService")
public class LocationService {

	LocationDao lDao;

	public LocationService() {
		lDao = new LocationDao();
		System.out.println("LocationDao object created");
	}

	@GET
	@Path("/cutomerSms")
	public String sendSMSToCustomer(@QueryParam("order_id") String orderId) throws IOException, SQLException {

		String customerNumber = lDao.getCustomerNumber(orderId);
		
		String smsText = "Your order id "+orderId +"with Amazon is out for delivery. Please click the link folowing"
				+ " if you are currently at location of expected delivery,for faster delivery "
				+ "https://shadowsms.byethost32.com/getLoc.htm?orderId="+orderId;
		
		//add code to send sms to customer
		
		return "smsSentToCustomer";
	}

	@Path("/setCoordinates")
	@GET
	public String setCoordinates(@QueryParam("lat") String lat, @QueryParam("lon") String lon,
			@QueryParam("orderId") String orderId) throws IOException, SQLException {

		System.out.println("service hit");
		System.out.println(lat);
		System.out.println(lon);
		System.out.println(orderId);
		
		lDao.enterCustomerCordinates(lat, lon, orderId);
		
		sendSMSToRider(lat,lon,orderId);
		
		return "you can exit window";

	}
	
	public void sendSMSToRider(String lat,String lon,String orderId) throws SQLException
	{
		String riderContact = lDao.getRiderContact(orderId);
		String smsText = "Coordinates of delivery for order id:"+orderId+" are latitude: "+lat+" longitude: "+lon ;
		
		
		//add code for sending sms to rider
		
		System.out.println("sms sent to rider");
	}
}
