package com.demo.bmi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.demo.bmi.model.*;
import com.demo.bmi.service.*;






@Controller
public class HomeController {
	
	@Autowired
	private DAO dao;
	

	@RequestMapping("/home")
	public String home() {
		
		System.out.println("in controller");
		return "index";
		
	}
	@RequestMapping("/register")
	public String register() {
		System.out.println("in register controller");
		return "register";
	}
	
	@RequestMapping("/login")
	public String login(UserDTO dto,Model m ,HttpSession session) {
		
		System.out.println("in register controller");
		UserDTO dto1=dao.findByUnameAndPassword(dto.getUname(),dto.getPassword());
		if(dto1==null)
		{
		System.out.println("Invalid Username or password");
		m.addAttribute("failed", "Invalid login");
		return "index";
		}
		else
		{
			session.setAttribute("user", dto.getUname());	
			m.addAttribute("user", dto.getUname());
		    return "home";
		}
	
	}
	
	@RequestMapping("/save")
	public String saveData(UserDTO dto)
		{
		System.out.println("in save");
		dao.save(dto);
		return "index";
	}
	
	@RequestMapping("/newProject")
	public String newProject(UserDTO dto ,HttpSession session ,Model m)
		{
		String user = (String) session.getAttribute("user");
		m.addAttribute("user", user);
		return "newProject";
	}
	
	@RequestMapping("/createProject")
	public String addProject (@RequestParam("title")String title , @RequestParam("createdDate1")String date ,
		ProjectDTO dto , ToDoListDTO dto1 ,HttpSession session ,Model m) {
	    dao.save(dto1);
		dto.setTitle(title);
		dto.setCreatedDate(date);
		List<ToDoListDTO> l =new ArrayList<ToDoListDTO>();
		l.add(dto1);
		dto.setTodos(l);
		System.out.println("in controller addprojeect");
		dao.save(dto);
		String user = (String) session.getAttribute("user");
		m.addAttribute("user", user);
			return "home";
			}
	
	@RequestMapping("/projectList")
	public String projectListing(Model m,HttpSession session)
		{
		List<ProjectDTO> l=dao.getAllProjects();
		int count=l.size();
		System.out.println(count);
		m.addAttribute("list", l);
		String user = (String) session.getAttribute("user");
		m.addAttribute("user", user);
		m.addAttribute("count", count);
		return "allProjects";
	}
	@RequestMapping("viewProject")
	public String viewProject(HttpSession session ,Model m)
	{
		String user = (String) session.getAttribute("user");
		m.addAttribute("user", user);
		return "viewproject1";
	}
	@RequestMapping("viewProjectdetails")
	public String viewProjectByTitle(@RequestParam("title") String title ,Model m,HttpSession session)
	{
	    ProjectDTO dto=dao.findByTitle(title);
		System.out.println(dto);
		m.addAttribute("dto", dto);
		String user = (String) session.getAttribute("user");
		m.addAttribute("user", user);
		return "projectview";
	}
	@RequestMapping("/edit")
	public String editTodo(@RequestParam("id") int id,Model m,HttpSession session)
	{
		System.out.println("edited");
		ToDoListDTO todo=dao.findById(id).orElse(null);
		m.addAttribute("todo",todo);
		String user = (String) session.getAttribute("user");
		m.addAttribute("user", user);
		return "edit";
		}
	
	@RequestMapping("/saveToDo")
	public String editnew(ToDoListDTO dto ,Model m ,HttpSession session )
	{
		System.out.println("edited new");
	     dao.save(dto);
	     String user = (String) session.getAttribute("user");
			m.addAttribute("user", user);
		 return "home";
	}
	@RequestMapping("/addTodo")
	public String addTodo(@RequestParam("id") int id,Model m ,HttpSession session)
	{
		System.out.println("deleted");
		ProjectDTO dto=dao.findProjectById(id).orElse(null);
		m.addAttribute("dto",dto);
		String user = (String) session.getAttribute("user");
		m.addAttribute("user", user);
		return "addtodo";
	}
	@RequestMapping("/addTodoAnother")
	public String addTodo (@RequestParam("pid")int id ,ToDoListDTO dto,Model m ,HttpSession session) {
		System.out.println("in controller dddto");
		ProjectDTO pdto=dao.findProjectById(id).orElse(null);
		//m.addAttribute("dto",dto);
		List<ToDoListDTO> l=pdto.getTodos();
		ToDoListDTO dto1=dao.save(dto);
		l.add(dto1);
		dao.save(pdto);
		m.addAttribute("dto",pdto);
		System.out.println("in controller dddto end");
		String user = (String) session.getAttribute("user");
		m.addAttribute("user", user);
		return "home";
			}
	@RequestMapping("/home1")
	public String goHome (HttpSession session ,Model m)
	{
		String user = (String) session.getAttribute("user");
		m.addAttribute("user", user); 
		return "home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
        session.invalidate();
		return "redirect:/home";
	}
	
//	Exception handling
	@ExceptionHandler(Exception.class)
	public String handleError(Exception ex, Model m, HttpSession session) {
		String user = (String) session.getAttribute("user");
		if (user == null) {
			return "redirect:/loginForm";
		} else {
			return "redirect:/home";
		}
	}
	
}
	

