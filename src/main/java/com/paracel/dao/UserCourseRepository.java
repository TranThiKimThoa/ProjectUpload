package com.paracel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paracel.entity.UserCourse;

@Repository
public interface UserCourseRepository extends CrudRepository<UserCourse, Integer> {

	@Query(value = "select * from user u join course_user c on u.USER_ID = c.iduser where u.USER_ID in (select u.USER_ID from user u where USER_NAME = ?)", nativeQuery = true)
	public List<UserCourse> findCourseName(String name);
	
	
	@Query(value = "select * from course_user where namecourse like %?%", nativeQuery = true)
	public List<UserCourse> searchCourseName(String searchText);
	
	@Query(value = "select * from course_user where idcourse = ?", nativeQuery = true) 
	public List<UserCourse> findAllUserCourseByIdCourse(int id);
	
	@Query(value = "select * from course_user where id = ?", nativeQuery = true)
	public UserCourse getIdCourse(int id);
	
	@Query(value = "select * from course_user where idcourse = ?1 and iduser = ?2", nativeQuery = true)
	public UserCourse findInUserCourseById(int idcourse, Long iduser);
}
