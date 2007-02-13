package br.bipweb.model.search;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.Locale;

import br.bipweb.model.Document;

public abstract class AbstractSearcher implements Searcher {
	
	protected static final int N = 10;
	protected static final String USERAGENT = "BIPWeb";
	protected static final NumberFormat FORMAT = NumberFormat.getNumberInstance(new Locale("en")); 
	
	protected int first, last, total;
	protected String criteria;
	
	public Collection<Document> search(String criteria)
			throws SearchException {
		
		first = last = total = 0;
		
		this.criteria = criteria;
		
		return null;
		
	}
	
	public Collection<Document> searchNext()
			throws SearchException {
		
		if (!hasMoreDocuments()) 
			throw new SearchException("Fim da busca.");
		
		return null;
		
	}
	
	public boolean hasMoreDocuments()
			throws SearchException {
		
		if (criteria == null)
			throw new SearchException("Deve-se primeiro fazer a busca.");
		
		return false;
		
	}
	
}