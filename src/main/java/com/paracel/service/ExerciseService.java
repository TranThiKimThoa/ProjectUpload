package com.paracel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paracel.dao.ExerciseRepository;
import com.paracel.entity.Exercise;

@Service
public class ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;
	
	public List<Exercise> findExercises(int id) {
		return exerciseRepository.findExercise(id);
	}
	
	public List<Exercise> findExercises1(Long id) {
		return exerciseRepository.findExercise1(id);
	}
	
	public Exercise saveExercise(Exercise ex) {
		return exerciseRepository.save(ex);
	}
	
	public void deleteExercise(int id) {
		exerciseRepository.deleteById(id);
    }

    public boolean delete(int id) {
        this.deleteExercise(id);
        return exerciseRepository.existsById(id);
    }
    
    public Exercise findByNameFile(int id) {
    	return exerciseRepository.findByNameFile(id);
    }
    
    public List<Exercise> searchByTitle(String searchText) {
    	return exerciseRepository.searchByTitle(searchText);
    }
    
    public List<Exercise> findAllExercise() {
    	List<Exercise> list = (List<Exercise>) exerciseRepository.findAll();
    	return list;
    }
    
    public List<Exercise> listAllExerciseDisplay(int idcourse, int idusercourse, Long iduser) {
    	List<Exercise> list = exerciseRepository.listAllExerciseDisplay(idcourse, idusercourse, iduser);
    	return list;
    }
    
    public List<Integer> numberExercise(int idcourse, long iduser) {
    	List<Integer> a = (List<Integer>) exerciseRepository.numberExercise(idcourse, iduser);
    	return a;
    }
    
    public List<String> maxDate(int idcourse, long iduser) {
    	List<String> list = exerciseRepository.maxDate(idcourse, iduser);
    	return list;
    }
}
