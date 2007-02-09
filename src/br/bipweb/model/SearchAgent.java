package br.bipweb.model;

import java.util.Collection;

public interface SearchAgent {
	
	public Collection<Document> search(String criteria)
			throws SearchException;
	
	public Collection<Document> searchNext()
			throws SearchException;
	
	public boolean hasMoreDocuments()
			throws SearchException;
	
}