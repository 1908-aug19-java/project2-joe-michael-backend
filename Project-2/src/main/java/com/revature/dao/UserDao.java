package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDao {
	
	public User getUserById(int id);
	public List <User> getAllUsers();
	public boolean createUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);

}
