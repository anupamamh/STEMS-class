package com.rsrit.coursemngt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.coursemngt.model.Schedule;
import com.rsrit.coursemngt.repos.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Override
	public List<Schedule> getAllSchedules() {
		return scheduleRepository.findAll();
	}

	@Override
	public Schedule getScheduleById(int scheduleId) {
		return scheduleRepository.getOne(scheduleId);
	}

	@Override
	public void addSchedule(Schedule schedule) {
		scheduleRepository.save(schedule);
	}

	@Override
	public Schedule updateScheduleById(Schedule schedule, int scheduleId) {
		scheduleRepository.getOne(scheduleId);
		return scheduleRepository.save(schedule);
	}

	@Override
	public void deleteScheduleById(int scheduleId) {
		scheduleRepository.deleteById(scheduleId);
	}

	@Override
	public void deleteAllSchedules() {
		scheduleRepository.deleteAll();
	}

}
