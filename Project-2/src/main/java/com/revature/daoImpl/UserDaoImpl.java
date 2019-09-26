package com.revature.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.dao.UserDao;
import com.revature.model.User;
import com.revature.util.Util;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserById(int id) {
		try(Session s = Util.getSession()){
			User user = s.get(User.class, id);

			return user;
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = null;
		try(Session s = Util.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			
			cq.select(cq.from(User.class));
			
			Query<User> query = s.createQuery(cq);
			users = query.list();
		}
		
		return users;
	}

	@Override
	public boolean createUser(User user) {
		try(Session s = Util.getSession()){
			
			Transaction tx = s.beginTransaction();
			 s.save(user);
			tx.commit();
		}
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		try(Session s = Util.getSession()){
			Transaction tx = s.beginTransaction();
			s.update(user);
			tx.commit();
		}
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		try(Session s = Util.getSession()){
			Transaction tx = s.beginTransaction();
			s.delete(user);
			tx.commit();
		}
		return true;
	}

	
}
