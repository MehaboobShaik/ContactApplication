package com.myproject.UserDaoTest;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.config.SpringRootConfig;
import com.myproject.dao.IUserDao;
import com.myproject.domain.User;

public class FindAllRecords {

	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IUserDao UserDao = applicationContext.getBean(IUserDao.class);
         List<User> users = UserDao.findAll();
         for(User u : users) {
        	System.out.println(u.getUserId()+" "+u.getName()+" "+u.getRole());
         }
       System.out.println("completed sucessfully");
		
	}
}
