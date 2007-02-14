package br.bipweb.dao;

import java.util.Collection;

import br.bipweb.model.History;
import br.bipweb.model.User;

public interface HistoryDao extends GenericDao<History, Long> {
	
	public Collection<History> listByUser(User user)
			throws DaoException;
	
}