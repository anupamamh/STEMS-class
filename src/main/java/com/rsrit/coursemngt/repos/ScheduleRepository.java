package com.rsrit.coursemngt.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrit.coursemngt.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
