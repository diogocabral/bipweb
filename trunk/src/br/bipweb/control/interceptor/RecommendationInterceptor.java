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
	private History recommendation;
	
	public void init() {
	}
	
	public void destroy() {
	}

	public String intercept(ActionInvocation invocation)
			throws Exception {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		recommendation = historyDao.recommend(user);
		
		return invocation.invoke();
		
	}
	
	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}
	
	public History getRecommendation() {
		return recommendation;
	}
	
}