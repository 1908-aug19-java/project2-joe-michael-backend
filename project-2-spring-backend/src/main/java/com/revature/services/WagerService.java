package com.revature.services;

import java.util.List;

import com.revature.models.Wager;

public interface WagerService {
	
	public List<Wager> findAllWagers();
	public Wager findWagerById(Integer id);
	public Wager addWager(Wager wager);
	public Wager updateWager(Wager wager);
	public Wager deleteWager(Wager wager);

}
