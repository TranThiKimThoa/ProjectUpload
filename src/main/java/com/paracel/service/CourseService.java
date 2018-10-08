package com.paracel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paracel.dao.CourseDao;
import com.paracel.dao.CourseRepository;
import com.paracel.entity.Course;
import com.paracel.entity.UserCourse;

@Service
@Transactional
public class CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourse(){
		return courseDao.getAllCourse();
	}
	
	public List<Course> getListCourse(int page, int line){
		return courseDao.getListCourse(page, line);
	}
	
	public long getCount() {
		return courseDao.getCount();
	}
	
	public Course findByIdCourse(int id) {
		return courseRepository.findByIdCourse(id);
	}

	public List<Course> findIdCourse(String name) {
		return courseRepository.findCourseId(name);
	}
	
	public List<Course> listAllCourse(long iduserteacher) {
		List<Course> list = (List<Course>) courseRepository.findCourseInIdTeacher(iduserteacher);
		return list;
	}

}
