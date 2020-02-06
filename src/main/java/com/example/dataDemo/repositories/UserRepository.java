package com.example.dataDemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dataDemo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAll();
	
	User findByUsername(String username);
	
	User findBySsn(String ssn);

}
