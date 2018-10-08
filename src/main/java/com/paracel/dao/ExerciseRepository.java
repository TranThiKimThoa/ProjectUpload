package com.paracel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paracel.entity.Exercise;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {

	@Query(value = "select * from exercise e join course_user c on e.idusercourse = c.id where c.id = ?",nativeQuery = true)
	public List<Exercise> findExercise(int id);
	
	@Query(value = "select * from exercise where id = ?", nativeQuery = true) 
	public Exercise findByNameFile(int id);
	
	@Query(value = "select * from exercise where title like %?%", nativeQuery = true)
	public List<Exercise> searchByTitle(String searchText);
	
	@Query(value = "select * from exercise e join course_user c on e.idusercourse = c.id where c.iduser = ?",nativeQuery = true)
	public List<Exercise> findExercise1(Long id);
	
	@Query(value = "select * from exercise where idteacherexercise in (select te.id from teacherexercise te where te.courseid = ?1) and idusercourse in (select c.id from course_user c where c.id = ?2 and c.iduser = ?3)", nativeQuery = true)
	public List<Exercise> listAllExerciseDisplay(int idcourse, int idusercourse, Long iduser);
	
	@Query(value = "select count(id) from exercise where idusercourse in (select id from course_user where idcourse = ?1 and iduser = ?2)", nativeQuery = true)
	public List<Integer> numberExercise(int idcourse, long iduser);
	
	@Query(value = "select Max(datefilling) from exercise where idusercourse in (select id from course_user where idcourse = ?1 and iduser = ?2) ",nativeQuery = true)
	public List<String> maxDate(int idcourse, long iduser);
}
