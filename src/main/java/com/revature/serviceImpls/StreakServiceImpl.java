package com.revature.serviceImpls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.Streak;
import com.revature.repositories.StreakRepository;
import com.revature.services.StreakService;

@Service
public class StreakServiceImpl implements StreakService{

	@Autowired 
	private StreakRepository streakRepository;
	
	Logger logger = LoggerFactory.getLogger(StreakService.class);
	
	@Override
	public List<Streak> findAllStreaks() {
		logger.warn("streaks pulled from database");
		return streakRepository.findAll();
	}

	@Override
	public Streak findStreakById(Integer id) {
		logger.warn("streak pulled by id");
		return streakRepository.getOne(id);
	}

	@Override
	public Streak addStreak(Streak streak) {
		logger.warn("streak added");
		return streakRepository.save(streak);
	}

	@Override
	public Streak updateStreak(Streak streak) {
		logger.warn("streak updated");
		return streakRepository.save(streak);
	}

	@Override
	public Streak deleteStreak(Streak streak) {
		logger.warn("streak deleted");
		streakRepository.delete(streak);
		return streak;
	}

}
