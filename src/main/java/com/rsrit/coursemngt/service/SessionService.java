package com.rsrit.coursemngt.service;

import java.util.List;

import com.rsrit.coursemngt.model.Session;

public interface SessionService {

	void addSession(Session session);
	
	List<Session> getAllSessions();
	
	Session getSessionById(int sessionId);
	
	Session updateSession(Session session, int sessionId);
	
	void deleteSessionById(int sessionId);
	
	void deleteAllSessions();

	List<String> addTopicsToSession(List<String> topics);
}
