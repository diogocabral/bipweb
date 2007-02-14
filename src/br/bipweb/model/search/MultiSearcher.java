package br.bipweb.model.search;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import br.bipweb.model.Document;
import br.bipweb.util.Constants;

/**
 * 
 * @author Leonardo Costa Beltrão Lessa
 */
public class MultiSearcher extends AbstractSearcher {
	
	private Collection<Searcher> searchers;
	
	public MultiSearcher() {
		super();
		
		searchers = new ArrayList<Searcher>();
		//searchers.add(new AltaVistaSearcher());
		//searchers.add(new GoogleSearcher());
		//searchers.add(new YahooSearcher());
		
		/*
		 * TODO Gambiarra para poder funcionar na Internet da UFAL :)
		 */
		LocalSearcher localSearcher = new LocalSearcher();
		localSearcher.setDirectory(new File(Constants.LOCALDOCS_LOCALPATH));
		localSearcher.setPrefix(Constants.LOCALDOCS_WEBPATH);
		searchers.add(localSearcher);
		
	}
	
	@Override
	public Collection<Document> search()
			throws SearchException {
		
		// HashSet verifica elementos duplicados
		Collection<Document> documents = new HashSet<Document>();
		
		for (Searcher searcher : searchers) {
			searcher.setCriteria(criteria);
			documents.addAll(searcher.search());
		}
		
		return documents;
		
	}
	
	@Override
	public Collection<Document> searchNext()
			throws SearchException {
		
		// HashSet verifica elementos duplicados
		Collection<Document> documents = new HashSet<Document>(); 
		
		for (Searcher searcher : searchers) {
			if (searcher.hasMoreDocuments()) {
				searcher.setCriteria(criteria);
				documents.addAll(searcher.searchNext());
			}
		}
		
		return documents;
		
	}
	
	@Override
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