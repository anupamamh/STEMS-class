package com.rsrit.coursemngt.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sessionId;
	private Timestamp createdOn;
	private double sessionDuration;
	// private List<long> listOfAttendeeIds = new ArrayList<long>();
	/*
	 * private List<Long> listOfAttendeeIds = new ArrayList<Long>(); private
	 * List<Long> listOfAbsenteeIds = new ArrayList<Long>();
	 */
	@OneToMany(mappedBy = "session")
	private List<Attendance> listOfAttendeeIds = new ArrayList<Attendance>();
	private boolean isAssignmentGiven;
	private String listOfTopics;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Class classes;

	
	

	public long getSessionId() {
		return sessionId;
	}

	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public double getSessionDuration() {
		return sessionDuration;
	}

	public void setSessionDuration(double sessionDuration) {
		this.sessionDuration = sessionDuration;
	}

	public List<Attendance> getListOfAttendeeIds() {
		return listOfAttendeeIds;
	}

	public void setListOfAttendeeIds(List<Attendance> listOfAttendeeIds) {
		this.listOfAttendeeIds = listOfAttendeeIds;
	}

	public boolean isAssignmentGiven() {
		return isAssignmentGiven;
	}

	public void setAssignmentGiven(boolean isAssignmentGiven) {
		this.isAssignmentGiven = isAssignmentGiven;
	}

	public String getListOfTopics() {
		return listOfTopics;
	}

	public void setListOfTopics(String listOfTopics) {
		this.listOfTopics = listOfTopics;
	}

	public Class getClasses() {
		return classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", createdOn=" + createdOn + ", sessionDuration=" + sessionDuration
				+ ", listOfAttendeeIds=" + listOfAttendeeIds + ", isAssignmentGiven=" + isAssignmentGiven
				+ ", listOfTopics=" + listOfTopics + ", classes=" + classes + "]";
	}

}
