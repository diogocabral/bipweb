package br.bipweb.model.search;

import java.io.IOException;
import java.util.Collection;

import br.bipweb.model.Criteria;
import br.bipweb.model.Document;

/**
 * 
 * Esta classe deve implementar controle de search e searchNext...
 * 
 * @author Leonardo Costa Beltr�o Lessa
 *
 */
public class SearchController {
	
	private static SearchController instance;
	
	private MultiSearcher searcher;
	private ScoreAgent scoreAgent;
	
	private Criteria criteria;
	private Collection<Document> excludeDocuments;
	
	private SearchController() {
		super();
		
		searcher = new MultiSearcher();
		scoreAgent = new ScoreAgent();
		
	}
	
	public synchronized static SearchController getInstance() {
		if (instance == null) {
			instance = new SearchController();
		}
		return instance;
	}
	
	public Collection<Document> search()
			throws SearchException, IOException {
		
		searcher.setCriteria(criteria);
		
		Collection<Document> documents = searcher.search();
		
		documents.removeAll(excludeDocuments);
		
		return scoreAgent.execute(criteria.getCleanCriteria(), documents);
		
	}
	
	public Collection<Document> searchNext()
			throws SearchException, IOException {
		
		searcher.setCriteria(criteria);
		
		Collection<Document> documents = searcher.searchNext();
		
		documents.removeAll(excludeDocuments);
		
		return scoreAgent.execute(criteria.getCleanCriteria(), documents);
		
	}
	
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
	public void setExcludeDocuments(Collection<Document> excludeDocuments) {
		this.excludeDocuments = excludeDocuments;
	}
	
}