package br.bipweb.control.action;

import java.io.IOException;
import java.util.Collection;

import br.bipweb.dao.CategoryDao;
import br.bipweb.dao.DaoException;
import br.bipweb.dao.HistoryDao;
import br.bipweb.dao.ObjectNotFoundException;
import br.bipweb.model.Category;
import br.bipweb.model.Criteria;
import br.bipweb.model.Document;
import br.bipweb.model.History;
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
	
	private String step;
	private String score;
	
	private CategoryDao categoryDao;
	private HistoryDao historyDao;
	
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
			search.setCriteria(criteria);
			documents = search.search();
			
		} catch (SearchException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) { // Erro no ScoreAgent
			System.out.println(e.getMessage());
			addActionError("Sistema indisponível!");
		}
		
		return doLoad();
	}
	
	public String doSearchNext()
			throws DaoException {
		
		this.step = "searchNext";
		
		try {
			
			documents = search.searchNext();
			
		} catch (SearchException e) {
			this.step = "";
			System.out.println(e.getMessage());
		} catch (IOException e) { // Erro no ScoreAgent
			System.out.println(e.getMessage());
			addActionError("Sistema indisponível!");
		}
		
		return doLoad();
	}
	
	public String doOpen()
			throws DaoException {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		History history = new History(document);
		history.setScore(new Float(score));
		history.setUser(user);
		history.setCategory(category);
		
		historyDao.save(history);
		
		return SUCCESS;
	}
	
	public Category getCategory() {
		return category;
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
	
	public String getStep() {
		return step;
	}
	
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public void setDocument(Document document) {
		this.document = document;
	}
	
	public Document getDocument() {
		return document;
	}
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}
	
}