package com.demo.bmi.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bmi.model.UserDTO;

@Repository
public interface UserRepo extends JpaRepository<UserDTO,Integer> {
	String getPasswordById(int id);

	UserDTO getPasswordByUname(String uname);

	UserDTO findByUnameAndPassword(String uname, String password);

}
