package br.ufal.ic.parser.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "artigos")
@Indexed
public class ArtigoPublicado implements Serializable {

	private static final long serialVersionUID = 528705935071053609L;
	
	@Id
	@GeneratedValue
	@DocumentId
	private Long id;
	
	private String sequenciaProducao;
	
	private String natureza;
	
	@Field(name = "titulo", index = Index.TOKENIZED, store = Store.YES)
	private String tituloArtigo;
	
	private String anoArtigo;
	
	private String paisPublicacao;
	
	private String idioma;
	
	private String meioDivulgacao;
	
	private String homePageTrabalho;
	
	private String flagRelevancia;
	
	private String doi;

	@Field(name = "tituloPeriodico", index = Index.TOKENIZED, store = Store.YES)
	private String tituloPeriodicoRevista;
	
	private String issn;
	
	private String volume;
	
	private String fasciculo;
	
	private String serie;
	
	private String paginaInicial;
	
	private String paginaFinal;
	
	private String localPublicacao;	
	
	@ManyToOne
	private CurriculoVitae curriculoVitae;

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
	 * @return the sequenciaProducao
	 */
	public String getSequenciaProducao() {
		return sequenciaProducao;
	}

	/**
	 * @param sequenciaProducao the sequenciaProducao to set
	 */
	public void setSequenciaProducao(String sequenciaProducao) {
		this.sequenciaProducao = sequenciaProducao;
	}

	/**
	 * @return the natureza
	 */
	public String getNatureza() {
		return natureza;
	}

	/**
	 * @param natureza the natureza to set
	 */
	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	/**
	 * @return the tituloArtigo
	 */
	public String getTituloArtigo() {
		return tituloArtigo;
	}

	/**
	 * @param tituloArtigo the tituloArtigo to set
	 */
	public void setTituloArtigo(String tituloArtigo) {
		this.tituloArtigo = tituloArtigo;
	}

	/**
	 * @return the anoArtigo
	 */
	public String getAnoArtigo() {
		return anoArtigo;
	}

	/**
	 * @param anoArtigo the anoArtigo to set
	 */
	public void setAnoArtigo(String anoArtigo) {
		this.anoArtigo = anoArtigo;
	}

	/**
	 * @return the paisPublicacao
	 */
	public String getPaisPublicacao() {
		return paisPublicacao;
	}

	/**
	 * @param paisPublicacao the paisPublicacao to set
	 */
	public void setPaisPublicacao(String paisPublicacao) {
		this.paisPublicacao = paisPublicacao;
	}

	/**
	 * @return the idioma
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * @param idioma the idioma to set
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	/**
	 * @return the meioDivulgacao
	 */
	public String getMeioDivulgacao() {
		return meioDivulgacao;
	}

	/**
	 * @param meioDivulgacao the meioDivulgacao to set
	 */
	public void setMeioDivulgacao(String meioDivulgacao) {
		this.meioDivulgacao = meioDivulgacao;
	}

	/**
	 * @return the homePageTrabalho
	 */
	public String getHomePageTrabalho() {
		return homePageTrabalho;
	}

	/**
	 * @param homePageTrabalho the homePageTrabalho to set
	 */
	public void setHomePageTrabalho(String homePageTrabalho) {
		this.homePageTrabalho = homePageTrabalho;
	}

	/**
	 * @return the flagRelevancia
	 */
	public String getFlagRelevancia() {
		return flagRelevancia;
	}

	/**
	 * @param flagRelevancia the flagRelevancia to set
	 */
	public void setFlagRelevancia(String flagRelevancia) {
		this.flagRelevancia = flagRelevancia;
	}

	/**
	 * @return the doi
	 */
	public String getDoi() {
		return doi;
	}

	/**
	 * @param doi the doi to set
	 */
	public void setDoi(String doi) {
		this.doi = doi;
	}

	/**
	 * @return the tituloPeriodicoRevista
	 */
	public String getTituloPeriodicoRevista() {
		return tituloPeriodicoRevista;
	}

	/**
	 * @param tituloPeriodicoRevista the tituloPeriodicoRevista to set
	 */
	public void setTituloPeriodicoRevista(String tituloPeriodicoRevista) {
		this.tituloPeriodicoRevista = tituloPeriodicoRevista;
	}

	/**
	 * @return the issn
	 */
	public String getIssn() {
		return issn;
	}

	/**
	 * @param issn the issn to set
	 */
	public void setIssn(String issn) {
		this.issn = issn;
	}

	/**
	 * @return the volume
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * @return the fasciculo
	 */
	public String getFasciculo() {
		return fasciculo;
	}

	/**
	 * @param fasciculo the fasciculo to set
	 */
	public void setFasciculo(String fasciculo) {
		this.fasciculo = fasciculo;
	}

	/**
	 * @return the serie
	 */
	public String getSerie() {
		return serie;
	}

	/**
	 * @param serie the serie to set
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}

	/**
	 * @return the paginaInicial
	 */
	public String getPaginaInicial() {
		return paginaInicial;
	}

	/**
	 * @param paginaInicial the paginaInicial to set
	 */
	public void setPaginaInicial(String paginaInicial) {
		this.paginaInicial = paginaInicial;
	}

	/**
	 * @return the paginaFinal
	 */
	public String getPaginaFinal() {
		return paginaFinal;
	}

	/**
	 * @param paginaFinal the paginaFinal to set
	 */
	public void setPaginaFinal(String paginaFinal) {
		this.paginaFinal = paginaFinal;
	}

	/**
	 * @return the localPublicacao
	 */
	public String getLocalPublicacao() {
		return localPublicacao;
	}

	/**
	 * @param localPublicacao the localPublicacao to set
	 */
	public void setLocalPublicacao(String localPublicacao) {
		this.localPublicacao = localPublicacao;
	}

	/**
	 * @return the curriculoVitae
	 */
	public CurriculoVitae getCurriculoVitae() {
		return curriculoVitae;
	}

	/**
	 * @param curriculoVitae the curriculoVitae to set
	 */
	public void setCurriculoVitae(CurriculoVitae curriculoVitae) {
		this.curriculoVitae = curriculoVitae;
	}	

}
