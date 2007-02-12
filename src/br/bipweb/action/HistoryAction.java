package br.bipweb.action;

import com.opensymphony.xwork.ActionSupport;

public class HistoryAction extends ActionSupport {

	private static final long serialVersionUID = -4580059119769736353L;
	
	public HistoryAction() {
		super();
	}
	
	public String doLoad() {
		return SUCCESS;
	}
	
	public String doQualify() {
		return SUCCESS;
	}
	
}