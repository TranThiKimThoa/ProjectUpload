package com.paracel.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paracel.dao.CourseGuestDao;
import com.paracel.entity.CourseGuest;

@Service
@Transactional
public class CourseGuestService {

	@Autowired
	private CourseGuestDao courseGuestDao;
	
	public void saveCourseGuest(CourseGuest courseGuest) {
		courseGuestDao.saveCourseGuest(courseGuest);
	}
}
