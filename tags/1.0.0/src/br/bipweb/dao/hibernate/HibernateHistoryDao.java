package br.bipweb.dao.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.bipweb.dao.DaoException;
import br.bipweb.dao.HistoryDao;
import br.bipweb.model.History;
import br.bipweb.model.User;

public class HibernateHistoryDao extends HibernateGenericDao<History, Long> implements HistoryDao {

	private static final long serialVersionUID = -2918742793156302631L;

	public HibernateHistoryDao(Session session) {
		super(History.class, session);
	}
	
	public Collection<History> listByUser(User user)
			throws DaoException {
		
		try {
			
			Criteria criteria = session.createCriteria(History.class);
			
			criteria.add(Restrictions.eq("user", user));
			
			return criteria.list();
			
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
		
	}
	
	public History recommend(User user) throws DaoException {
		
		/*
		 * Restrições da consulta:
		 * - Não pode um History.url igual a History.url do usuário;
		 * - O usuário tem que ter algum vínculo (dono ou associado) com a categoria da History;
		 * - A History tem que ter um feedbackScore > 0.5;
		 * - Obter o primeiro item da consulta.
		 */
		
		Criteria criteria = session.createCriteria(History.class);
		criteria.add(Restrictions.ne("user", user));
		criteria.add(Restrictions.gt("feedbackScore", Float.valueOf("0.5")));
		criteria.createCriteria("category")
			//TODO resolver o disjunction
//			.add(Restrictions.disjunction()
//					.add(Restrictions.eq("owner", user))		
			.createCriteria("users")
				.add(Restrictions.eq("username", user.getUsername()));
		
		criteria.setMaxResults(1);
		
		List<History> list = criteria.list();
		
		return (list.size() == 0 ? null : list.get(0));
		
	}
	
}
