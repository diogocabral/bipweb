package br.bipweb.action;

import java.util.Collection;

import br.bipweb.model.Category;
import br.bipweb.model.User;
import br.bipweb.view.TreeView;

import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;

public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = -8319247320803388078L;
	
	private Category category;
	private Collection<Category> categories;
	private String tree;
	
	public CategoryAction() {
		super();
	}
	
	public String doManage() {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		tree = new TreeView(user.getCategories()).toString();
		
		return SUCCESS;
		
	}
	
	public String doSave() {
		return SUCCESS;
	}
	
	public String doDelete() {
		return SUCCESS;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Collection<Category> getCategories() {
		return categories;
	}
	
	public String getTree() {
		return tree;
	}
	
}