package br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos;

import java.io.Serializable;

public class Autores implements Serializable {

	private static final long serialVersionUID = -1706324457766005275L;
	
	private String nomeCompletoAutor;
	
	private String nomeCitacao;
	
	private String ordemAutoria;
	
	private String cpf;

	@Override
	public String toString() {
		return String.format("{Autores nomeCompletoAutor=[%s] nomeCitacao=[%s] ordemAutoria=[%s] cpf=[%s] }", 
				nomeCompletoAutor, nomeCitacao, ordemAutoria, cpf);
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNomeCitacao(String nomeCitacao) {
		this.nomeCitacao = nomeCitacao;
	}

	public void setNomeCompletoAutor(String nomeCompletoAutor) {
		this.nomeCompletoAutor = nomeCompletoAutor;
	}

	public void setOrdemAutoria(String ordemAutoria) {
		this.ordemAutoria = ordemAutoria;
	}

}
