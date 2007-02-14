package br.bipweb.model.search;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.Test;

import br.bipweb.model.Criteria;
import br.bipweb.model.Document;

public class LocalSearcherTest {

	@Test
	public void testSearch()
			throws SearchException, IOException {
		
		Criteria criteria = new Criteria("apache");
		
		LocalSearcher searcher = new LocalSearcher(new File("web/localdocs"));
		searcher.setCriteria(criteria);
		
		ScoreAgent agent = new ScoreAgent();
		
		Collection<Document> documents = searcher.search();
		documents = agent.execute(criteria.getCleanCriteria(), documents);
		int count = 1;
		for (Document document : documents) {
			System.out.println(String.format("%s. %s", count++, document));
		}
		
	}

}