package com.myproject.ContactDaoTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.config.SpringRootConfig;
import com.myproject.dao.IContactDao;
import com.myproject.dao.IUserDao;
import com.myproject.domain.Contact;
import com.myproject.domain.User;

public class TestContactDaoDelete {

	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IContactDao contactDao = applicationContext.getBean(IContactDao.class);
		contactDao.delete(1);
		System.out.println("deleted sucessfully");
		
	}
}
