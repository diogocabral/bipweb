package br.bipweb.dao.hibernate;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
			Query query = session.createQuery("select category from Category category where category.parent = null");

			return query.list();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}		
	}
	
}