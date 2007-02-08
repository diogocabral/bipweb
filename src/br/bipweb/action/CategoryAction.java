package br.bipweb.action;

import br.bipweb.model.Category;

import com.opensymphony.xwork.ActionSupport;

public class CategoryAction extends ActionSupport {
	
	private Category category;
	
	public CategoryAction() {
		super();
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String doSave() {
		return SUCCESS;
	}
	
	public String doDelete() {
		return SUCCESS;
	}
	
}