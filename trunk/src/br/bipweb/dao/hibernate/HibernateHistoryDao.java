package br.bipweb.dao.hibernate;

import java.util.Collection;

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
	
	public History recommend(User user)
			throws DaoException {
		
		/*
		 * Restri��es da consulta:
		 * - N�o pode um History.url igual a History.url do usu�rio;
		 * - O usu�rio tem que ter algum v�nculo (dono ou associado) com a categoria da History;
		 * - A History tem que ter um feedbackScore > 0.5;
		 * - Obter o primeiro item da consulta.
		 */
		
		// TODO In�cio lixo
		History history = new History();
		history.setTitle("Isto � apenas um teste!");
		history.setUrl("http://teste.com.br");
		// TODO Fim lixo
		
		return history;
		
	}
	
}
