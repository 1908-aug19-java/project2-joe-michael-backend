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
import com.revature.models.Team;
import com.revature.models.User;
import com.revature.services.TeamService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/teams")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List <Team> getAll(){
		return teamService.findAllTeams();
	}
	
	@GetMapping("/{id}")
	public Team getTeamById(@PathVariable("id")Integer id) {
		return teamService.findTeamById(id);
	}
	
	@PostMapping
	public ResponseEntity<Team> addTeam(@RequestParam(value="user_id", required=true)Integer id,@Valid @RequestBody Team team){
		team = teamService.addTeam(team);
		User user = userService.findUserById(id);
		List<Team> teams = user.getTeams();
		teams.add(team);
		user.setTeams(teams);
		userService.updateUser(user);
		
		return new ResponseEntity<Team>(team, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Team updateTeam(@PathVariable("id")Integer id, @Valid @RequestBody Team team) {
		team.setApi_team_id(id);
		return teamService.updateTeam(team);
	}
	
	@DeleteMapping("/{id}")
	public Team deleteTeam(@RequestParam(value="user_id", required=false)Integer userId,
			@PathVariable("id")Integer id) {
		Team team = teamService.findTeamById(id);
		if(userId != null) {
			User user = userService.findUserById(userId);
			List<Team> teams = user.getTeams();
			for (int i = 0; i<teams.size();i++) {
				if (teams.get(i).getId() == team.getId()) {
					teams.remove(i);
				}
			}
			user.setTeams(teams);
			userService.updateUser(user);
		}
		return teamService.deleteTeam(new Team(id));
	}
}
