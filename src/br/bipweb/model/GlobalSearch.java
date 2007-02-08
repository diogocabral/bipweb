package br.bipweb.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * 
 * @author Leonardo Costa Beltrão Lessa
 */
public class GlobalSearch {
	
	private Collection<SearchAgent> agents;
	
	public GlobalSearch() {
		super();
	}
	
	public Collection<Document> search(String criteria)
			throws SearchException {
		
		// HashSet verifica elementos duplicados
		Collection<Document> documents = new HashSet<Document>();
		
		for (SearchAgent agent : agents) {
			documents.addAll(agent.search(criteria));
		}
		
		return documents;
		
	}
	
	
	public Collection<Document> searchNext()
			throws SearchException {
		
		// HashSet verifica elementos duplicados
		Collection<Document> documents = new HashSet<Document>(); 
		
		for (SearchAgent agent : agents) {
			documents.addAll(agent.searchNext());
		}
		
		return documents;
		
	}
	
	public Collection<SearchAgent> getAgents() {
		return agents;
	}
	
	public void setAgents(Collection<SearchAgent> agents) {
		this.agents = agents;
	}
	
}