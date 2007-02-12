package br.bipweb.dao.hibernate;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.bipweb.dao.CategoryDao;
import br.bipweb.dao.DaoException;
import br.bipweb.model.Category;
import br.bipweb.model.User;

public class HibernateCategoryDao extends HibernateGenericDao<Category, Long> implements CategoryDao {

	private static final long serialVersionUID = -3888412407240090588L;
	
	public HibernateCategoryDao(Session session) {
		super(Category.class, session);
	}

	public Collection<Category> listByUser(User user) throws DaoException {		
		try {
			Criteria criteria = session.createCriteria(Category.class);
			
			// TODO criteria.setResultTransformer(new AliasToBeanResultTransformer(Category.class));
			
			// TODO Não está funcionando corretamente
			/*
			 * A classe Category não tem uma listagem comum. Ela deve retornar somente
			 * as tuplas que não tiverem parent.
			 * parent == null
			 */

			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}		
	}
	
}