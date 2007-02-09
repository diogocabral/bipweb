package br.bipweb.dao.hibernate;

import org.hibernate.Session;

import br.bipweb.dao.UserDao;
import br.bipweb.model.User;

public class HibernateUserDao extends HibernateGenericDao<User, String> implements UserDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8533922261448100003L;

	public HibernateUserDao(Session session) {
		super(User.class, session);
	}

}
