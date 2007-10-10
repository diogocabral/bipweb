package br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.livrospublicadosorganizados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufal.ic.parser.bean.dadosgerais.PalavrasChave;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.AreaConhecimento;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.SetoresAtividade;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.livrospublicadosorganizados.livropublicadoorganizado.DadosBasicosLivro;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.livrospublicadosorganizados.livropublicadoorganizado.DetalhamentoLivro;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.Autores;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.InformacoesAdicionais;

public class LivroPublicadoOrganizado implements Serializable {

	private static final long serialVersionUID = -4022058266475767287L;

	private String sequenciaProducao;

	private DadosBasicosLivro dadosLivro;

	private DetalhamentoLivro detalhamentoLivro;

	private List<Autores> autores = new ArrayList<Autores>();

	private PalavrasChave palavrasChave;

	private List<AreaConhecimento> areasConhecimento = new ArrayList<AreaConhecimento>();

	private SetoresAtividade setoresAtividade;

	private InformacoesAdicionais informacoesAdicionais;

	@Override
	public String toString() {
		return String
				.format(
						"{LivroPublicadoOrganizado sequenciaProducao=[%s] dadosLivro=[%s] detalhamentoLivro=[%s] "
								+ "autores=[%s] palavrasChave=[%s] areasConhecimento=[%s] setoresAtividade=[%s] informacoesAdicionais=[%s]}",
						sequenciaProducao, dadosLivro, detalhamentoLivro,
						autores, palavrasChave, areasConhecimento,
						setoresAtividade, informacoesAdicionais);
	}

	public void setDadosLivro(DadosBasicosLivro dadosLivro) {
		this.dadosLivro = dadosLivro;
	}

	public void setDetalhamentoLivro(DetalhamentoLivro detalhamentoLivro) {
		this.detalhamentoLivro = detalhamentoLivro;
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

	public void addAutor(Autores autor) {
		this.autores.add(autor);
	}

	public void addAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areasConhecimento.add(areaConhecimento);
	}

}
