import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

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
		
		CurriculoVitae curriculoVitae = new CurriculoVitaeXmlParser().parse(new File("xml/0306751604362704.xml"));
		//xml/0306751604362704.xml
		//xml/1918508793868984.xml
		//xml/8441037104511506.xml
		//xml/4038730280834132.xml
		//xml/5760364940162939.xml
		
		session.save(curriculoVitae);
		
		for (ArtigoPublicado artigoPublicado : curriculoVitae.getProducaoBibliografica().getArtigosPublicados()) {
			CurriculoVitae curriculoVitae2 = new CurriculoVitae();
			curriculoVitae2.setId(curriculoVitae.getId());
			
			artigoPublicado.setCurriculoVitae(curriculoVitae);
			session.save(artigoPublicado);
		}
		
//		System.out.println(session.createCriteria(CurriculoVitaeXmlParser.class).list());
		
		tx.commit();
		
		session.close();
	}

}
