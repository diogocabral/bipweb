package br.bipweb.model.search;

import java.util.Collection;

import br.bipweb.model.Criteria;
import br.bipweb.model.Document;

public abstract class AbstractSearcher implements Searcher {
	
	protected Criteria criteria;
	protected int documentsPerPage;
	
	public AbstractSearcher() {
		super();
		
		documentsPerPage = 10;
		
	}
	
	public Collection<Document> search()
			throws SearchException {
		
		if (criteria == null)
			throw new SearchException("Deve-se definir um critério de busca.");
		
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
	
	public Criteria getCriteria() {
		return criteria;
	}
	
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
	public int getDocumentsPerPage() {
		return documentsPerPage;
	}
	
	public void setDocumentsPerPage(int documentsPerPage) {
		this.documentsPerPage = documentsPerPage;
	}
	
}