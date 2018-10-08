package com.paracel.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.paracel.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	@Query(value="select * from role where role_name=?",nativeQuery=true)
	Role findByNameRole(String name);
}
