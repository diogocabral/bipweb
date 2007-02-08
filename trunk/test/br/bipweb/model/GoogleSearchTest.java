package br.bipweb.model;

import java.util.Collection;

import junit.framework.TestCase;

import org.junit.Test;

public class GoogleSearchTest extends TestCase {
	
	@Test
	public void testSearch() {
		
		GoogleSearch search = new GoogleSearch();
		
		Collection<Document> documents = search.search("Leonardo");
		
		System.out.println(documents.size());
		
	}

}