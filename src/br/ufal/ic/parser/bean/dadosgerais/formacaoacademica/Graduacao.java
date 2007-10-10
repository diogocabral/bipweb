package br.ufal.ic.parser.bean.dadosgerais.formacaoacademica;

import java.io.Serializable;

public class Graduacao implements Serializable {
	
	private static final long serialVersionUID = 119005360298571377L;

	private String anoConclusao;
	
	private String anoInicio;
	
	private String codigoAgenciaFinanciadora;
	
	private String codigoAreaCurso;
	
	private String codigoCurso;
	
	private String codigoCursoCapes;
	
	private String codigoInstituicao;
	
	private String codigoOrgao;
	
	private String flagBolsa;
	
	private String nivel;
	
	private String nomeAgencia;
	
	private String nomeCurso;
	
	private String nomeOrientador;
	
	private String nomeInstituicao;
	
	private String nomeOrgao;
	
	private String numeroIdOrientador;
	
	private String sequenciaFormacao;
	
	private String statusCurso;
	
	private String tituloTrabalhoConclusaoCurso;

	@Override
	public String toString() {
		return String.format("{Graduacao anoConclusao=[%s] anoInicio=[%s] codigoAgenciaFinanciadora=[%s] codigoAreaCurso=[%s] codigoCurso=[%s]" +
				" codigoCursoCapes=[%s] codigoInstituicao=[%s] codigoOrgao=[%s] flagBolsa=[%s] nivel=[%s] nomeAgencia=[%s] nomeCurso=[%s] " +
				"nomeOrientador=[%s] nomeInstituicao=[%s] nomeOrgao=[%s] numeroIdOrientador=[%s] sequenciaFormacao=[%s] statusCurso=[%s] " +
				"tituloTrabalhoConclusaoCurso=[%s]}", anoConclusao, anoInicio, codigoAgenciaFinanciadora, codigoAreaCurso, codigoCurso, 
				codigoCursoCapes, codigoInstituicao, codigoOrgao, flagBolsa, nivel, nomeAgencia, nomeCurso, nomeOrientador, nomeInstituicao, 
				nomeOrgao, numeroIdOrientador, sequenciaFormacao, statusCurso, tituloTrabalhoConclusaoCurso);
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

	public void setCodigoAreaCurso(String codigoAreaCurso) {
		this.codigoAreaCurso = codigoAreaCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public void setCodigoCursoCapes(String codigoCursoCapes) {
		this.codigoCursoCapes = codigoCursoCapes;
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

	public void setNumeroIdOrientador(String numeroIdOrientador) {
		this.numeroIdOrientador = numeroIdOrientador;
	}

	public void setSequenciaFormacao(String sequenciaFormacao) {
		this.sequenciaFormacao = sequenciaFormacao;
	}

	public void setStatusCurso(String statusCurso) {
		this.statusCurso = statusCurso;
	}

	public void setTituloTrabalhoConclusaoCurso(String tituloTrabalhoConclusaoCurso) {
		this.tituloTrabalhoConclusaoCurso = tituloTrabalhoConclusaoCurso;
	}

}
