package br.ufal.ic.parser.bean.dadosgerais;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OutrasInformacoesRelevantes implements Serializable {

	private static final long serialVersionUID = 5636849375692190750L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String outrasInformacoesRelevantes;

	@Override
	public String toString() {
		return String.format("{OutrasInformacoesRelevantes outrasInformacoesRelevantes=[%s]}", outrasInformacoesRelevantes);
	}

	public void setOutrasInformacoesRelevantes(String outrasInformacoesRelevantes) {
		this.outrasInformacoesRelevantes = outrasInformacoesRelevantes;
	}

}
