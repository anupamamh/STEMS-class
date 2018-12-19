package com.rsrit.coursemngt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rsrit.coursemngt.model.Schedule;
import com.rsrit.coursemngt.service.ScheduleService;

@RestController
public class ScheduleRESTController {

	@Autowired
	ScheduleService scheduleService;

	@GetMapping("/schedules")
	public List<Schedule> getAllSchedules() {
		return scheduleService.getAllSchedules();

	}

	@GetMapping("/schedules/{id}")
	public Schedule getScheduleById(@PathVariable int scheduleId) {
		return scheduleService.getScheduleById(scheduleId);

	}

	@PostMapping("/schedules")
	public void addSchedule(@RequestBody Schedule schedule) {
		scheduleService.addSchedule(schedule);
	}

	@PutMapping("/schedules/{id}")
	public void updateSchedule(@RequestBody Schedule schedule, @PathVariable int scheduleId) {
		scheduleService.updateScheduleById(schedule, scheduleId);
	}

	@DeleteMapping("/schedules/{id}")
	public void deleteScheduleById(int scheduleId) {
		scheduleService.deleteScheduleById(scheduleId);
	}

	@DeleteMapping("/schedules")
	public void deleteAllSchedules() {
		scheduleService.deleteAllSchedules();
	}

}
