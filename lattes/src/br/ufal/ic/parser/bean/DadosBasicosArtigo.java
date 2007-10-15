package br.ufal.ic.parser.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;

@Embeddable
public class DadosBasicosArtigo implements Serializable {

	private static final long serialVersionUID = 7898898359278662006L;

	private String natureza;
	
	@Field(name = "titulo", index = Index.TOKENIZED)
	private String tituloArtigo;
	
	private String anoArtigo;
	
	private String paisPublicacao;
	
	private String idioma;
	
	private String meioDivulgacao;
	
	private String homePageTrabalho;
	
	private String flagRelevancia;
	
	private String doi;
	
	@Override
	public String toString() {
		return String.format("{DadosBasicosArtigo natureza=[%s] tituloArtigo=[%s] anoArtigo=[%s] paisPublicacao=[%s] " +
				"idioma=[%s] meioDivulgacao=[%s] homePageTrabalho=[%s] flagRelevancia=[%s] doi=[%s] }", 
				natureza, tituloArtigo, anoArtigo, paisPublicacao, idioma, meioDivulgacao, homePageTrabalho, flagRelevancia, doi);
	}

	public void setAnoArtigo(String anoArtigo) {
		this.anoArtigo = anoArtigo;
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

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public void setPaisPublicacao(String paisPublicacao) {
		this.paisPublicacao = paisPublicacao;
	}

	public void setTituloArtigo(String tituloArtigo) {
		this.tituloArtigo = tituloArtigo;
	}
	
	
}
