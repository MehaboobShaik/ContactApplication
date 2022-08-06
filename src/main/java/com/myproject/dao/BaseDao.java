package com.myproject.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

//Note: do not use @Repository,service or componenet annotation
public class BaseDao extends NamedParameterJdbcDaoSupport {
    @Autowired
	public void setDataSource2(DataSource ds) {
		super.setDataSource(ds);
	}
 
	
}
