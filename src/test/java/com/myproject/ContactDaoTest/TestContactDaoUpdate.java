package com.myproject.ContactDaoTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.config.SpringRootConfig;
import com.myproject.dao.IContactDao;
import com.myproject.dao.IUserDao;
import com.myproject.domain.Contact;
import com.myproject.domain.User;

public class TestContactDaoUpdate {

	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IContactDao bean = applicationContext.getBean(IContactDao.class);
		User user = new User();
		Contact contact = new Contact();
		contact.setUserId(5);
		contact.setName("Subhani");
		contact.setAddress("KVL");
		contact.setEmail("subhani@123");
		contact.setPhone(null);
		contact.setRemark("good Boy");
		contact.setContactId(2);
		bean.Update(contact);
	    System.out.println("data saved--------");
	}
}
