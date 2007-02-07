package br.bipweb.model;

import java.util.List;

import org.junit.Test;

public class AltaVistaSearchTest {

	@Test
	public void testSearch() {
		
		AltaVistaSearch search = new AltaVistaSearch();
		
		List<Document> documents = search.search("teste");
		
		for (Document document : documents) {
			System.out.println(document);
		}
		
	}

}
