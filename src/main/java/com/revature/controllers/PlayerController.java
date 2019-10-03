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
import com.revature.models.Player;
import com.revature.models.Team;
import com.revature.models.User;
import com.revature.services.PlayerService;
import com.revature.services.TeamService;
import com.revature.services.UserService;
import com.revature.util.AuthorizationUtil;

@RestController
@RequestMapping("/players")
@CrossOrigin
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	@Autowired
	private TeamService teamService;
	@Autowired 
	private UserService userService;
	
	AuthorizationUtil au = new AuthorizationUtil();
	
	@GetMapping
	public ResponseEntity<List<Player>> getAll(@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int userId){
		
		if(token != null && userId != 0) {
			User user = userService.findUserById(userId);
			Boolean authorized = au.authorize(user, token);
			if(Boolean.TRUE.equals(authorized)) {
				
				List<Player> players = playerService.findAllPlayers();
				return new ResponseEntity<>(players, HttpStatus.ACCEPTED);
			
			}
			else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		}
		else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}	
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Player> getPlayerById(@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int userId,
			@PathVariable("id")Integer id) {
		
		if(token != null && userId != 0) {
			User user = userService.findUserById(userId);
			Boolean authorized = au.authorize(user, token);
			if(Boolean.TRUE.equals(authorized)) {
				//normal operations
				Player player = playerService.findPlayerById(id);

				return new ResponseEntity<>(player, HttpStatus.ACCEPTED);
			}
			else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		}
		else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
	}
	
	
	@PostMapping
	public ResponseEntity<Player> addPlayer(@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int userId,
			@RequestParam(value="team_id", required=false)Integer teamId,
			@RequestParam(value="user_id", required=false)Integer userIdParam,
			@Valid @RequestBody Player player){
		
		if(token == null || userId == 0) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(userId);
		Boolean authorized = au.authorize(user, token);
		if(!Boolean.TRUE.equals(authorized)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		player = playerService.addPlayer(player);
		if(teamId != null) {
			Team team = teamService.findTeamById(teamId);
			List<Player> players = team.getPlayers();
			players.add(player);
			team.setPlayers(players);
			teamService.updateTeam(team);
		}
		else if(userIdParam != null) {
			user = userService.findUserById(userIdParam);
			List<Player> players = user.getPlayers();
			players.add(player);
			user.setPlayers(players);
			userService.updateUser(user);
		}
		
		return new ResponseEntity<>(player, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Player> updatePlayer(@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int userId,
			@PathVariable("id")Integer id, 
			@Valid @RequestBody Player player) {
		
		if(token == null || userId == 0) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(userId);
		Boolean authorized = au.authorize(user, token);
		if(!Boolean.TRUE.equals(authorized)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		player.setApi_player_id(id);
		player = playerService.updatePlayer(player);
		return new ResponseEntity<>(player, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Player> deletePlayer(@RequestHeader(value="token")String token,
			@RequestHeader(value="user_id")int userId,
			@RequestParam(value="team_id", required=false)Integer teamId,
			@RequestParam(value="user_id", required=false)Integer userIdParam,
			@PathVariable("id")Integer id) {
		
		if(token == null || userId == 0) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.findUserById(userId);
		Boolean authorized = au.authorize(user, token);
		if(!Boolean.TRUE.equals(authorized)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		Player player = playerService.findPlayerById(id);
		if(userIdParam != null) {
			user = userService.findUserById(userIdParam);
			List<Player> players = user.getPlayers();
			for (int i = 0; i<players.size();i++) {
				if (players.get(i).getId() == player.getId()) {
					players.remove(i);
				}
			}
			user.setPlayers(players);
			userService.updateUser(user);
		}
		else if(teamId != null) {
			Team team = teamService.findTeamById(teamId);
			List<Player> players = team.getPlayers();
			for (int i = 0; i<players.size();i++) {
				if (players.get(i).getId() == player.getId()) {
					players.remove(i);
				}
			}
			team.setPlayers(players);
			teamService.updateTeam(team);
		}
		
		playerService.deletePlayer(player);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
