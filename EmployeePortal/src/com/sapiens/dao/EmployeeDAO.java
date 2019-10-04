package com.sapiens.dao;

import java.util.List;

import com.sapiens.model.Address;
import com.sapiens.model.EmpForm;
import com.sapiens.model.Employee;
import com.sapiens.model.Project;

public interface EmployeeDAO {

	void addEmp(Employee emp);
	
	void addAddress(Address add);
	
	void addProject(Project pro);
	
	List<Address> getEmp();
	
	void deleteEmpById(int id);	
	
	Employee getEmpById(int id);
	
	Address getAddById(int id);
	
	Project getProjById(int id);
	
	void updateEmp(EmpForm e);
	
}
