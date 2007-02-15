package br.bipweb.dao;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class ObjectNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6546607909241255482L;

	/**
	 * Constroi uma ObjetoNaoEncontradoException vazia.
	 */
	public ObjectNotFoundException() {
		super();
	}

	/**
	 * Constroi uma ObjetoNaoEncontradoException com uma mensagem.
	 * 
	 * @param message
	 *            mensagem da excecao.
	 */
	public ObjectNotFoundException(String message) {
		super(message);
	}

	/**
	 * Constroi uma ObjetoNaoEncontradoException com uma mensagem e uma causa.
	 * 
	 * @param message
	 *            mensagem da excecao.
	 * @param cause
	 *            causa da excecao.
	 */
	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
		this.setStackTrace(cause.getStackTrace());
	}

	/**
	 * Constroi uma ObjetoNaoEncontradoException com uma causa.
	 * 
	 * @param cause
	 *            causa da excecao.
	 */
	public ObjectNotFoundException(Throwable cause) {
		super(cause);
		this.setStackTrace(cause.getStackTrace());
	}
	
}
