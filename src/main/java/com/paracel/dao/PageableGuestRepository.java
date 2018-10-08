package com.paracel.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.paracel.entity.Guest;

@Repository
public interface PageableGuestRepository extends JpaRepository<Guest, Integer> {

	@Query(value="select * from guest",nativeQuery=true)
	public List<Guest> findPageGuest(Pageable pageable);
	
	@Query(value="select count(id) as so from guest",nativeQuery=true)
	public int countGuest();
}
