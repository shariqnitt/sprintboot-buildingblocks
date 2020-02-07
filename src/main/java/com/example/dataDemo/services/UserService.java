package com.example.dataDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dataDemo.entities.User;
import com.example.dataDemo.exceptions.UserExistsException;
import com.example.dataDemo.exceptions.UserNotFoundException;
import com.example.dataDemo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
		
	}
	
	
	public User createUser(User user) throws UserExistsException{
		User existingUser = userRepository.findByUsername(user.getUsername());
		if(existingUser != null) {
			throw new UserExistsException("User Already Exists");
		}
		
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User with ID:" + id + " not present");
		}
		return user;
		
	}
	
	public User updateUserById(Long id, User user){
		user.setId(id);
		return userRepository.save(user);
		
	}
	
	public void deleteUserById(Long id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
		
	}
	
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User findUserBySsn(String ssn) {
		return userRepository.findBySsn(ssn);
		
	}

}
