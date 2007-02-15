package br.bipweb.dao.hibernate;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.bipweb.dao.CategoryDao;
import br.bipweb.dao.DaoException;
import br.bipweb.model.Category;
import br.bipweb.model.User;

public class HibernateCategoryDao extends HibernateGenericDao<Category, Long> implements CategoryDao {

	private static final long serialVersionUID = -3888412407240090588L;
	
	public HibernateCategoryDao(Session session) {
		super(Category.class, session);
	}

	public Collection<Category> listByOwner(User owner)
			throws DaoException {
		try {
			Criteria criteria = session.createCriteria(Category.class);
			
			criteria.add(Restrictions.isNull("parent"));
			criteria.add(Restrictions.eq("owner", owner));
			
			criteria.addOrder(Order.asc("name"));
			
			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}		
	}
	
	public Collection<Category> listNotJoinedByName(User user, String name)
			throws DaoException {
		try {
			Criteria criteria = session.createCriteria(Category.class);
			
			criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
			criteria.add(Restrictions.isNull("parent"));
			criteria.add(Restrictions.not(Restrictions.eq("owner", user)));
			criteria.add(Restrictions.eq("shared", true));
			criteria.createCriteria("users").add(Restrictions.not(Restrictions.eq("username", user.getUsername())));
			
			criteria.addOrder(Order.asc("name"));
			
			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	
	public Collection<Category> listNotJoined(User user) throws DaoException {
		try {
			Criteria criteria = session.createCriteria(Category.class);
			criteria.add(Restrictions.not(Restrictions.eq("owner", user)));
			criteria.createCriteria("users").add(Restrictions.not(Restrictions.eq("username", user.getUsername())));
			
			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException();
		}
	}	
	
	public Collection<Category> listJoined(User user) throws DaoException {
		try {
			Criteria criteria = session.createCriteria(Category.class);
			criteria.add(Restrictions.not(Restrictions.eq("owner", user)));
			criteria.add(Restrictions.isNull("parent"));
			criteria.createCriteria("users").add(Restrictions.eq("username", user.getUsername()));
			
			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException();
		}
	}
	
	public Collection<Category> listJoinedByName(User user, String name) throws DaoException {
		try {
			Criteria criteria = session.createCriteria(Category.class);
			
			criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
			criteria.add(Restrictions.isNull("parent"));
			criteria.add(Restrictions.not(Restrictions.eq("owner", user)));
			criteria.add(Restrictions.eq("shared", true));
			criteria.createCriteria("users").add(Restrictions.eq("username", user.getUsername()));
			
			criteria.addOrder(Order.asc("name"));
			
			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	
}