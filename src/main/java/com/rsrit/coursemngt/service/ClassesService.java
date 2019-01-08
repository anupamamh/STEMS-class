package com.rsrit.coursemngt.service;

import java.util.List;

import com.rsrit.coursemngt.model.Class;

public interface ClassesService {

	void addClass(Class classes);

	List<Class> getAllClasses();

	Class getClassById(long classId);

	Class updateClass(Class classes);

	void deleteClassById(long classId);

	void deleteAllClasses();

	Class getClassByName(String string);

	Class getClassByStudentId(long studentId);

	Class getClassByTrainerId(long trainerId);

}
