package com.myproject.ContactDaoTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.config.SpringRootConfig;
import com.myproject.dao.ContactDaoImpl;
import com.myproject.dao.IContactDao;
import com.myproject.domain.Contact;

public class ContactSaveOPeration {

	public static void main(String[] args) {
		 
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		IContactDao bean = context.getBean(IContactDao.class);
		Contact contact = new Contact();
		contact.setContactId(1);
		contact.setUserId(1);
		contact.setName("Mahaboob");
		contact.setAddress("KVL");
		contact.setEmail("Mehar@123");
		contact.setPhone("9493732723");
		contact.setRemark("good Boy");
		bean.save(contact);
		System.out.println("data saved--------");
	}

}
