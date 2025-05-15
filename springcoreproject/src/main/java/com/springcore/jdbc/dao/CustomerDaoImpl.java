package com.springcore.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springcore.jdbc.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int insertCustomer(Customer customer) {
		String query="insert into customer(id,name,email,city) values(?,?,?,?);";
		int update=jdbcTemplate.update(query,customer.getId(),customer.getName(),customer.getEmail(),customer.getCity());
		return update;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	


}
