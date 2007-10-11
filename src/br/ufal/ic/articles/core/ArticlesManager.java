package br.ufal.ic.articles.core;

import java.io.Serializable;

import br.ufal.ic.articles.util.HibernateUtil;

public class ArticlesManager implements Serializable {

	private static final long serialVersionUID = 3830559427387098352L;

	public DublinCoreArticle get(String id) {
		return (DublinCoreArticle) HibernateUtil.getSession().get(DublinCoreArticle.class, id);
	}
	
	public DublinCoreArticle[] search(String term, int firstResult, int maxResults) {		
		DublinCoreArticle[] dublinCoreArticles = new DublinCoreArticle[maxResults]; 
		return new DublinCoreLuceneSearch().findByExample(term, firstResult, maxResults)
			.toArray(dublinCoreArticles); 
	}
	
	public Integer searchCount(String term) {
		return new DublinCoreLuceneSearch().findByExampleCount(term);
	}	

}
