package com.revature.serviceImpls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.Player;
import com.revature.repositories.PlayerRepository;
import com.revature.services.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	Logger logger = LoggerFactory.getLogger(PlayerService.class);
	
	
	@Autowired 
	private PlayerRepository playerRepository;
	
	@Override
	public List<Player> findAllPlayers() {
		logger.warn("all players pulled");
		
		return playerRepository.findAll();
	}

	@Override
	public Player findPlayerById(Integer id) {
		logger.warn("player pulled by id");
		return playerRepository.getOne(id);
	}

	@Override
	public Player addPlayer(Player player) {
		logger.warn("player added");
		return playerRepository.save(player);
	}

	@Override
	public Player updatePlayer(Player player) {
		logger.warn("player updated");
		return playerRepository.save(player);
	}

	@Override
	public Player deletePlayer(Player player) {
		logger.warn("player deleted");
		playerRepository.delete(player);
		return player;
	}

}
