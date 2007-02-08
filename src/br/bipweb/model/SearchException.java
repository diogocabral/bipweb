package br.bipweb.model;

public class SearchException extends Exception {
	
	public SearchException(String message) {
		super(message);
	}
	
	public SearchException(Throwable cause) {
		super(cause);
	}
	
	public SearchException(String message, Throwable cause) {
		super(message, cause);
	}
	
}