package br.bipweb.model.agent;

import java.util.Collection;

import junit.framework.TestCase;

import org.junit.Test;

import br.bipweb.model.Document;
import br.bipweb.model.search.GoogleSearcher;
import br.bipweb.model.search.SearchException;

public class GoogleSearchTest extends TestCase {
	
	@Test
	public void testSearch()
			throws SearchException {
		
		GoogleSearcher search = new GoogleSearcher();
		
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