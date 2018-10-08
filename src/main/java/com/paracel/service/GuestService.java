package com.paracel.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paracel.dao.GuestDao;
import com.paracel.dao.GuestRepository;
import com.paracel.entity.Guest;

@Service
@Transactional
public class GuestService {

	@Autowired
	private GuestDao guestDao;
	
	@Autowired
	private GuestRepository guestRepository;
	
	public void insertGuest(Guest guest) {
		guestRepository.save(guest);
	}
	
}
