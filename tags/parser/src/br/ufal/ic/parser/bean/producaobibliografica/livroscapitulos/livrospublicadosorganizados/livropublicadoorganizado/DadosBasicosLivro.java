package br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.livrospublicadosorganizados.livropublicadoorganizado;

import java.io.Serializable;

public class DadosBasicosLivro implements Serializable {

	private static final long serialVersionUID = 8218510937774237289L;
	
	private String tipo;
	
	private String natureza;
	
	private String tituloLivro;
	
	private String ano;
	
	private String paisPublicacao;
	
	private String idioma;
	
	private String meioDivulgacao;
	
	private String homePageTrabalho;
	
	private String flagRelevancia;
	
	private String doi;
	
	@Override
	public String toString() {
		return String.format("{DadosBasicosLivro tipo=[%s] natureza=[%s] tituloLivro=[%s] ano=[%s] paisPublicacao=[%s] " +
				"idioma=[%s] meioDivulgacao=[%s] homePageTrabalho=[%s] flagRelevancia=[%s] doi=[%s]}", tipo, natureza, 
				tituloLivro, ano, paisPublicacao, idioma, meioDivulgacao, homePageTrabalho, flagRelevancia, doi);
	}

	public void setAno(String ano) {
		this.ano = ano;
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

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}
	
}
