package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Streak;
import com.revature.models.User;
import com.revature.services.StreakService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private StreakService streakService;
	
	@GetMapping
	public List <User> getAll(){
		return userService.findAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id")Integer id) {
		return userService.findUserById(id);
	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@Valid @RequestBody User user){
		Streak streak = new Streak(0,0,0,4);
		streak = streakService.addStreak(streak);
		user.setStreak(streak);
		userService.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id")Integer id, @Valid @RequestBody User user) {
		user.setId(id);
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/{id}")
	public User deleteUser(@PathVariable("id")Integer id) {
		return userService.deleteUser(new User(id));
	}
}
