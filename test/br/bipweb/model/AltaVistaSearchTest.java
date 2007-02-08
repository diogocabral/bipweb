package br.bipweb.model;

import java.util.Collection;

import org.junit.Test;

public class AltaVistaSearchTest {

	@Test
	public void testSearch() throws SearchException {
		
		AltaVistaSearch search = new AltaVistaSearch();
		
		Collection<Document> documents;
		
		// Buscando
		documents = search.search("hashne");		
		//System.out.println(documents.size());
		
		// Continuando a busca
		documents = search.searchNext();
		documents = search.searchNext();
		documents = search.searchNext();
		documents = search.searchNext();
		documents = search.searchNext();
		documents = search.searchNext();
		documents = search.searchNext();
		documents = search.searchNext();
		documents = search.searchNext();
		documents = search.searchNext();
		documents = search.searchNext();
		documents = search.searchNext();
		documents = search.searchNext();
		//System.out.println(documents.size());
		
	}

}
