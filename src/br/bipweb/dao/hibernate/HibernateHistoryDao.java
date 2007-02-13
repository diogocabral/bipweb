package br.bipweb.dao.hibernate;

import org.hibernate.Session;

import br.bipweb.dao.HistoryDao;
import br.bipweb.model.History;

public class HibernateHistoryDao extends HibernateGenericDao<History, Long> implements HistoryDao {

	private static final long serialVersionUID = -2918742793156302631L;

	public HibernateHistoryDao(Session session) {
		super(History.class, session);
	}

}
