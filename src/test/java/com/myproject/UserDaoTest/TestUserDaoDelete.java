package com.myproject.UserDaoTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.config.SpringRootConfig;
import com.myproject.dao.IUserDao;
import com.myproject.domain.User;

public class TestUserDaoDelete {

	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IUserDao UserDao = applicationContext.getBean(IUserDao.class);
//		UserDao.delete(2);
		User user = new User();
		user.setUserId(1);
		UserDao.delete(user);
		System.out.println("deleted sucessfully");
		
	}
}
