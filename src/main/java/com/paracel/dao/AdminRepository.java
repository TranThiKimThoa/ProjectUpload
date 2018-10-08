package com.paracel.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paracel.entity.Guest;

@Repository
@Transactional
public interface AdminRepository extends CrudRepository<Guest, Integer> {
	
}
