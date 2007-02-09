package br.bipweb.action;

import br.bipweb.dao.DaoException;
import br.bipweb.dao.ObjectNotFoundException;
import br.bipweb.dao.UserDao;
import br.bipweb.model.User;
import br.bipweb.util.Md5;

import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = -6596367958176468326L;
	
	private User user;
	private String password;
	
	private UserDao userDao;
	
	public UserAction() {
		super();
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setPassword(String password) {
		this.password = Md5.crypt(password);
	}
	
	public String doLogin() throws DaoException {		
		try {
			user = userDao.get(user.getUsername());

			if (!user.getPassword().equals(password)) {
				addActionError("Senha inválida");				
				return INPUT;
			}
			
			ActionContext.getContext().getSession().put("user", user);
			
		} catch (ObjectNotFoundException e) {
			addActionError("Login inválido");
			return INPUT;
		}
		
		return SUCCESS;
	}
	
	public String doSave() throws DaoException {
		user.setPassword(Md5.crypt(user.getPassword()));
		
		if (!password.equals(user.getPassword())) {
			return INPUT;
		}
		
		ActionContext.getContext().getSession().put("user", userDao.save(user));		
		
		return SUCCESS;
	}
	
	public String doLogout() throws DaoException {
		ActionContext.getContext().getSession().remove("user");		
		
		return SUCCESS;
	}	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}