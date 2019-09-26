package com.revature.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.dao.WagerDao;
import com.revature.model.Wager;
import com.revature.util.Util;

public class WagerDaoImpl implements WagerDao {

	@Override
	public Wager getWagerById(int id) {
		try(Session s = Util.getSession()){
			Wager wager = s.get(Wager.class, id);

			return wager;
		}
	}

	@Override
	public List<Wager> getAllWagers() {
		List<Wager> wagers = null;
		try(Session s = Util.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Wager> cq = cb.createQuery(Wager.class);
			
			cq.select(cq.from(Wager.class));
			
			Query<Wager> query = s.createQuery(cq);
			wagers = query.list();
		}
		
		return wagers;
	}

	@Override
	public boolean createWager(Wager wager) {
		try(Session s = Util.getSession()){
			
			Transaction tx = s.beginTransaction();
			 s.save(wager);
			tx.commit();
		}
		return true;
	}

	@Override
	public boolean updateWager(Wager wager) {
		try(Session s = Util.getSession()){
			Transaction tx = s.beginTransaction();
			s.update(wager);
			tx.commit();
		}
		return true;
	}

	@Override
	public boolean deleteWager(Wager wager) {
		try(Session s = Util.getSession()){
			Transaction tx = s.beginTransaction();
			s.delete(wager);
			tx.commit();
		}
		return true;
	}

}
