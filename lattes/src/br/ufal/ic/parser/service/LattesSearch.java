package br.ufal.ic.parser.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.Query;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

import br.ufal.ic.parser.bean.ArtigoPublicado;
import br.ufal.ic.parser.util.HibernateUtil;

public class LattesSearch {
	
	public String[] search(String term) {
		FullTextSession luceneSession = Search.createFullTextSession(HibernateUtil.getSession());
		
		List<ArtigoPublicado> artigos = null;
		
		try {
			MultiFieldQueryParser parser = new MultiFieldQueryParser(
					new String[] {"titulo", "tituloPeriodico"}, new StandardAnalyzer());
	
		    Query luceneQuery = parser.parse(term);
	
		    FullTextQuery fullTextQuery = luceneSession.createFullTextQuery(luceneQuery, ArtigoPublicado.class);

		    artigos = fullTextQuery.list();
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		
		Set<String> pesq = new LinkedHashSet<String>();
		
		for (ArtigoPublicado artigoPublicado : artigos) {
			pesq.add(artigoPublicado.getCurriculoVitae().getDadosGerais().getNomeCompleto());
		}
		
		String[] pesquisadores = new String[pesq.size()];
				
		return pesq.toArray(pesquisadores);
	}

}
