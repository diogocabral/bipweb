package br.bipweb.model;

import java.util.ArrayList;
import java.util.List;

public class GlobalSearch {
	
	private List<SearchAgent> agents;
	
	public GlobalSearch() {
		super();
		agents = new ArrayList<SearchAgent>();
		agents.add(new GoogleSearch());
	}
	
	public List<Document> search(String criteria) {
		
		// TODO Verificar documentos duplicados
		
		List<Document> documents = new ArrayList<Document>();
		
		for (SearchAgent agent : agents) {
			documents.addAll(agent.search(criteria));
		}
		
		return documents;
		
	}
	
}