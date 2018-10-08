package com.paracel.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="User_Role")
public class UserRole {
	 
    @Id
    @Column(name = "Id", nullable = false)
    private Long id;
 
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "User_Id")
    private User u1;
 
    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name = "Role_Id")
    private Role role;
    
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

	public User getUser() {
		return u1;
	}

	public void setUser(User user) {
		this.u1 = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
 
     
}
