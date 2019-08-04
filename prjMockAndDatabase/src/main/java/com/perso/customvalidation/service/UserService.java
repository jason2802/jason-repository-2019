package com.perso.customvalidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perso.customvalidation.domain.User;
import com.perso.customvalidation.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();		
	}
}

