package br.ufal.ic.parser.bean.dadosgerais.formacaoacademica;

import java.io.Serializable;

import br.ufal.ic.parser.bean.dadosgerais.PalavrasChave;

public class PosDoutorado implements Serializable {

	private static final long serialVersionUID = -2133754484315246694L;

	private String anoConclusao;
		
	private String anoInicio;
	
	private String anoObtencaoTitulo;
	
	private String codigoAgenciaFinanciadora;
	
	private String codigoCursoCapes;
	
	private String codigoInstituicao;
	
	private String flagBolsa;
	
	private String nivel;
	
	private String nomeAgencia;
	
	private String nomeInstituicao;
		
	private String numeroIdOrientador;
		
	private String sequenciaFormacao;
		
	private String statusCurso;
	
	private String statusEstagio;
		
	private PalavrasChave palavrasChave;
		
	private AreasConhecimento areasConhecimento;
		
	private SetoresAtividade setoresAtividade;

	@Override
	public String toString() {
		return String.format("{PosDoutorado anoConclusao=[%s] anoInicio=[%s] anoObtencaoTitulo=[%s] codigoAgenciaFinanciadora=[%s] " +
				"codigoCursoCapes=[%s] codigoInstituicao=[%s] flagBolsa=[%s] nivel=[%s] nomeAgencia=[%s] nomeInstituicao=[%s] " +
				"numeroIdOrientador=[%s] sequenciaFormacao=[%s] statusCurso=[%s] statusEstagio=[%s] palavrasChave=[%s] areasConhecimento=[%s] " +
				"setoresAtividade=[%s]}", anoConclusao, anoInicio, anoObtencaoTitulo, codigoAgenciaFinanciadora, codigoCursoCapes, 
				codigoInstituicao, flagBolsa, nivel, nomeAgencia, nomeInstituicao, numeroIdOrientador, sequenciaFormacao, statusCurso, 
				statusEstagio, palavrasChave, areasConhecimento, setoresAtividade);
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

	public void setCodigoCursoCapes(String codigoCursoCapes) {
		this.codigoCursoCapes = codigoCursoCapes;
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

	public void setNumeroIdOrientador(String numeroIdOrientador) {
		this.numeroIdOrientador = numeroIdOrientador;
	}

	public void setSequenciaFormacao(String sequenciaFormacao) {
		this.sequenciaFormacao = sequenciaFormacao;
	}

	public void setStatusCurso(String statusCurso) {
		this.statusCurso = statusCurso;
	}

	public void setStatusEstagio(String statusEstagio) {
		this.statusEstagio = statusEstagio;
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
