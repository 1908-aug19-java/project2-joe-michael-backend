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

import com.revature.models.Player;
import com.revature.services.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@GetMapping
	public List <Player> getAll(){
		return playerService.findAllPlayers();
	}
	
	@GetMapping("/{id}")
	public Player getPlayerById(@PathVariable("id")Integer id) {
		return playerService.findPlayerById(id);
	}
	
	@PostMapping
	public ResponseEntity<Player> addPlayer(@Valid @RequestBody Player player){
		playerService.addPlayer(player);
		return new ResponseEntity<Player>(player, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Player updatePlayer(@PathVariable("id")Integer id, @Valid @RequestBody Player player) {
		player.setApi_player_id(id);
		return playerService.updatePlayer(player);
	}
	
	@DeleteMapping("/{id}")
	public Player deletePlayer(@PathVariable("id")Integer id) {
		return playerService.deletePlayer(new Player(id));
	}
}
