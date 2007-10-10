package br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.livrospublicadosorganizados.LivroPublicadoOrganizado;

public class LivrosPublicadosOrganizados implements Serializable {
	
	private List<LivroPublicadoOrganizado> livrosPublicadosOrganizados = new ArrayList<LivroPublicadoOrganizado>();
	
	@Override
	public String toString() {
		return String.format("{LivrosPublicadosOrganizados livroPublicadoOrganizado=[%s]}", livrosPublicadosOrganizados);
	}
	
	public void addLivroPublicado(LivroPublicadoOrganizado livroPublicadoOrganizado) {
		livrosPublicadosOrganizados.add(livroPublicadoOrganizado);
	}

}
