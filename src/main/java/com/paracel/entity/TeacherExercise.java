package com.paracel.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="teacherexercise")
public class TeacherExercise {

	@Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
 	
 	@Column(name = "name", length = 36, nullable = false)
    private String name;
 	
 	@OneToMany(mappedBy = "te")
	@Fetch(value = FetchMode.SUBSELECT)
    private List<Exercise> e1;
 	
 	@ManyToOne
    @JoinColumn(name = "courseid")
    private Course cour;

	public TeacherExercise() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Exercise> getE1() {
		return e1;
	}

	public void setE1(List<Exercise> e1) {
		this.e1 = e1;
	}

	public Course getCour() {
		return cour;
	}

	public void setCour(Course cour) {
		this.cour = cour;
	}
 	
 	
}
