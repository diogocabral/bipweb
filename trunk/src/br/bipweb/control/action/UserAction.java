package br.bipweb.control.action;

import java.util.HashMap;

import br.bipweb.dao.DaoException;
import br.bipweb.dao.HistoryDao;
import br.bipweb.dao.ObjectNotFoundException;
import br.bipweb.dao.UserDao;
import br.bipweb.model.History;
import br.bipweb.model.User;
import br.bipweb.util.Md5;

import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = -6596367958176468326L;
	
	private User user;
	
	private String password;
	
	private UserDao userDao;
	
	private HistoryDao historyDao;
	
	public UserAction() {
		super();
	}
	
	public String doLogin() throws DaoException {		
		try {
			user = userDao.get(user.getUsername());
			
			if (!user.getPassword().equals(password)) {
				addActionError("Senha inválida");				
				return INPUT;
			}
			
			ActionContext.getContext().getSession().put("user", user);
			
			History recommendation = historyDao.recommend(user);
			
			ActionContext.getContext().getSession().put("recommendation", recommendation);
			
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
	
	public String doLoad() throws DaoException {		
		user = (User) ActionContext.getContext().getSession().get("user");		
		
		return SUCCESS;
	}	
	
	public String doEdit() throws DaoException {		
		user.setPassword(Md5.crypt(user.getPassword()));
		
		if (!password.equals(user.getPassword())) {
			addActionError("Senhas não conferem");
			return INPUT;
		}
		
		try {
			userDao.update(user);
		} catch (ObjectNotFoundException e) {
			return ERROR;
		}
		
		ActionContext.getContext().getSession().put("user", user);
		
		addActionMessage("Senha alterada com sucesso");
		
		return SUCCESS;
	}	
	
	public String doLogout() throws DaoException {
		ActionContext.getContext().getSession().remove("user");
		ActionContext.getContext().getSession().remove("recommendation");
		
		return SUCCESS;
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
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}
	
}