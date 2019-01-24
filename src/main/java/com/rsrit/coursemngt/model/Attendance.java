/**
 * 
 */
package com.rsrit.coursemngt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * @author Anupama
 *
 */
@Entity
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long attendanceId;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Session session;
	private long studentsIds;
	private boolean present;

	public Attendance() {
		super();
	}

	public long getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(long attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public long getStudentsIds() {
		return studentsIds;
	}

	public void setStudentsIds(long studentsIds) {
		this.studentsIds = studentsIds;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

}
