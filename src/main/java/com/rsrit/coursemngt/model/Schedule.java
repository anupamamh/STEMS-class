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
	private List<String> topics;
	private int numberOfSessions;
	@OneToOne
	private Class classes;

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

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

	public int getNumberOfSessions() {
		return numberOfSessions;
	}

	public void setNumberOfSessions(int numberOfSessions) {
		this.numberOfSessions = numberOfSessions;
	}

	public Class getClasses() {
		return classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", scheduleStartDate=" + scheduleStartDate + ", scheduleEndDate="
				+ scheduleEndDate + ", topicsIds=" + topics + ", numberOfSessions=" + numberOfSessions + ", classes="
				+ classes + "]";
	}

}
