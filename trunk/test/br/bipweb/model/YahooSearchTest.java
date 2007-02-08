package br.bipweb.model;

import java.util.Collection;

import org.junit.Test;

public class YahooSearchTest {

	@Test
	public void testSearch() {
		
		YahooSearch search = new YahooSearch();
		
		Collection<Document> documents = search.search("Teste");
		
		for (Document document : documents) {
			System.out.println(document);
		}
		
	}

}
