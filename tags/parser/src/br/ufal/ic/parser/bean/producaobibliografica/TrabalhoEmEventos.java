package br.ufal.ic.parser.bean.producaobibliografica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufal.ic.parser.bean.dadosgerais.PalavrasChave;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.AreaConhecimento;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.SetoresAtividade;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.Autores;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.DadosBasicosTrabalho;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.DetalhamentoTrabalho;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.InformacoesAdicionais;

public class TrabalhoEmEventos implements Serializable {

	private static final long serialVersionUID = 65865694982745620L;

	private String sequenciaProducao;

	private DadosBasicosTrabalho dadosBasicoTrabalho;

	private DetalhamentoTrabalho detalhamentoTrabalho;

	private List<Autores> autores = new ArrayList<Autores>();

	private PalavrasChave palavrasChave;

	private List<AreaConhecimento> areasConhecimento = new ArrayList<AreaConhecimento>();

	private SetoresAtividade setoresAtividade;

	private InformacoesAdicionais informacoesAdicionais;
	
	@Override
	public String toString() {
		return String.format("{TrabalhoEmEventos sequenciaProducao=[%s] dadosBasicoTrabalho=[%s] detalhamentoTrabalho=[%s] " +
				"autores=[%s] palavrasChave=[%s] areasConhecimento=[%s] setoresAtividade=[%s] informacoesAdicionais=[%s] }", 
				sequenciaProducao, dadosBasicoTrabalho, detalhamentoTrabalho, autores, palavrasChave, areasConhecimento, setoresAtividade, informacoesAdicionais);
	}

	public void setDadosBasicoTrabalho(DadosBasicosTrabalho dadosBasicoTrabalho) {
		this.dadosBasicoTrabalho = dadosBasicoTrabalho;
	}

	public void setDetalhamentoTrabalho(DetalhamentoTrabalho detalhamentoTrabalho) {
		this.detalhamentoTrabalho = detalhamentoTrabalho;
	}

	public void setInformacoesAdicionais(InformacoesAdicionais informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}

	public void setPalavrasChave(PalavrasChave palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	public void setSequenciaProducao(String sequenciaProducao) {
		this.sequenciaProducao = sequenciaProducao;
	}

	public void setSetoresAtividade(SetoresAtividade setoresAtividade) {
		this.setoresAtividade = setoresAtividade;
	}
	
	public void addAutor(Autores autor) {
		this.autores.add(autor);
	}
	
	public void addAreaConhecimento(AreaConhecimento area) {
		this.areasConhecimento.add(area);
	}

	/**
	 * @return the autores
	 */
	public List<Autores> getAutores() {
		return autores;
	}

	/**
	 * @param autores the autores to set
	 */
	public void setAutores(List<Autores> autores) {
		this.autores = autores;
	}

	/**
	 * @return the areasConhecimento
	 */
	public List<AreaConhecimento> getAreasConhecimento() {
		return areasConhecimento;
	}

	/**
	 * @param areasConhecimento the areasConhecimento to set
	 */
	public void setAreasConhecimento(List<AreaConhecimento> areasConhecimento) {
		this.areasConhecimento = areasConhecimento;
	}

	/**
	 * @return the sequenciaProducao
	 */
	public String getSequenciaProducao() {
		return sequenciaProducao;
	}

	/**
	 * @return the dadosBasicoTrabalho
	 */
	public DadosBasicosTrabalho getDadosBasicoTrabalho() {
		return dadosBasicoTrabalho;
	}

	/**
	 * @return the detalhamentoTrabalho
	 */
	public DetalhamentoTrabalho getDetalhamentoTrabalho() {
		return detalhamentoTrabalho;
	}

	/**
	 * @return the palavrasChave
	 */
	public PalavrasChave getPalavrasChave() {
		return palavrasChave;
	}

	/**
	 * @return the setoresAtividade
	 */
	public SetoresAtividade getSetoresAtividade() {
		return setoresAtividade;
	}

	/**
	 * @return the informacoesAdicionais
	 */
	public InformacoesAdicionais getInformacoesAdicionais() {
		return informacoesAdicionais;
	}

}
