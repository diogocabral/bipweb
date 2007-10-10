package br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.capituloslivrospublicados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufal.ic.parser.bean.dadosgerais.PalavrasChave;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.AreasConhecimento;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.SetoresAtividade;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.capituloslivrospublicados.capitulolivropublicado.DadosBasicosCapitulo;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.capituloslivrospublicados.capitulolivropublicado.DetalhamentoCapitulo;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.Autores;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.InformacoesAdicionais;

public class CapituloLivroPublicado implements Serializable {

	private static final long serialVersionUID = -8104518262262123231L;

	private String sequenciaProducao;

	private DadosBasicosCapitulo dadosBasicosCapitulo;

	private DetalhamentoCapitulo detalhamentoCapitulo;

	private List<Autores> autores = new ArrayList<Autores>();

	private PalavrasChave palavrasChave;

	private List<AreasConhecimento> areasConhecimento = new ArrayList<AreasConhecimento>();

	private SetoresAtividade setoresAtividade;

	private InformacoesAdicionais informacoesAdicionais;

	@Override
	public String toString() {
		return String
				.format("{CapituloLivroPublicado sequenciaProducao=[%s] dadosBasicosCapitulo=[%s] detalhamentoCapitulo=[%s] "
						+ "autores=[%s] palavrasChave=[%s] areasConhecimento=[%s] setoresAtividade=[%s] informacoesAdicionais=[%s]}",
						sequenciaProducao, dadosBasicosCapitulo,
						detalhamentoCapitulo, autores, palavrasChave,
						areasConhecimento, setoresAtividade,
						informacoesAdicionais);
	}

	public void addAutor(Autores autor) {
		this.autores.add(autor);
	}

	public void addAreaConhecimento(AreasConhecimento areaConhecimento) {
		this.areasConhecimento.add(areaConhecimento);
	}

	public void setDadosBasicosCapitulo(
			DadosBasicosCapitulo dadosBasicosCapitulo) {
		this.dadosBasicosCapitulo = dadosBasicosCapitulo;
	}

	public void setDetalhamentoCapitulo(
			DetalhamentoCapitulo detalhamentoCapitulo) {
		this.detalhamentoCapitulo = detalhamentoCapitulo;
	}

	public void setInformacoesAdicionais(
			InformacoesAdicionais informacoesAdicionais) {
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

}
