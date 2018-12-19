package com.rsrit.coursemngt.service;

import java.util.List;

import com.rsrit.coursemngt.model.Classes;

public interface ClassesService {

	void addClass(Classes classes);

	List<Classes> getAllClasses();

	Classes getClassById(int classid);

	Classes updateClass(Classes classes, int classId);

	void deleteClassById(int classId);

	void deleteAllClasses();

	Classes getClassByName(String string);

	Classes getClassByStudentId(long studentId);

	Classes getClassByTrainerId(long trainerId);

}
