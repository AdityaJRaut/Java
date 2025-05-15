package com.ems.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ems.model.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveEmployee(Employee employee)
	{
		int id =(Integer)this.hibernateTemplate.save(employee);
		return id;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
