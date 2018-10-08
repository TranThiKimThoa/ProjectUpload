package com.paracel.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.paracel.entity.Course;

@Repository
@Transactional
public class CourseDao {
    
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Course> getAllCourse(){
		List<Course> list = new ArrayList<Course>();
	    list = entityManager.createQuery("select e from Course e", Course.class).getResultList();
	    return list;
	}
	
	public List<Course> getListCourse(int page, int line){
		List<Course> list = new ArrayList<Course>();
		if(page==1) {
			list = entityManager.createQuery("select e from Course e", Course.class)
					.setFirstResult(0).setMaxResults(line).getResultList();
		}
		else list = entityManager.createQuery("select e from Course e", Course.class)
				.setFirstResult(page).setMaxResults(line).getResultList();
		return list;
	}
	
	public long getCount() {
		long count = (long)entityManager.createQuery("select count(id) from Course")
			   .getSingleResult();
	   return count;
	}
	
}
