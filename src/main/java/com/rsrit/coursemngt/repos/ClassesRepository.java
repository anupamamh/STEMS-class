package com.rsrit.coursemngt.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrit.coursemngt.model.Class;

public interface ClassesRepository extends JpaRepository<Class, Long> {

}
