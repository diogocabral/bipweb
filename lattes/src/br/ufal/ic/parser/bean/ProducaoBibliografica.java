package br.ufal.ic.parser.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

@Embeddable
public class ProducaoBibliografica implements Serializable {

	private static final long serialVersionUID = -3393825511450037711L;
	
	@OneToMany(mappedBy = "curriculoVitae")
	private List<ArtigoPublicado> artigosPublicados = new ArrayList<ArtigoPublicado>();

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
	
}
