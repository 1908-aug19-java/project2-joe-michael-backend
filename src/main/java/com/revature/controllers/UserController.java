package com.revature.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.models.Streak;
import com.revature.models.User;
import com.revature.services.StreakService;
import com.revature.services.UserService;
import com.revature.util.AuthorizationUtil;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private StreakService streakService;
	
	private AuthorizationUtil au = new AuthorizationUtil();
	
	 
	@GetMapping
	public ResponseEntity<List<User>> getAll(@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int user_id){
		
		if(token == null || user_id == 0) {
			return new ResponseEntity<List<User>>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(user_id);
		if(!au.authorize(user, token)) {
			return new ResponseEntity<List<User>>(HttpStatus.UNAUTHORIZED);
		}
		
		List<User> users = userService.findAllUsers();
		for(User u : users) {
			u.setPassword("");
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	 
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id")Integer id,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int user_id) {
		
		if(token == null || user_id == 0) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(user_id);
		if(!au.authorize(user, token)) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
		
		user = userService.findUserById(id);
		user.setPassword("");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<User> addUser(@Valid @RequestBody User user){
		
		if(userService.findUserByEmail(user.getEmail()) != null) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
		
		Streak streak = new Streak(0,0,0,4);
		streak = streakService.addStreak(streak);
		user.setStreak(streak);
		userService.addUser(user);
		User newUser = userService.findUserByEmail(user.getEmail());
		String token = au.login(newUser, user);
		
		newUser.setPassword("");
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Expose-Headers", "token");
		responseHeaders.set("token", token);
		return new ResponseEntity<User>(newUser, responseHeaders, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id")Integer id,
			@Valid @RequestBody User user,
			@RequestHeader(value="token")String token, 
			@RequestHeader(value="user_id")int user_id) {
		
		if(token == null || user_id == 0) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
		
		User authUser = userService.findUserById(user_id);
		if(!au.authorize(authUser, token)) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
		
		user.setId(id);
		user =  userService.updateUser(user);
		user.setPassword("");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id")Integer id,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int user_id) {
		
		if(token == null || user_id == 0) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(user_id);
		if(!au.authorize(user, token)) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
		
		userService.deleteUser(new User(id));
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<User> loginUser(@Valid @RequestBody User user) {
		
		User userInDb = userService.findUserByEmail(user.getEmail());
		if(userInDb == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		String token = au.login(userInDb, user);
		
		if(token.contentEquals("failed authorization")) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		else {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Access-Control-Expose-Headers", "token");
			responseHeaders.set("token", token);
			userInDb.setPassword("");
			return new ResponseEntity<User>(userInDb, responseHeaders, HttpStatus.ACCEPTED);
		}
	}
}
