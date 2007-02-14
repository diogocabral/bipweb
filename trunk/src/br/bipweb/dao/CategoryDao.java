package br.bipweb.dao;

import java.util.Collection;

import br.bipweb.model.Category;
import br.bipweb.model.User;

public interface CategoryDao extends GenericDao<Category, Long> {
	
	Collection<Category> listByOwner(User owner)
			throws DaoException;
	
}