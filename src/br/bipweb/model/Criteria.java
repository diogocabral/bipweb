package br.bipweb.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Criteria {
	
	private String cleanCriteria;
	
	public Criteria() {
	}
	
	public Criteria(String cleanCriteria) {
		this.cleanCriteria = cleanCriteria;
	}
	
	public Criteria(Category category) {
		this.cleanCriteria = concat(category);
	}
	
	public String getCleanCriteria() {
		return cleanCriteria;
	}
	
	public String getEncodedCriteria() {
		
		String encodedCriteria = "";
		
		try {
			encodedCriteria = URLEncoder.encode(cleanCriteria, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {}
		
		return encodedCriteria;
		
	}
	
	private String concat(Category category) {
		
		if (category == null)
			return "";
		
		return concat(category.getParent()) + " " + category.getCriteria();
		
	}
	
}