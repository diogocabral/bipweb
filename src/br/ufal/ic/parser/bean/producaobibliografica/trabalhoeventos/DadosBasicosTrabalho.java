package br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos;

import java.io.Serializable;

public class DadosBasicosTrabalho implements Serializable {

	private static final long serialVersionUID = -2536059614244082406L;
	
	private String natureza;
	
	private String tituloTrabalho;
	
	private String anoTrabalho;
	
	private String paisEvento;
	
	private String idioma;
	
	private String meioDivulgacao;
	
	private String homePageTrabalho;
	
	private String flagRelevancia;
	
	private String doi;
	
	@Override
	public String toString() {
		return String.format("{DadosBasicosTrabalho natureza=[%s] tituloTrabalho=[%s] anoTrabalho=[%s] paisEvento=[%s] " +
				"idioma=[%s] meioDivulgacao=[%s] homePageTrabalho=[%s] flagRelevancia=[%s] doi=[%s] }", 
				natureza, tituloTrabalho, anoTrabalho, paisEvento, idioma, meioDivulgacao, homePageTrabalho, flagRelevancia, doi);
	}

	public void setAnoTrabalho(String anoTrabalho) {
		this.anoTrabalho = anoTrabalho;
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

	public void setPaisEvento(String paisEvento) {
		this.paisEvento = paisEvento;
	}

	public void setTituloTrabalho(String tituloTrabalho) {
		this.tituloTrabalho = tituloTrabalho;
	}
	
	

}
