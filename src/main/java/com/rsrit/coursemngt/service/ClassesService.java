package com.rsrit.coursemngt.service;

import java.util.List;

import com.rsrit.coursemngt.exception.ClassDoesNotExistsException;
import com.rsrit.coursemngt.model.Class;

public interface ClassesService {

	void addClass(Class classes);

	List<Class> getAllClasses() throws ClassDoesNotExistsException;

	Class getClassById(long classId)throws ClassDoesNotExistsException;

	Class updateClass(Class classes)throws ClassDoesNotExistsException;

	void deleteClassById(long classId);

	void deleteAllClasses();

	Class getClassByName(String string);

	Class getClassByStudentId(long studentId);

	Class getClassByTrainerId(long trainerId);

}
