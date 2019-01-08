package com.rsrit.coursemngt.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sessionId;
	private Timestamp createdOn;
	private double sessionDuration;
	private String attendeeIds;
	private String absenteeIds;
	private boolean isAssignmentGiven;
	private String listOfTopics;
	@ManyToOne
	@JsonProperty(access=Access.WRITE_ONLY)
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

	public String getAttendeeIds() {
		return attendeeIds;
	}

	public void setAttendeeIds(String attendeeIds) {
		this.attendeeIds = attendeeIds;
	}

	public String getAbsenteeIds() {
		return absenteeIds;
	}

	public void setAbsenteeIds(String absenteeIds) {
		this.absenteeIds = absenteeIds;
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
		return "Session [sessionId=" + sessionId + ", createdOn=" + createdOn + ", runTime=" + sessionDuration
				+ ", attendeeIds=" + attendeeIds + ", absenteeIds=" + absenteeIds + ", isAssignmentProvided="
				+ isAssignmentGiven + ", listOfTopics=" + listOfTopics + ", classes=" + classes + "]";
	}

}
