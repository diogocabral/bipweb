package br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.capituloslivrospublicados.capitulolivropublicado;

import java.io.Serializable;

public class DadosBasicosCapitulo implements Serializable {

	private static final long serialVersionUID = 3390895590585908116L;
	
	private String tipo;
	
	private String tituloCapituloLivro;
	
	private String ano;
	
	private String paisPublicacao;
	
	private String idioma;
	
	private String meioDivulgacao;
	
	private String homePageTrabalho;
	
	private String flagRelevancia;
	
	private String doi;
	
	@Override
	public String toString() {
		return String.format("{DadosBasicosCapitulo tipo=[%s] tituloCapituloLivro=[%s] ano=[%s] paisPublicacao=[%s] " +
				"idioma=[%s] meioDivulgacao=[%s] homePageTrabalho=[%s] flagRelevancia=[%s] doi=[%s]}", tipo, 
				tituloCapituloLivro, ano, paisPublicacao, idioma, meioDivulgacao, homePageTrabalho, flagRelevancia, doi);
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

	public void setPaisPublicacao(String paisPublicacao) {
		this.paisPublicacao = paisPublicacao;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setTituloCapituloLivro(String tituloCapituloLivro) {
		this.tituloCapituloLivro = tituloCapituloLivro;
	}	

}
