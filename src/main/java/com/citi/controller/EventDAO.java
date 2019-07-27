package com.citi.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventDAO {
	
	@RequestMapping("/event/view/{id}")
	@ResponseBody
    Map<String, String> viewEvent(@PathVariable("id") int eventID	) {
		Map<String, String> result = new HashMap<>();
		
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
	            	 result.put("OrganiserID", rs.getString(1));
	            	 
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
