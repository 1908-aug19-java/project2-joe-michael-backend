package com.revature.services;

import java.util.List;
import com.revature.models.User;

public interface UserService {
	
	public List<User> findAllUsers();
	public User findUserById(Integer id);
	public User findUserByEmail(String email);
	public User addUser(User user);
	public User updateUser(User user);
	public User deleteUser(User user);
	
}
