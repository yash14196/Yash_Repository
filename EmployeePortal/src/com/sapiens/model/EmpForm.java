package com.sapiens.model;

import javax.persistence.*;

//@Entity
public class EmpForm {
	
	//@Id
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String presentAddress;
	private String projName;
	private String projDuration;
	private String status;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getProjDuration() {
		return projDuration;
	}
	public void setProjDuration(String projDuration) {
		this.projDuration = projDuration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "EmpForm [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", presentAddress="
				+ presentAddress + "]";
	}
	
	

}
