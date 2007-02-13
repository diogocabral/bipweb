package br.bipweb.model.agent;

import java.util.Collection;

import org.junit.Test;

import br.bipweb.model.Document;
import br.bipweb.model.search.AltaVistaSearcher;
import br.bipweb.model.search.SearchException;

public class AltaVistaSearchTest {

	@Test
	public void testSearch() throws SearchException {
		
		AltaVistaSearcher search = new AltaVistaSearcher();
		
		Collection<Document> documents;
		
		// Buscando
		documents = search.search("hashne");		
		System.out.println(documents.size());
		
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
