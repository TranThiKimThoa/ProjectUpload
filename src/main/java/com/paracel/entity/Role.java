package com.paracel.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
@Table(name="Role")
public class Role {

	@Id
	@GeneratedValue
	@Column(name = "Role_Id", nullable = false)
	private Long roleId;

	@Column(name = "Role_Name", length = 30, nullable = false)
	private String roleName;
	
	@OneToMany(mappedBy = "role")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<UserRole> ur;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserRole> getUr() {
		return ur;
	}

	public void setUr(List<UserRole> ur) {
		this.ur = ur;
	}


}