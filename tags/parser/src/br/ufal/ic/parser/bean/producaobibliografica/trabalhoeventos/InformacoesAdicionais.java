package br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos;

import java.io.Serializable;

public class InformacoesAdicionais implements Serializable {

	private static final long serialVersionUID = 8294522407020170554L;
	
	private String descricaoInformacoesAdicionais;
	
	@Override
	public String toString() {
		return String.format("{InformacoesAdicionais descricaoInformacoesAdicionais=[%s] }", descricaoInformacoesAdicionais);
	}
	
	public void setDescricaoInformacoesAdicionais(
			String descricaoInformacoesAdicionais) {
		this.descricaoInformacoesAdicionais = descricaoInformacoesAdicionais;
	}

}
