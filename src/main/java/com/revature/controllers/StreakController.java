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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.models.Streak;
import com.revature.models.User;
import com.revature.services.StreakService;
import com.revature.services.UserService;
import com.revature.util.AuthorizationUtil;

@RestController
@RequestMapping("/streaks")
public class StreakController {
	
	@Autowired
	private StreakService streakService;
	@Autowired 
	private UserService userService;
	
	AuthorizationUtil au = new AuthorizationUtil();
	
	@GetMapping
	public ResponseEntity<List<Streak>> getAll(@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int user_id){
		
		if(token == null || user_id == 0) {
			return new ResponseEntity<List<Streak>>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(user_id);
		if(!au.authorize(user, token)) {
			return new ResponseEntity<List<Streak>>(HttpStatus.UNAUTHORIZED);
		}
		
		List<Streak> streaks = streakService.findAllStreaks();
		return new ResponseEntity<List<Streak>>(streaks, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Streak> getStreakById(@PathVariable("id")Integer id,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int user_id) {
		
		if(token == null || user_id == 0) {
			return new ResponseEntity<Streak>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(user_id);
		if(!au.authorize(user, token)) {
			return new ResponseEntity<Streak>(HttpStatus.UNAUTHORIZED);
		}
		
		Streak streak = streakService.findStreakById(id);
		
		return new ResponseEntity<Streak>(streak, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Streak> addStreak(@Valid @RequestBody Streak streak,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int user_id){
		
		if(token == null || user_id == 0) {
			return new ResponseEntity<Streak>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(user_id);
		if(!au.authorize(user, token)) {
			return new ResponseEntity<Streak>(HttpStatus.UNAUTHORIZED);
		}
		
		streakService.addStreak(streak);
		return new ResponseEntity<Streak>(streak, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Streak> updateStreak(@PathVariable("id")Integer id,
			@Valid @RequestBody Streak streak,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int user_id) {
		
		if(token == null || user_id == 0) {
			return new ResponseEntity<Streak>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(user_id);
		if(!au.authorize(user, token)) {
			return new ResponseEntity<Streak>(HttpStatus.UNAUTHORIZED);
		}
		
		streak.setId(id);
		streak = streakService.updateStreak(streak);
		return new ResponseEntity<Streak>(streak, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Streak> deleteStreak(@PathVariable("id")Integer id,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int user_id) {
		
		if(token == null || user_id == 0) {
			return new ResponseEntity<Streak>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(user_id);
		if(!au.authorize(user, token)) {
			return new ResponseEntity<Streak>(HttpStatus.UNAUTHORIZED);
		}
		
		streakService.deleteStreak(new Streak(id));
		return new ResponseEntity<Streak>(HttpStatus.OK);
	}
}
