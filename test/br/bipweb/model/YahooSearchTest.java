package br.bipweb.model;

import java.util.List;

import org.junit.Test;

public class YahooSearchTest {

	@Test
	public void testSearch() {
		
		YahooSearch search = new YahooSearch();
		
		List<Document> documents = search.search("teste");
		
		for (Document document : documents) {
			System.out.println(document);
		}
		
	}

}
