package br.ufal.ic.parser.bean.producaobibliografica.textojornaisrevistas;

import java.io.Serializable;

public class DetalhamentoTexto implements Serializable {
	
	private static final long serialVersionUID = -7629231364359919700L;

	private String tituloJornalRevista;
	
	private String issn;
	
	private String formatoDataPublicacao;
	
	private String dataPublicacao;
	
	private String volume;
	
	private String paginaInicial;
	
	private String paginaFinal;
	
	private String localPublicacao;
	
	@Override
	public String toString() {
		return String.format("{DetalhamentoTexto tituloJornalRevista=[%s] issn=[%s] formatoDataPublicacao=[%s] dataPublicacao=[%s] " +
				"volume=[%s] paginaInicial=[%s] paginaFinal=[%s] localPublicacao=[%s]}", tituloJornalRevista, issn, 
				formatoDataPublicacao, dataPublicacao, volume, paginaInicial, paginaFinal, localPublicacao);
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public void setFormatoDataPublicacao(String formatoDataPublicacao) {
		this.formatoDataPublicacao = formatoDataPublicacao;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public void setLocalPublicacao(String localPublicacao) {
		this.localPublicacao = localPublicacao;
	}

	public void setPaginaFinal(String paginaFinal) {
		this.paginaFinal = paginaFinal;
	}

	public void setPaginaInicial(String paginaInicial) {
		this.paginaInicial = paginaInicial;
	}

	public void setTituloJornalRevista(String tituloJornalRevista) {
		this.tituloJornalRevista = tituloJornalRevista;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	

}
