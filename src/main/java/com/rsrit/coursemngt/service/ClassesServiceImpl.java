package com.rsrit.coursemngt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.coursemngt.model.Classes;
import com.rsrit.coursemngt.repos.ClassesRepository;

@Service
public class ClassesServiceImpl implements ClassesService {

	@Autowired
	private ClassesRepository classesRepository;

	@Override
	public void addClass(Classes classes) {

		classesRepository.save(classes);

	}

	@Override
	public List<Classes> getAllClasses() {

		List<Classes> list = classesRepository.findAll();
		return list;
	}

	@Override
	public Classes getClassById(int classId) {

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
	public Classes updateClass(Classes classes, int classId) {
		classesRepository.getOne(classId);
		return classesRepository.save(classes);
	}

	@Override
	public void deleteClassById(int classId) {

		classesRepository.deleteById(classId);

	}

	@Override
	public void deleteAllClasses() {
		classesRepository.deleteAll();
	}

	@Override
	public Classes getClassByName(String string) {
		return null;

	}

	@Override
	public Classes getClassByStudentId(long studentId) {
		return classesRepository.getOne((int) studentId);
	}

	@Override
	public Classes getClassByTrainerId(long trainerId) {
		return classesRepository.getOne((int) trainerId);
	}

}
