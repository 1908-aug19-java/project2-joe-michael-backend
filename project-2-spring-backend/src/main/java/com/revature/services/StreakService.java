package com.revature.services;

import java.util.List;

import com.revature.models.Streak;

public interface StreakService {
	
	public List<Streak> findAllStreaks();
	public Streak findStreakById(Integer id);
	public Streak addStreak(Streak streak);
	public Streak updateStreak(Streak streak);
	public Streak deleteStreak(Streak streak);
	
}
