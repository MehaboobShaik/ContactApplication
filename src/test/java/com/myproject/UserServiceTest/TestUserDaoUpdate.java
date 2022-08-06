package com.myproject.UserServiceTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.config.SpringRootConfig;
import com.myproject.dao.IUserDao;
import com.myproject.domain.User;

public class TestUserDaoUpdate {

	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IUserDao UserDao = applicationContext.getBean(IUserDao.class);
		User user = new User();
	    user.setPhone("9492732723");
		user.setUserId(1);
		UserDao.Update(user);System.out.println("data saved--------");
	}
}
