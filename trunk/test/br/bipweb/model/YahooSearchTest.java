package br.bipweb.model;

import java.util.Collection;

import org.junit.Test;

public class YahooSearchTest {

	@Test
	public void testSearch() throws SearchException {
		
		YahooSearch search = new YahooSearch();
		
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
