package com.paracel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paracel.dao.CourseRepository;
import com.paracel.dao.GuestRepository;
import com.paracel.dao.RoleRepository;
import com.paracel.dao.UserRepository;
import com.paracel.dao.UserRoleRepository;
import com.paracel.entity.Course;
import com.paracel.entity.Guest;
import com.paracel.entity.Role;
import com.paracel.entity.User;

@Service
@Transactional
public class AdminService {

	@Autowired
	private GuestRepository guestRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Guest> findAllGuest(){
		return guestRepository.findAllGuest();
	}
	
	public Guest findGuestById(int id) {
		return guestRepository.findGuestById(id);
	}
	
	public void updateStatusGuest(int id,int status) {
		Guest guest = guestRepository.findGuestById(id);
		guestRepository.updateStatusGuest(id, status);
	}
	
	public List<User> getListUser(){
		return userRepository.getListUser();
	}
	
	public void updateEnabled(boolean enabled,long id) {
		User user = userRepository.findByUserId(id);
		userRepository.updateEnabled(enabled, id);
	}
	
	public int getMaxIdUser() {
		return userRepository.getMaxIdUser();
	}
	
	public int getMaxUserRole() {
		return userRoleRepository.getMaxUserRole();
	}
	
	public void insertUserRole(long id,long iduser) {
		userRoleRepository.insertUserRole(id,iduser);
	}
	
	public Role findByNameRole(String name) {
		return roleRepository.findByNameRole(name);
	}
	
	public Course findByIdCourse(int id) {
		return courseRepository.findByIdCourse(id);
	}
	
}
