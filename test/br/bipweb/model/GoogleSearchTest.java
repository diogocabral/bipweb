package br.bipweb.model;

import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class GoogleSearchTest extends TestCase {
	
	@Test
	public void testSearch() {
		
		GoogleSearch search = new GoogleSearch();
		
		List<Document> documents = search.search("coisado");
		
		for (Document document : documents) {
			System.out.println(document);
		}
		
	}

}