package br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.livrospublicadosorganizados.livropublicadoorganizado;

import java.io.Serializable;

public class DetalhamentoLivro implements Serializable {

	private static final long serialVersionUID = -6709632474085252642L;
	
	private String numeroVolumes;
	
	private String numeroPaginas;
	
	private String isbn;
	
	private String numeroEdicaoRevisao;
	
	private String numeroSerie;
	
	private String cidadeEditora;
	
	private String nomeEditora;
	
	@Override
	public String toString() {
		return String.format("{DetalhamentoLivro numeroVolumes=[%s] numeroPaginas=[%s] isbn=[%s] numeroEdicaoRevisao=[%s] " +
				"numeroSerie=[%s] cidadeEditora=[%s] nomeEditora=[%s]}", numeroVolumes, numeroPaginas, isbn, 
				numeroEdicaoRevisao, numeroSerie, cidadeEditora, nomeEditora);
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

	public void setNumeroPaginas(String numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public void setNumeroVolumes(String numeroVolumes) {
		this.numeroVolumes = numeroVolumes;
	}

	
}
