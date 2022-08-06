package com.myproject.ContactServiceTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.config.SpringRootConfig;
import com.myproject.dao.IUserDao;
import com.myproject.domain.User;

public class FindUserRecord {

	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IUserDao UserDao = applicationContext.getBean(IUserDao.class);
        User user = UserDao.findById(1);
        System.out.println(user.getUserId());
        System.out.println(user.getName());
        System.out.println(user.getPhone());
        System.out.println(user.getEmail());
        System.out.println(user.getAddress());
        System.out.println(user.getLoginName());
        System.out.println(user.getLoginStatus());
        System.out.println(user.getRole());
        System.out.println("completed sucessfully");
		
	}
}
