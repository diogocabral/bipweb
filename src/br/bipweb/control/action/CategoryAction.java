package br.bipweb.control.action;

import java.util.Collection;

import br.bipweb.dao.CategoryDao;
import br.bipweb.dao.DaoException;
import br.bipweb.dao.ObjectNotFoundException;
import br.bipweb.model.Category;
import br.bipweb.model.User;
import br.bipweb.view.TreeView;
import br.bipweb.view.TreeView.Type;

import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;

public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = -8319247320803388078L;
	
	private Category category;
	private Collection<Category> categories;
	private TreeView treeView;
	
	private String step;
	private String query;
	
	private CategoryDao categoryDao;
	
	public CategoryAction() {
		super();
	}
	
	public String doManage()
			throws DaoException {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		treeView = new TreeView(Type.MANAGE, categoryDao.listByOwner(user));
		
		return SUCCESS;
		
	}
	
	public String doNew()
			throws DaoException {
		
		this.step = "new";
		
		return doManage();
	}
	
	public String doEdit()
			throws DaoException, ObjectNotFoundException {
		
		this.step = "edit";
		
		category = categoryDao.get(category.getId());
		
		return doManage();
	}
	
	public String doSave()
			throws DaoException, ObjectNotFoundException {

		if (category.getId() == null) {
			category.setOwner((User) ActionContext.getContext().getSession().get("user"));
			categoryDao.save(category);
		} else {
			categoryDao.update(category);
		}
		
		addActionMessage("Dados registrados com sucesso!");
		
		return SUCCESS;
		
	}
	
	public String doDelete()
			throws DaoException, ObjectNotFoundException {
		
		categoryDao.delete(category);
		
		addActionMessage("Dados excluídos com sucesso!");
		
		return SUCCESS;
		
	}

	
	// Shared
	
	public String doManageShared()
			throws DaoException {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		treeView = new TreeView(Type.MANAGE_SHARED, categoryDao.listByOwner(user));
		
		return SUCCESS;
	}
	
	public String doEditShared()
			throws DaoException, ObjectNotFoundException {
		
		this.step = "editShared";
		
		category = categoryDao.get(category.getId());
		
		return doManageShared();
		
	}
	
	public String doSearchShared()
			throws DaoException {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		categories = categoryDao.listByNotUserAndName(user, query);
		
		return SUCCESS;
		
	}
	
	public String doJoin()
			throws DaoException {
		
		return doManageShared();
		
	}
	
	public String doUnjoin()
			throws DaoException {
		
		return doManageShared();
		
	}	
	
	// Get e Set
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Collection<Category> getCategories() {
		return categories;
	}
	
	public TreeView getTreeView() {
		return treeView;
	}
	
	public String getStep() {
		return step;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
}