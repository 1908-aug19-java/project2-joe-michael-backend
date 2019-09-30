package com.revature.services;

import java.util.List;

import com.revature.models.Player;

public interface PlayerService {
	
	public List<Player> findAllPlayers();
	public Player findPlayerById(Integer id);
	public Player addPlayer(Player player);
	public Player updatePlayer(Player player);
	public Player deletePlayer(Player player);

}
