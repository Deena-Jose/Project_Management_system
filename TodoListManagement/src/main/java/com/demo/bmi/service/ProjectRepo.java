package com.demo.bmi.service;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.demo.bmi.model.ProjectDTO;

@Repository
public interface ProjectRepo extends JpaRepository<ProjectDTO, Integer>
{
	ProjectDTO findByTitle(String title);
}
