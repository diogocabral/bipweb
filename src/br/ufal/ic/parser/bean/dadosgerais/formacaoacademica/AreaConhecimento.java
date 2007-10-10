package br.ufal.ic.parser.bean.dadosgerais.formacaoacademica;

import java.io.Serializable;

public class AreaConhecimento implements Serializable {
	
	private static final long serialVersionUID = 6192946394637757486L;

	private String nomeGrandeAreaConhecimento;
	
	private String nomeAreaConhecimento;
	
	private String nomeSubAreaConhecimento;
	
	private String nomeEspecialidade;
	
	@Override
	public String toString() {
		return String.format("{AreaConhecimento nomeGrandeAreaConhecimento=[%s] nomeAreaConhecimento=[%s] nomeSubAreaConhecimento[%s] " +
				"nomeEspecialidaed=[%s]}", nomeGrandeAreaConhecimento, nomeAreaConhecimento, nomeSubAreaConhecimento, nomeEspecialidade);
	}

	public void setNomeGrandeAreaConhecimento(String nomeGrandeAreaConhecimento) {
		this.nomeGrandeAreaConhecimento = nomeGrandeAreaConhecimento;
	}

	public void setNomeAreaConhecimento(String nomeAreaConhecimento) {
		this.nomeAreaConhecimento = nomeAreaConhecimento;
	}

	public void setNomeSubAreaConhecimento(String nomeSubAreaConhecimento) {
		this.nomeSubAreaConhecimento = nomeSubAreaConhecimento;
	}

	public void setNomeEspecialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}
	
}
