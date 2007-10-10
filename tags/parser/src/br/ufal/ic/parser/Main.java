package br.ufal.ic.parser;

import java.io.File;

import br.ufal.ic.parser.bean.CurriculoVitae;
import br.ufal.ic.parser.bean.DadosGerais;

public class Main {
	
	public static void main(String[] args) throws Exception {
//		CurriculoVitae curriculoVitae = new CurriculoVitaeXmlParser().parse(new File("xml/LMPLCurriculo.xml"));
//		CurriculoVitae curriculoVitae = new CurriculoVitaeXmlParser().parse(new File("xml/8441037104511506.xml"));
//		CurriculoVitae curriculoVitae = new CurriculoVitaeXmlParser().parse(new File("xml/4038730280834132.xml"));
		CurriculoVitae curriculoVitae = new CurriculoVitaeXmlParser().parse(new File("xml/5760364940162939.xml"));
		
		DadosGerais dadosGerais = curriculoVitae.getDadosGerais();
		
		System.out.println("OK " + dadosGerais.getNomeCompleto());
		System.out.println("OK " + dadosGerais.getNomeCitacoesBibliograficas());
		System.out.println("OK " + dadosGerais.getSexo());
		System.out.println("OK " + dadosGerais.getUfNascimento());
		System.out.println("OK " + dadosGerais.getNacionalidade());
		
		System.out.println("OK " + curriculoVitae.getProducaoBibliografica().getTrabalhosEmEventos());
		System.out.println("OK " + curriculoVitae.getProducaoBibliografica().getArtigosPublicados());
		System.out.println("OK " + curriculoVitae.getProducaoBibliografica().getLivrosCapitulos());
		System.out.println("OK " + curriculoVitae.getProducaoBibliografica().getTextoJornaisRevistas());
		System.out.println("OK " + curriculoVitae.getProducaoBibliografica().getArtigosAceitosPublicacao());
	}

}
