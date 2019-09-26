package com.revature.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.dao.TeamDao;
import com.revature.model.Team;
import com.revature.util.Util;

public class TeamDaoImpl implements TeamDao{

	@Override
	public Team getTeamById(int id) {
		try(Session s = Util.getSession()){
			Team team = s.get(Team.class, id);

			return team;
		}
	}

	@Override
	public List<Team> getAllTeams() {
		List<Team> teams = null;
		try(Session s = Util.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Team> cq = cb.createQuery(Team.class);
			
			cq.select(cq.from(Team.class));
			
			Query<Team> query = s.createQuery(cq);
			teams = query.list();
		}
		
		return teams;	}

	@Override
	public boolean createTeam(Team team) {
		try(Session s = Util.getSession()){
			
			Transaction tx = s.beginTransaction();
			 s.save(team);
			tx.commit();
		}
		return true;
	}

	@Override
	public boolean updateTeam(Team team) {
		try(Session s = Util.getSession()){
			Transaction tx = s.beginTransaction();
			s.update(team);
			tx.commit();
		}
		return true;
	}

	@Override
	public boolean deleteTeam(Team team) {
		try(Session s = Util.getSession()){
			Transaction tx = s.beginTransaction();
			s.delete(team);
			tx.commit();
		}
		return true;
	}

}
