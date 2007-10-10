import java.io.File;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.xml.sax.SAXException;

import br.ufal.ic.parser.CurriculoVitaeXmlParser;
import br.ufal.ic.parser.bean.CurriculoVitae;
import br.ufal.ic.parser.bean.producaobibliografica.ArtigoPublicado;


public class Teste {
	
	public static void main(String[] args) throws Exception {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		CurriculoVitae curriculoVitae = new CurriculoVitaeXmlParser().parse(new File("xml/5760364940162939.xml"));
		
		for (ArtigoPublicado artigoPublicado : curriculoVitae.getProducaoBibliografica().getArtigosPublicados()) {
			session.save(artigoPublicado);
		}
		
//		session.save(curriculoVitae);
		
//		System.out.println(session.createCriteria(CurriculoVitaeXmlParser.class).list());
		
		tx.commit();
		
		session.close();
	}

}
