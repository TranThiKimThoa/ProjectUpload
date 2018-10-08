package com.paracel.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.paracel.entity.Guest;

@Repository
@Transactional
public class GuestDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public int saveGuest(Guest guest) {
		entityManager.persist(guest);
		entityManager.flush();
		return guest.getIdname();
	}
}
