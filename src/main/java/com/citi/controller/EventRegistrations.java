package com.citi.controller;

import java.util.*;

public class EventRegistrations {

	public EventRegistrations(String eventID, String userID, Date signupTime, String status, String feedback) {
		super();
		this.eventID = eventID;
		this.userID = userID;
		this.signupTime = signupTime;
		this.status = status;
		this.feedback = feedback;
	}
	
	private String eventID;
	private String userID;
	private Date signupTime;
	private String status;
	private String feedback;
	
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Date getSignupTime() {
		return signupTime;
	}
	public void setSignupTime(Date signupTime) {
		this.signupTime = signupTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
}
