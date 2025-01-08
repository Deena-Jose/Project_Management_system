package com.demo.bmi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ToDo")
public class ToDoListDTO implements Serializable {
	

	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	private int id;
	private String Description;
	private String status;
	private String createdDate;
	private String updatedDate;
	public ToDoListDTO() {
		super();
		System.out.println("project object created");
	}
	@Override
	public String toString() {
		return "ToDoListDTO [id=" + id + ", Description=" + Description + ", status=" + status + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	

}
