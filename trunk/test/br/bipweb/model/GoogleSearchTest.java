package br.bipweb.model;

import java.util.Collection;

import junit.framework.TestCase;

import org.junit.Test;

public class GoogleSearchTest extends TestCase {
	
	@Test
	public void testSearch()
			throws SearchException {
		
		GoogleSearch search = new GoogleSearch();
		
		Collection<Document> documents = search.search("leao");
		
		int count = 1;
		
		for (Document document : documents) {
			System.out.println(count + ". " + document);
			count++;
		}
		
		if (search.hasMoreDocuments()) {
			
			documents = search.searchNext();
			
			for (Document document : documents) {
				System.out.println(count + ". " + document);
				count++;
			}
		
		}
		
	}

}