package com.paracel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.paracel.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

	@Query(value="select * from course where id=?",nativeQuery=true)
	public Course findByIdCourse(int id);
	
	@Query(value = "select * from course where iduserteacher in (select USER_ID from user where USER_NAME = ?)", nativeQuery = true)
	public List<Course> findCourseId(String name);
	
	@Query(value = "select * from course where iduserteacher = ?",nativeQuery = true)
	public List<Course> findCourseInIdTeacher(long iduserteacher);

}
