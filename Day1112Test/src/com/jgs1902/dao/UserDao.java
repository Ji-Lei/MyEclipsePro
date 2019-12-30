package com.jgs1902.dao;

import java.util.List;

import com.jgs1902.pojo.User;

public interface UserDao {
	public List<User> getUserList();
	public User getUserById(String userid);
	public Integer addUser(User user);
	public Integer updateUser(User user);
	public Integer deleteUser(String userid);
}
