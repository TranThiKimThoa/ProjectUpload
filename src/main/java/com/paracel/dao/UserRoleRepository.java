package com.paracel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paracel.entity.UserRole;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

	@Query(value = "Select * from user_role where USER_ID = ?", nativeQuery = true)
	public List<UserRole> findAllRoleIdInUserRole(Long id);
	
	@Modifying
	@Query(value="insert into user_role(id,user_id,role_id) values(?1,?2,2)",nativeQuery=true)
	public void insertUserRole(long id,long iduser);
	
	@Query(value="select max(id) as so from user_role",nativeQuery=true)
	public int getMaxUserRole();
}
