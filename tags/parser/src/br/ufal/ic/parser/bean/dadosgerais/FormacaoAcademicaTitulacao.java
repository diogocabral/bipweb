package br.ufal.ic.parser.bean.dadosgerais;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;

import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.Aperfeicoamento;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.CursoTecnicoProfissionalizante;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.Doutorado;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.EnsinoFundamentalPrimeiroGrau;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.EnsinoMedioSegundoGrau;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.Especializacao;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.Graduacao;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.LivreDocencia;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.Mestrado;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.MestradoProfissionalizante;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.PosDoutorado;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.ResidenciaMedica;

@Embeddable
public class FormacaoAcademicaTitulacao implements Serializable {

	private static final long serialVersionUID = 9203831964274289221L;

	private List<Graduacao> graduacoes = new ArrayList<Graduacao>();
	
	private List<Especializacao> especializacoes = new ArrayList<Especializacao>();
	
	private List<Mestrado> mestrados = new ArrayList<Mestrado>();
	
	private List<Doutorado> doutorados = new ArrayList<Doutorado>();
	
	private List<PosDoutorado> posDoutorados = new ArrayList<PosDoutorado>();
	
	private List<LivreDocencia> livreDocencias = new ArrayList<LivreDocencia>();
	
	private List<CursoTecnicoProfissionalizante> cursosTecnicoProfissionalizante = new ArrayList<CursoTecnicoProfissionalizante>();
	
	private List<MestradoProfissionalizante> mestradosProfissionalizante = new ArrayList<MestradoProfissionalizante>();
	
	private EnsinoFundamentalPrimeiroGrau ensinoFundamentalPrimeiroGrau;
	
	private EnsinoMedioSegundoGrau ensinoMedioSegundoGrau;
	
	private List<ResidenciaMedica> residenciasMedicas = new ArrayList<ResidenciaMedica>();
	
	private List<Aperfeicoamento> aperfeicoamentos = new ArrayList<Aperfeicoamento>();

	@Override
	public String toString() {
		return String.format("{FormacaoAcademicaTitulacao graduacao=[%s] especializacao=[%s] mestrado=[%s] doutorado=[%s] posDoutorado=[%s] " +
				"livreDocencia=[%s] cursoTecnicoProfissionalizante=[%s] mestradoProfissionalizante=[%s] ensinoFundamentalPrimeirograu=[%s] " +
				"ensinoMedioSegundoGrau=[%s] residenciaMedica=[%s] aperfeicoamento=[%s]}", graduacoes, especializacoes, mestrados, doutorados, 
				posDoutorados, livreDocencias, cursosTecnicoProfissionalizante, mestradosProfissionalizante, ensinoFundamentalPrimeiroGrau,
				ensinoMedioSegundoGrau, residenciasMedicas, aperfeicoamentos);
	}

	public void addGraduacao(Graduacao graduacao) {
		this.graduacoes.add(graduacao);
	}

	public void addEspecializacao(Especializacao especializacao) {
		this.especializacoes.add(especializacao);
	}

	public void addMestrado(Mestrado mestrado) {
		this.mestrados.add(mestrado);
	}

	public void addDoutorado(Doutorado doutorado) {
		this.doutorados.add(doutorado);
	}

	public void addPosDoutorado(PosDoutorado posDoutorado) {
		this.posDoutorados.add(posDoutorado);
	}

	public void addLivreDocencia(LivreDocencia livreDocencia) {
		this.livreDocencias.add(livreDocencia);
	}

	public void addCursoTecnicoProfissionalizante(CursoTecnicoProfissionalizante cursoTecnicoProfissionalizante) {
		this.cursosTecnicoProfissionalizante.add(cursoTecnicoProfissionalizante);
	}

	public void addMestradoProfissionalizante(MestradoProfissionalizante mestradoProfissionalizante) {
		this.mestradosProfissionalizante.add(mestradoProfissionalizante);
	}

	public void setEnsinoFundamentalPrimeiroGrau(EnsinoFundamentalPrimeiroGrau ensinoFundamentalPrimeiroGrau) {
		this.ensinoFundamentalPrimeiroGrau = ensinoFundamentalPrimeiroGrau;
	}

	public void setEnsinoMedioSegundoGrau(EnsinoMedioSegundoGrau ensinoMedioSegundoGrau) {
		this.ensinoMedioSegundoGrau = ensinoMedioSegundoGrau;
	}

	public void addResidenciaMedica(ResidenciaMedica residenciaMedica) {
		this.residenciasMedicas.add(residenciaMedica);
	}

	public void addAperfeicoamento(Aperfeicoamento aperfeicoamento) {
		this.aperfeicoamentos.add(aperfeicoamento);
	}

}
