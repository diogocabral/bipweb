package br.ufal.ic.parser.bean.producaobibliografica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufal.ic.parser.bean.dadosgerais.PalavrasChave;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.AreasConhecimento;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.SetoresAtividade;
import br.ufal.ic.parser.bean.producaobibliografica.textojornaisrevistas.DadosBasicosTexto;
import br.ufal.ic.parser.bean.producaobibliografica.textojornaisrevistas.DetalhamentoTexto;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.Autores;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.InformacoesAdicionais;

public class TextoJornaisRevistas implements Serializable {

	private static final long serialVersionUID = -2057483952506296286L;
	
	private String sequenciaProducao;
	
	private DadosBasicosTexto dadosBasicosTexto;
	
	private DetalhamentoTexto detalhamentoTexto;
	
	private List<Autores> autores = new ArrayList<Autores>();
	
	private PalavrasChave palavrasChave;
	
	private List<AreasConhecimento> areasConhecimento = new ArrayList<AreasConhecimento>();
	
	private SetoresAtividade setoresAtividade;
	
	private InformacoesAdicionais informacoesAdicionais;
	
	@Override
	public String toString() {
		return String.format("{TextoJornaisRevistas sequenciaProducao=[%s] dadosBasicosTexto=[%s] detalhamentoTexto=[%s] " +
				"autores=[%s] palavrasChave=[%s] areasConhecimento=[%s] setoresAtividade=[%s] informacoesAdicionais=[%s]}", 
				sequenciaProducao, dadosBasicosTexto, detalhamentoTexto, autores, palavrasChave, areasConhecimento, setoresAtividade, informacoesAdicionais);
	}
	
	public void addAutor(Autores autor) {
		this.autores.add(autor);
	}
	
	public void addAreaConhecimento(AreasConhecimento areaConhecimento) {
		this.areasConhecimento.add(areaConhecimento);
	}

	public void setDadosBasicosTexto(DadosBasicosTexto dadosBasicosTexto) {
		this.dadosBasicosTexto = dadosBasicosTexto;
	}

	public void setDetalhamentoTexto(DetalhamentoTexto detalhamentoTexto) {
		this.detalhamentoTexto = detalhamentoTexto;
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

	
	
}
