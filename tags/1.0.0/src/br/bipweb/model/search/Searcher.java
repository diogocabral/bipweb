package br.bipweb.model.search;

import java.util.Collection;

import br.bipweb.model.Criteria;
import br.bipweb.model.Document;

public interface Searcher {
	
	public Collection<Document> search()
			throws SearchException;
	
	public Collection<Document> searchNext()
			throws SearchException;
	
	public boolean hasMoreDocuments()
			throws SearchException;
	
	public Criteria getCriteria();
	
	public void setCriteria(Criteria criteria);
	
	public int getDocumentsPerPage();
	
	public void setDocumentsPerPage(int documentsPerPage);
	
}