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

import com.rsrit.coursemngt.exception.ClassesCustomGenericException;
import com.rsrit.coursemngt.model.Classes;
import com.rsrit.coursemngt.service.ClassesService;

@RestController
public class ClassesRESTController {

	private static final Logger logger = LogManager.getLogger(ClassesRESTController.class.getName());

	public ClassesRESTController() {
		System.out.println("--------Classes REST Controller-----------");
	}

	@Autowired
	private ClassesService classesService;

	/*
	 * @GetMapping("/classes") public Classes getClasses() { return
	 * classService.getClassByName("java"); }
	 */

	// displaying list of available Classes
	@GetMapping("/classes")
	public List<Classes> getAllClasses() {
		logger.info("Classes Controller getAllClasses() STARTED");
		return classesService.getAllClasses();

	}

	// retrieving classes by studentID or trainerId
	@GetMapping("/classes/{Id}")
	public Classes getClassesByIds(@RequestParam long studentId, @RequestParam long trainerId) {

		if (String.valueOf(studentId) != null) {
			return classesService.getClassByStudentId(studentId);
		} else {
			return classesService.getClassByTrainerId(trainerId);
		}

	}

	// displaying class by id
	@GetMapping("/classes/{id}")
	public Classes getClassById(@PathVariable int id) throws Exception {
		logger.info("Classes Controller getClass() STARTED");
		// System.out.println();
		return classesService.getClassById(id);

	}

	// displaying class by className
	@GetMapping("/classes/{name}")
	public Classes getClassByClassName(@PathVariable String name) throws Exception {
		return classesService.getClassByName(name);

	}

	// inserting class
	@PostMapping("/classes")
	public void addClass(@RequestBody @Valid Classes classes) throws ClassesCustomGenericException {
		logger.info("Classes Controller addClass() STARTED");
		if (classes.getClassId() == 0) {
			if (classes.getClassName() == "" || classes.getClassName().length() == 0) {
				classes.setClassName(null);
			}
			classes.setCreatedOn(Timestamp.from(Instant.now()));
			logger.info("Classes Controller addClass() END");
			classesService.addClass(classes);
		}
	}

	// updating class by id
	@PutMapping("/classes/{id}")
	public void updateClass(@RequestBody Classes classes, @PathVariable int classId) {
		logger.info("Classes Controller updateClass() STARTED");
		classesService.updateClass(classes, classId);
	}

	// deleting class by id
	@DeleteMapping("/classes/{id}")
	public void deleteClassById(@RequestBody Classes classes, @PathVariable int classId) {
		logger.info("Classes Controller deleteClass() STARTED");
		classesService.deleteClassById(classId);
	}

	// deleting all the classes
	@DeleteMapping("/classes")
	public void deleteAllClasses() {
		logger.info("Classes Controller deleteAllClasses() STARTED");
		classesService.deleteAllClasses();
	}

}
