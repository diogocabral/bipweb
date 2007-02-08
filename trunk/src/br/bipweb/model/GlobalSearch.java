package br.bipweb.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * @author Leonardo Costa Beltrão Lessa
 */
public class GlobalSearch {
	
	private List<SearchAgent> agents;
	
	public GlobalSearch() {
		super();
	}
	
	public Collection<Document> search(String criteria) {
		
		/*
		 * Um HashSet verifica elementos duplicados :)
		 */
		
		Collection<Document> documents = new HashSet<Document>();
		
		for (SearchAgent agent : agents) {
			documents.addAll(agent.search(criteria));
		}
		
		return documents;
		
	}
	
	public List<SearchAgent> getAgents() {
		return agents;
	}
	
	public void setAgents(List<SearchAgent> agents) {
		this.agents = agents;
	}
	
}