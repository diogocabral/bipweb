package br.bipweb.control.interceptor;

import br.bipweb.dao.HistoryDao;
import br.bipweb.model.History;
import br.bipweb.model.User;

import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;

public class RecommendationInterceptor implements Interceptor {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3744844853893003401L;
	
	private HistoryDao historyDao;
	
	public void init() {
	}
	
	public void destroy() {
	}

	public String intercept(ActionInvocation invocation)
			throws Exception {
		
		System.out.println("Olá mundo");
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		History recommendation = historyDao.recommend(user);
		
		System.out.println(recommendation);
		
		ActionContext.getContext().getSession().put("recommendation", recommendation);
		
		return invocation.invoke();
		
	}
	
	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}
	
}