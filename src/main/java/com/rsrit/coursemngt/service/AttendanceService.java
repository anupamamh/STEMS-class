package com.rsrit.coursemngt.service;

import java.util.List;

import com.rsrit.coursemngt.model.Attendance;
import com.rsrit.coursemngt.model.Session;

public interface AttendanceService {
	void addAttendance(Attendance attendance);

	Attendance updateAttendance(Attendance attendance);

	public Attendance findDuplicateAttendance(long sessionId, long attndStudentIds);

	List<Attendance> attendanceList(Session session);
}
