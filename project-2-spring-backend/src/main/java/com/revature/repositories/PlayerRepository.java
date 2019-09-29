package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.models.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	
}
