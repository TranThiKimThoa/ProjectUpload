package com.paracel.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name = "course_user")
public class UserCourse {

	@Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
	
	@Column(name="namecourse")
	private String nameCourse;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private String price;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="startdate")
	private Date startDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="enddate")
	private Date endDate;
	
	@ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name = "idcourse")
    private Course c;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "iduser")
    private User u;
	
	@OneToMany(mappedBy = "usc")
	@Fetch(value = FetchMode.SUBSELECT)
    private List<Exercise> e;

	public UserCourse() {
		super();
	}

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

	public Course getC() {
		return c;
	}

	public void setC(Course c) {
		this.c = c;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public List<Exercise> getE() {
		return e;
	}

	public void setE(List<Exercise> e) {
		this.e = e;
	}
 
	
}
