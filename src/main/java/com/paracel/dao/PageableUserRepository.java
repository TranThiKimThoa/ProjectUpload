package com.paracel.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.paracel.entity.User;

@Repository
public interface PageableUserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="select * from user where user_id in (select user_id from user_role where user_id not in (select user_id from user_role where role_id=1 or role_id=3))",nativeQuery=true)
	public List<User> findUsers(Pageable pageable);
	
	@Query(value="select count(user_id) as so from user where user_id in (select user_id from user_role where user_id not in (select user_id from user_role where role_id=1 or role_id=3))",nativeQuery=true)
	public int countUsers();

}
