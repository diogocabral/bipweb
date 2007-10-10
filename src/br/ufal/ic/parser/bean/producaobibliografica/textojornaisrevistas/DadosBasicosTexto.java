package br.ufal.ic.parser.bean.producaobibliografica.textojornaisrevistas;

import java.io.Serializable;

public class DadosBasicosTexto implements Serializable {

	private static final long serialVersionUID = 6418898870877214314L;

	private String natureza;
	
	private String tituloTexto;
	
	private String anoTexto;
	
	private String paisPublicacao;
	
	private String idioma;
	
	private String meioDivulgacao;
	
	private String homePageTrabalho;
	
	private String flagRelevancia;
	
	private String doi;
	
	@Override
	public String toString() {
		return String.format("{DadosBasicosTexto natureza=[%s] tituloTexto=[%s] anoTexto=[%s] paisPublicacao=[%s] idioma=[%s] " +
				"meioDivulgacao=[%s] homePageTrabalho=[%s] flagRelevancia=[%s] doi=[%s]}", natureza, tituloTexto, anoTexto, 
				paisPublicacao, idioma, meioDivulgacao, homePageTrabalho, flagRelevancia, doi);
	}
	
	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public void setAnoTexto(String anoTexto) {
		this.anoTexto = anoTexto;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public void setFlagRelevancia(String flagRelevancia) {
		this.flagRelevancia = flagRelevancia;
	}

	public void setHomePageTrabalho(String homePageTrabalho) {
		this.homePageTrabalho = homePageTrabalho;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public void setMeioDivulgacao(String meioDivulgacao) {
		this.meioDivulgacao = meioDivulgacao;
	}

	public void setPaisPublicacao(String paisPublicacao) {
		this.paisPublicacao = paisPublicacao;
	}

	public void setTituloTexto(String tituloTexto) {
		this.tituloTexto = tituloTexto;
	}
	
	

}
