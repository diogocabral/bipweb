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

	public Collection<Category> listByOwner(User owner)
			throws DaoException {
		
		try {
			
			String hql = String.format("select category from Category category where category.parent = null and category.owner.username = '%s'", owner.getUsername());
			
			Query query = session.createQuery(hql);

			return query.list();
			
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
		
	}
	
}