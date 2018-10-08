package com.paracel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import com.paracel.entity.TeacherExercise;

@Controller
public interface TeacherExerciseRepository extends CrudRepository<TeacherExercise, Integer> {

	@Query(value = "select * from teacherexercise where courseid in( select c.idcourse from course_user c join user u on c.iduser = u.USER_ID where u.USER_ID = ?1 and c.idcourse = ?2)", nativeQuery = true)
	public List<TeacherExercise> findAllTeacherExercise(Long idUser, int idCourse);
	
	@Query(value = "select * from teacherexercise where courseid = ?", nativeQuery = true)
	public List<TeacherExercise> getTeacherExerciseByIdCourse(int id);
}
