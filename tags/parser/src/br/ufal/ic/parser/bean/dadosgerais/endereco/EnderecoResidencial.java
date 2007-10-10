package br.ufal.ic.parser.bean.dadosgerais.endereco;

import java.io.Serializable;

public class EnderecoResidencial implements Serializable {

	private static final long serialVersionUID = 1189943002155503348L;

	private String logradouro;
	
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
		return String.format("{EnderecoResidencial logradouro=[%s] pais=[%s] uf=[%s] cep=[%s] cidade=[%s] bairro=[%s] ddd=[%s] telefone=[%s]" +
				" ramal=[%s] fax=[%s] caixaPotal=[%s] email=[%s] homePage=[%s]}", logradouro, pais, uf, cep, cidade, bairro, ddd, telefone, 
				ramal, fax, caixaPostal, email, homePage);
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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
