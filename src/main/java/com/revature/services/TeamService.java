package com.revature.services;

import java.util.List;
import com.revature.models.Team;

public interface TeamService {

	public List<Team> findAllTeams();
	public Team findTeamById(Integer id);
	public Team addTeam(Team team);
	public Team updateTeam(Team team);
	public Team deleteTeam(Team team);
	
}
