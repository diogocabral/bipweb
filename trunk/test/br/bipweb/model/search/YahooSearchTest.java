package br.bipweb.model.search;

import java.util.Collection;

import org.junit.Test;

import br.bipweb.model.Document;
import br.bipweb.model.search.SearchException;
import br.bipweb.model.search.YahooSearcher;

public class YahooSearchTest {

	@Test
	public void testSearch() throws SearchException {
		
		YahooSearcher search = new YahooSearcher();
		
		Collection<Document> documents = search.search();
		
		System.out.println(documents.size() + "\n");
		
		int count = 1;
		
		for (Document document : documents) {
			System.out.println(count + ". " + document);
			count++;
		}
		
		System.out.println("\n" + documents.size());
		
	}

}
