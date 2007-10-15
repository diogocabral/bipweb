import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

import br.ufal.ic.parser.bean.ArtigoPublicado;

public class Main {
	
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();

		List<ArtigoPublicado> artigos = session.createCriteria(ArtigoPublicado.class).list();
		System.out.println(artigos.size());
		FullTextSession luceneSession = Search.createFullTextSession(session);
		
		for (ArtigoPublicado artigoPublicado : artigos) {
			luceneSession.index(artigoPublicado);
		}
//		
//		try {
//			MultiFieldQueryParser parser = new MultiFieldQueryParser(
//					new String[] {"titulo", "tituloPeriodico"}, new StandardAnalyzer());
//	
//		    Query luceneQuery = parser.parse("aprendizagem");
//	
//		    FullTextQuery fullTextQuery = luceneSession.createFullTextQuery(luceneQuery, ArtigoPublicado.class);
//		    
//		    artigos = fullTextQuery.list();
//		} catch (ParseException e) {
//			throw new RuntimeException(e);
//		}
//		
//		Set<String> pesq = new HashSet<String>();
//		
//		for (ArtigoPublicado artigoPublicado : artigos) {
//			pesq.add(artigoPublicado.getCurriculoVitae().getDadosGerais().getNomeCompleto());
//		}
//		
//		System.out.println(pesq);
		
		luceneSession.close();
	}

}
