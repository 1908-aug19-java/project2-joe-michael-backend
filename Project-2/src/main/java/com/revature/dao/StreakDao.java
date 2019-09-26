package com.revature.dao;

import java.util.List;

import com.revature.model.Streak;

public interface StreakDao {
	public Streak getStreakById(int id);
	public List <Streak> getAllStreaks();
	public boolean createStreak(Streak streak);
	public boolean updateStreak(Streak streak);
	public boolean deleteStreak(Streak streak);
}
