package br.ufal.ic.articles.core;

import java.util.Collection;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.Query;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

import br.ufal.ic.articles.util.HibernateUtil;

public class DublinCoreLuceneSearch {
	
	private FullTextSession luceneSession;
	
	public DublinCoreLuceneSearch() {
		luceneSession = Search.createFullTextSession(HibernateUtil.getSession());
	}
	
	public DublinCoreArticle get(String identifier) {
		return (DublinCoreArticle) luceneSession.get(DublinCoreArticle.class, identifier);
	}

	public Collection<DublinCoreArticle> findByExample(String term, Integer firstResult, Integer maxResults) {
		try {
			MultiFieldQueryParser parser = new MultiFieldQueryParser(
					new String[] {"title", "subject", "description"}, new StandardAnalyzer());
	
		    Query luceneQuery = parser.parse(term);
	
		    FullTextQuery fullTextQuery = luceneSession.createFullTextQuery(luceneQuery, DublinCoreArticle.class)
		    	.setFirstResult(firstResult)
		    	.setMaxResults(maxResults);
		    
		    return fullTextQuery.list();
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Integer findByExampleCount(String term) {
		try {
			MultiFieldQueryParser parser = new MultiFieldQueryParser(
					new String[] {"title", "subject", "description"}, new StandardAnalyzer());
	
		    Query luceneQuery = parser.parse(term);
	
		    return luceneSession.createFullTextQuery(luceneQuery, DublinCoreArticle.class).getResultSize();
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
