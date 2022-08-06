package com.myproject.UserServiceTest;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.myproject.config.SpringRootConfig;

public class TestDataSource {

	public static void main(String args[]) {
		
  @SuppressWarnings("resource")
AnnotationConfigApplicationContext applicationContext = 
		              new AnnotationConfigApplicationContext(SpringRootConfig.class);
    
   DataSource dataSource = applicationContext.getBean(DataSource.class);
   JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
   String query =
   "insert into user(name,phone,email,address,loginName,password)values(?,?,?,?,?,?);";
   Object[] params = new Object[] 
   {"mahaboob","123","mahaboob@gmail.com","kavali","Mehar","123"};
   jdbcTemplate.update(query,params);
   System.out.println("_________________Updated_________________");
	
	
	}
	
}
