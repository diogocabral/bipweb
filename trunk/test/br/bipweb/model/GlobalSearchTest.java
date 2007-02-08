package br.bipweb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class GlobalSearchTest {

	@Test
	public void testSearch() throws SearchException {
		
		List<SearchAgent> agents = new ArrayList<SearchAgent>();
		
		agents.add(new GoogleSearch());
		//agents.add(new YahooSearch()); // TODO <- Tá bugado
		agents.add(new AltaVistaSearch());
		
		GlobalSearch search = new GlobalSearch();
		
		search.setAgents(agents);
		
		Collection<Document> documents = search.search("Fibonacci");
		
		System.out.println(documents.size() + "\n");
		
		for (Document document : documents) {
			System.out.println(document);
		}
		
		System.out.println("\n" + documents.size());
		
	}

}
