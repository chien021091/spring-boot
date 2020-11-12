package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.CustomUserDetails;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUserName(username);
		if(user == null)	return null;
		return new CustomUserDetails(user);
	}
	
	public UserDetails loadUserById(Long userId) {
		UserEntity user = userRepository.findOne(userId);
		if(user == null) {
			throw new UsernameNotFoundException("userId not Found");
		}
		return new CustomUserDetails(user);
	}
	
	public boolean registerUser(UserDTO user) {
		UserDetails userDetails = loadUserByUsername(user.getUsername());
		if(userDetails != null)	return false;
		
		UserEntity newUser = new UserEntity();
		newUser.setUserName(user.getUsername());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setFullName(user.getFullname());
		newUser.setStatus(UserEntity.STAT_ACTIVE);
		
		userRepository.save(newUser);
		return true;
	}

}
