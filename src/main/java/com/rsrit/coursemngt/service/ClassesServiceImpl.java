package com.rsrit.coursemngt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.coursemngt.model.Class;
import com.rsrit.coursemngt.repos.ClassesRepository;

@Service
public class ClassesServiceImpl implements ClassesService {

	@Autowired
	private ClassesRepository classesRepository;

	@Override
	public void addClass(Class classes) {

		classesRepository.save(classes);

	}

	@Override
	public List<Class> getAllClasses() {

		List<Class> list = classesRepository.findAll();
		return list;
	}

	@Override
	public Class getClassById(long classId) {
		return classesRepository.getOne(classId);

	}

	/*
	 * @Override public void getClassByName(Classes classes, String className) {
	 * 
	 * // Classes quriedClass = new Classes("java", 20, null, null, null, null,null,
	 * // null);
	 * 
	 * if(className.equals(classes.getClassName())) { classesRepository.getClass();
	 * } }
	 */

	@Override
	public Class updateClass(Class classes) {
		classesRepository.getOne(classes.getClassId());
		return classesRepository.save(classes);
	}

	@Override
	public void deleteClassById(long classId) {

		classesRepository.deleteById(classId);

	}

	@Override
	public void deleteAllClasses() {
		classesRepository.deleteAll();
	}

	@Override
	public Class getClassByName(String string) {
		return null;

	}

	@Override
	public Class getClassByStudentId(long studentId) {
		return classesRepository.getOne(studentId);
	}

	@Override
	public Class getClassByTrainerId(long trainerId) {
		return classesRepository.getOne(trainerId);
	}

}
