package br.ufal.ic.parser.bean.dadosgerais;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ResumoCv implements Serializable {

	private static final long serialVersionUID = -2298680594544049510L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String textoResumoCvRh;

	@Override
	public String toString() {
		return String.format("{ResumoCv textoResumoCv=[%s]}", textoResumoCvRh);
	}

	public void setTextoResumoCvRh(String textoResumoCvRh) {
		this.textoResumoCvRh = textoResumoCvRh;
	}

}
