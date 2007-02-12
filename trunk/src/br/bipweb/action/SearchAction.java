package br.bipweb.action;

import java.util.ArrayList;
import java.util.Collection;

import br.bipweb.dao.CategoryDao;
import br.bipweb.dao.DaoException;
import br.bipweb.dao.ObjectNotFoundException;
import br.bipweb.model.AltaVistaSearch;
import br.bipweb.model.Category;
import br.bipweb.model.CriteriaCalculator;
import br.bipweb.model.Document;
import br.bipweb.model.GlobalSearch;
import br.bipweb.model.GoogleSearch;
import br.bipweb.model.SearchAgent;
import br.bipweb.model.SearchException;
import br.bipweb.model.User;
import br.bipweb.model.YahooSearch;
import br.bipweb.view.TreeView;
import br.bipweb.view.TreeView.Type;

import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;

public class SearchAction extends ActionSupport {

	private static final long serialVersionUID = -5237261947821051526L;

	private static GlobalSearch search;
	
	private Category category;
	
	private Collection<Document> documents;
	
	private TreeView treeView;
	
	private CategoryDao categoryDao;
	
	private String step;
	
	public SearchAction() {
		super();
	}
	
	public String doLoad()
			throws DaoException {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		treeView = new TreeView(Type.SEARCH, categoryDao.listByUser(user));
		
		return SUCCESS;
	}
	
	public String doSearch()
			throws DaoException, ObjectNotFoundException {
		
		this.step = "search";
		
		try {
			
			category = categoryDao.get(category.getId());
			
			CriteriaCalculator calculator = new CriteriaCalculator();
			
			String criteria = calculator.calculate(category);
			
			Collection<SearchAgent> agents = new ArrayList<SearchAgent>();
			agents.add(new AltaVistaSearch());
			agents.add(new GoogleSearch());
			agents.add(new YahooSearch());
			
			search = new GlobalSearch();
			search.setAgents(agents);
			
			documents = search.search(criteria);
			
			ActionContext.getContext().getSession().put("search", search);
			
		} catch (SearchException e) {
			e.printStackTrace(); // TODO
		}
		
		return doLoad();
	}
	
	public String doContinue()
			throws DaoException {
		
		this.step = "continue";
		
		try {
			
			search = (GlobalSearch) ActionContext.getContext().getSession().get("search");
			
			documents = search.searchNext();
			
		} catch (SearchException e) {
			e.printStackTrace(); // TODO
		}
		
		return doLoad();
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Collection<Document> getDocuments() {
		return documents;
	}
	
	public TreeView getTreeView() {
		return treeView;
	}
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	public String getStep() {
		return step;
	}
	
}