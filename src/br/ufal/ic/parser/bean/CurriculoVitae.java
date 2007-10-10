package br.ufal.ic.parser.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "curriculo")
public class CurriculoVitae implements Serializable {

	private static final long serialVersionUID = -5204864757860503785L;

	private String sistemaOrigemXml;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String numeroIdentificador;
	
	@Transient
	private String formatoDataAtualizacao;
	
	@Transient
	private Date dataAtualizacao;
	
	@Transient
	private String formatoHoraAtualizacao;
	
	@Transient
	private Date horaAtualizacao;
	
	@Transient
	private String xmlnsLattes;	
	
	@Embedded
	private DadosGerais dadosGerais;
	
	@Embedded
	private ProducaoBibliografica producaoBibliografica;
	
	@Transient
	private ProducaoTecnica producaoTecnica;
	
	@Transient
	private OutraProducao outraProducao;
	
	@Transient
	private DadosComplementares dadosComplementares;

	public void setSistemaOrigemXml(String sistemaOrigemXml) {
		this.sistemaOrigemXml = sistemaOrigemXml;
	}

	@Override
	public String toString() {
		return String.format("{CurriculoVitae sistemaOrigemXml=[%s] numeroIdentificador=[%s] formatoDataAtualizacao=[%s] dataAtualizacao=[%s] " +
				"formatoHoraAtualizacao=[%s] horaAtualizacao=[%s] xmlnsLattes=[%s] dadosGerais=[%s] producaoBibliografica=[%s] " +
				"producaoTecnica=[%s] outraProducao=[%s] dadosComplementares=[%s]}", sistemaOrigemXml, numeroIdentificador, 
				formatoDataAtualizacao, dataAtualizacao, formatoHoraAtualizacao, horaAtualizacao, xmlnsLattes, dadosGerais, 
				producaoBibliografica, producaoTecnica, outraProducao, dadosComplementares);
	}
	
	public void setDataAtualizacao(String dataAtualizacao) {
		try {
			if (dataAtualizacao != null && dataAtualizacao.trim().length() == 8) {
				this.dataAtualizacao = new SimpleDateFormat("ddMMyyyy").parse(dataAtualizacao);
			}
		} catch (ParseException e) {
			// TODO Refactoring - É possível que o campo dataAtualização seja mudado para String
			e.printStackTrace();
		}
	}

	public void setHoraAtualizacao(String horaAtualizacao) {
		try {
			if (horaAtualizacao != null && horaAtualizacao.trim().length() == 6) {
				this.horaAtualizacao = new SimpleDateFormat("hhmmss").parse(horaAtualizacao);
			}
		} catch (ParseException e) {
			// TODO Refactoring - É possível que o campo horaAtualização seja mudado para String
			e.printStackTrace();
		}
	}

	public void setXmlnsLattes(String xmlnsLattes) {
		this.xmlnsLattes = xmlnsLattes;
	}	

	public void setNumeroIdentificador(String numeroIdentificador) {
		this.numeroIdentificador = numeroIdentificador;
	}

	public void setFormatoDataAtualizacao(String formatoDataAtualizacao) {
		this.formatoDataAtualizacao = formatoDataAtualizacao;
	}

	public void setFormatoHoraAtualizacao(String formatoHoraAtualizacao) {
		this.formatoHoraAtualizacao = formatoHoraAtualizacao;
	}

	public void setDadosGerais(DadosGerais dadosGerais) {
		this.dadosGerais = dadosGerais;
	}

	public void setProducaoBibliografica(ProducaoBibliografica producaoBibliografica) {
		this.producaoBibliografica = producaoBibliografica;
	}

	public void setProducaoTecnica(ProducaoTecnica producaoTecnica) {
		this.producaoTecnica = producaoTecnica;
	}

	public void setOutraProducao(OutraProducao outraProducao) {
		this.outraProducao = outraProducao;
	}

	public void setDadosComplementares(DadosComplementares dadosComplementares) {
		this.dadosComplementares = dadosComplementares;
	}

	/**
	 * @return the dataAtualizacao
	 */
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	/**
	 * @return the horaAtualizacao
	 */
	public Date getHoraAtualizacao() {
		return horaAtualizacao;
	}

	/**
	 * @return the sistemaOrigemXml
	 */
	public String getSistemaOrigemXml() {
		return sistemaOrigemXml;
	}

	/**
	 * @return the numeroIdentificador
	 */
	public String getNumeroIdentificador() {
		return numeroIdentificador;
	}

	/**
	 * @return the formatoDataAtualizacao
	 */
	public String getFormatoDataAtualizacao() {
		return formatoDataAtualizacao;
	}

	/**
	 * @return the formatoHoraAtualizacao
	 */
	public String getFormatoHoraAtualizacao() {
		return formatoHoraAtualizacao;
	}

	/**
	 * @return the xmlnsLattes
	 */
	public String getXmlnsLattes() {
		return xmlnsLattes;
	}

	/**
	 * @return the dadosGerais
	 */
	public DadosGerais getDadosGerais() {
		return dadosGerais;
	}

	/**
	 * @return the producaoBibliografica
	 */
	public ProducaoBibliografica getProducaoBibliografica() {
		return producaoBibliografica;
	}

	/**
	 * @return the producaoTecnica
	 */
	public ProducaoTecnica getProducaoTecnica() {
		return producaoTecnica;
	}

	/**
	 * @return the outraProducao
	 */
	public OutraProducao getOutraProducao() {
		return outraProducao;
	}

	/**
	 * @return the dadosComplementares
	 */
	public DadosComplementares getDadosComplementares() {
		return dadosComplementares;
	}

}
