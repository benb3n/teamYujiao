package com.citi.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
	
	@RequestMapping("/event/view/{id}")
	@ResponseBody
	
	ArrayList<HashMap<String, String>> viewEventRegistrationByID(@PathVariable("id") int eventID) {
		  ArrayList<HashMap<String, String>> result = new ArrayList<>();
	
    //Map<String, String> viewEvent(@PathVariable("id") int eventID) {
		//Map<String, String> result = new HashMap<>();
		
		 System.out.println("starting");
	         try {
	             Class.forName("com.mysql.jdbc.Driver");
	             String username ="CitiAdmin";
	             String password = "citihack2019";
	             Connection con = DriverManager.getConnection("jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username, password);
	 
	             Statement stmt = con.createStatement();
	             ResultSet rs = stmt.executeQuery("select * from Events where EventID = " + eventID);
	             System.out.println("Pulled data");
	             
	             while (rs.next()) {
	            	 HashMap<String, String> rsJSON = new HashMap<>();
	            	 rsJSON.put("OrganiserID", rs.getString(1));
	            	 
	            	 result.add(rsJSON);
	            	 
	                 //return "Read from database : " + rs.getString(1) + "  " + rs.getString(2) ;
	             }
	             con.close();
	         } catch (Exception e) {
	             System.out.println(e);
	         }
	        
		return result;
//        return "Well Done!! Nice Try!! Good bye!";
    }
	
	
	@RequestMapping("/event/view/")
	@ResponseBody
	ArrayList<HashMap<String, String>> viewAllEvents() {
		  ArrayList<HashMap<String, String>> result = new ArrayList<>();
	
    //Map<String, String> viewAllEvents() {
		//Map<String, String> result = new HashMap<>();
		
		 System.out.println("starting");
	         try {
	             Class.forName("com.mysql.jdbc.Driver");
	             String username ="CitiAdmin";
	             String password = "citihack2019";
	             Connection con = DriverManager.getConnection("jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username, password);
	 
	             Statement stmt = con.createStatement();
	             ResultSet rs = stmt.executeQuery("select * from Events");
	             System.out.println("Pulled data");
	             
	             while (rs.next()) {
	            	 
	            	 HashMap<String, String> rsJSON = new HashMap<>();
	            	 
	            	 rsJSON.put("EventID", rs.getString(1));
	            	 //rsJSON.put("OrganiserID", rs.getString(2));
	            	 rsJSON.put("EventName", rs.getString(3));
	            	 rsJSON.put("EventDescription", rs.getString(4));
	            	 //rsJSON.put("StartTime", rs.getString(5));
	            	 //rsJSON.put("EndTime", rs.getString(6));
	            	 rsJSON.put("MinPax", ""+rs.getInt(1));
	            	 rsJSON.put("MaxPax", ""+rs.getInt(2));
	            	 rsJSON.put("SignupCount", ""+rs.getInt(3));
	            	 rsJSON.put("Status", rs.getString(7));
	            	 
	            	 result.add(rsJSON);
	            	 
	                 //return "Read from database : " + rs.getString(1) + "  " + rs.getString(2) ;
	             }
	             con.close();
	         } catch (Exception e) {
	             System.out.println(e);
	         }
	    System.out.println(result.size());  
	    System.out.println("hi1");  
		return result;
//        return "Well Done!! Nice Try!! Good bye!";
    }
	
	
	@RequestMapping("/event/view/date/{Dates}")
	@ResponseBody
    Map<String, String> viewAllEventsFromDates(@PathVariable("Dates")String Dates) {
		Map<String, String> result = new HashMap<>();
		
		 System.out.println("starting");
	         try {
	             Class.forName("com.mysql.jdbc.Driver");
	             String username ="CitiAdmin";
	             String password = "citihack2019";
	             Connection con = DriverManager.getConnection("jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username, password);
	 
	             Statement stmt = con.createStatement();
	             
	             String fromDate = Dates.split(":")[0];
	             String toDate = Dates.split(":")[1];
	             
	             ResultSet rs = stmt.executeQuery("select * from Events where StartTime > " + "'" + fromDate + "' AND EndTime < '" + toDate + "'");
	             System.out.println("Pulled data");
	             
	             while (rs.next()) {
	            	 result.put("EventID", rs.getString(1));
	            	 result.put("OrganiserID", rs.getString(2));
	            	 result.put("EventName", rs.getString(3));
	            	 result.put("EventDescription", rs.getString(4));
	            	 result.put("StartTime", rs.getString(5));
	            	 result.put("EndTime", rs.getString(5));
	            	 result.put("MinPax", ""+rs.getInt(1));
	            	 result.put("MaxPax", ""+rs.getInt(2));
	            	 result.put("SignupCount", ""+rs.getInt(3));
	            	 result.put("Status", rs.getString(6));
	            	 
	                 //return "Read from database : " + rs.getString(1) + "  " + rs.getString(2) ;
	             }
	             con.close();
	         } catch (Exception e) {
	             System.out.println(e);
	         }
	        
		return result;
//        return "Well Done!! Nice Try!! Good bye!";
    }
	
	
	@RequestMapping("/event/getEvents/search/{eventName}")
	@ResponseBody
    Map<String, String> viewAllEventsByName(@PathVariable("eventName")String eventName) {
		Map<String, String> result = new HashMap<>();
		
		 System.out.println("starting");
	         try {
	             Class.forName("com.mysql.jdbc.Driver");
	             String username ="CitiAdmin";
	             String password = "citihack2019";
	             Connection con = DriverManager.getConnection("jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username, password);
	 
	             Statement stmt = con.createStatement();
	             ResultSet rs = stmt.executeQuery("select * from Events where eventName like '%" + eventName + "%'");
	             System.out.println("Pulled data");
	             
	             while (rs.next()) {
	            	 result.put("EventID", rs.getString(1));
	            	 result.put("OrganiserID", rs.getString(2));
	            	 result.put("EventName", rs.getString(3));
	            	 result.put("EventDescription", rs.getString(4));
	            	 result.put("StartTime", rs.getString(5));
	            	 result.put("EndTime", rs.getString(5));
	            	 result.put("MinPax", ""+rs.getInt(1));
	            	 result.put("MaxPax", ""+rs.getInt(2));
	            	 result.put("SignupCount", ""+rs.getInt(3));
	            	 result.put("Status", rs.getString(6));
	            	 
	                 //return "Read from database : " + rs.getString(1) + "  " + rs.getString(2) ;
	             }
	             con.close();
	         } catch (Exception e) {
	             System.out.println(e);
	         }
	        
		return result;
//        return "Well Done!! Nice Try!! Good bye!";
    }
	
	
	@RequestMapping("/event/getEvents")
	@ResponseBody
    Map<String, String> viewAllEventsFromToday() {
		Map<String, String> result = new HashMap<>();
		
		 System.out.println("starting");
	         try {
	             Class.forName("com.mysql.jdbc.Driver");
	             String username ="CitiAdmin";
	             String password = "citihack2019";
	             Connection con = DriverManager.getConnection("jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username, password);
	 
	             Statement stmt = con.createStatement();
	             
	             
	             ResultSet rs = stmt.executeQuery("select * from Events where StartTime > now()");
	             System.out.println("Pulled data");
	             
	             while (rs.next()) {
	            	 result.put("EventID", rs.getString(1));
	            	 result.put("OrganiserID", rs.getString(2));
	            	 result.put("EventName", rs.getString(3));
	            	 result.put("EventDescription", rs.getString(4));
	            	 result.put("StartTime", rs.getString(5));
	            	 result.put("EndTime", rs.getString(5));
	            	 result.put("MinPax", ""+rs.getInt(1));
	            	 result.put("MaxPax", ""+rs.getInt(2));
	            	 result.put("SignupCount", ""+rs.getInt(3));
	            	 result.put("Status", rs.getString(6));
	            	 
	                 //return "Read from database : " + rs.getString(1) + "  " + rs.getString(2) ;
	             }
	             con.close();
	         } catch (Exception e) {
	             System.out.println(e);
	         }
	        
		return result;
//        return "Well Done!! Nice Try!! Good bye!";
    }
	
	
	

}
