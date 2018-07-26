package com.jacobduchen.spring.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jacobduchen.model.UserDetails;
import com.jacobduchen.spring.dao.UserDetailsDao;
import com.jacobduchen.spring.service.UserDetailsService;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	public UserDetails getUserDetails(int id) {
		return userDetailsDao.getUserDetails(id);
	}

	public List<UserDetails> getAllUserDetails() {
		return userDetailsDao.getAllUserDetails();
	}

	@Override
	public int addUserDetails(UserDetails userDetails) {
		return userDetailsDao.addUserDetails(userDetails);
	}

	@Override
	public int updateUserDetails(UserDetails userDetails) {
		return userDetailsDao.updateUserDetails(userDetails);
	}

	@Override
	public int deleteUserDetails(int id) {
		return userDetailsDao.deleteUserDetails(id);
	}

	public UserDetailsDao getUserDetailsDao() {
		return userDetailsDao;
	}

}
