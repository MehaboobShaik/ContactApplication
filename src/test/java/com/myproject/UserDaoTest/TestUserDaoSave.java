package com.myproject.UserDaoTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.config.SpringRootConfig;
import com.myproject.dao.IUserDao;
import com.myproject.domain.User;

public class TestUserDaoSave {

	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IUserDao UserDao = applicationContext.getBean(IUserDao.class);
		User user = new User();
		user.setName("rihana");
		user.setEmail("rihana@gmail.com");
		user.setAddress("KVL");
		user.setLoginName("rihana");
		user.setPassword("rihana123");
		user.setRole(1);//Admin role
		user.setLoginStatus(1);
		UserDao.save(user);System.out.println("data saved--------");
	}
}
