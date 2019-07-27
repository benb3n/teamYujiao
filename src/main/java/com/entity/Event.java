package com.entity;

import java.util.*;

public class Event {

	public class Event {
		// TODO Auto-generated method stub
		
		private String eventID;
		private String eventName;
		private String eventDescription;
		private Date startTime;
		private Date endTime;
		private String minPax;
		private String maxPax; 
		private String organiserID;
		private String signupCount;
		private String status;
		
		public Event(int eventID, String eventName, String eventDescription, Date startTime, Date endTime, int minPax,
				int maxPax, int organiserID, int signupCount, String status) {
			this.eventID = eventID;
			this.eventName = eventName;
			this.eventDescription = eventDescription;
			this.startTime = startTime;
			this.endTime = endTime;
			this.minPax = minPax;
			this.maxPax = maxPax;
			this.organiserID = organiserID;
			this.signupCount = signupCount;
			this.status = status;
		}
		
		
		public int getEventID() {
			return eventID;
		}
		public void setEventID(int eventID) {
			this.eventID = eventID;
		}
		public String getEventName() {
			return eventName;
		}
		public void setEventName(String eventName) {
			this.eventName = eventName;
		}
		public String getEventDescription() {
			return eventDescription;
		}
		public void setEventDescription(String eventDescription) {
			this.eventDescription = eventDescription;
		}
		public Date getStartTime() {
			return startTime;
		}
		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}
		public Date getEndTime() {
			return endTime;
		}
		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}
		public int getMinPax() {
			return minPax;
		}
		public void setMinPax(int minPax) {
			this.minPax = minPax;
		}
		public int getMaxPax() {
			return maxPax;
		}
		public void setMaxPax(int maxPax) {
			this.maxPax = maxPax;
		}
		public int getOrganiserID() {
			return organiserID;
		}
		public void setOrganiserID(int organiserID) {
			this.organiserID = organiserID;
		}
		public int getSignupCount() {
			return signupCount;
		}
		public void setSignupCount(int signupCount) {
			this.signupCount = signupCount;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		

	}

}
