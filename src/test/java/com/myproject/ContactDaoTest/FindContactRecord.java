package com.myproject.ContactDaoTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.config.SpringRootConfig;
import com.myproject.dao.IContactDao;
import com.myproject.dao.IUserDao;
import com.myproject.domain.Contact;
import com.myproject.domain.User;

public class FindContactRecord {

	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IContactDao contactDao = applicationContext.getBean(IContactDao.class);
        Contact contact = contactDao.findById(2);
        System.out.println();
        System.out.println(contact.getContactId());
        System.out.println(contact.getUserId());
        System.out.println(contact.getName());
        System.out.println(contact.getPhone());
        System.out.println(contact.getEmail());
        System.out.println(contact.getAddress());
        System.out.println(contact.getRemark());
        System.out.println("completed sucessfully");
		
	}
}
