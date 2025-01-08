package com.demo.bmi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "Project1")
public class ProjectDTO implements Serializable {
	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	private int id;
	private String title;
	private String createdDate;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "projectid")
	private List<ToDoListDTO> todos=null;
	
	@Override
	public String toString() {
		return "ProjectDTO [id=" + id + ", title=" + title + ", createdDate=" + createdDate + ", todos=" + todos + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public List<ToDoListDTO> getTodos() {
		return todos;
	}

	public void setTodos(List<ToDoListDTO> todos) {
		this.todos = todos;
	}

	
	
	public ProjectDTO() {
		super();
		System.out.println("project object created");
	}
	
	

}
