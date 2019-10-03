package com.revature.serviceImpls;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.Player;
import com.revature.repositories.PlayerRepository;
import com.revature.services.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired 
	private PlayerRepository playerRepository;
	
	@Override
	public List<Player> findAllPlayers() {
		
		return playerRepository.findAll();
	}

	@Override
	public Player findPlayerById(Integer id) {
		return playerRepository.getOne(id);
	}

	@Override
	public Player addPlayer(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public Player updatePlayer(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public Player deletePlayer(Player player) {
		playerRepository.delete(player);
		return player;
	}

}
