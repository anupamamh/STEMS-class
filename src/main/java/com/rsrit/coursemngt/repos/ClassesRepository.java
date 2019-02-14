package com.rsrit.coursemngt.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rsrit.coursemngt.model.Class;

public interface ClassesRepository extends JpaRepository<Class, Long> {
	
	@Query("Select c from Class as c where c.className=:className")
	public Class findByClassName(@Param("className") String className);
	
	@Query("Select c from Class as c where c.trainerId=:trainerId")
	public List<Class> getClassByTrainerId(@Param("trainerId") Long trainerId);
	
	public List<Class> getClassByStudentsIds(Long studentId);
	}
