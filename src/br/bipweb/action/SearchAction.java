package br.bipweb.action;

import java.util.Collection;

import br.bipweb.dao.CategoryDao;
import br.bipweb.dao.DaoException;
import br.bipweb.dao.ObjectNotFoundException;
import br.bipweb.model.Category;
import br.bipweb.model.Criteria;
import br.bipweb.model.Document;
import br.bipweb.model.User;
import br.bipweb.model.search.SearchController;
import br.bipweb.model.search.SearchException;
import br.bipweb.view.TreeView;
import br.bipweb.view.TreeView.Type;

import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;

public class SearchAction extends ActionSupport {

	private static final long serialVersionUID = -5237261947821051526L;

	private SearchController search;
	
	private Category category;
	private Document document;	
	private Collection<Document> documents;
	
	private TreeView treeView;
	
	private CategoryDao categoryDao;
	
	private String step;
	
	public SearchAction() {
		super();
		search = SearchController.getInstance();
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
			
			Criteria criteria = new Criteria(category);
			
			documents = search.search(criteria);
			
		} catch (SearchException e) {
			e.printStackTrace(); // TODO
		}
		
		return doLoad();
	}
	
	public String doSearchNext()
			throws DaoException {
		
		this.step = "searchNext";
		
		try {
			
			documents = search.searchNext();
			
		} catch (SearchException e) {
			e.printStackTrace(); // TODO
		}
		
		return doLoad();
	}
	
	public String doOpen() {
		
		// TODO Gravar document.getUrl() como History
		
		return SUCCESS;
	}
	
	//
	
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
	
	public void setDocument(Document document) {
		this.document = document;
	}
	
	public Document getDocument() {
		return document;
	}
	
}