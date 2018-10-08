package com.paracel.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="guest")
public class Guest implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int idname;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Type(type="date")
	@Column(name="dateregister")
	private Date dateregister;
	
	@Column(name="status")
	private int status=0;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="course_guest",
	    joinColumns= {@JoinColumn(name="idguest")},
	       inverseJoinColumns= {@JoinColumn(name="idcourse")}
			)
	private List<Course> courses;
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getIdname() {
		return idname;
	}
	public void setIdname(int idname) {
		this.idname = idname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDateregister() {
		return dateregister;
	}
	public void setDateregister(Date dateregister) {
		this.dateregister = dateregister;
	}
	public Guest() {
		super();
	}
	public Guest(int idname, String name, String phone, String email, Date dateregister, int status,
			List<Course> courses) {
		super();
		this.idname = idname;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.dateregister = dateregister;
		this.status = status;
		this.courses = courses;
	}
	
}
