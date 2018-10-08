package com.paracel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paracel.dao.UserRepository;
import com.paracel.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAllUser() {
		List<User> list = (List<User>) userRepository.findAll();
		return list;
	}
	
	public User findById(Long id) {
		User user = userRepository.findByUserId(id);
		return user;
	}
	
	public User findPassword(String user) {
		return userRepository.findPassword(user);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User findByUserName(String username) {
		return userRepository.findByUserName(username);
	}
	
}
