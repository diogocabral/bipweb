package br.ufal.ic.parser.bean.producaobibliografica.artigospublicados.artigopublicado;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DetalhamentoArtigo implements Serializable {

	private static final long serialVersionUID = 5672056247886175651L;

	private String tituloPeriodicoRevista;
	
	private String issn;
	
	private String volume;
	
	private String fasciculo;
	
	private String serie;
	
	private String paginaInicial;
	
	private String paginaFinal;
	
	private String localPublicacao;
	
	@Override
	public String toString() {
		return String.format("{DetalhamentoArtigo tituloPeriodicoRevista=[%s] issn=[%s] volume=[%s] fasciculo=[%s] " +
				"serie=[%s] paginaInicial=[%s] paginaFinal=[%s] localPublicacao=[%s] }", tituloPeriodicoRevista, 
				issn, volume, fasciculo, serie, paginaInicial, paginaFinal, localPublicacao);
	}

	public void setFasciculo(String fasciculo) {
		this.fasciculo = fasciculo;
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

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public void setTituloPeriodicoRevista(String tituloPeriodicoRevista) {
		this.tituloPeriodicoRevista = tituloPeriodicoRevista;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	
}
