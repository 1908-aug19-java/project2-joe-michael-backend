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
import com.revature.services.StreakService;

@RestController
@RequestMapping("/streaks")
public class StreakController {
	
	@Autowired
	private StreakService streakService;
	
	@GetMapping
	public List <Streak> getAll(){
		return streakService.findAllStreaks();
	}
	
	@GetMapping("/{id}")
	public Streak getStreakById(@PathVariable("id")Integer id) {
		return streakService.findStreakById(id);
	}
	
	@PostMapping
	public ResponseEntity<Streak> addStreak(@Valid @RequestBody Streak streak){
		streakService.addStreak(streak);
		return new ResponseEntity<Streak>(streak, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Streak updateStreak(@PathVariable("id")Integer id, @Valid @RequestBody Streak streak) {
		streak.setId(id);
		return streakService.updateStreak(streak);
	}
	
	@DeleteMapping("/{id}")
	public Streak deleteStreak(@PathVariable("id")Integer id) {
		return streakService.deleteStreak(new Streak(id));
	}
}
