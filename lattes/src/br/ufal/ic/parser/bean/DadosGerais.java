package br.ufal.ic.parser.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class DadosGerais implements Serializable {

	private static final long serialVersionUID = 3198877327789017065L;

	private String nomeCompleto;
	
	private String nomeCitacoesBibliograficas;
	
	private String nacionalidade;
	
	private String cpf;
	
	private String numeroPassaporte;
	
	private String paisNascimento;
	
	private String ufNascimento;
	
	private String cidadeNascimento;
	
	private String formatoDataNascimento;
	
	private Date dataNascimento;
	
	private String sexo;
	
	private String numeroIdentidade;
	
	private String orgaoEmissor;
	
	private String ufOrgaoEmissor;
	
	private String formatoOrgaoEmissor;

	private String formatoDataEmissao;
	
	private String dataEmissao;
	
	private String nomePai;
	
	private String nomeMae;
	
	private String permissaoDivulgacao;

	private String nomeArquivoFoto;
	
	private String textoResumoCvRh;

	private String outrasInformacoesRelevantes;

	/**
	 * @return the nomeCompleto
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	/**
	 * @param nomeCompleto the nomeCompleto to set
	 */
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	/**
	 * @return the nomeCitacoesBibliograficas
	 */
	public String getNomeCitacoesBibliograficas() {
		return nomeCitacoesBibliograficas;
	}

	/**
	 * @param nomeCitacoesBibliograficas the nomeCitacoesBibliograficas to set
	 */
	public void setNomeCitacoesBibliograficas(String nomeCitacoesBibliograficas) {
		this.nomeCitacoesBibliograficas = nomeCitacoesBibliograficas;
	}

	/**
	 * @return the nacionalidade
	 */
	public String getNacionalidade() {
		return nacionalidade;
	}

	/**
	 * @param nacionalidade the nacionalidade to set
	 */
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the numeroPassaporte
	 */
	public String getNumeroPassaporte() {
		return numeroPassaporte;
	}

	/**
	 * @param numeroPassaporte the numeroPassaporte to set
	 */
	public void setNumeroPassaporte(String numeroPassaporte) {
		this.numeroPassaporte = numeroPassaporte;
	}

	/**
	 * @return the paisNascimento
	 */
	public String getPaisNascimento() {
		return paisNascimento;
	}

	/**
	 * @param paisNascimento the paisNascimento to set
	 */
	public void setPaisNascimento(String paisNascimento) {
		this.paisNascimento = paisNascimento;
	}

	/**
	 * @return the ufNascimento
	 */
	public String getUfNascimento() {
		return ufNascimento;
	}

	/**
	 * @param ufNascimento the ufNascimento to set
	 */
	public void setUfNascimento(String ufNascimento) {
		this.ufNascimento = ufNascimento;
	}

	/**
	 * @return the cidadeNascimento
	 */
	public String getCidadeNascimento() {
		return cidadeNascimento;
	}

	/**
	 * @param cidadeNascimento the cidadeNascimento to set
	 */
	public void setCidadeNascimento(String cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	/**
	 * @return the formatoDataNascimento
	 */
	public String getFormatoDataNascimento() {
		return formatoDataNascimento;
	}

	/**
	 * @param formatoDataNascimento the formatoDataNascimento to set
	 */
	public void setFormatoDataNascimento(String formatoDataNascimento) {
		this.formatoDataNascimento = formatoDataNascimento;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the numeroIdentidade
	 */
	public String getNumeroIdentidade() {
		return numeroIdentidade;
	}

	/**
	 * @param numeroIdentidade the numeroIdentidade to set
	 */
	public void setNumeroIdentidade(String numeroIdentidade) {
		this.numeroIdentidade = numeroIdentidade;
	}

	/**
	 * @return the orgaoEmissor
	 */
	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	/**
	 * @param orgaoEmissor the orgaoEmissor to set
	 */
	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	/**
	 * @return the ufOrgaoEmissor
	 */
	public String getUfOrgaoEmissor() {
		return ufOrgaoEmissor;
	}

	/**
	 * @param ufOrgaoEmissor the ufOrgaoEmissor to set
	 */
	public void setUfOrgaoEmissor(String ufOrgaoEmissor) {
		this.ufOrgaoEmissor = ufOrgaoEmissor;
	}

	/**
	 * @return the formatoOrgaoEmissor
	 */
	public String getFormatoOrgaoEmissor() {
		return formatoOrgaoEmissor;
	}

	/**
	 * @param formatoOrgaoEmissor the formatoOrgaoEmissor to set
	 */
	public void setFormatoOrgaoEmissor(String formatoOrgaoEmissor) {
		this.formatoOrgaoEmissor = formatoOrgaoEmissor;
	}

	/**
	 * @return the formatoDataEmissao
	 */
	public String getFormatoDataEmissao() {
		return formatoDataEmissao;
	}

	/**
	 * @param formatoDataEmissao the formatoDataEmissao to set
	 */
	public void setFormatoDataEmissao(String formatoDataEmissao) {
		this.formatoDataEmissao = formatoDataEmissao;
	}

	/**
	 * @return the dataEmissao
	 */
	public String getDataEmissao() {
		return dataEmissao;
	}

	/**
	 * @param dataEmissao the dataEmissao to set
	 */
	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	/**
	 * @return the nomePai
	 */
	public String getNomePai() {
		return nomePai;
	}

	/**
	 * @param nomePai the nomePai to set
	 */
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	/**
	 * @return the nomeMae
	 */
	public String getNomeMae() {
		return nomeMae;
	}

	/**
	 * @param nomeMae the nomeMae to set
	 */
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	/**
	 * @return the permissaoDivulgacao
	 */
	public String getPermissaoDivulgacao() {
		return permissaoDivulgacao;
	}

	/**
	 * @param permissaoDivulgacao the permissaoDivulgacao to set
	 */
	public void setPermissaoDivulgacao(String permissaoDivulgacao) {
		this.permissaoDivulgacao = permissaoDivulgacao;
	}

	/**
	 * @return the nomeArquivoFoto
	 */
	public String getNomeArquivoFoto() {
		return nomeArquivoFoto;
	}

	/**
	 * @param nomeArquivoFoto the nomeArquivoFoto to set
	 */
	public void setNomeArquivoFoto(String nomeArquivoFoto) {
		this.nomeArquivoFoto = nomeArquivoFoto;
	}

	/**
	 * @return the textoResumoCvRh
	 */
	public String getTextoResumoCvRh() {
		return textoResumoCvRh;
	}

	/**
	 * @param textoResumoCvRh the textoResumoCvRh to set
	 */
	public void setTextoResumoCvRh(String textoResumoCvRh) {
		this.textoResumoCvRh = textoResumoCvRh;
	}

	/**
	 * @return the outrasInformacoesRelevantes
	 */
	public String getOutrasInformacoesRelevantes() {
		return outrasInformacoesRelevantes;
	}

	/**
	 * @param outrasInformacoesRelevantes the outrasInformacoesRelevantes to set
	 */
	public void setOutrasInformacoesRelevantes(String outrasInformacoesRelevantes) {
		this.outrasInformacoesRelevantes = outrasInformacoesRelevantes;
	}	
	
}
