package com.rsrit.coursemngt.service;

import java.util.List;

import com.rsrit.coursemngt.model.Schedule;

public interface ScheduleService {

	List<Schedule> getAllSchedules();
	
	Schedule getScheduleById(int scheduleId);
	
	void addSchedule(Schedule schedule);
	
	Schedule updateScheduleById(Schedule schedule, int scheduleId);
	
	void deleteScheduleById(int scheduleId);
	
	void deleteAllSchedules();
}
