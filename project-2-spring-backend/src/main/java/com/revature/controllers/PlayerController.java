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
import com.revature.models.Player;
import com.revature.models.Team;
import com.revature.models.User;
import com.revature.services.PlayerService;
import com.revature.services.TeamService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/players")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	@Autowired
	private TeamService teamService;
	@Autowired 
	private UserService userService;
	
	@GetMapping
	public List <Player> getAll(){
		return playerService.findAllPlayers();
	}
	
	@GetMapping("/{id}")
	public Player getPlayerById(@PathVariable("id")Integer id) {
		return playerService.findPlayerById(id);
	}
	
	@PostMapping
	public ResponseEntity<Player> addPlayer(@RequestParam(value="team_id", required=false)Integer teamId,
			@RequestParam(value="user_id", required=false)Integer userId,
			@Valid @RequestBody Player player){
		
		
		player = playerService.addPlayer(player);
		if(teamId != null) {
			Team team = teamService.findTeamById(teamId);
			List<Player> players = team.getPlayers();
			players.add(player);
			team.setPlayers(players);
			teamService.updateTeam(team);
		}
		else if(userId != null) {
			User user = userService.findUserById(userId);
			List<Player> players = user.getPlayers();
			players.add(player);
			user.setPlayers(players);
			userService.updateUser(user);
		}
		return new ResponseEntity<Player>(player, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Player updatePlayer(@PathVariable("id")Integer id, @Valid @RequestBody Player player) {
		player.setApi_player_id(id);
		return playerService.updatePlayer(player);
	}
	
	@DeleteMapping("/{id}")
	public Player deletePlayer(@RequestParam(value="team_id", required=false)Integer teamId,
			@RequestParam(value="user_id", required=false)Integer userId,
			@PathVariable("id")Integer id) {
		
		Player player = playerService.findPlayerById(id);
		if(userId != null) {
			User user = userService.findUserById(userId);
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
		
		return playerService.deletePlayer(player); 
	}
}
