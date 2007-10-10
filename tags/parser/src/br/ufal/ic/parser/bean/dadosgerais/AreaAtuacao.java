package br.ufal.ic.parser.bean.dadosgerais;

import java.io.Serializable;

public class AreaAtuacao implements Serializable {

	private static final long serialVersionUID = 3585545748374151092L;

	private String nomeAreaConhecimento;

	private String nomeEspecialidade;
	
	private String nomeSubAreaConhecimento;
	
	private String nomeGrandeAreaConhecimento;
	
	private String sequenciaAreaAtuacao;

	@Override
	public String toString() {
		return String.format("{AreaAtuacao nomeAreaConhecimento=[%s] nomeEspecialidade=[%s] nomeSubAreaConhecimento=[%s] " +
				"nomeGrandeAreaConhecimento=[%s] sequenciaAreaAtuacao=[%s]}", nomeAreaConhecimento, nomeEspecialidade, 
				nomeSubAreaConhecimento, nomeGrandeAreaConhecimento, sequenciaAreaAtuacao);
	}

	public void setNomeAreaConhecimento(String nomeAreaConhecimento) {
		this.nomeAreaConhecimento = nomeAreaConhecimento;
	}

	public void setNomeEspecialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}

	public void setNomeSubAreaConhecimento(String nomeSubAreaConhecimento) {
		this.nomeSubAreaConhecimento = nomeSubAreaConhecimento;
	}

	public void setNomeGrandeAreaConhecimento(String nomeGrandeAreaConhecimento) {
		this.nomeGrandeAreaConhecimento = nomeGrandeAreaConhecimento;
	}

	public void setSequenciaAreaAtuacao(String sequenciaAreaAtuacao) {
		this.sequenciaAreaAtuacao = sequenciaAreaAtuacao;
	}
	
}
