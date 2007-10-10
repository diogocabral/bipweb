package br.ufal.ic.parser.bean.dadosgerais.formacaoacademica;

import java.io.Serializable;

import br.ufal.ic.parser.bean.dadosgerais.PalavrasChave;

public class ResidenciaMedica implements Serializable {

	private static final long serialVersionUID = 8237307373652446879L;

	private String anoConclusao;
		
	private String anoInicio;
	
	private String codigoAgenciaFinanciadora;
	
	private String codigoInstituicao;
	
	private String flagBolsa;
	
	private String nivel;
	
	private String nomeAgencia;
	
	private String nomeInstituicao;
	
	private String numeroRegistro;
		
	private String sequenciaFormacao;
		
	private String statusCurso;
	
	private String tituloResidenciaMedica;
		
	private PalavrasChave palavrasChave;
		
	private AreasConhecimento areasConhecimento;
		
	private SetoresAtividade setoresAtividade;
	
	@Override
	public String toString() {
		return String.format("{ResidenciaMedica anoConclusao=[%s] anoInicio=[%s] codigoAgenciaFinanciadora=[%s] " +
				"codigoInstituicao=[%s] flagBolsa=[%s] nivel=[%s] nomeAgencia=[%s] nomeInstituicao=[%s] numeroRegistro=[%s] " +
				"sequenciaFormacao=[%s] statusCurso=[%s] tituloResidenciaMedica=[%s] palavrasChave=[%s] areasConhecimento=[%s] " +
				"setoresAtividade=[%s]}", anoConclusao, anoInicio, codigoAgenciaFinanciadora, codigoInstituicao, flagBolsa, nivel, nomeAgencia, 
				nomeInstituicao, numeroRegistro, sequenciaFormacao, statusCurso, tituloResidenciaMedica, palavrasChave, areasConhecimento, 
				setoresAtividade);
	}

	public void setAnoConclusao(String anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public void setAnoInicio(String anoInicio) {
		this.anoInicio = anoInicio;
	}

	public void setCodigoAgenciaFinanciadora(String codigoAgenciaFinanciadora) {
		this.codigoAgenciaFinanciadora = codigoAgenciaFinanciadora;
	}

	public void setCodigoInstituicao(String codigoInstituicao) {
		this.codigoInstituicao = codigoInstituicao;
	}

	public void setFlagBolsa(String flagBolsa) {
		this.flagBolsa = flagBolsa;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public void setSequenciaFormacao(String sequenciaFormacao) {
		this.sequenciaFormacao = sequenciaFormacao;
	}

	public void setStatusCurso(String statusCurso) {
		this.statusCurso = statusCurso;
	}

	public void setTituloResidenciaMedica(String tituloResidenciaMedica) {
		this.tituloResidenciaMedica = tituloResidenciaMedica;
	}

	public void setPalavrasChave(PalavrasChave palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	public void setAreasConhecimento(AreasConhecimento areasConhecimento) {
		this.areasConhecimento = areasConhecimento;
	}

	public void setSetoresAtividade(SetoresAtividade setoresAtividade) {
		this.setoresAtividade = setoresAtividade;
	}
	
}
