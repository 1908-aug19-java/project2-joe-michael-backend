package com.revature.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.models.User;
import com.revature.models.Wager;

public interface WagerRepository extends JpaRepository<Wager, Integer>{
	public List<Wager> findWagerByInitiatingOrRecieving(User initiating, User recieving);
	
}
