package br.ufal.ic.parser.bean.dadosgerais.formacaoacademica;

import java.io.Serializable;

public class EnsinoMedioSegundoGrau implements Serializable {

	private static final long serialVersionUID = 2892896507247754691L;

	private String anoConclusao;
	
	private String anoInicio;
	
	private String codigoInstituicao;
	
	private String nivel;
	
	private String nomeInstituicao;
	
	private String sequenciaFormacao;
	
	private String statusCurso;

	@Override
	public String toString() {
		return String.format("{EnsinoMedioSegundoGrau anoConclusao=[%s] anoInicio=[%s] codigoInstituicao=[%s] nivel=[%s] " +
				"nomeInstituicao=[%s] sequenciaFormacao=[%s] statusCurso=[%s]}", anoConclusao, anoInicio, codigoInstituicao, nivel, 
				nomeInstituicao, sequenciaFormacao, statusCurso);
	}

	public void setAnoConclusao(String anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public void setAnoInicio(String anoInicio) {
		this.anoInicio = anoInicio;
	}

	public void setCodigoInstituicao(String codigoInstituicao) {
		this.codigoInstituicao = codigoInstituicao;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public void setSequenciaFormacao(String sequenciaFormacao) {
		this.sequenciaFormacao = sequenciaFormacao;
	}

	public void setStatusCurso(String statusCurso) {
		this.statusCurso = statusCurso;
	}

}
