package com.rsrit.coursemngt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.coursemngt.model.Attendance;
import com.rsrit.coursemngt.model.Session;
import com.rsrit.coursemngt.repos.AttendanceRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private AttendanceRepository attendanceRepository;
	

	@Override
	public void addAttendance(Attendance attendance) {
		attendanceRepository.save(attendance);
	}
	/*
	@Override
	public void updateAttendance(Attendance attendance) {
		attendanceRepository.updateAttendance(attendance);
	}*/
	
	@Override
	public List<Attendance> attendanceList(Session session) {
		/*Attendance attendance;
		((attendance) entityManager.getTransaction()).
		Query("Select ATTENDANCE from ATTENDANCE AS A INNER JOIN SESSION  AS S ON A.SESSION_SESSION_ID =S.SESSION_ID");*/
		return null;
	}
	


	@Override
	public Attendance findDuplicateAttendance(long sessionId, long attndStudentIds) {
		return attendanceRepository.findDuplicateAttendance(sessionId,attndStudentIds);
		//return null;
	}

	@Override
	public Attendance updateAttendance(Attendance attendance) {
		Attendance atten;
		if(attendance.getAttendanceId()==0) {
		}
		System.out.println("attendance.getAttendanceId()"+attendance.getAttendanceId());
		atten=attendanceRepository.getOne(attendance.getAttendanceId());
		atten.setPresent(attendance.isPresent());
		return attendanceRepository.save(atten);
		
	}

}
