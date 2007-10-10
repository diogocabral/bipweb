package br.ufal.ic.parser.bean.producaobibliografica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.ufal.ic.parser.bean.dadosgerais.PalavrasChave;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.AreaConhecimento;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.SetoresAtividade;
import br.ufal.ic.parser.bean.producaobibliografica.artigospublicados.artigopublicado.DadosBasicosArtigo;
import br.ufal.ic.parser.bean.producaobibliografica.artigospublicados.artigopublicado.DetalhamentoArtigo;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.Autores;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.InformacoesAdicionais;

@Entity
@Table(name = "artigos")
public class ArtigoPublicado implements Serializable {

	private static final long serialVersionUID = 528705935071053609L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String sequenciaProducao;
	
	@Embedded
	private DadosBasicosArtigo dadosBasicoArtigo;
	
	@Embedded
	private DetalhamentoArtigo detalhamentoArtigo;
	
	@Transient
	private List<Autores> autores = new ArrayList<Autores>();
	
	@Transient
	private PalavrasChave palavrasChave;
	
	@Transient
	private List<AreaConhecimento> areasConhecimento = new ArrayList<AreaConhecimento>();
	
	@Transient
	private SetoresAtividade setoresAtividade;
	
	@Transient
	private InformacoesAdicionais informacoesAdicionais;
	
	@Override
	public String toString() {
		return String.format("{ArtigoPublicado sequenciaProducao=[%s] dadosBasicoArtigo=[%s] detalhamentoArtigo=[%s] autores=[%s] palavrasChave=[%s]" +
				" areasConhecimento=[%s] setoresAtividade=[%s] informacoesAdicionais=[%s] }", sequenciaProducao, dadosBasicoArtigo, 
				detalhamentoArtigo, autores, palavrasChave, areasConhecimento, setoresAtividade, informacoesAdicionais);
	}
	
	public void setSequenciaProducao(String sequenciaProducao) {
		this.sequenciaProducao = sequenciaProducao;
	}

	public void setDadosBasicoArtigo(DadosBasicosArtigo dadosBasicoArtigo) {
		this.dadosBasicoArtigo = dadosBasicoArtigo;
	}

	public void setDetalhamentoArtigo(DetalhamentoArtigo detalhamentoArtigo) {
		this.detalhamentoArtigo = detalhamentoArtigo;
	}

	public void setInformacoesAdicionais(InformacoesAdicionais informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}

	public void setPalavrasChave(PalavrasChave palavrasChave) {
		this.palavrasChave = palavrasChave;
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

}
