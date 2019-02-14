package com.rsrit.coursemngt.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long classId;
	@NotNull
	@Size(min = 3, max = 15)
	private String className;
	private long trainerId;
	private String trainerName;
	@ElementCollection
	private List<Long> studentsIds;
	@JsonProperty(access = Access.WRITE_ONLY)
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT, pattern = "dd-MM-yyyy hh:mm:ss")
	private Timestamp createdOn;
	private long createdBy;
	@OneToMany(mappedBy = "classes", cascade = CascadeType.ALL)
	private List<Session> listOfSessions = new ArrayList<Session>();
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "scheduleId")
	private Schedule schedule;

	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Class(long classId, @NotNull @Size(min = 3, max = 15) String className, long trainerId, String trainerName,
			List<Long> studentsIds, Timestamp createdOn, long createdBy, List<Session> listOfSessions,
			Schedule schedule) {
		super();
		this.classId = classId;
		this.className = className;
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.studentsIds = studentsIds;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.listOfSessions = listOfSessions;
		this.schedule = schedule;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(long trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public List<Long> getStudentsIds() {
		return studentsIds;
	}

	public void setStudentsIds(List<Long> studentsIds) {
		this.studentsIds = studentsIds;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public List<Session> getListOfSessions() {
		return listOfSessions;
	}

	public void setListOfSessions(List<Session> listOfSessions) {
		this.listOfSessions = listOfSessions;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + ", trainerId=" + trainerId
				+ ", trainerName=" + trainerName + ", studentsIds=" + studentsIds + ", createdOn=" + createdOn
				+ ", createdBy=" + createdBy + ", listOfSessions=" + listOfSessions + ", schedule=" + schedule + "]";
	}

}
