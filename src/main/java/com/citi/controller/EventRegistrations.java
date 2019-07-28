package com.citi.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventRegistrations {

	
	@RequestMapping("/event/register/{details}")
	@ResponseBody
    Map<String, String> insertEvent(@PathVariable("details")String details) {
		Map<String, String> result = new HashMap<>();
		
		 System.out.println("starting");
	         try {
	             Class.forName("com.mysql.jdbc.Driver");
	             String username ="CitiAdmin";
	             String password = "citihack2019";
	             Connection con = DriverManager.getConnection("jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username, password);
	 
	             Statement stmt = con.createStatement();
	             
	             String eventID = details.split(":")[0];
	             String userID = details.split(":")[1];
	             
	             stmt.executeUpdate("insert into EventRegistrations (EventID, UserID, Signuptime, Status) Values (" + eventID + "," + userID + ",now(),'pending')");
	             System.out.println("Inserted data");
	             
	            
	             con.close();
	         } catch (Exception e) {
	             System.out.println(e);
	         }
	        
		return result;
//        return "Well Done!! Nice Try!! Good bye!";
    }
	
	
	@RequestMapping("/event/withdraw/{details}")
	@ResponseBody
    Map<String, String> withdrawEvent(@PathVariable("details")String details) {
		Map<String, String> result = new HashMap<>();
		
		 System.out.println("starting");
	         try {
	             Class.forName("com.mysql.jdbc.Driver");
	             String username ="CitiAdmin";
	             String password = "citihack2019";
	             Connection con = DriverManager.getConnection("jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username, password);
	 
	             Statement stmt = con.createStatement();
	             
	             String eventID = details.split(":")[0];
	             String userID = details.split(":")[1];
	          
	             
	             stmt.executeUpdate("update EventRegistrations SET Status = 'withdrawn' where EventID = '" + eventID + "' AND UserID = '" + userID + "'");
	             System.out.println("Updated data");
	             
	            
	             con.close();
	         } catch (Exception e) {
	             System.out.println(e);
	         }
	        
		return result;
//        return "Well Done!! Nice Try!! Good bye!";
    }
	
	
	@RequestMapping("/event/getEventRegistrations/{id}")
	 @ResponseBody
	  ArrayList<HashMap<String, String>> viewEventRegistrationByID(@PathVariable("id") int userID) {
	  ArrayList<HashMap<String, String>> result = new ArrayList<>();
	  
	   System.out.println("starting");
	          try {
	              Class.forName("com.mysql.jdbc.Driver");
	              String username ="CitiAdmin";
	              String password = "citihack2019";
	              Connection con = DriverManager.getConnection("jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username, password);
	  
	              Statement stmt = con.createStatement();
	              ResultSet rs = stmt.executeQuery("select * from EventRegistrations where UserID = " + userID + " and Status in ('Pending', 'Registered')");
	              System.out.println("Pulled data");
	              
	              while (rs.next()) {
	               HashMap<String, String> rsJSON = new HashMap<>();
	               rsJSON.put("EventID", rs.getString(1));

	               rsJSON.put("UserID", rs.getString(2));
	               rsJSON.put("Signuptime", rs.getString(3));
	               rsJSON.put("Status", rs.getString(4));
	               
	               result.add(rsJSON);
	                  //return "Read from database : " + rs.getString(1) + "  " + rs.getString(2) ;
	              }
	              con.close();
	          } catch (Exception e) {
	              System.out.println(e);
	          }
	         
	  return result;
//	        return "Well Done!! Nice Try!! Good bye!";
	    }
	
	
	
}
