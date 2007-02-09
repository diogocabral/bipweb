package br.bipweb.model;

public class CriteriaCalculator {
	
	public CriteriaCalculator() {
		super();
	}
	
	public String calculate(Category category) {
		
		if (category == null)
			return "";
		
		return calculate(category.getParent()) + parseForm(category.getCriteria());
		
	}
	
	private String parseForm(String s) {
		return s.replaceAll(" ", "+");
	}
	
}