package com.revature.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.dao.StreakDao;

import com.revature.model.Streak;
import com.revature.util.Util;

public class StreakDaoImpl implements StreakDao {

	@Override
	public Streak getStreakById(int id) {
		try(Session s = Util.getSession()){
			Streak streak = s.get(Streak.class, id);

			return streak;
		}
	}

	@Override
	public List<Streak> getAllStreaks() {
		List<Streak> streaks = null;
		try(Session s = Util.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Streak> cq = cb.createQuery(Streak.class);
			
			cq.select(cq.from(Streak.class));
			
			Query<Streak> query = s.createQuery(cq);
			streaks = query.list();
		}
		
		return streaks;
	}

	@Override
	public boolean createStreak(Streak streak) {
		try(Session s = Util.getSession()){
			
			Transaction tx = s.beginTransaction();
			 s.save(streak);
			tx.commit();
		}
		return true;
	}

	@Override
	public boolean updateStreak(Streak streak) {
		try(Session s = Util.getSession()){
			Transaction tx = s.beginTransaction();
			s.update(streak);
			tx.commit();
		}
		return true;
	}

	@Override
	public boolean deleteStreak(Streak streak) {
		try(Session s = Util.getSession()){
			Transaction tx = s.beginTransaction();
			s.delete(streak);
			tx.commit();
		}
		return true;
	}

}
