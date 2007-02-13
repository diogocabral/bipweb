package br.bipweb.model.agent;

import java.util.Collection;

import br.bipweb.model.Document;

public interface Searcher {
	
	public Collection<Document> search(String criteria)
			throws SearchException;
	
	public Collection<Document> searchNext()
			throws SearchException;
	
	public boolean hasMoreDocuments()
			throws SearchException;
	
}