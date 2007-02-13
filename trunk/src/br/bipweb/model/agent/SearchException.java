package br.bipweb.model.agent;

public class SearchException extends Exception {
	
	private static final long serialVersionUID = -894464084877195933L;

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