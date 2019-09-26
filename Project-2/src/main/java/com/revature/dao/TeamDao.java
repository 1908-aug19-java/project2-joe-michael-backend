package com.revature.dao;

import java.util.List;

import com.revature.model.Team;

public interface TeamDao {
	public Team getTeamById(int id);
	public List <Team> getAllTeams();
	public boolean createTeam(Team team);
	public boolean updateTeam(Team team);
	public boolean deleteTeam(Team team);
}
