package com.jacobduchen.spring.dao;

import java.util.List;

import com.jacobduchen.model.UserDetails;

public interface UserDetailsDao {

	public UserDetails getUserDetails(int id);

	public List<UserDetails> getAllUserDetails();

	public int addUserDetails(UserDetails userDetails);

	public int updateUserDetails(UserDetails userDetails);

	public int deleteUserDetails(int id);

}