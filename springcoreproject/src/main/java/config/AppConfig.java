package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springcore.jdbc.dao.CustomerDaoImpl;
import com.springcore.jdbc.entity.Customer;

@Configuration
public class AppConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/demo?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}

	@Bean(name = "customerDaoImpl")
	public CustomerDaoImpl getCustomerDaoImpl() {
		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		customerDao.setJdbcTemplate(getJdbcTemplate());
		return customerDao;
	}

	@Bean(name = "customer")
	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setId(2);
		customer.setName("Aditya");
		customer.setEmail("rautadityaj@gmail.com");
		customer.setCity("Kolhapur");
		return customer;
	}
}
