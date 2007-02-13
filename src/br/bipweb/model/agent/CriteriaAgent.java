package br.bipweb.model.agent;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import br.bipweb.model.Category;

public class CriteriaAgent {
	
	public CriteriaAgent() {
		super();
	}
	
	public String execute(Category category) {
		
		if (category == null)
			return "";
		
		return execute(category.getParent()) + "+" + parseForm(category.getCriteria());
		
	}
	
	private String parseForm(String s) {
		
		try {
			return URLEncoder.encode(s, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()); // TODO Com farinha
		}
		
		return null;
		
	}
	
}