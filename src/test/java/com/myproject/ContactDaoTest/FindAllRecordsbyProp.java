package com.myproject.ContactDaoTest;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.config.SpringRootConfig;
import com.myproject.dao.IContactDao;
import com.myproject.dao.IUserDao;
import com.myproject.domain.Contact;
import com.myproject.domain.User;

public class FindAllRecordsbyProp {

	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IContactDao contactDao = applicationContext.getBean(IContactDao.class);
		List<Contact> contacts = contactDao.findByProperty("name", "subhani");
         for(Contact c : contacts) {
        	System.out.println(c.getUserId()+" "+c.getName());
         }
       System.out.println("completed sucessfully");
	}
}
