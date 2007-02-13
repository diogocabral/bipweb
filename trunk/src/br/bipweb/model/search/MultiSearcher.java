package br.bipweb.model.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import br.bipweb.model.Document;

/**
 * 
 * @author Leonardo Costa Beltrão Lessa
 */
public class MultiSearcher implements Searcher {
	
	private Collection<Searcher> searchers;
	
	public MultiSearcher() {
		super();
		
		searchers = new ArrayList<Searcher>();
		searchers.add(new AltaVistaSearcher());
		searchers.add(new GoogleSearcher());
		searchers.add(new YahooSearcher());
		
	}
	
	public Collection<Document> search(String criteria)
			throws SearchException {
		
		// HashSet verifica elementos duplicados
		Collection<Document> documents = new HashSet<Document>();
		
		for (Searcher searcher : searchers) {
			documents.addAll(searcher.search(criteria));
		}
		
		return documents;
		
	}
	
	public Collection<Document> searchNext()
			throws SearchException {
		
		// HashSet verifica elementos duplicados
		Collection<Document> documents = new HashSet<Document>(); 
		
		for (Searcher searcher : searchers) {
			if (searcher.hasMoreDocuments()) {
				documents.addAll(searcher.searchNext());
			}
		}
		
		return documents;
		
	}

	public boolean hasMoreDocuments()
			throws SearchException {
		
		for (Searcher searcher : searchers) {
			if (searcher.hasMoreDocuments()) {
				return true;
			}
		}
		
		return false;
	}
	
}