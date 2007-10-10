import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

import br.ufal.ic.articles.core.DublinCoreArticle;

public class IndexadorDadosExistentes {

	public static void main(String[] args) throws Exception {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Integer total = (Integer) session.createCriteria(DublinCoreArticle.class)
			.setProjection(Projections.count("id"))
			.uniqueResult();		
		
		session.close();
		
		final int maxResults = 1000;
		
		List<DublinCoreArticle> articles = null; 

		int count = 0;
		
		for (int i = 0; i < (int) total/maxResults; i++) {
			session = sessionFactory.openSession();
			FullTextSession luceneSession = Search.createFullTextSession(session);
			
			articles = session.createCriteria(DublinCoreArticle.class)
				.setMaxResults(maxResults)
				.setFirstResult(i * maxResults)
				.list();
			
			Transaction transaction = luceneSession.beginTransaction();

			for (DublinCoreArticle citeseerArticle : articles) {
				luceneSession.index(citeseerArticle);
			}
			transaction.commit();
			luceneSession.close();
			
			System.out.println(++count);			
		}
	}

}
