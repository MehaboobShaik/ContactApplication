package com.myproject.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan(basePackages = {"com.myproject.dao","com.myproject.service"})
public class SpringRootConfig {
   
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactapp");
		dataSource.setUsername("root");
		dataSource.setPassword("root@123");
		return dataSource;
		
	}

	
}
