package br.bipweb.action;

import java.util.ArrayList;
import java.util.Collection;

import br.bipweb.model.AltaVistaSearch;
import br.bipweb.model.Category;
import br.bipweb.model.CriteriaCalculator;
import br.bipweb.model.Document;
import br.bipweb.model.GlobalSearch;
import br.bipweb.model.GoogleSearch;
import br.bipweb.model.SearchAgent;
import br.bipweb.model.SearchException;
import br.bipweb.model.YahooSearch;

import com.opensymphony.xwork.ActionSupport;

public class SearchAction extends ActionSupport {

	private static final long serialVersionUID = -5237261947821051526L;

	private GlobalSearch search;
	
	private Category category;
	
	private Collection<Document> documents;
	
	public SearchAction() {
		super();
		
		Collection<SearchAgent> agents = new ArrayList<SearchAgent>();
		agents.add(new AltaVistaSearch());
		agents.add(new GoogleSearch());
		agents.add(new YahooSearch());
		
		search = new GlobalSearch();
		search.setAgents(agents);
		
	}
	
	public String doSearch() {
		
		try {
			
			documents = search.search("webwork+tree+example");
			
			CriteriaCalculator calculator = new CriteriaCalculator();
			
			String criteria = calculator.calculate(category);
			
			documents = search.search(criteria);
			
		} catch (SearchException e) {
			e.printStackTrace(); // TODO
		}
		
		return SUCCESS;
	}
	
	public String doContinue() {
		return SUCCESS;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Collection<Document> getDocuments() {
		return documents;
	}
	
}