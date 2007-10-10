package br.ufal.ic.parser.bean.dadosgerais.formacaoacademica;

import java.io.Serializable;

public class SetoresAtividade implements Serializable {

	private static final long serialVersionUID = -9114115799252856848L;

	private String setorAtividade1;
	
	private String setorAtividade2;
	
	private String setorAtividade3;	

	@Override
	public String toString() {
		return String.format("{SetoresAtividade setorAtividade1=[%s] setorAtividade2=[%s] setorAtividade3=[%s]}", setorAtividade1, 
				setorAtividade2, setorAtividade3);
	}

	public void setSetorAtividade1(String setorAtividade1) {
		this.setorAtividade1 = setorAtividade1;
	}

	public void setSetorAtividade2(String setorAtividade2) {
		this.setorAtividade2 = setorAtividade2;
	}

	public void setSetorAtividade3(String setorAtividade3) {
		this.setorAtividade3 = setorAtividade3;
	}

}
