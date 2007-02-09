package br.bipweb.interceptor;

import br.bipweb.model.User;

import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;

public class PermissionInterceptor implements Interceptor {

	private static final long serialVersionUID = -3812540746158385724L;

	public void destroy() {
	}

	public void init() {		
	}

	public String intercept(ActionInvocation action) throws Exception {		
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		if (user == null) {
			return Action.LOGIN;
		}
		
		return action.invoke();
	}

}
