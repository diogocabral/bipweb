package br.bipweb.model;

import java.util.List;

public interface SearchAgent {
	
	public List<Document> search(String criteria);
	
}