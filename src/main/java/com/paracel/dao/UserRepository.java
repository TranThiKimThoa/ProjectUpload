package com.paracel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paracel.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query(value = "Select * from User where USER_ID = ?", nativeQuery = true)
	public User findByUserId(Long id);

	@Query(value = "select * from User where `user_name` = ?", nativeQuery = true)
	public User findPassword(String user);
	
	@Query(value="select * from user where user_id in (select user_id from user_role where user_id not in (select user_id from user_role where role_id=1 or role_id=3))",nativeQuery=true)
	public List<User> getListUser();
	
	@Modifying
	@Query(value="update user set enabled=?1 where user_id=?2",nativeQuery=true)
	public void updateEnabled(boolean enabled,long id);
	
	@Query(value="select max(user_id) as so from user",nativeQuery=true)
	public int getMaxIdUser();
	
	public User findByEmail(String email);
	
	public User findByUserName(String username);
	
}
