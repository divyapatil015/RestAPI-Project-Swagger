package com.express.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.express.entities.User;

@Repository
public interface UserRepository extends JpaRepository< User, Long> {

	//DSL Method
	//select*from user where id=1(findById)
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	User findByUsernameOrEmail(String username,String email);
	
	//select * from username and password
	User findByUsernameAndPassword(String username, String password);
}
