package br.bipweb.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CriteriaCalculator {
	
	public CriteriaCalculator() {
		super();
	}
	
	public String calculate(Category category) {
		
		if (category == null)
			return "";
		
		return calculate(category.getParent()) + "+" + parseForm(category.getCriteria());
		
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