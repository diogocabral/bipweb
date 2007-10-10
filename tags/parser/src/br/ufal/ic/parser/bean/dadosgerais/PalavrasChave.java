package br.ufal.ic.parser.bean.dadosgerais;

import java.io.Serializable;

import javax.persistence.Embeddable;

public class PalavrasChave implements Serializable {

	private static final long serialVersionUID = 6248828230472664100L;

	private String palavraChave1;
	
	private String palavraChave2;
	
	private String palavraChave3;
	
	private String palavraChave4;
	
	private String palavraChave5;
	
	private String palavraChave6;

	@Override
	public String toString() {
		return String.format("{PalavrasChave palavraChave1=[%s] palavraChave2=[%s] palavraChave3=[%s] palavraChave4=[%s] palavraChave5=[%s] " +
				"palavraChave6=[%s]}", palavraChave1, palavraChave2, palavraChave3, palavraChave4, palavraChave5, palavraChave6);
	}

	public void setPalavraChave1(String palavraChave1) {
		this.palavraChave1 = palavraChave1;
	}

	public void setPalavraChave2(String palavraChave2) {
		this.palavraChave2 = palavraChave2;
	}

	public void setPalavraChave3(String palavraChave3) {
		this.palavraChave3 = palavraChave3;
	}

	public void setPalavraChave4(String palavraChave4) {
		this.palavraChave4 = palavraChave4;
	}

	public void setPalavraChave5(String palavraChave5) {
		this.palavraChave5 = palavraChave5;
	}

	public void setPalavraChave6(String palavraChave6) {
		this.palavraChave6 = palavraChave6;
	}

}
