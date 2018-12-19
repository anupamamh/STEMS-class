package com.rsrit.coursemngt.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrit.coursemngt.model.Session;

public interface SessionRepository extends JpaRepository<Session, Integer> {

}
