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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.models.Wager;
import com.revature.services.UserService;
import com.revature.services.WagerService;

@RestController
@RequestMapping("/wagers")
public class WagerController {
	
	@Autowired
	private WagerService wagerService;
	@Autowired
	private UserService userService;

	
	@GetMapping
	public List <Wager> getAll(@RequestParam(value="user_id", required=false)Integer id){
		if(id != null) {
			User user = userService.findUserById(id);
			return wagerService.findAllWagersByInitiatingOrRecieving(user, user);
		}
		return wagerService.findAllWagers();
	}
	
	@GetMapping("/{id}")
	public Wager getWagerById(@PathVariable("id")Integer id) {
		return wagerService.findWagerById(id);
	}
	
	@PostMapping
	public ResponseEntity<Wager> addWager(@Valid @RequestBody Wager wager){
		wagerService.addWager(wager);
		return new ResponseEntity<Wager>(wager, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Wager updateWager(@PathVariable("id")Integer id, @Valid @RequestBody Wager wager) {
		wager.setId(id);
		return wagerService.updateWager(wager);
	}
	
	@DeleteMapping("/{id}")
	public Wager deleteWager(@PathVariable("id")Integer id) {
		return wagerService.deleteWager(new Wager(id));
	}
}
