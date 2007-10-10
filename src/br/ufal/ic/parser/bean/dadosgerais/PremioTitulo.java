package br.ufal.ic.parser.bean.dadosgerais;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PremioTitulo implements Serializable {

	private static final long serialVersionUID = -6176070784208326781L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String anoPremiacao;
	
	private String nomeEntidadePromotora;
	
	private String nomePremioTitulo;

	@Override
	public String toString() {
		return String.format("{PremioTitulo anoPremiacao=[%s] nomeEntidadePromotora=[%s] nomePremioTitulo=[%s]}", anoPremiacao, 
				nomeEntidadePromotora, nomePremioTitulo);
	}

	public void setAnoPremiacao(String anoPremiacao) {
		this.anoPremiacao = anoPremiacao;
	}

	public void setNomeEntidadePromotora(String nomeEntidadePromotora) {
		this.nomeEntidadePromotora = nomeEntidadePromotora;
	}

	public void setNomePremioTitulo(String nomePremioTitulo) {
		this.nomePremioTitulo = nomePremioTitulo;
	}

}
