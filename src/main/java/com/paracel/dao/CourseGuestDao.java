package com.paracel.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.paracel.entity.CourseGuest;

@Repository
@Transactional
public class CourseGuestDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void saveCourseGuest(CourseGuest courseGuest){
		entityManager.persist(courseGuest);
	}
	
}
