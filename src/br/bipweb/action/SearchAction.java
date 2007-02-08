package br.bipweb.action;

import java.util.ArrayList;
import java.util.Collection;

import br.bipweb.model.AltaVistaSearch;
import br.bipweb.model.Category;
import br.bipweb.model.Document;
import br.bipweb.model.GlobalSearch;
import br.bipweb.model.GoogleSearch;
import br.bipweb.model.SearchAgent;
import br.bipweb.model.SearchException;

import com.opensymphony.xwork.ActionSupport;

public class SearchAction extends ActionSupport {
	
	private GlobalSearch search;
	
	private Category category;
	
	private Collection<Document> documents;
	
	public SearchAction() {
		super();
		
		Collection<SearchAgent> agents = new ArrayList<SearchAgent>();
		agents.add(new GoogleSearch());
		agents.add(new AltaVistaSearch());
		
		search = new GlobalSearch();
		search.setAgents(agents);
		
	}
	
	public String doSearch() {
		
		try {
			
			System.out.println(category);
			
			documents = search.search("webwork+tree+example");
			
			System.out.println(documents.size());
			
		} catch (SearchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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