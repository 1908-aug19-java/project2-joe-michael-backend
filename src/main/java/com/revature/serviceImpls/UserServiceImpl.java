package com.revature.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public List<User> findAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User findUserById(Integer id) {
		return userRepository.getOne(id);
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User deleteUser(User user) {
		userRepository.delete(user);
		return user;
	}

	@Override
	public User findUserByEmail(String email) {
		
		return userRepository.findUserByEmail(email);
	}

}
