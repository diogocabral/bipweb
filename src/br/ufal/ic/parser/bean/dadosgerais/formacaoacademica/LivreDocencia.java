package br.ufal.ic.parser.bean.dadosgerais.formacaoacademica;

import java.io.Serializable;

import br.ufal.ic.parser.bean.dadosgerais.PalavrasChave;

public class LivreDocencia implements Serializable {

	private static final long serialVersionUID = -4715644833590016772L;

	private String anoObtencaoTitulo;
	
	private String codigoInstituicao;
	
	private String nivel;
	
	private String nomeInstituicao;
	
	private String sequenciaFormacao;
	
	private String tituloTrabalho;
	
	private PalavrasChave palavrasChave;
	
	private AreasConhecimento areasConhecimento;
		
	private SetoresAtividade setoresAtividade;

	@Override
	public String toString() {
		return String.format("{LivreDocencia anoObtencaoTitulo=[%s] codigoInstituicao=[%s] nivel=[%s] nomeInstituicao=[%s] " +
				"sequenciaFormacao=[%s] tituloTrabalho=[%s] palavrasChave=[%s] areasConhecimento=[%s] setoresAtividade=[%s]}", 
				anoObtencaoTitulo, codigoInstituicao, nivel, nomeInstituicao, sequenciaFormacao, tituloTrabalho, palavrasChave, 
				areasConhecimento, setoresAtividade);
	}

	public void setAnoObtencaoTitulo(String anoObtencaoTitulo) {
		this.anoObtencaoTitulo = anoObtencaoTitulo;
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

	public void setTituloTrabalho(String tituloTrabalho) {
		this.tituloTrabalho = tituloTrabalho;
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
