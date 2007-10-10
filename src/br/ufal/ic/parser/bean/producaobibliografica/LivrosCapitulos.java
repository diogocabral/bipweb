package br.ufal.ic.parser.bean.producaobibliografica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.CapitulosLivrosPublicados;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.LivrosPublicadosOrganizados;

public class LivrosCapitulos implements Serializable {

	private static final long serialVersionUID = -7451026916240048028L;
	
	private List<LivrosPublicadosOrganizados> livrosPublicados = new ArrayList<LivrosPublicadosOrganizados>();
	
	private List<CapitulosLivrosPublicados> capitulosPublicados = new ArrayList<CapitulosLivrosPublicados>();
	
	@Override
	public String toString() {
		return String.format("{LivrosCapitulos livrosPublicados=[%s] capitulosPublicados=[%s]}", livrosPublicados, capitulosPublicados);
	}
	
	public void addLivroPublicado(LivrosPublicadosOrganizados livroPublicado) {
		this.livrosPublicados.add(livroPublicado);
	}
	
	public void addCapituloPublicado(CapitulosLivrosPublicados capituloPublicado) {
		this.capitulosPublicados.add(capituloPublicado);
	}

}
