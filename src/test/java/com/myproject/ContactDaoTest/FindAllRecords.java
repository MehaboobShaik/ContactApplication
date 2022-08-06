package com.myproject.ContactDaoTest;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.config.SpringRootConfig;
import com.myproject.dao.IContactDao;
import com.myproject.dao.IUserDao;
import com.myproject.domain.Contact;
import com.myproject.domain.User;

public class FindAllRecords {

	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IContactDao contactDao = applicationContext.getBean(IContactDao.class);
		List<Contact> findAll = contactDao.findAll();
         for(Contact c : findAll) {
        	System.out.println("contact id::"+c.getContactId()
        			         +" user id::"+c.getUserId()
        			         +" name::"+c.getName()
        			         +" phone::"+c.getPhone()
        			         +" remarks::"+c.getRemark()
        			         +" address::"+c.getAddress());
         }
       System.out.println("completed sucessfully");

		
	}
}
