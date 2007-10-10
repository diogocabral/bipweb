package br.ufal.ic.parser.bean.dadosgerais.formacaoacademica;

import java.io.Serializable;

public class AreasConhecimento implements Serializable {

	private static final long serialVersionUID = -2571676566875321092L;

	private AreaConhecimento areaConhecimento1;
	
	private AreaConhecimento areaConhecimento2;
	
	private AreaConhecimento areaConhecimento3;
	
	@Override
	public String toString() {
		return String.format("{AreasConhecimento areaConhecimento1=[%s] areaConhecimento2=[%s] areaConhecimento3=[%s]}", areaConhecimento1, 
				areaConhecimento2, areaConhecimento3);
	}

	public void setAreaConhecimento1(AreaConhecimento areaConhecimento1) {
		this.areaConhecimento1 = areaConhecimento1;
	}

	public void setAreaConhecimento2(AreaConhecimento areaConhecimento2) {
		this.areaConhecimento2 = areaConhecimento2;
	}

	public void setAreaConhecimento3(AreaConhecimento areaConhecimento3) {
		this.areaConhecimento3 = areaConhecimento3;
	}	

}
