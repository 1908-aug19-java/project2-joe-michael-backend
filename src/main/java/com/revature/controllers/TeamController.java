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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.revature.models.Team;
import com.revature.models.User;
import com.revature.services.TeamService;
import com.revature.services.UserService;
import com.revature.util.AuthorizationUtil;

@RestController
@RequestMapping("/teams")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	@Autowired
	private UserService userService;
	
	AuthorizationUtil au = new AuthorizationUtil();
	
	@GetMapping
	public ResponseEntity<List<Team>> getAll(@RequestHeader(value="token")String token, 
			@RequestHeader(value="user_id")int user_id){
		if(token == null || user_id == 0) {
			return new ResponseEntity<List<Team>>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(user_id);
		if(!au.authorize(user, token)) {
			return new ResponseEntity<List<Team>>(HttpStatus.UNAUTHORIZED);
		}
		List<Team> teams = teamService.findAllTeams();
		return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Team> getTeamById(@PathVariable("id")Integer id,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int user_id) {
		
		if(token == null || user_id == 0) {
			return new ResponseEntity<Team>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(user_id);
		if(!au.authorize(user, token)) {
			return new ResponseEntity<Team>(HttpStatus.UNAUTHORIZED);
		}
		
		Team team = teamService.findTeamById(id);
		return new ResponseEntity<Team>(team, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Team> addTeam(@RequestParam(value="user_id", required=true)Integer id,
			@Valid @RequestBody Team team,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int user_id){
		
		if(token == null || user_id == 0) {
			return new ResponseEntity<Team>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(user_id);
		if(!au.authorize(user, token)) {
			return new ResponseEntity<Team>(HttpStatus.UNAUTHORIZED);
		}
		
		team = teamService.addTeam(team);
		user = userService.findUserById(id);
		List<Team> teams = user.getTeams();
		teams.add(team);
		user.setTeams(teams);
		userService.updateUser(user);
		
		return new ResponseEntity<Team>(team, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Team> updateTeam(@PathVariable("id")Integer id,
			@Valid @RequestBody Team team,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int user_id) {
		
		if(token == null || user_id == 0) {
			return new ResponseEntity<Team>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(user_id);
		if(!au.authorize(user, token)) {
			return new ResponseEntity<Team>(HttpStatus.UNAUTHORIZED);
		}
		
		team.setApi_team_id(id);
		team = teamService.updateTeam(team);
		return new ResponseEntity<Team>(team, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Team> deleteTeam(@RequestParam(value="user_id", required=false)Integer userId,
			@PathVariable("id")Integer id,
			@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int user_id) {
		
		if(token == null || user_id == 0) {
			return new ResponseEntity<Team>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(user_id);
		if(!au.authorize(user, token)) {
			return new ResponseEntity<Team>(HttpStatus.UNAUTHORIZED);
		}
		
		Team team = teamService.findTeamById(id);
		if(userId != null) {
		    user = userService.findUserById(userId);
			List<Team> teams = user.getTeams();
			for (int i = 0; i<teams.size();i++) {
				if (teams.get(i).getId() == team.getId()) {
					teams.remove(i);
				}
			}
			user.setTeams(teams);
			userService.updateUser(user);
		}
		 teamService.deleteTeam(new Team(id));
		return new ResponseEntity<Team>(team, HttpStatus.OK);
	}
}
