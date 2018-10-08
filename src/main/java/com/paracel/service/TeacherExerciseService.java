package com.paracel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paracel.dao.TeacherExerciseRepository;
import com.paracel.entity.Exercise;
import com.paracel.entity.TeacherExercise;

@Service
public class TeacherExerciseService {

	@Autowired
	private TeacherExerciseRepository teacherExerciseRepository;
	
	public List<TeacherExercise> findAllNames(Long idUser, int idCourse) {
		return teacherExerciseRepository.findAllTeacherExercise(idUser, idCourse);
	}
	
	public List<TeacherExercise> getListTeacherExerciseByIDCourse(int id) {
		List<TeacherExercise> list = teacherExerciseRepository.getTeacherExerciseByIdCourse(id);
		return list;
	}
	
	public TeacherExercise saveExercise(TeacherExercise te) {
		return teacherExerciseRepository.save(te);
	}
}
