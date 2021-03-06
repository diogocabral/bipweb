package br.bipweb.model.search;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.br.BrazilianAnalyzer;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Searcher;

import br.bipweb.model.Document;
import br.bipweb.model.lucene.HTMLDocument;

public class ScoreAgent {

	private String dir;

	public ScoreAgent() {
		super();

		this.dir = System.getProperty("java.io.tmpdir", "tmp") + System.getProperty("file.separator") + "index-";

	}

	public Collection<Document> execute(String criteria, Collection<Document> documents)
			throws IOException {

		try {
			
			String dir = this.dir + new Date().getTime();
			
			this.index(documents, dir);

			return this.search(criteria, dir);

		} catch (ParseException e) {} // Faz nada

		return null;

	}

	private void index(Collection<Document> documents, String dir)
			throws IOException {

		Analyzer analyzer = new BrazilianAnalyzer();

		IndexWriter writer = new IndexWriter(dir, analyzer, true);
		writer.setMaxFieldLength(500); // 10000 Default
		
		for (Document document : documents) {

			try {
				
				URL url = new URL(document.getUrl());

				org.apache.lucene.document.Document html = HTMLDocument.getDocument(url);
				
				//System.out.println(html); // TOD

				writer.addDocument(html);

			} catch (Exception e) {} // Faz nada

		}

		writer.close();

	}

	private Collection<Document> search(String criteria, String dir)
			throws IOException, ParseException {

		Analyzer analyzer = new BrazilianAnalyzer();

		IndexReader reader = IndexReader.open(dir);

		Searcher searcher = new IndexSearcher(reader);

		QueryParser parser = new QueryParser("contents", analyzer);

		Query query = parser.parse(criteria);

		Hits hits = searcher.search(query);

		Collection<Document> documents = new ArrayList<Document>();

		for (int count = 0; count < hits.length(); count++) {

			Document document = new Document();

			org.apache.lucene.document.Document doc = hits.doc(count);

			document.setTitle(doc.get("title"));
			document.setUrl(doc.get("path"));
			document.setScore(hits.score(count));

			documents.add(document);

		}

		return documents;

	}

}