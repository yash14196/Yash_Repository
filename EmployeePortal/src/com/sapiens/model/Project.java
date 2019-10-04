package com.sapiens.model;

import java.sql.Time;

import javax.persistence.*;


@Entity
@Table(name="Project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="project_id")
	private int pid;
	private String projName;
	private String projDuration;
	private String status;
	
	 @ManyToOne
	 private Employee employee;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	 
}
