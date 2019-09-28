package com.revature.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Streak;
import com.revature.repositories.StreakRepository;
import com.revature.services.StreakService;

@Service
public class StreakServiceImpl implements StreakService{

	@Autowired 
	private StreakRepository streakRepository;
	
	@Override
	public List<Streak> findAllStreaks() {
		return streakRepository.findAll();
	}

	@Override
	public Streak findStreakById(Integer id) {
		return streakRepository.getOne(id);
	}

	@Override
	public Streak addStreak(Streak streak) {
		return streakRepository.save(streak);
	}

	@Override
	public Streak updateStreak(Streak streak) {
		return streakRepository.save(streak);
	}

	@Override
	public Streak deleteStreak(Streak streak) {
		streakRepository.delete(streak);
		return streak;
	}

}
