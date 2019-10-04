package com.sapiens.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

//import javax.transaction.Transactional;

//import org.hibernate.Query;
//import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sapiens.model.Address;
import com.sapiens.model.EmpForm;
import com.sapiens.model.Employee;
import com.sapiens.model.Project;

/*@org.springframework.transaction.annotation.Transactional*/
@Transactional
@Component
public  class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private HibernateTemplate template;
	
	//Session session = HibernateUtil.getSessionFactory().openSession();
	@Override
	public void addEmp(Employee emp) {
		
		template.save(emp);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void addAddress(Address add) {
		// TODO Auto-generated method stub
		template.save(add);
		
		}
	
	@Override
	public void addProject(Project pro) {
		
		template.save(pro);
	}

	@Override
	public List<Address> getEmp() {
		
		List empList = template.find("select e.id, e.firstName, e.lastName, e.age, a.presentAddress, p.projName, p.projDuration ,p.status from Employee e join Address a on e.id = a.empref1 join Project p on e.id = p.employee");
		
		return empList;
	}

	@Override
	public void deleteEmpById(int id) {
		// TODO Auto-generated method stub
		//template.delete(template.get(Employee.class,id));
		Session session = template.getSessionFactory().openSession();
		
		System.out.println(id);
		
		Transaction tx = session.beginTransaction();
		
		Query query0 = session.createQuery("delete from Project where employee_id = :ID");
		query0.setParameter("ID", id);
		int res0 = query0.executeUpdate();
		
		
		
		Query query1 = session.createQuery("delete from Address where empref = :ID");
		query1.setParameter("ID", id);
		int res1 = query1.executeUpdate();
		
	
		
		Query query2 = session.createQuery("delete from Employee where id = :ID");
		query2.setParameter("ID", id);
		int res2 = query2.executeUpdate();
		
		tx.commit();
		
		session.close();
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		return template.get(Employee.class,id);
	}

	@Override
	public void updateEmp(EmpForm e) {
		// TODO Auto-generated method stub
		
		Session session = template.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		Query query1 = session.createQuery("update Employee set firstName = :FN, lastName = :LN, age= :AGE where id = :ID");
		query1.setParameter("FN", e.getFirstName());
		query1.setParameter("LN", e.getLastName());
		query1.setParameter("AGE", e.getAge());
		query1.setParameter("ID", e.getId());
		int res = query1.executeUpdate();
		
		Query query2 = session.createQuery("update Address set presentAddress = :PA where empref = :ID");
		query2.setParameter("PA", e.getPresentAddress());
		query2.setParameter("ID", e.getId());
		int res2 = query2.executeUpdate();
		
		Query query3 = session.createQuery("update Project set projName = :PN, projDuration = :PD, status = :S where employee_id = :ID");
		query3.setParameter("PN", e.getProjName());
		query3.setParameter("PD", e.getProjDuration());
		query3.setParameter("S", e.getStatus());
		query3.setParameter("ID", e.getId());
		
		int res3 = query3.executeUpdate();
		
		tx.commit();
		
		session.close();
	}

	@Override
	public Address getAddById(int id) {
		// TODO Auto-generated method stub
		
Session session = template.getSessionFactory().openSession();
		
		//System.out.println(id);
		
		Transaction tx = session.beginTransaction();
		
		Query query0 = session.createQuery("from Address where empref = :ID");
		query0.setParameter("ID", id);
		
		//List<Address> addResult = query0.list();
		Address ad = (Address) query0.getSingleResult();
		System.out.println(ad);
		tx.commit();
		
		session.close();
		return ad;
	}

	@Override
	public Project getProjById(int id) {

Session session = template.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		Query query0 = session.createQuery("from Project where employee_id = :ID");
		query0.setParameter("ID", id);
		
		//List<Address> addResult = query0.list();
		Project p = (Project) query0.getSingleResult();
		System.out.println(p);
		tx.commit();
		
		session.close();
		return p;
		
	}

}
