package services;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class LocationService {

 //  UserDao userDao = new UserDao();

   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public String getUsers(){
	   
	// Replace DEMO_USERNAME with username of your account
			String username = "9600094441";
			// Replace DEMO_PASSWORD with password of your account
			String password = "44cc73";
			// Replace TARGET_MOBILE with a valid mobile number
			String toMobile = "9897133506";

			String toMessage = "Test message from http://cooljapps.blogspot.com";

			FullOnSMS fullOnSMS = new FullOnSMS(username, password);
			try {
				if (fullOnSMS.isLoggedIn() && fullOnSMS.sendSMS(toMobile, toMessage)) {
					fullOnSMS.logoutSMS();
					System.out.println("Message was sent successfully ");
				}
			} catch (IOException e) {
				System.out.println("Unable to send message, possible cause: " + e.getMessage());
			}
	   
      return "hello world";
   }	
}