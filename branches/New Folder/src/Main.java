import java.io.IOException;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.SearchFactory;
import org.hibernate.search.reader.ReaderProvider;
import org.hibernate.search.store.DirectoryProvider;

import br.ufal.ic.articles.core.DublinCoreArticle;
import br.ufal.ic.articles.util.HibernateUtil;


public class Main {
	
	public static void main(String[] args) throws CorruptIndexException, IOException {		
		FullTextSession fullTextSession = Search.createFullTextSession(HibernateUtil.openSession());
		
		SearchFactory searchFactory = fullTextSession.getSearchFactory();
		
		DirectoryProvider orderProvider = (DirectoryProvider) searchFactory.getDirectoryProviders(DublinCoreArticle.class)[0];

		ReaderProvider readerProvider = searchFactory.getReaderProvider();
		IndexReader reader = readerProvider.openReader(orderProvider);

		try {
		    System.out.println(reader.getTermFreqVector(1, "title"));
		} finally {
		    readerProvider.closeReader(reader);
		}
		
		HibernateUtil.close();
	}

}
