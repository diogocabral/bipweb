package br.ufal.ic.parser.bean;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "curriculo")
public class CurriculoVitae implements Serializable {

	private static final long serialVersionUID = -5204864757860503785L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	private DadosGerais dadosGerais;
	
	@Embedded
	private ProducaoBibliografica producaoBibliografica;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dadosGerais
	 */
	public DadosGerais getDadosGerais() {
		return dadosGerais;
	}

	/**
	 * @param dadosGerais the dadosGerais to set
	 */
	public void setDadosGerais(DadosGerais dadosGerais) {
		this.dadosGerais = dadosGerais;
	}

	/**
	 * @return the producaoBibliografica
	 */
	public ProducaoBibliografica getProducaoBibliografica() {
		return producaoBibliografica;
	}

	/**
	 * @param producaoBibliografica the producaoBibliografica to set
	 */
	public void setProducaoBibliografica(ProducaoBibliografica producaoBibliografica) {
		this.producaoBibliografica = producaoBibliografica;
	}

}
