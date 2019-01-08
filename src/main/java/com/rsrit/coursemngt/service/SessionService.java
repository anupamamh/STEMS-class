package com.rsrit.coursemngt.service;

import java.util.List;

import com.rsrit.coursemngt.model.Session;

public interface SessionService {

	void addSession(Session session);
	
	List<Session> getAllSessions();
	
	Session getSessionById(long sessionId);
	
	Session updateSession(Session session, long sessionId);
	
	void deleteSessionById(long sessionId);
	
	void deleteAllSessions();

	List<String> addTopicsToSession(List<String> topics);
}
