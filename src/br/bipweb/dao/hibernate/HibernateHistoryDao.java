package br.bipweb.dao.hibernate;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;

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
		
		
		String hql = String.format("select history from History history where history.user.username = '%s'", user.getUsername());
		
		Query query = session.createQuery(hql);

		return query.list();
		
	}
	
}
