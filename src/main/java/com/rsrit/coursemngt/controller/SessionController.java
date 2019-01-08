package com.rsrit.coursemngt.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rsrit.coursemngt.model.Session;
import com.rsrit.coursemngt.service.ClassesService;
import com.rsrit.coursemngt.service.SessionService;

@RestController
public class SessionController {

	@Autowired
	SessionService sessionService;
	@Autowired
	private ClassesService classesService;

	@GetMapping("/{classId}/session")
	public List<Session> getAllSessions(@PathVariable long classId) {
		com.rsrit.coursemngt.model.Class classToGetSession = classesService.getClassById(classId);
		return classToGetSession.getListOfSessions();
		// return sessionService.getAllSessions();

	}

	@GetMapping("/sessions/{id}")
	public Session getSessionById(@PathVariable long sessionId) {
		return sessionService.getSessionById(sessionId);

	}

	/*
	 * @PostMapping("/session") public void addSession(@RequestBody Session session)
	 * { session.setCreatedOn(Timestamp.from(Instant.now()));
	 * sessionService.addSession(session); }
	 */
	@PostMapping("/{classId}/session")
	public void addSession(@RequestBody Session session, @PathVariable long classId) {

		com.rsrit.coursemngt.model.Class classToAddSession = classesService.getClassById(classId);
		List<Session> tempListOfSessions = classToAddSession.getListOfSessions();
		session.setCreatedOn(Timestamp.from(Instant.now()));
		tempListOfSessions.add(session);
		classToAddSession.setListOfSessions(tempListOfSessions);
		classesService.updateClass(classToAddSession);
		session.setClasses(classToAddSession);
		sessionService.addSession(session);
	}

	@PutMapping("/{classId}/session/{sessionId}")
	public void updateSessionById(@RequestBody Session session, @PathVariable long sessionId,
			@PathVariable long classId) {
		com.rsrit.coursemngt.model.Class classToAddSession = classesService.getClassById(classId);
		List<Session> tempListOfSessions = classToAddSession.getListOfSessions();
		session.setCreatedOn(Timestamp.from(Instant.now()));
		tempListOfSessions.add(session);
		classToAddSession.setListOfSessions(tempListOfSessions);
		classesService.updateClass(classToAddSession);
		session.setClasses(classToAddSession);
		sessionService.addSession(session);
		sessionService.updateSession(session, sessionId);
	}

	/*
	 * @DeleteMapping("/classes/{classId}") public void
	 * deleteClassById(@PathVariable long classId) {
	 * logger.info("Classes Controller deleteClass() STARTED");
	 * classesService.deleteClassById(classId); }
	 * 
	 */
	@DeleteMapping("{classId}/session/{sessionId}")
	public void deleteSessionById(@PathVariable long sessionId, @PathVariable long classId) {
		// com.rsrit.coursemngt.model.Class classToDeleteSession=
		// classesService.getClassById(classId);

		sessionService.deleteSessionById(sessionId);
	}

	@DeleteMapping("/session")
	public void deleteAllSessions() {
		sessionService.deleteAllSessions();
	}

	// adding topics to session
	@PostMapping("/session/{topics}")
	public List<String> addingTopicsToSession(@RequestParam List<String> topics) {
		return sessionService.addTopicsToSession(topics);

	}

}
