package br.bipweb.model.agent;

import java.util.Collection;

import br.bipweb.model.Category;
import br.bipweb.model.Document;

/**
 * 
 * Esta classe deve implementar controle de ...
 * 
 * @author Leonardo Costa Beltrão Lessa
 *
 */
public class SearchController {
	
	private static SearchController instance;
	
	private MultiSearcher searcher;
	private CriteriaAgent criteriaAgent;
	private ScoreAgent scoreAgent;
	
	private String criteria;
	
	private SearchController() {
		super();
		
		searcher = new MultiSearcher();
		criteriaAgent = new CriteriaAgent();
		scoreAgent = new ScoreAgent();
		
	}
	
	public synchronized static SearchController getInstance() {
		if (instance == null) {
			instance = new SearchController();
		}
		return instance;
	}
	
	public Collection<Document> search(Category category)
			throws SearchException {
		
		criteria = criteriaAgent.execute(category);
		
		return scoreAgent.execute(criteria, searcher.search(criteria));
		
	}
	
	public Collection<Document> searchNext()
			throws SearchException {
		
		return scoreAgent.execute(criteria, searcher.searchNext());
		
	}
	
}