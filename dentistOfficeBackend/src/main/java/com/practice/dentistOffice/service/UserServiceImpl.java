package com.practice.dentistOffice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.dentistOffice.model.Appoinment;
import com.practice.dentistOffice.model.User;
import com.practice.dentistOffice.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

 
    @Autowired
    private UserRepository userRepository;

	//It will be provided on WebSecurityConfig as @Bean
    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appoinment saveMyUser(Appoinment appoinment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long numberOfUsers() {
		// TODO Auto-generated method stub
		return null;
	}


   

}
