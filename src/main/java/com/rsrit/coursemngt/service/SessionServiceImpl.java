package com.rsrit.coursemngt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.coursemngt.model.Session;
import com.rsrit.coursemngt.repos.SessionRepository;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionRepository sessionRepository;
	
	@Override
	public void addSession(Session session) {
		sessionRepository.save(session);
	}

	@Override
	public List<Session> getAllSessions() {
		return sessionRepository.findAll();
	}

	@Override
	public Session getSessionById(int sessionId) {
		return sessionRepository.getOne(sessionId);
	}

	@Override
	public Session updateSession(Session session, int sessionId) {
		sessionRepository.getOne(sessionId);
		return sessionRepository.save(session);
	}

	@Override
	public void deleteSessionById(int sessionId) {
		sessionRepository.deleteById(sessionId);
	}

	@Override
	public void deleteAllSessions() {
		sessionRepository.deleteAll();
	}

	
	@Override
	public List<String> addTopicsToSession(List<String> topics) {		
//		Todo
		return null;
	}

}
