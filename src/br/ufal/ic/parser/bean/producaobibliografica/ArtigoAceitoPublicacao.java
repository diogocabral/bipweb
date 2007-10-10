package br.ufal.ic.parser.bean.producaobibliografica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufal.ic.parser.bean.dadosgerais.PalavrasChave;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.AreaConhecimento;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.SetoresAtividade;
import br.ufal.ic.parser.bean.producaobibliografica.artigospublicados.artigopublicado.DadosBasicosArtigo;
import br.ufal.ic.parser.bean.producaobibliografica.artigospublicados.artigopublicado.DetalhamentoArtigo;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.Autores;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.InformacoesAdicionais;

public class ArtigoAceitoPublicacao implements Serializable {

	private static final long serialVersionUID = -5105042556020132562L;
	
	private String sequenciaProducao;
	
	private DadosBasicosArtigo dadosBasicosArtigo;
	
	private DetalhamentoArtigo detalhamentoArtigo;
	
	private List<Autores> autores = new ArrayList<Autores>();
	
	private PalavrasChave palavrasChave;
	
	private List<AreaConhecimento> areasConhecimento = new ArrayList<AreaConhecimento>();
	
	private SetoresAtividade setoresAtividade;
	
	private InformacoesAdicionais informacoesAdicionais;
	
	@Override
	public String toString() {
		return String.format("{ArtigoAceitoPublicacao sequenciaProducao=[%s] dadosBasicosArtigo=[%s] detalhamentoArtigo=[%s]" +
				" autores=[%s] palavrasChave=[%s] areasConhecimento=[%s] setoresAtividade=[%s] informacoesAdicionais=[%s] }", 
				sequenciaProducao, dadosBasicosArtigo, detalhamentoArtigo, autores, palavrasChave, areasConhecimento, setoresAtividade, informacoesAdicionais);
	}
	
	public void addAutor(Autores autores) {
		this.autores.add(autores);
	}

	/**
	 * @return the sequenciaProducao
	 */
	public String getSequenciaProducao() {
		return sequenciaProducao;
	}

	/**
	 * @param sequenciaProducao the sequenciaProducao to set
	 */
	public void setSequenciaProducao(String sequenciaProducao) {
		this.sequenciaProducao = sequenciaProducao;
	}

	/**
	 * @return the dadosBasicosArtigo
	 */
	public DadosBasicosArtigo getDadosBasicosArtigo() {
		return dadosBasicosArtigo;
	}

	/**
	 * @param dadosBasicosArtigo the dadosBasicosArtigo to set
	 */
	public void setDadosBasicosArtigo(DadosBasicosArtigo dadosBasicosArtigo) {
		this.dadosBasicosArtigo = dadosBasicosArtigo;
	}

	/**
	 * @return the detalhamentoArtigo
	 */
	public DetalhamentoArtigo getDetalhamentoArtigo() {
		return detalhamentoArtigo;
	}

	/**
	 * @param detalhamentoArtigo the detalhamentoArtigo to set
	 */
	public void setDetalhamentoArtigo(DetalhamentoArtigo detalhamentoArtigo) {
		this.detalhamentoArtigo = detalhamentoArtigo;
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
	 * @return the palavrasChave
	 */
	public PalavrasChave getPalavrasChave() {
		return palavrasChave;
	}

	/**
	 * @param palavrasChave the palavrasChave to set
	 */
	public void setPalavrasChave(PalavrasChave palavrasChave) {
		this.palavrasChave = palavrasChave;
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
	 * @return the setoresAtividade
	 */
	public SetoresAtividade getSetoresAtividade() {
		return setoresAtividade;
	}

	/**
	 * @param setoresAtividade the setoresAtividade to set
	 */
	public void setSetoresAtividade(SetoresAtividade setoresAtividade) {
		this.setoresAtividade = setoresAtividade;
	}

	/**
	 * @return the informacoesAdicionais
	 */
	public InformacoesAdicionais getInformacoesAdicionais() {
		return informacoesAdicionais;
	}

	/**
	 * @param informacoesAdicionais the informacoesAdicionais to set
	 */
	public void setInformacoesAdicionais(InformacoesAdicionais informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}	

}
