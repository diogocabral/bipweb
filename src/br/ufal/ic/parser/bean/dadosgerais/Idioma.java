package br.ufal.ic.parser.bean.dadosgerais;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Idioma implements Serializable {

	private static final long serialVersionUID = -1736467520691479275L;
	
	@Id
	@GeneratedValue
	private Long id;

	private String descricaoIdioma;
	
	private String idioma;
	
	private String proficienciaCompreensao;
	
	private String proficienciaEscrita;
	
	private String proficienciaFala;
	
	private String proficienciaLeitura;

	@Override
	public String toString() {
		return String.format("{Idioma descricaoIdioma=[%s] idioma=[%s] proficienciaCompreensao=[%s] proficienciaEscrita=[%s] " +
				"proficienciaFala=[%s] proficienciaLeitura=[%s]}", descricaoIdioma, idioma, proficienciaCompreensao, proficienciaEscrita, 
				proficienciaFala, proficienciaLeitura);
	}

	public void setDescricaoIdioma(String descricaoIdioma) {
		this.descricaoIdioma = descricaoIdioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public void setProficienciaCompreensao(String proficienciaCompreensao) {
		this.proficienciaCompreensao = proficienciaCompreensao;
	}

	public void setProficienciaEscrita(String proficienciaEscrita) {
		this.proficienciaEscrita = proficienciaEscrita;
	}

	public void setProficienciaFala(String proficienciaFala) {
		this.proficienciaFala = proficienciaFala;
	}

	public void setProficienciaLeitura(String proficienciaLeitura) {
		this.proficienciaLeitura = proficienciaLeitura;
	}
	
}
