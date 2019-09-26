package com.revature.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.dao.PlayerDao;
import com.revature.model.Player;
import com.revature.model.User;
//import com.revature.model.User;
import com.revature.util.Util;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public Player getPlayerById(int id) {
		try(Session s = Util.getSession()){
			Player player = s.get(Player.class, id);

			return player;
		}
	}

	@Override
	public List<Player> getAllPlayers() {
		List<Player> players = null;
		try(Session s = Util.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Player> cq = cb.createQuery(Player.class);
			
			cq.select(cq.from(Player.class));
			
			Query<Player> query = s.createQuery(cq);
			players = query.list();
		}
		
		return players;
	}

	@Override
	public boolean createPlayer(Player player) {
		try(Session s = Util.getSession()){
			
			Transaction tx = s.beginTransaction();
			 s.save(player);
			tx.commit();
		}
		return true;
	}

	@Override
	public boolean updatePlayer(Player player) {
		try(Session s = Util.getSession()){
			Transaction tx = s.beginTransaction();
			s.update(player);
			tx.commit();
		}
		return true;
	}

	@Override
	public boolean deletePlayer(Player player) {
		try(Session s = Util.getSession()){
			Transaction tx = s.beginTransaction();
			s.delete(player);
			tx.commit();
		}
		return true;
	}

}
