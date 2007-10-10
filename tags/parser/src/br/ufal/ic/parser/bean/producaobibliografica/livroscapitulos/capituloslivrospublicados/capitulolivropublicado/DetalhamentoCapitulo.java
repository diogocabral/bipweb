package br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.capituloslivrospublicados.capitulolivropublicado;

import java.io.Serializable;

public class DetalhamentoCapitulo implements Serializable {

	private static final long serialVersionUID = -1571645883955856992L;

	private String tituloLivro;
	
	private String numeroVolumes;
	
	private String paginaInicial;
	
	private String paginaFinal;
	
	private String isbn;
	
	private String organizadores;
	
	private String numeroEdicaoRevisao;
	
	private String numeroSerie;
	
	private String cidadeEditora;
	
	private String nomeEditora;
	
	@Override
	public String toString() {
		return String.format("{DetalhamentoCapitulo tituloLivro=[%s] numeroVolumes=[%s] paginaInicial=[%s] paginaFinal=[%s] " +
				"isbn=[%s] organizadores=[%s] numeroEdicaoRevisao=[%s] numeroSerie=[%s] cidadeEditora=[%s] nomeEditora=[%s]}", 
				tituloLivro, numeroVolumes, paginaInicial, paginaFinal, isbn, organizadores, numeroEdicaoRevisao, numeroSerie, cidadeEditora, nomeEditora);
	}

	public void setCidadeEditora(String cidadeEditora) {
		this.cidadeEditora = cidadeEditora;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}

	public void setNumeroEdicaoRevisao(String numeroEdicaoRevisao) {
		this.numeroEdicaoRevisao = numeroEdicaoRevisao;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public void setNumeroVolumes(String numeroVolumes) {
		this.numeroVolumes = numeroVolumes;
	}

	public void setOrganizadores(String organizadores) {
		this.organizadores = organizadores;
	}

	public void setPaginaFinal(String paginaFinal) {
		this.paginaFinal = paginaFinal;
	}

	public void setPaginaInicial(String paginaInicial) {
		this.paginaInicial = paginaInicial;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}
	
	
	
}
