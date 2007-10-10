package br.ufal.ic.parser.bean.dadosgerais;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.ufal.ic.parser.bean.dadosgerais.endereco.EnderecoProfissional;
import br.ufal.ic.parser.bean.dadosgerais.endereco.EnderecoResidencial;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 742630517557980523L;
	
	@Id
	@GeneratedValue
	private Long id;

	private String flagReferencia;	
	
	private EnderecoProfissional enderecoProfissional;
	
	private EnderecoResidencial enderecoResidencial;

	@Override
	public String toString() {
		return String.format("{Endereco flagReferencia=[%s] enderecoProfissional=[%s] enderecoResidencial=[%s]}", flagReferencia, 
				enderecoProfissional, enderecoResidencial);
	}

	public void setEnderecoProfissional(EnderecoProfissional enderecoProfissional) {
		this.enderecoProfissional = enderecoProfissional;
	}

	public void setEnderecoResidencial(EnderecoResidencial enderecoResidencial) {
		this.enderecoResidencial = enderecoResidencial;
	}

	public void setFlagReferencia(String flagReferencia) {
		this.flagReferencia = flagReferencia;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
