package br.bipweb.model;

import java.util.Collection;

import org.junit.Test;

import br.bipweb.model.agent.SearchException;
import br.bipweb.model.agent.YahooSearcher;

public class YahooSearchTest {

	@Test
	public void testSearch() throws SearchException {
		
		YahooSearcher search = new YahooSearcher();
		
		Collection<Document> documents = search.search("Teste");
		
		System.out.println(documents.size() + "\n");
		
		int count = 1;
		
		for (Document document : documents) {
			System.out.println(count + ". " + document);
			count++;
		}
		
		System.out.println("\n" + documents.size());
		
	}

}
