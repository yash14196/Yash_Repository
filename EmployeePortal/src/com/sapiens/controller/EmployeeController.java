package com.sapiens.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapiens.dao.EmployeeDAO;
import com.sapiens.model.Address;
import com.sapiens.model.EmpForm;
import com.sapiens.model.Employee;
import com.sapiens.model.Project;

@Transactional
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO edao;

	@RequestMapping("/addempform")
	public ModelAndView addemplyeeform()
	{
		EmpForm e = new EmpForm();
		return new ModelAndView("addemp","emp",e);
	}
	
	@RequestMapping("/registeremp")
	public ModelAndView registerEmp(EmpForm empl)
	{
		Employee emp1 = new Employee();
		emp1.setFirstName(empl.getFirstName());
		emp1.setLastName(empl.getLastName());
		emp1.setAge(empl.getAge());
		
		edao.addEmp(emp1);
		
		Address add = new Address();
		add.setPresentAddress(empl.getPresentAddress());
		add.setEmpref1(emp1);
	
		edao.addAddress(add);
		
		Project p = new Project();
		p.setProjName(empl.getProjName());
		p.setProjDuration(empl.getProjDuration());
		p.setStatus(empl.getStatus());
		p.setEmployee(emp1);
		
		edao.addProject(p);
		
		return new ModelAndView("index","emp",empl);
	}
	
	@GetMapping("/viewemp")
	public ModelAndView viewEmpDetails()
	{
		List<Address> empList = edao.getEmp();
		return new ModelAndView("showemp","emplist",empList);
		
	}
	
	@RequestMapping(value = "/deleteemp/{eid}", method = RequestMethod.GET)  
	 public ModelAndView deleteEmpById(@PathVariable int eid) {
		
		edao.deleteEmpById(eid);
		return new ModelAndView("viewemp");
		
	}
	
	@RequestMapping(value = "/editemp/{eid}", method = RequestMethod.GET)  
	 public ModelAndView getEmpById(@PathVariable Integer eid) {
		
		EmpForm ef = new EmpForm();
		Employee e = edao.getEmpById(eid);
		Address a = edao.getAddById(eid);
		Project p = edao.getProjById(eid);
		
		ef.setFirstName(e.getFirstName());
		ef.setLastName(e.getLastName());
		ef.setAge(e.getAge());
		ef.setPresentAddress(a.getPresentAddress());
		ef.setProjName(p.getProjName());
		ef.setProjDuration(p.getProjDuration());
		ef.setStatus(p.getStatus());
		ef.setId(eid);
		
		return new ModelAndView("editemp","emp",ef);
	}
	
	@RequestMapping("/updateemp")
	public ModelAndView updateEmp(EmpForm empl)
	{
		edao.updateEmp(empl);		
		return new ModelAndView("index","emp",empl);
	}
	
}
