package com.revature.dao;

import java.util.List;

import com.revature.model.Player;

public interface PlayerDao {
	public Player getPlayerById(int id);
	public List <Player> getAllPlayers();
	public boolean createPlayer(Player player);
	public boolean updatePlayer(Player player);
	public boolean deletePlayer(Player player);
}
