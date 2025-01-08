package com.demo.bmi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bmi.model.ProjectDTO;
import com.demo.bmi.model.ToDoListDTO;
import com.demo.bmi.model.UserDTO;


@Component
public class DAO {
	@Autowired
	private UserRepo urepo;
	@Autowired
	private ProjectRepo prepo;
	@Autowired
	private ToDoRepo trepo;

	public void save(UserDTO dto) {
		// TODO Auto-generated method stub
		urepo.save(dto);
		
	}
public UserDTO findByUnameAndPassword(String uname, String password) {
		
		// TODO Auto-generated method stub
		UserDTO dto=urepo. findByUnameAndPassword( uname,password);
		return dto;
	}

	public void save(ProjectDTO dto) {
		// TODO Auto-generated method stub
		prepo.save(dto);
	}

	public ToDoListDTO save(ToDoListDTO dto) {
		// TODO Auto-generated method stub
		//l.add(dto);
		trepo.save(dto);
		return dto;
	}

	public List<ProjectDTO> getAllProjects() {
		// TODO Auto-generated method stub
		List<ProjectDTO> l= prepo.findAll();
		return l;
	}

	public ProjectDTO findByTitle(String title) {
		// TODO Auto-generated method stub
		ProjectDTO dto =prepo.findByTitle(title);
		return dto;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		trepo.deleteById(id);
		
	}

	public Optional<ToDoListDTO> findById(int id) {
		// TODO Auto-generated method stub
		Optional<ToDoListDTO> dto = trepo.findById(id);
		return dto;
	}

	public Optional<ProjectDTO> findProjectById(int id) {
		Optional<ProjectDTO> dto= prepo.findById(id);
		
		// TODO Auto-generated method stub
		return dto;
	}
	



}
