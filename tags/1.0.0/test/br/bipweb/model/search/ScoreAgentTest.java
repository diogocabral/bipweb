package br.bipweb.model.search;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.Test;

import br.bipweb.model.Criteria;
import br.bipweb.model.Document;
import br.bipweb.model.search.ScoreAgent;
import br.bipweb.util.Constants;

public class ScoreAgentTest {

	@Test
	public void testExecute()
			throws SearchException, IOException {
		
		Criteria criteria = new Criteria("banco de dados");
		
		LocalSearcher searcher = new LocalSearcher();
		searcher.setCriteria(criteria);
		searcher.setDirectory(new File(Constants.LOCALDOCS_LOCALPATH));
		searcher.setPrefix(Constants.LOCALDOCS_WEBPATH);
		
		Collection<Document> documents;
		int count;
		
		System.out.println(criteria.getEncodedCriteria());
		
		documents = searcher.search();
		count = 1;
		for (Document document : documents) {
			System.out.println(String.format("%s. %s", count++, document));
		}
		
		ScoreAgent agent = new ScoreAgent();
		
		documents = agent.execute(criteria.getCleanCriteria(), documents);
		count = 1;
		for (Document document : documents) {
			System.out.println(String.format("%s. %s", count++, document));
		}
		
	}

}
