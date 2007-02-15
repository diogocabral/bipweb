package br.bipweb.dao;

import java.util.Collection;

import br.bipweb.model.Category;
import br.bipweb.model.User;

public interface CategoryDao extends GenericDao<Category, Long> {

	Collection<Category> listByOwner(User owner) throws DaoException;

	Collection<Category> listNotJoinedByName(User user, String name) throws DaoException;
	
	Collection<Category> listJoinedByName(User user, String name) throws DaoException;

	Collection<Category> listNotJoined(User user) throws DaoException;
	
	Collection<Category> listJoined(User user) throws DaoException;

}