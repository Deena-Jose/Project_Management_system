package com.demo.bmi.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.demo.bmi.model.ToDoListDTO;


@Repository
public interface ToDoRepo extends JpaRepository<ToDoListDTO,Integer>{

}
