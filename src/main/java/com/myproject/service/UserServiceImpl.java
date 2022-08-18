package com.myproject.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dao.BaseDao;
import com.myproject.dao.IUserDao;
import com.myproject.domain.User;
import com.myproject.excpetion.UserBlockedException;
import com.myproject.rm.UserRowMapper;

@Transactional
@Service
public class UserServiceImpl extends BaseDao implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public void register(User u) {

		userDao.save(u);
	}
	@Override
	public User Login(String loginName, String password) throws UserBlockedException {

		String SqlLogin = "Select userId,name,phone,email,address,role,loginStatus,loginName"

				+ " from user where loginName=:ln and password=:pw";

		HashMap hashMap = new HashMap();
		hashMap.put("ln", loginName);
		hashMap.put("pw", password);
		try {
			User user = getNamedParameterJdbcTemplate().queryForObject(SqlLogin, hashMap, new UserRowMapper());
			if (user.getLoginStatus().equals(IUserService.LOGIN_STATUS_BLOCKED)) {
				throw new UserBlockedException("you account has been blocked, contact admin to unblock");
			} else {

				return user;
			}
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}

	}

	@Override
	public List<User> getUserList() {
		List<User> findByProperty = userDao.findByProperty("role", UserServiceImpl.ROLE_USER);
		return findByProperty;
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub

	}

}
