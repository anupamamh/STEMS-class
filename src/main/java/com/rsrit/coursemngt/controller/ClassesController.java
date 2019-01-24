package com.rsrit.coursemngt.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rsrit.coursemngt.exception.ClassDoesNotExistsException;
import com.rsrit.coursemngt.model.Class;
import com.rsrit.coursemngt.model.Schedule;
import com.rsrit.coursemngt.service.ClassesService;
import com.rsrit.coursemngt.service.ScheduleService;

@RestController
public class ClassesController {

	private static final Logger logger = LogManager.getLogger(ClassesController.class.getName());

	public ClassesController() {
		System.out.println("--------Classes REST Controller-----------");
	}

	@Autowired
	private ClassesService classesService;
	@Autowired
	private ScheduleService scheduleService;

	// displaying list of available Classes
	@GetMapping("/classes")
	public List<Class> getAllClasses() throws ClassDoesNotExistsException {
		try {
			logger.info("Classes Controller getAllClasses() STARTED");
			return classesService.getAllClasses();
		} catch (ClassDoesNotExistsException e) {

			throw new ClassDoesNotExistsException("There are no claasses found", e, 404);
		}
	}

	// retrieving classes by studentID or trainerId
	@GetMapping("/classes/{Id}")
	public Class getClassesByIds(@RequestParam long studentId, @RequestParam long trainerId) {

		if (String.valueOf(studentId) != null) {
			return classesService.getClassByStudentId(studentId);
		} else {
			return classesService.getClassByTrainerId(trainerId);
		}

	}

	/*
	 * // displaying class by id
	 * 
	 * @GetMapping("/classes/{id}") public Classes getClassById(@PathVariable long
	 * id) throws Exception { logger.info("Classes Controller getClass() STARTED");
	 * // System.out.println(); return classesService.getClassById(id);
	 * 
	 * }
	 */

	// displaying class by className
	@GetMapping("/classes/{name}")
	public Class getClassByClassName(@PathVariable String name) throws Exception {
		return classesService.getClassByName(name);

	}

	// inserting class
	@PostMapping("/classes")
	public void addClass(@RequestBody @Valid Class classes) {
		logger.info("Classes Controller addClass() STARTED");
		/*
		 * if (classes.getClassId() == 0) { if (classes.getClassName() == "" ||
		 * classes.getClassName().length() == 0) { classes.setClassName(null); }
		 */
		classes.setCreatedOn(Timestamp.from(Instant.now()));
		logger.info("Classes Controller addClass() END");
		classesService.addClass(classes);
		// }
	}

	/*
	 * // updating class by id
	 * 
	 * @PutMapping("/classes/{id}") public void updateClass(@RequestBody Classes
	 * classes, @PathVariable int classId) {
	 * logger.info("Classes Controller updateClass() STARTED");
	 * classesService.updateClass(classes, classId); }
	 */
	// updating class by id
	@PutMapping("/classes")
	public void updateClass(@RequestBody Class classes) throws ClassDoesNotExistsException {
		if (classes.getClassId() != 0) {
			classes.setCreatedOn(Timestamp.from(Instant.now()));
			logger.info("Classes Controller updateClass() STARTED");
			classesService.updateClass(classes);
		} else {
			throw new ClassDoesNotExistsException("There is no claass/classId found to Update");
		}

	}

	// deleting class by id
	@DeleteMapping("/classes/{classId}")
	public void deleteClassById(@PathVariable long classId) {
		logger.info("Classes Controller deleteClass() STARTED");

		if (!classesService.getClassById(classId).equals(null)) {
			classesService.deleteClassById(classId);
		} else {
			throw new ClassDoesNotExistsException("No Class Id given to delete a class");
		}
	}

	/*
	 * // deleting all the classes
	 * 
	 * @DeleteMapping("/classes") public void deleteAllClasses() {
	 * logger.info("Classes Controller deleteAllClasses() STARTED");
	 * classesService.deleteAllClasses(); }
	 */
	@PostMapping("/{classId}/schedule")
	public void addSchedule(@RequestBody Schedule schedule, @PathVariable long classId)throws ClassDoesNotExistsException {
		try {
		Class classToAddSchedule = classesService.getClassById(classId);
		if (!classToAddSchedule.equals(null)) {
			schedule.setClasses(classToAddSchedule);
			scheduleService.addSchedule(schedule);
			classToAddSchedule.setSchedule(schedule);
			classesService.updateClass(classToAddSchedule);
		}
		}catch (RuntimeException e) {
			throw new ClassDoesNotExistsException("Class not found for the given Id", e, 404);
		}
 
	}

	@GetMapping("/{classId}/schedule")
	public Schedule getAllSchedules(@PathVariable long classId)throws ClassDoesNotExistsException {
		try {
		Class classToGetSchedule = classesService.getClassById(classId);
		if(!classToGetSchedule.equals(null)) {
		return classToGetSchedule.getSchedule();
		}else
		{
			System.out.println("in else block");
			return null;
		}
		
		}
		catch(RuntimeException e){
			throw new ClassDoesNotExistsException("No Class found for the given Class Id.", e, 404);
		}
		
	}

	@PutMapping("/{classId}/schedule/{scheduleId}")
	public void updateSchedule(@RequestBody Schedule schedule, @PathVariable int scheduleId,
			@PathVariable long classId)throws ClassDoesNotExistsException {
		try {
		Class classToUpdateSchedule = classesService.getClassById(classId);
		schedule.setClasses(classToUpdateSchedule);
		scheduleService.updateScheduleById(schedule, scheduleId);
		}
		catch(RuntimeException e){
			throw new ClassDoesNotExistsException("No Class found for the given Class Id.", e, 404);
		}
	}

}
