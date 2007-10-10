package br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos;

import java.io.Serializable;

public class DetalhamentoTrabalho implements Serializable {

	private static final long serialVersionUID = -8791471139300389634L;
	
	private String classificacaoEvento;
	
	private String nomeEvento;
	
	private String cidadeEvento;
	
	private String anoRealizacao;
	
	private String titulosAnaisProceedings;
	
	private String volume;
	
	private String fasciculo;
	
	private String serie;
	
	private String paginaInicial;
	
	private String paginaFinal;
	
	private String isbn;
	
	private String nomeEditora;
	
	private String cidadeEditora;
	
	@Override
	public String toString() {
		return String.format("{DetalhamentoTrabalho classificacaoEvento=[%s] nomeEvento=[%s] cidadeEvento=[%s] anoRealizacao=[%s]" +
				" titulosAnaisProceedings=[%s] volume=[%s] fasciculo=[%s] serie=[%s] paginaInicial=[%s] paginaFinal=[%s]" +
				" isbn=[%s] nomeEditora=[%s] cidadeEditora=[%s] }", classificacaoEvento, nomeEvento, cidadeEvento, 
				anoRealizacao, titulosAnaisProceedings, volume, fasciculo, serie, paginaInicial, paginaFinal, isbn, nomeEditora, cidadeEditora);
	}

	public void setAnoRealizacao(String anoRealizacao) {
		this.anoRealizacao = anoRealizacao;
	}

	public void setCidadeEditora(String cidadeEditora) {
		this.cidadeEditora = cidadeEditora;
	}

	public void setCidadeEvento(String cidadeEvento) {
		this.cidadeEvento = cidadeEvento;
	}

	public void setClassificacaoEvento(String classificacaoEvento) {
		this.classificacaoEvento = classificacaoEvento;
	}

	public void setFasciculo(String fasciculo) {
		this.fasciculo = fasciculo;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
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

	public void setTitulosAnaisProceedings(String titulosAnaisProceedings) {
		this.titulosAnaisProceedings = titulosAnaisProceedings;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}
	
}
