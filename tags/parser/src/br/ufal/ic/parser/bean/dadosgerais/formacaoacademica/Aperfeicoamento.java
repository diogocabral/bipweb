package br.ufal.ic.parser.bean.dadosgerais.formacaoacademica;

import java.io.Serializable;

public class Aperfeicoamento implements Serializable {

	private static final long serialVersionUID = 2058341277871104674L;

	private String anoConclusao;
	
	private String anoInicio;
		
	private String cargaHoraria;
	
	private String codigoAgenciaFinanciadora;
	
	private String codigoAreaCurso;
	
	private String codigoCurso;
	
	private String codigoInstituicao;
	
	private String codigoOrgao;
	
	private String flagBolsa;
	
	private String nivel;
	
	private String nomeAgencia;
	
	private String nomeCurso;
	
	private String nomeOrientador;
	
	private String nomeInstituicao;
	
	private String nomeOrgao;
	
	private String sequenciaFormacao;
	
	private String statusCurso;
	
	private String tituloMonografia;
	
	@Override
	public String toString() {
		return String.format("{Especializacao anoConclusao=[%s] anoInicio=[%s] codigoAgenciaFinanciadora=[%s] cargaHoraria=[%s] " +
				"codigoAreaCurso=[%s] codigoCurso=[%s] codigoInstituicao=[%s] codigoOrgao=[%s] flagBolsa=[%s] nivel=[%s] nomeAgencia=[%s] " +
				"nomeCurso=[%s] nomeOrientador=[%s] nomeInstituicao=[%s] nomeOrgao=[%s] sequenciaFormacao=[%s] statusCurso=[%s] " +
				"tituloMonografia=[%s]}", anoConclusao, anoInicio, codigoAgenciaFinanciadora, cargaHoraria, codigoAreaCurso, codigoCurso, 
				codigoInstituicao, codigoOrgao, flagBolsa, nivel, nomeAgencia, nomeCurso, nomeOrientador, nomeInstituicao, nomeOrgao, 
				sequenciaFormacao, statusCurso, tituloMonografia);
	}

	public void setAnoConclusao(String anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public void setAnoInicio(String anoInicio) {
		this.anoInicio = anoInicio;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public void setCodigoAgenciaFinanciadora(String codigoAgenciaFinanciadora) {
		this.codigoAgenciaFinanciadora = codigoAgenciaFinanciadora;
	}

	public void setCodigoAreaCurso(String codigoAreaCurso) {
		this.codigoAreaCurso = codigoAreaCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public void setCodigoInstituicao(String codigoInstituicao) {
		this.codigoInstituicao = codigoInstituicao;
	}

	public void setCodigoOrgao(String codigoOrgao) {
		this.codigoOrgao = codigoOrgao;
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

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public void setNomeOrientador(String nomeOrientador) {
		this.nomeOrientador = nomeOrientador;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public void setNomeOrgao(String nomeOrgao) {
		this.nomeOrgao = nomeOrgao;
	}

	public void setSequenciaFormacao(String sequenciaFormacao) {
		this.sequenciaFormacao = sequenciaFormacao;
	}

	public void setStatusCurso(String statusCurso) {
		this.statusCurso = statusCurso;
	}

	public void setTituloMonografia(String tituloMonografia) {
		this.tituloMonografia = tituloMonografia;
	}
}
