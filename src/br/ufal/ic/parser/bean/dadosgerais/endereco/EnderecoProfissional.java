package br.ufal.ic.parser.bean.dadosgerais.endereco;

import java.io.Serializable;

public class EnderecoProfissional implements Serializable {

	private static final long serialVersionUID = -6337912335661544949L;

	private String codigoInstituicao;
	
	private String nomeInstituicaoEmpresa;
	
	private String codigoOrgao;
	
	private String nomeOrgao;
	
	private String codigoUnidade;
	
	private String nomeUnidade;

	private String logradouroComplemento;
	
	private String pais;
	
	private String uf;
	
	private String cep;
	
	private String cidade;
	
	private String bairro;
	
	private String ddd;

	private String telefone;
	
	private String ramal;
	
	private String fax;
	
	private String caixaPostal;
	
	private String email;
	
	private String homePage;

	@Override
	public String toString() {
		return String.format("{EnderecoProfissional codigoInstituicao=[%s] nomeInstituicaoEmpresa=[%s] codigoOrgao=[%s] nomeOrgao=[%s]" +
				"codigoUnidade=[%s] nomeUnidade=[%s] logradouroComplemento=[%s] pais=[%s] uf=[%s] cep=[%s] cidade=[%s] bairro=[%s] ddd=[%s] " +
				"telefone=[%s] ramal=[%s] fax=[%s] caixaPostal=[%s] email=[%s] homePage=[%s]}", codigoInstituicao, nomeInstituicaoEmpresa,
				codigoOrgao, nomeOrgao, codigoUnidade, nomeUnidade, logradouroComplemento, pais, uf, cep, cidade, bairro, ddd, telefone,
				ramal, fax, caixaPostal, email, homePage);
	}

	public void setCodigoInstituicao(String codigoInstituicao) {
		this.codigoInstituicao = codigoInstituicao;
	}

	public void setNomeInstituicaoEmpresa(String nomeInstituicaoEmpresa) {
		this.nomeInstituicaoEmpresa = nomeInstituicaoEmpresa;
	}

	public void setCodigoOrgao(String codigoOrgao) {
		this.codigoOrgao = codigoOrgao;
	}

	public void setNomeOrgao(String nomeOrgao) {
		this.nomeOrgao = nomeOrgao;
	}

	public void setCodigoUnidade(String codigoUnidade) {
		this.codigoUnidade = codigoUnidade;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public void setLogradouroComplemento(String logradouroComplemento) {
		this.logradouroComplemento = logradouroComplemento;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setCaixaPostal(String caixaPostal) {
		this.caixaPostal = caixaPostal;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

}
