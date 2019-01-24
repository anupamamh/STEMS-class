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

import com.rsrit.coursemngt.exception.ClassDoesNotExistsException;
import com.rsrit.coursemngt.exception.StudentNotFoundInClassException;
import com.rsrit.coursemngt.model.Attendance;
import com.rsrit.coursemngt.model.Session;
import com.rsrit.coursemngt.service.AttendanceService;
import com.rsrit.coursemngt.service.ClassesService;
import com.rsrit.coursemngt.service.SessionService;

@RestController
public class SessionController {

	@Autowired
	SessionService sessionService;
	@Autowired
	private ClassesService classesService;
	@Autowired(required = true)
	private AttendanceService attendanceService;

	@GetMapping("/{classId}/session")
	public List<Session> getAllSessions(@PathVariable long classId) throws ClassNotFoundException {
		try {
			com.rsrit.coursemngt.model.Class classToGetSession = classesService.getClassById(classId);
			return classToGetSession.getListOfSessions();
			// return sessionService.getAllSessions();
		} catch (RuntimeException e) {
			throw new ClassDoesNotExistsException("No Class found for the given Class Id.", e, 404);
		}
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
		// classesService.updateClass(classToAddSession);
		session.setClasses(classToAddSession);
		sessionService.addSession(session);
	}

	/*
	 * Working Copy - doing changes for attendance
	 * 
	 * @PutMapping("/{classId}/session/{sessionId}") public void
	 * updateSessionById(@RequestBody Session session, @PathVariable long sessionId,
	 * 
	 * @PathVariable long classId) { com.rsrit.coursemngt.model.Class
	 * classToAddSession = classesService.getClassById(classId); List<Session>
	 * tempListOfSessions = classToAddSession.getListOfSessions();
	 * session.setCreatedOn(Timestamp.from(Instant.now()));
	 * tempListOfSessions.add(session);
	 * classToAddSession.setListOfSessions(tempListOfSessions);
	 * classesService.updateClass(classToAddSession);
	 * session.setClasses(classToAddSession); sessionService.addSession(session);
	 * sessionService.updateSession(session, sessionId); }
	 */
	@PutMapping("/{classId}/session/{sessionId}")
	public void updateSessionById(@RequestBody Session session, @PathVariable("sessionId") long sessionId,
			@PathVariable("classId") long classId) throws ClassNotFoundException, StudentNotFoundInClassException {
		List<Attendance> tempListOfAttendance;
		com.rsrit.coursemngt.model.Class classToAddSession;
		List<Session> tempListOfSessions;
		try {
		classToAddSession = classesService.getClassById(classId);
		tempListOfSessions = classToAddSession.getListOfSessions();

		session.setCreatedOn(Timestamp.from(Instant.now()));
		tempListOfSessions.add(session);
		classToAddSession.setListOfSessions(tempListOfSessions);
		classesService.updateClass(classToAddSession);
		session.setClasses(classToAddSession);
		sessionService.addSession(session);
		tempListOfAttendance = session.getListOfAttendeeIds();
		} catch (RuntimeException ex) {
			throw new ClassDoesNotExistsException("No Class found for the given Class Id.", ex, 404);
		}
		tempListOfAttendance.stream().forEach(attendance -> {
			attendance.setSession(session);
			if (classToAddSession.getStudentsIds().contains(attendance.getStudentsIds())) {
				if (attendance.getAttendanceId() == 0) {
					Attendance attend = attendanceService.findDuplicateAttendance(session.getSessionId(),
							attendance.getStudentsIds());
					if (attend != null) {
						attendance.setAttendanceId(attend.getAttendanceId());
						attendanceService.updateAttendance(attendance);
					}
				}
				attendanceService.addAttendance(attendance);
				session.setListOfAttendeeIds(tempListOfAttendance);
				sessionService.updateSession(session, sessionId);
			}
			else {
				throw new StudentNotFoundInClassException("Students should be present in class");
			}
		});

		// attendanceService.addAttendance(attendance);
		session.setListOfAttendeeIds(tempListOfAttendance);
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
