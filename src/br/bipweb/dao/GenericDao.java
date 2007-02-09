package br.bipweb.dao;

import java.io.Serializable;
import java.util.Collection;

/**
 * 
 * @author Diogo Cabral de Almeida
 * 
 */
public interface GenericDao<PersistentObject, PK extends Serializable> {

	PersistentObject get(PK pk) throws DaoException,
			ObjectNotFoundException;

	PersistentObject save(PersistentObject object) throws DaoException;

	void update(PersistentObject object) throws DaoException,
			ObjectNotFoundException;

	void delete(PersistentObject object) throws DaoException,
			ObjectNotFoundException;

	int findByExamplePageCount(PersistentObject object) throws DaoException;

	int listAllPageCount() throws DaoException;

	Collection<PersistentObject> findByExample(PersistentObject object)
			throws DaoException;

	Collection<PersistentObject> findByExample(PersistentObject object,
			int firstResult, int maxResults) throws DaoException;

	Collection<PersistentObject> listAll() throws DaoException;

	Collection<PersistentObject> listAll(int firstResult, int maxResults)
			throws DaoException;

}
