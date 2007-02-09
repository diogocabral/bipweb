package br.bipweb.dao.hibernate;

import org.hibernate.Session;

import br.bipweb.dao.CategoryDao;
import br.bipweb.model.Category;

public class HibernateCategoryDao extends HibernateGenericDao<Category, Long> implements CategoryDao {

	private static final long serialVersionUID = -3888412407240090588L;
	
	public HibernateCategoryDao(Session session) {
		super(Category.class, session);
	}	

}
