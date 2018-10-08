package com.paracel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.paracel.entity.Guest;

public interface GuestRepository extends CrudRepository<Guest, Integer> {
	@Query(value="select * from guest",nativeQuery=true)
	public List<Guest> findAllGuest();
	
	@Query(value="select * from guest where id=?",nativeQuery=true)
	public Guest findGuestById(int id);
	
	@Modifying
	@Query(value="update guest set status=?2 where id=?1",nativeQuery=true)
	public void updateStatusGuest(int id,int status);

}
