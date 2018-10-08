package com.paracel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course_guest")
public class CourseGuest {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="id_course")
	private int id_course;
	@Column(name="udguest")
	private int udguest;
	
	
	public int getId() {
		return id;
	}                                                       
	public void setId(int id) {                             
		this.id = id;                                       
	}                                                       
	public int getId_course() {                             
		return id_course;                                   
	}                                                       
	public void setId_course(int id_course) {               
		this.id_course = id_course;                         
	}                                                       
	public int getUdguest() {                               
		return udguest;                                                 
	}                                                                   
	public void setUdguest(int udguest) {                               
		this.udguest = udguest;                                         
	}
	public CourseGuest() {
		super();
	}
	public CourseGuest(int id, int id_course, int udguest) {
		super();
		this.id = id;
		this.id_course = id_course;
		this.udguest = udguest;
	}                                                                                                                                       
                                                                   
}
