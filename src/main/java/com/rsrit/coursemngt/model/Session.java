package com.rsrit.coursemngt.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sessionId;
	private Timestamp createdOn;
	private double runTime;
	private String attendeeIds;
	private String absenteeIds;
	private boolean isAssignmentProvided;
	private String listOfTopics;
	@ManyToOne
	private Classes classes;

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public double getRunTime() {
		return runTime;
	}

	public void setRunTime(double runTime) {
		this.runTime = runTime;
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

	public boolean isAssignmentProvided() {
		return isAssignmentProvided;
	}

	public void setAssignmentProvided(boolean isAssignmentProvided) {
		this.isAssignmentProvided = isAssignmentProvided;
	}

	public String getListOfTopics() {
		return listOfTopics;
	}

	public void setListOfTopics(String listOfTopics) {
		this.listOfTopics = listOfTopics;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", createdOn=" + createdOn + ", runTime=" + runTime
				+ ", attendeeIds=" + attendeeIds + ", absenteeIds=" + absenteeIds + ", isAssignmentProvided="
				+ isAssignmentProvided + ", listOfTopics=" + listOfTopics + ", classes=" + classes + "]";
	}

}
