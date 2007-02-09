package br.bipweb.dao.hibernate;

import org.hibernate.Session;

import br.bipweb.dao.DocumentDao;
import br.bipweb.model.Document;

public class HibernateDocumentDao extends HibernateGenericDao<Document, Long> implements DocumentDao {

	private static final long serialVersionUID = -2918742793156302631L;

	public HibernateDocumentDao(Session session) {
		super(Document.class, session);
	}

}
