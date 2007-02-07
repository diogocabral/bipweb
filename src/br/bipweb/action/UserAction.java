package br.bipweb.action;

import br.bipweb.model.User;

import com.opensymphony.xwork.ActionSupport;

public class UserAction extends ActionSupport {
	
	private User user;
	
	public UserAction() {
		super();
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String doLogin() {
		return SUCCESS;
	}
	
}
