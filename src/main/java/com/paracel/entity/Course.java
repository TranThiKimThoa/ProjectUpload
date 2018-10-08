package com.paracel.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;


import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "course")
public class Course implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name_course")
	private String nameCourse;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private String price;

	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_start")
	private Date startDate;

	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_end")
	private Date endDate;

	@OneToMany(mappedBy = "c")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<UserCourse> userc;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
	private List<Guest> guests;

	public List<Guest> getGuests() {
		return guests;
	}

	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}

	public List<UserCourse> getUserc() {
		return userc;
	}

	public void setUserc(List<UserCourse> userc) {
		this.userc = userc;
	}

	@ManyToOne
    @JoinColumn(name = "iduserteacher")
    private User usertt;
	
	@OneToMany(mappedBy = "cour")
    private List<TeacherExercise> tea;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Course() {
		super();
	}

	public Course(int id, String nameCourse, String description, String price, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.nameCourse = nameCourse;
		this.description = description;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public User getUsertt() {
		return usertt;
	}
	public void setUsertt(User usertt) {
		this.usertt = usertt;
	}
	public List<TeacherExercise> getTea() {
		return tea;
	}
	public void setTea(List<TeacherExercise> tea) {
		this.tea = tea;
	}
	
}