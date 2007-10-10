package br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufal.ic.parser.bean.dadosgerais.PalavrasChave;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.AreasConhecimento;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.SetoresAtividade;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.capituloslivrospublicados.CapituloLivroPublicado;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.capituloslivrospublicados.capitulolivropublicado.DadosBasicosCapitulo;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.capituloslivrospublicados.capitulolivropublicado.DetalhamentoCapitulo;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.Autores;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.InformacoesAdicionais;

public class CapitulosLivrosPublicados implements Serializable {

	private static final long serialVersionUID = 8624060619441080559L;
	
	private CapituloLivroPublicado capituloLivroPublicado;
	
	@Override
	public String toString() {
		return String
				.format("{CapitulosLivrosPublicados capituloLivroPublicado=[%s]}", capituloLivroPublicado );
	}
	
	public void setCapituloLivroPublicado(
			CapituloLivroPublicado capituloLivroPublicado) {
		this.capituloLivroPublicado = capituloLivroPublicado;
	}
	
}
