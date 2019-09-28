package com.revature.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Team;
import com.revature.repositories.TeamRepository;
import com.revature.services.TeamService;

@Service
public class TeamServiceImpl implements TeamService{

	@Autowired 
	private TeamRepository teamRepository;
	
	@Override
	public List<Team> findAllTeams() {
		
		return teamRepository.findAll();
	}

	@Override
	public Team findTeamById(Integer id) {
		return teamRepository.getOne(id);
	}

	@Override
	public Team addTeam(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public Team updateTeam(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public Team deleteTeam(Team team) {
		teamRepository.delete(team);
		return team;
	}

}
