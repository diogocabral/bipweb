package br.bipweb.model.agent;

import java.util.Collection;

import br.bipweb.model.Criteria;
import br.bipweb.model.Document;

/**
 * 
 * Esta classe deve implementar controle de search e searchNext...
 * 
 * @author Leonardo Costa Beltrão Lessa
 *
 */
public class SearchController {
	
	private static SearchController instance;
	
	private MultiSearcher searcher;
	private ScoreAgent scoreAgent;
	
	private Criteria criteria;
	
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
	
	public Collection<Document> search(Criteria criteria)
			throws SearchException {
		
		this.criteria = criteria;
		
		return scoreAgent.execute(criteria.getCleanCriteria(), searcher.search(criteria.getEncodedCriteria()));
		
	}
	
	public Collection<Document> searchNext()
			throws SearchException {
		
		return scoreAgent.execute(criteria.getCleanCriteria(), searcher.searchNext());
		
	}
	
}