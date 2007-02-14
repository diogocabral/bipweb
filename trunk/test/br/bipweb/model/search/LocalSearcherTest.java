package br.bipweb.model.search;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.Test;

import br.bipweb.model.Criteria;
import br.bipweb.model.Document;
import br.bipweb.util.Constants;

public class LocalSearcherTest {

	@Test
	public void testSearch()
			throws SearchException, IOException {
		
		Criteria criteria = new Criteria("lucene");
		
		LocalSearcher searcher = new LocalSearcher();
		searcher.setDirectory(new File(Constants.LOCALDOCS_LOCALPATH));
		searcher.setPrefix(Constants.LOCALDOCS_WEBPATH);
		searcher.setCriteria(criteria);
		
		ScoreAgent agent = new ScoreAgent();
		
		Collection<Document> documents = searcher.search();
		documents = agent.execute(criteria.getCleanCriteria(), documents);
		int count = 1;
		for (Document document : documents) {
			System.out.println(String.format("%s. %s", count++, document));
		}
		
		System.out.println();
		
		documents = searcher.searchNext();
		documents = agent.execute(criteria.getCleanCriteria(), documents);
		for (Document document : documents) {
			System.out.println(String.format("%s. %s", count++, document));
		}
		
	}

}