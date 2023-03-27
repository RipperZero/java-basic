package com.zero.service;

import java.util.List;

import com.zero.pojo.Pager;
import com.zero.pojo.User;

public interface UserService {
	List<User> findAll();
	
	Pager<User> findByPager(int page,int size);

	User findUserByUsername(String username);

	int saveUser(User user);

	int updateUser(User user);

	int deleteUserById(int id);
}
