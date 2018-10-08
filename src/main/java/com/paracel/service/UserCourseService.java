package com.paracel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paracel.dao.UserCourseRepository;
import com.paracel.entity.UserCourse;

@Service
public class UserCourseService {

	@Autowired
	private UserCourseRepository userCourseRepository;
	
	public List<UserCourse> findNameCourse(String name) {
		return userCourseRepository.findCourseName(name);
	}
	
	public List<UserCourse> searchNameCourse(String searchText) {
		return userCourseRepository.searchCourseName(searchText);
	}
	
	public List<UserCourse> findAllByIdCourse(int id) {
		List<UserCourse> list = userCourseRepository.findAllUserCourseByIdCourse(id);
		return list;
	}
	
	public UserCourse getFindIdCourse(int id) {
		return userCourseRepository.getIdCourse(id);
	}
	
	public UserCourse findInUserCourseById(int idcourse, Long iduser) {
		return userCourseRepository.findInUserCourseById(idcourse, iduser);
	}
}
