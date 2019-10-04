package com.revature.serviceImpls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.Team;
import com.revature.repositories.TeamRepository;
import com.revature.services.TeamService;

@Service
public class TeamServiceImpl implements TeamService{
	
	Logger logger = LoggerFactory.getLogger(TeamService.class);

	@Autowired 
	private TeamRepository teamRepository;
	
	@Override
	public List<Team> findAllTeams() {
		
		logger.warn("all teams pulled");
		
		return teamRepository.findAll();
	}

	@Override
	public Team findTeamById(Integer id) {
		logger.warn("team pulled by id");
		
		return teamRepository.getOne(id);
	}

	@Override
	public Team addTeam(Team team) {
		logger.warn("team added");
		
		return teamRepository.save(team);
	}

	@Override
	public Team updateTeam(Team team) {
		
		logger.warn("team updated");
		
		return teamRepository.save(team);
	}

	@Override
	public Team deleteTeam(Team team) {
		
		logger.warn("team deleted");
		
		teamRepository.delete(team);
		return team;
	}

}
