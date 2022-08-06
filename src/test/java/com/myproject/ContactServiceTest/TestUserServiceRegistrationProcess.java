package com.myproject.ContactServiceTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.config.SpringRootConfig;
import com.myproject.dao.IUserDao;
import com.myproject.domain.User;
import com.myproject.service.IUserService;
import com.myproject.service.UserServiceImpl;

public class TestUserServiceRegistrationProcess {

	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IUserService bean = applicationContext.getBean(IUserService.class);
		User user = new User();
		user.setName("Rihana");
		user.setPhone("123456789");
		user.setEmail("Rihana@gmail.com");
		user.setAddress("KVL");
		user.setLoginName("Rihana");
		user.setPassword("Rihana123");
		user.setRole(bean.ROLE_ADMIN);//Admin role
		user.setLoginStatus(bean.LOGIN_STATUS_ACTIVE);
		bean.register(user);
		System.out.println("User Registerd sucessfully--------");
	}
}
