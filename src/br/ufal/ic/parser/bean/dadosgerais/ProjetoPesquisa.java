package br.ufal.ic.parser.bean.dadosgerais;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProjetoPesquisa implements Serializable {
	
	private static final long serialVersionUID = 2516033029375362145L;
	
	@Id
	@GeneratedValue
	private Long id;

	private String sequenciaFuncaoAtividade;
	
	private String flagPeriodo;
	
	private String mesInicio;
	
	private String anoInicio;
	
	private String mesFim;
	
	private String anoFim;
	
	private String codigoOrgao;
	
	private String nomeOrgao;
	
	private String codigoUnidade;
	
	private String nomeUnidade;
	
	@Override
	public String toString() {
		return String.format("{ProjetoPesquisa sequenciaFuncaoAtividade=[%s] flagPeriodo=[%s] mesInicio=[%s] anoInicio=[%s] mesFim=[%s] anoFim=[%s] codigoOrgao=[%s] nomeOrgao=[%s] codigoUnidade=[%s] nomeUnidade=[%s]}", sequenciaFuncaoAtividade, 
				flagPeriodo, mesInicio, anoInicio, mesFim, anoFim, codigoOrgao, nomeOrgao, codigoUnidade, nomeUnidade);
	}

	public void setAnoFim(String anoFim) {
		this.anoFim = anoFim;
	}

	public void setAnoInicio(String anoInicio) {
		this.anoInicio = anoInicio;
	}

	public void setCodigoOrgao(String codigoOrgao) {
		this.codigoOrgao = codigoOrgao;
	}

	public void setCodigoUnidade(String codigoUnidade) {
		this.codigoUnidade = codigoUnidade;
	}

	public void setFlagPeriodo(String flagPeriodo) {
		this.flagPeriodo = flagPeriodo;
	}

	public void setMesFim(String mesFim) {
		this.mesFim = mesFim;
	}

	public void setMesInicio(String mesInicio) {
		this.mesInicio = mesInicio;
	}

	public void setNomeOrgao(String nomeOrgao) {
		this.nomeOrgao = nomeOrgao;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public void setSequenciaFuncaoAtividade(String sequenciaFuncaoAtividade) {
		this.sequenciaFuncaoAtividade = sequenciaFuncaoAtividade;
	}
	
	

}
