package br.bipweb.action;

import br.bipweb.model.User;

import com.opensymphony.xwork.ActionSupport;

public class UserAction extends ActionSupport {
	
	private User user;
	private String passwordConfirm;
	
	public UserAction() {
		super();
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public String doLogin() {
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		return SUCCESS;
	}
	
	public String doSave() {
		
		if (!passwordConfirm.equals(user.getPassword()))
			return ERROR;
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(passwordConfirm);
		
		return SUCCESS;
	}
	
}