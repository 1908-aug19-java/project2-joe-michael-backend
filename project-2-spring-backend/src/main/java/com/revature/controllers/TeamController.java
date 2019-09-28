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

import com.revature.models.Team;
import com.revature.services.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping
	public List <Team> getAll(){
		return teamService.findAllTeams();
	}
	
	@GetMapping("/{id}")
	public Team getTeamById(@PathVariable("id")Integer id) {
		return teamService.findTeamById(id);
	}
	
	@PostMapping
	public ResponseEntity<Team> addTeam(@Valid @RequestBody Team team){
		teamService.addTeam(team);
		return new ResponseEntity<Team>(team, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Team updateTeam(@PathVariable("id")Integer id, @Valid @RequestBody Team team) {
		team.setApi_team_id(id);
		return teamService.updateTeam(team);
	}
	
	@DeleteMapping("/{id}")
	public Team deleteTeam(@PathVariable("id")Integer id) {
		return teamService.deleteTeam(new Team(id));
	}
}
