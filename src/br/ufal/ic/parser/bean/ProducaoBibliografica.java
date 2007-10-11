package br.ufal.ic.parser.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import br.ufal.ic.parser.bean.producaobibliografica.ArtigoAceitoPublicacao;
import br.ufal.ic.parser.bean.producaobibliografica.ArtigoPublicado;
import br.ufal.ic.parser.bean.producaobibliografica.LivrosCapitulos;
import br.ufal.ic.parser.bean.producaobibliografica.TextoJornaisRevistas;
import br.ufal.ic.parser.bean.producaobibliografica.TrabalhoEmEventos;

@Embeddable
public class ProducaoBibliografica implements Serializable {

	private static final long serialVersionUID = -3393825511450037711L;
	
	@Transient
	private List<TrabalhoEmEventos> trabalhosEmEventos = new ArrayList<TrabalhoEmEventos>();
	
	@OneToMany(mappedBy = "curriculoVitae")
	private List<ArtigoPublicado> artigosPublicados = new ArrayList<ArtigoPublicado>();
	
	@Transient
	private LivrosCapitulos livrosCapitulos;
	
	@Transient
	private List<TextoJornaisRevistas> textosJornaisRevistas = new ArrayList<TextoJornaisRevistas>();
	
	@Transient
	private List<ArtigoAceitoPublicacao> artigosAceitosPublicacao = new ArrayList<ArtigoAceitoPublicacao>();
	
	public void addTextoJornalRevista(TextoJornaisRevistas textoJornaisRevistas) {
		this.textosJornaisRevistas.add(textoJornaisRevistas);
	}
	
	public void addTrabalhoEmEventos(TrabalhoEmEventos trabalhoEmEventos) {
		trabalhosEmEventos.add(trabalhoEmEventos);
	}
	
	public void addArtigoPublicado(ArtigoPublicado artigoPublicado) {
		artigosPublicados.add(artigoPublicado);
	}
	
	public void addArtigoAceitoPublicacao(ArtigoAceitoPublicacao artigoAceitoPublicacao) {
		artigosAceitosPublicacao.add(artigoAceitoPublicacao);
	}

	/**
	 * @return the trabalhosEmEventos
	 */
	public List<TrabalhoEmEventos> getTrabalhosEmEventos() {
		return trabalhosEmEventos;
	}

	/**
	 * @param trabalhosEmEventos the trabalhosEmEventos to set
	 */
	public void setTrabalhosEmEventos(List<TrabalhoEmEventos> trabalhosEmEventos) {
		this.trabalhosEmEventos = trabalhosEmEventos;
	}

	/**
	 * @return the artigosPublicados
	 */
	public List<ArtigoPublicado> getArtigosPublicados() {
		return artigosPublicados;
	}

	/**
	 * @param artigosPublicados the artigosPublicados to set
	 */
	public void setArtigosPublicados(List<ArtigoPublicado> artigosPublicados) {
		this.artigosPublicados = artigosPublicados;
	}

	/**
	 * @return the livrosCapitulos
	 */
	public LivrosCapitulos getLivrosCapitulos() {
		return livrosCapitulos;
	}

	/**
	 * @param livrosCapitulos the livrosCapitulos to set
	 */
	public void setLivrosCapitulos(LivrosCapitulos livrosCapitulos) {
		this.livrosCapitulos = livrosCapitulos;
	}

	/**
	 * @return the textoJornaisRevistas
	 */
	public List<TextoJornaisRevistas> getTextoJornaisRevistas() {
		return textosJornaisRevistas;
	}

	/**
	 * @param textoJornaisRevistas the textoJornaisRevistas to set
	 */
	public void setTextoJornaisRevistas(
			List<TextoJornaisRevistas> textoJornaisRevistas) {
		this.textosJornaisRevistas = textoJornaisRevistas;
	}

	/**
	 * @return the artigosAceitosPublicacao
	 */
	public List<ArtigoAceitoPublicacao> getArtigosAceitosPublicacao() {
		return artigosAceitosPublicacao;
	}

	/**
	 * @param artigosAceitosPublicacao the artigosAceitosPublicacao to set
	 */
	public void setArtigosAceitosPublicacao(
			List<ArtigoAceitoPublicacao> artigosAceitosPublicacao) {
		this.artigosAceitosPublicacao = artigosAceitosPublicacao;
	}
	
}
