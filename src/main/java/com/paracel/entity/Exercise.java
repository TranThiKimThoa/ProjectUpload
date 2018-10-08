package com.paracel.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="exercise")
public class Exercise {

	 	@Id
	    @GeneratedValue
	    @Column(name = "id", nullable = false)
	    private int id;
	 	
	 	@Column(name = "title", length = 36, nullable = false)
	    private String title;
	 	
	 	@Column(name = "description", length = 36, nullable = false)
	    private String description;
	 	
	 	@Column(name = "namefile", length = 36, nullable = false)
	    private String namefile;
	 	
	 	@Column(name = "file_path")
	    private String filepath;
	 	
	 	@Column(name = "tail_path")
	    private String tailpath;
	 	
	 	@NotNull

	    @Column(name = "datefilling", length = 128, nullable = false)
		private Date datefilling;
	 	
	 	@ManyToOne
	    @JoinColumn(name = "idusercourse")
	    private UserCourse usc;
	 	
	 	@ManyToOne
	    @JoinColumn(name = "idteacherexercise")
	    private TeacherExercise te;

		public Exercise() {
			super();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getNamefile() {
			return namefile;
		}

		public void setNamefile(String namefile) {
			this.namefile = namefile;
		}

		public Date getDatefilling() {
			return datefilling;
		}

		public void setDatefilling(Date datefilling) {
			this.datefilling = datefilling;
		}

		public UserCourse getUsc() {
			return usc;
		}

		public void setUsc(UserCourse usc) {
			this.usc = usc;
		}

		public String getFilepath() {
			return filepath;
		}

		public void setFilepath(String filepath) {
			this.filepath = filepath;
		}

		public String getTailpath() {
			return tailpath;
		}

		public void setTailpath(String tailpath) {
			this.tailpath = tailpath;
		}

		public TeacherExercise getTe() {
			return te;
		}

		public void setTe(TeacherExercise te) {
			this.te = te;
		}

		
		
	 	
}
