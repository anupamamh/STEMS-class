package com.rsrit.coursemngt.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scheduleId;
	private Timestamp scheduleStartDate;
	private Timestamp scheduleEndDate;
	@ElementCollection
	private List<String> topicsIds;
	private int numberOfSessions;
	@OneToOne
	private Classes classes;

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Timestamp getScheduleStartDate() {
		return scheduleStartDate;
	}

	public void setScheduleStartDate(Timestamp scheduleStartDate) {
		this.scheduleStartDate = scheduleStartDate;
	}

	public Timestamp getScheduleEndDate() {
		return scheduleEndDate;
	}

	public void setScheduleEndDate(Timestamp scheduleEndDate) {
		this.scheduleEndDate = scheduleEndDate;
	}

	public List<String> getTopicsIds() {
		return topicsIds;
	}

	public void setTopicsIds(List<String> topicsIds) {
		this.topicsIds = topicsIds;
	}

	public int getNumberOfSessions() {
		return numberOfSessions;
	}

	public void setNumberOfSessions(int numberOfSessions) {
		this.numberOfSessions = numberOfSessions;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", scheduleStartDate=" + scheduleStartDate + ", scheduleEndDate="
				+ scheduleEndDate + ", topicsIds=" + topicsIds + ", numberOfSessions=" + numberOfSessions + ", classes="
				+ classes + "]";
	}

}
