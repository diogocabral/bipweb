package br.ufal.ic.parser.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import br.ufal.ic.parser.bean.dadosgerais.AreaAtuacao;
import br.ufal.ic.parser.bean.dadosgerais.AtuacaoProfissional;
import br.ufal.ic.parser.bean.dadosgerais.Endereco;
import br.ufal.ic.parser.bean.dadosgerais.FormacaoAcademicaTitulacao;
import br.ufal.ic.parser.bean.dadosgerais.Idioma;
import br.ufal.ic.parser.bean.dadosgerais.OutrasInformacoesRelevantes;
import br.ufal.ic.parser.bean.dadosgerais.PalavrasChave;
import br.ufal.ic.parser.bean.dadosgerais.PremioTitulo;
import br.ufal.ic.parser.bean.dadosgerais.ProjetoPesquisa;
import br.ufal.ic.parser.bean.dadosgerais.ResumoCv;

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
	
	@Transient
	private ResumoCv resumoCv;
	
	@Transient
	private OutrasInformacoesRelevantes outrasInformacoes;
	
	@Transient
	private Endereco endereco;
	
	@Transient
	private PalavrasChave palavrasChave;
	
	@Transient
	private FormacaoAcademicaTitulacao formacaoAcademicaTitulacao;
	
	@Transient
	private List<AtuacaoProfissional> atuacoesProfissionais = new ArrayList<AtuacaoProfissional>();
	
	@Transient
	private List<AreaAtuacao> areasAtuacao = new ArrayList<AreaAtuacao>();
	
	@Transient
	private List<Idioma> idiomas = new ArrayList<Idioma>();
	
	@Transient
	private List<PremioTitulo> premiosTitulos = new ArrayList<PremioTitulo>();
	
	@Transient
	private List<ProjetoPesquisa> projetosPesquisa = new ArrayList<ProjetoPesquisa>();
	
	@Override
	public String toString() {
		return String.format("{DadosGerais nomeCompleto=[%s] nomeCitacoesBibliograficas=[%s] nacionalidade=[%s] cpf=[%s] numeroPassaporte=[%s]" +
				" paisNascimento=[%s] ufNascimento=[%s] cidadeNascimento=[%s] formatoDataNascimento=[%s] dataNascimento=[%s] sexo=[%s]" +
				" numeroIdentidade=[%s] orgaoEmissor=[%s] ufOrgaoEmissor=[%s] formatoOrgaoEmissor=[%s] formatoDataEmissao=[%s]" +
				" dataEmissao=[%s] nomePai=[%s] nomeMae=[%s] permissaoDivulgacao=[%s] nomeArquivoFoto=[%s] textoResumoCvRh=[%s]" +
				" outrasInformacoesRelevantes=[%s] resumoCv=[%s] outrasInformacoesRelevantes=[%s] endereco=[%s] palavrasChave=[%s]" +
				" formacaoAcademicaTitulacao=[%s] atuacoesProfissionais=[%s] areasAtuacao=[%s] idiomas=[%s] projetosPesquisa=[%s]}", nomeCompleto, 
				nomeCitacoesBibliograficas, nacionalidade, cpf,	numeroPassaporte, paisNascimento, ufNascimento, cidadeNascimento, 
				formatoDataNascimento, dataNascimento, sexo, numeroIdentidade, orgaoEmissor, ufOrgaoEmissor, formatoOrgaoEmissor, 
				formatoDataEmissao, dataEmissao, nomePai, nomeMae, permissaoDivulgacao, nomeArquivoFoto, textoResumoCvRh, 
				outrasInformacoesRelevantes, resumoCv, outrasInformacoes, endereco, palavrasChave, formacaoAcademicaTitulacao, 
				atuacoesProfissionais, areasAtuacao, idiomas, projetosPesquisa);
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public void setNomeCitacoesBibliograficas(String nomeCitacoesBibliograficas) {
		this.nomeCitacoesBibliograficas = nomeCitacoesBibliograficas;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNumeroPassaporte(String numeroPassaporte) {
		this.numeroPassaporte = numeroPassaporte;
	}

	public void setPaisNascimento(String paisNascimento) {
		this.paisNascimento = paisNascimento;
	}

	public void setUfNascimento(String ufNascimento) {
		this.ufNascimento = ufNascimento;
	}

	public void setCidadeNascimento(String cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	public void setFormatoDataNascimento(String formatoDataNascimento) {
		this.formatoDataNascimento = formatoDataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		try {
			if (dataNascimento != null && dataNascimento.trim().length() == 8) {
				this.dataNascimento = new SimpleDateFormat("ddMMyyyy").parse(dataNascimento);
			}
		} catch (ParseException e) {
			// TODO Refatoring - � poss�vel que o campo dataNascimento seja mudado para String
			e.printStackTrace();
		}
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setNumeroIdentidade(String numeroIdentidade) {
		this.numeroIdentidade = numeroIdentidade;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public void setUfOrgaoEmissor(String ufOrgaoEmissor) {
		this.ufOrgaoEmissor = ufOrgaoEmissor;
	}

	public void setFormatoOrgaoEmissor(String formatoOrgaoEmissor) {
		this.formatoOrgaoEmissor = formatoOrgaoEmissor;
	}

	public void setFormatoDataEmissao(String formatoDataEmissao) {
		this.formatoDataEmissao = formatoDataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public void setPermissaoDivulgacao(String permissaoDivulgacao) {
		this.permissaoDivulgacao = permissaoDivulgacao;
	}

	public void setNomeArquivoFoto(String nomeArquivoFoto) {
		this.nomeArquivoFoto = nomeArquivoFoto;
	}

	public void setTextoResumoCvRh(String textoResumoCvRh) {
		this.textoResumoCvRh = textoResumoCvRh;
	}

	public void setOutrasInformacoesRelevantes(String outrasInformacoesRelevantes) {
		this.outrasInformacoesRelevantes = outrasInformacoesRelevantes;
	}

	public void setResumoCv(ResumoCv resumoCv) {
		this.resumoCv = resumoCv;
	}

	public void setOutrasInformacoes(OutrasInformacoesRelevantes outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setPalavrasChave(PalavrasChave palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	public void setFormacaoAcademicaTitulacao(
			FormacaoAcademicaTitulacao formacaoAcademicaTitulacao) {
		this.formacaoAcademicaTitulacao = formacaoAcademicaTitulacao;
	}

	public void addAtuacaoProfissional(AtuacaoProfissional atuacaoProfissional) {
		this.atuacoesProfissionais.add(atuacaoProfissional);
	}
	
	public void addAreaAtuacao(AreaAtuacao areaAtuacao) {
		this.areasAtuacao.add(areaAtuacao);
	}
	
	public void addIdioma(Idioma idioma) {
		this.idiomas.add(idioma);
	}
	
	public void addPremioTitulo(PremioTitulo premioTitulo) {
		this.premiosTitulos.add(premioTitulo);
	}
	
	public void addProjetoPesquisa(ProjetoPesquisa projetoPesquisa) {
		this.projetosPesquisa.add(projetoPesquisa);
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @return the atuacoesProfissionais
	 */
	public List<AtuacaoProfissional> getAtuacoesProfissionais() {
		return atuacoesProfissionais;
	}

	/**
	 * @param atuacoesProfissionais the atuacoesProfissionais to set
	 */
	public void setAtuacoesProfissionais(
			List<AtuacaoProfissional> atuacoesProfissionais) {
		this.atuacoesProfissionais = atuacoesProfissionais;
	}

	/**
	 * @return the areasAtuacao
	 */
	public List<AreaAtuacao> getAreasAtuacao() {
		return areasAtuacao;
	}

	/**
	 * @param areasAtuacao the areasAtuacao to set
	 */
	public void setAreasAtuacao(List<AreaAtuacao> areasAtuacao) {
		this.areasAtuacao = areasAtuacao;
	}

	/**
	 * @return the idiomas
	 */
	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	/**
	 * @param idiomas the idiomas to set
	 */
	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	/**
	 * @return the premiosTitulos
	 */
	public List<PremioTitulo> getPremiosTitulos() {
		return premiosTitulos;
	}

	/**
	 * @param premiosTitulos the premiosTitulos to set
	 */
	public void setPremiosTitulos(List<PremioTitulo> premiosTitulos) {
		this.premiosTitulos = premiosTitulos;
	}

	/**
	 * @return the projetosPesquisa
	 */
	public List<ProjetoPesquisa> getProjetosPesquisa() {
		return projetosPesquisa;
	}

	/**
	 * @param projetosPesquisa the projetosPesquisa to set
	 */
	public void setProjetosPesquisa(List<ProjetoPesquisa> projetosPesquisa) {
		this.projetosPesquisa = projetosPesquisa;
	}

	/**
	 * @return the nomeCompleto
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	/**
	 * @return the nomeCitacoesBibliograficas
	 */
	public String getNomeCitacoesBibliograficas() {
		return nomeCitacoesBibliograficas;
	}

	/**
	 * @return the nacionalidade
	 */
	public String getNacionalidade() {
		return nacionalidade;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @return the numeroPassaporte
	 */
	public String getNumeroPassaporte() {
		return numeroPassaporte;
	}

	/**
	 * @return the paisNascimento
	 */
	public String getPaisNascimento() {
		return paisNascimento;
	}

	/**
	 * @return the ufNascimento
	 */
	public String getUfNascimento() {
		return ufNascimento;
	}

	/**
	 * @return the cidadeNascimento
	 */
	public String getCidadeNascimento() {
		return cidadeNascimento;
	}

	/**
	 * @return the formatoDataNascimento
	 */
	public String getFormatoDataNascimento() {
		return formatoDataNascimento;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @return the numeroIdentidade
	 */
	public String getNumeroIdentidade() {
		return numeroIdentidade;
	}

	/**
	 * @return the orgaoEmissor
	 */
	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	/**
	 * @return the ufOrgaoEmissor
	 */
	public String getUfOrgaoEmissor() {
		return ufOrgaoEmissor;
	}

	/**
	 * @return the formatoOrgaoEmissor
	 */
	public String getFormatoOrgaoEmissor() {
		return formatoOrgaoEmissor;
	}

	/**
	 * @return the formatoDataEmissao
	 */
	public String getFormatoDataEmissao() {
		return formatoDataEmissao;
	}

	/**
	 * @return the dataEmissao
	 */
	public String getDataEmissao() {
		return dataEmissao;
	}

	/**
	 * @return the nomePai
	 */
	public String getNomePai() {
		return nomePai;
	}

	/**
	 * @return the nomeMae
	 */
	public String getNomeMae() {
		return nomeMae;
	}

	/**
	 * @return the permissaoDivulgacao
	 */
	public String getPermissaoDivulgacao() {
		return permissaoDivulgacao;
	}

	/**
	 * @return the nomeArquivoFoto
	 */
	public String getNomeArquivoFoto() {
		return nomeArquivoFoto;
	}

	/**
	 * @return the textoResumoCvRh
	 */
	public String getTextoResumoCvRh() {
		return textoResumoCvRh;
	}

	/**
	 * @return the outrasInformacoesRelevantes
	 */
	public String getOutrasInformacoesRelevantes() {
		return outrasInformacoesRelevantes;
	}

	/**
	 * @return the resumoCv
	 */
	public ResumoCv getResumoCv() {
		return resumoCv;
	}

	/**
	 * @return the outrasInformacoes
	 */
	public OutrasInformacoesRelevantes getOutrasInformacoes() {
		return outrasInformacoes;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @return the palavrasChave
	 */
	public PalavrasChave getPalavrasChave() {
		return palavrasChave;
	}

	/**
	 * @return the formacaoAcademicaTitulacao
	 */
	public FormacaoAcademicaTitulacao getFormacaoAcademicaTitulacao() {
		return formacaoAcademicaTitulacao;
	}
	
}
