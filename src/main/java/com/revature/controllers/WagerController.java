package com.revature.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.revature.models.User;
import com.revature.models.Wager;
import com.revature.services.UserService;
import com.revature.services.WagerService;
import com.revature.util.AuthorizationUtil;

@RestController
@RequestMapping("/wagers")
@CrossOrigin
public class WagerController {
	
	@Autowired
	private WagerService wagerService;
	@Autowired
	private UserService userService;
	
	AuthorizationUtil au = new AuthorizationUtil();

	
	@GetMapping
	public ResponseEntity<List<Wager>> getAll(@RequestParam(value="user_id", required=false)Integer id, 
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int userId){
		if(token == null || userId == 0) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(userId);
		Boolean authorized = au.authorize(user, token);
		if(!Boolean.TRUE.equals(authorized)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		if(id != null) {
		    user = userService.findUserById(id);
			List<Wager> wagers = wagerService.findAllWagersByInitiatingOrRecieving(user, user);
			return new ResponseEntity<>(wagers, HttpStatus.OK);
		}
		List<Wager> wagers = wagerService.findAllWagers();
		return new ResponseEntity<>(wagers, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Wager> getWagerById(@PathVariable("id")Integer id,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int userId) {
		
		if(token == null || userId == 0) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(userId);
		Boolean authorized = au.authorize(user, token);
		if(!Boolean.TRUE.equals(authorized)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		Wager wager = wagerService.findWagerById(id);
		return new ResponseEntity<>(wager, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Wager> addWager(@Valid @RequestBody Wager wager,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int userId){
		
		if(token == null || userId == 0) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(userId);
		Boolean authorized = au.authorize(user, token);
		if(!Boolean.TRUE.equals(authorized)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		wagerService.addWager(wager);
		return new ResponseEntity<>(wager, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Wager> updateWager(@PathVariable("id")Integer id,
			@Valid @RequestBody Wager wager,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int userId) {
		
		if(token == null || userId == 0) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(userId);
		Boolean authorized = au.authorize(user, token);
		if(!Boolean.TRUE.equals(authorized)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		wager.setId(id);
		wager = wagerService.updateWager(wager);
		return new ResponseEntity<>(wager, HttpStatus.OK); 
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Wager> deleteWager(@PathVariable("id")Integer id,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int userId) {
		
		if(token == null || userId == 0) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(userId);
		Boolean authorized = au.authorize(user, token);
		if(!Boolean.TRUE.equals(authorized)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		wagerService.deleteWager(new Wager(id));
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}
