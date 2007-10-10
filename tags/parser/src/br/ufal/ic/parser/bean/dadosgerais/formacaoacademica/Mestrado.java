package br.ufal.ic.parser.bean.dadosgerais.formacaoacademica;

import java.io.Serializable;

import br.ufal.ic.parser.bean.dadosgerais.PalavrasChave;

public class Mestrado implements Serializable {

	private static final long serialVersionUID = -2354510825884939668L;

	private String anoConclusao;
	
	private String anoInicio;
	
	private String anoObtencaoTitulo;
	
	private String codigoAgenciaFinanciadora;
	
	private String codigoAreaCurso;
	
	private String codigoCurso;
	
	private String codigoCursoCapes;
	
	private String codigoInstituicao;
	
	private String codigoOrgao;
	
	private String flagBolsa;
	
	private String nivel;
	
	private String nomeAgencia;
	
	private String nomeCompletoOrientador;
	
	private String nomeCurso;
	
	private String nomeInstituicao;
	
	private String nomeOrgao;
	
	private String numeroIdOrientador;
	
	private String sequenciaFormacao;
	
	private String statusCurso;
	
	private String tituloDissertacaoTese;
	
	private PalavrasChave palavrasChave;
	
	private AreasConhecimento areasConhecimento;
	
	private SetoresAtividade setoresAtividade;

	@Override
	public String toString() {
		return String.format("{Mestrado anoConclusao=[%s] anoInicio=[%s] anoObtencaoTitulo=[%s] codigoAgenciaFinanciadora=[%s] " +
				"codigoAreaCurso=[%s] codigoCurso=[%s] codigoCursoCapes=[%s] codigoInstituicao=[%s] codigoOrgao=[%s] flagBolsa=[%s] " +
				"nivel=[%s] nomeAgencia=[%s] nomeCompletoOrientador=[%s] nomeCurso=[%s] nomeInstituicao=[%s] nomeOrgao=[%s] " +
				"numeroIdOrientador=[%s] sequenciaFormacao=[%s] statusCurso=[%s] tituloDissertacaoTese=[%s] palavrasChave=[%s] " +
				"areasConhecimento=[%s] setoresAtividade=[%s]}", anoConclusao, anoInicio, anoObtencaoTitulo, codigoAgenciaFinanciadora, 
				codigoAreaCurso, codigoCurso, codigoCursoCapes, codigoInstituicao, codigoOrgao, flagBolsa, nivel, nomeAgencia, 
				nomeCompletoOrientador, nomeCurso, nomeInstituicao, nomeOrgao, numeroIdOrientador, sequenciaFormacao, statusCurso, 
				tituloDissertacaoTese, palavrasChave, areasConhecimento, setoresAtividade);
	}

	public void setAnoConclusao(String anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public void setAnoInicio(String anoInicio) {
		this.anoInicio = anoInicio;
	}

	public void setAnoObtencaoTitulo(String anoObtencaoTitulo) {
		this.anoObtencaoTitulo = anoObtencaoTitulo;
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

	public void setNomeCompletoOrientador(String nomeCompletoOrientador) {
		this.nomeCompletoOrientador = nomeCompletoOrientador;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
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

	public void setTituloDissertacaoTese(String tituloDissertacaoTese) {
		this.tituloDissertacaoTese = tituloDissertacaoTese;
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
