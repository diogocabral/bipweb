package br.bipweb.model.search;

import java.util.Collection;

import junit.framework.TestCase;

import org.junit.Test;

import br.bipweb.model.Criteria;
import br.bipweb.model.Document;
import br.bipweb.model.search.GoogleSearcher;
import br.bipweb.model.search.SearchException;

public class GoogleSearchTest extends TestCase {
	
	@Test
	public void testSearch()
			throws SearchException {
		
		GoogleSearcher search = new GoogleSearcher();
		search.setCriteria(new Criteria("hello world"));
		
		Collection<Document> documents = search.search();
		
		int count = 1;
		
		for (Document document : documents) {
			System.out.println(count + ". " + document);
			count++;
		}
		
	}

}