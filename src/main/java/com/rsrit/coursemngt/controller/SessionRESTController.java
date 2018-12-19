package com.rsrit.coursemngt.controller;

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
import com.rsrit.coursemngt.service.SessionService;

@RestController
public class SessionRESTController {

	@Autowired
	SessionService sessionService;

	@GetMapping("/sessions")
	public List<Session> getAllSessions() {
		return sessionService.getAllSessions();

	}

	@GetMapping("/sessions/{id}")
	public Session getSessionById(@PathVariable int sessionId) {
		return sessionService.getSessionById(sessionId);

	}

	@PostMapping("/sessions")
	public void addSession(@RequestBody Session session) {
		sessionService.addSession(session);
	}

	@PutMapping("/session/{id}")
	public void updateSessionById(@RequestBody Session session, @PathVariable int sessionId) {
		sessionService.updateSession(session, sessionId);
	}

	@DeleteMapping("/session/{id}")
	public void deleteSessionById(@PathVariable int sessionId) {
		sessionService.deleteSessionById(sessionId);
	}

	@DeleteMapping("/session")
	public void deleteAllSessions() {
		sessionService.deleteAllSessions();
	}
	
	//adding topics to session
	@PostMapping("/session/{topcs}")
	public List<String> addingTopicsToSession(@RequestParam List<String> topics){
		return sessionService.addTopicsToSession(topics);
		
	}

}
