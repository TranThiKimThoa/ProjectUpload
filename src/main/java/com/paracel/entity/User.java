package com.paracel.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "User")
public class User {

	@Id
	@Column(name = "User_Id", nullable = false)
	private Long userId;

	@Column(name = "User_Name", length = 36, nullable = false,unique=true)
	private String userName;
	
	@Column(name="fullname",length=45,nullable=false)
	private String full_Name;

	@Column(name = "Encryted_Password", length = 128, nullable = false)
	private String encrytedPassword;

	@Column(name = "PHONE", length = 128, nullable = false)
	private String phone;

	@Column(name = "EMAIL", length = 128, nullable = false)
	private String email;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATE_REGISTER", length = 128, nullable = false)
	private Date dateRegister;

	@Column(name = "Enabled", length = 1, nullable = false)
	private boolean enabled=true;
	
	@OneToMany(mappedBy="u",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<UserCourse> userCourses;

	public List<UserCourse> getUserCourses() {
		return userCourses;
	}
	
	@OneToMany(mappedBy = "usertt")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Course> ce;
	
	@OneToMany(mappedBy = "u1",cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<UserRole> uro;

	public void setUserCourses(List<UserCourse> userCourses) {
		this.userCourses = userCourses;
	}

	public User() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public List<UserRole> getUro() {
		return uro;
	}

	public void setUro(List<UserRole> uro) {
		this.uro = uro;
	}

	public String getFull_Name() {
		return full_Name;
	}

	public void setFull_Name(String full_Name) {
		this.full_Name = full_Name;
	}

	public List<Course> getCe() {
		return ce;
	}

	public void setCe(List<Course> ce) {
		this.ce = ce;
	}
	
	

}
