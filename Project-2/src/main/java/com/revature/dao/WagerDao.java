package com.revature.dao;

import java.util.List;

import com.revature.model.Wager;

public interface WagerDao {
	public Wager getWagerById(int id);
	public List <Wager> getAllWagers();
	public boolean createWager(Wager wager);
	public boolean updateWager(Wager wager);
	public boolean deleteWager(Wager wager);
}
