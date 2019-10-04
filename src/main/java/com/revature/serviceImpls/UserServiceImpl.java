package com.revature.serviceImpls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public List<User> findAllUsers() {
		logger.warn("all users pulled");
		return userRepository.findAll();
	}

	@Override
	public User findUserById(Integer id) {
		logger.warn("user pulled by id");
		return userRepository.getOne(id);
	}

	@Override
	public User addUser(User user) {
		logger.warn("user added");
		
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		logger.warn("user updated");
		return userRepository.save(user);
	}

	@Override
	public User deleteUser(User user) {
		logger.warn("user deleted");
		userRepository.delete(user);
		return user;
	}

	@Override
	public User findUserByEmail(String email) {
		logger.warn("user pulled by email");
		return userRepository.findUserByEmail(email);
	}

}
