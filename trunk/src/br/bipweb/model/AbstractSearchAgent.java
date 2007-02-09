package br.bipweb.model;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.Locale;

public abstract class AbstractSearchAgent implements SearchAgent {
	
	protected static final int N = 10;
	protected static final String USERAGENT = "BIPWeb";
	protected static final NumberFormat FORMAT = NumberFormat.getNumberInstance(new Locale("en")); 
	
	protected String criteria;
	
	public Collection<Document> search(String criteria)
			throws SearchException {
		
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