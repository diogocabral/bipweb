package br.bipweb.model.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import br.bipweb.model.Document;

/**
 * Agente de busca que acessa o mecanismo de busca da Google.
 * Url do mecanismo de busca: www.google.com.
 * 
 * @author Leonardo Costa Beltr�o Lessa
 */
public class GoogleSearcher extends AbstractWebSearcher {
	
	private static final String SEARCH_URL = "http://www.google.com/search";
	
	public GoogleSearcher() {
		super();
	}
	
	public Collection<Document> search()
			throws SearchException {
		super.search();
		
		try {
			
			URL url = new URL(String.format("%s?num=%s&q=%s", SEARCH_URL, documentsPerPage, criteria.getEncodedCriteria()));
			
			return search(url);
			
		} catch (MalformedURLException e) {
			throw new SearchException(e);
		}
		
	}

	public Collection<Document> searchNext()
			throws SearchException {
		super.searchNext();
		
		try {
			
			URL url = new URL(String.format("%s?num=%s&q=%s&start=%s", SEARCH_URL, documentsPerPage, criteria.getEncodedCriteria(), last));
			
			return search(url);
			
		} catch (MalformedURLException e) {
			throw new SearchException(e);
		}
		
	}
	
	public boolean hasMoreDocuments()
			throws SearchException {
		super.hasMoreDocuments();
		
		if (last < total && (last % documentsPerPage == 0))
			return true;
		
		return false;
		
	}
	
	private Collection<Document> search(URL url)
			throws SearchException {
		
		BufferedReader reader = null;
		
		try {
			
			Collection<Document> documents = new ArrayList<Document>();
			
			URLConnection connection = url.openConnection();
			
			connection.setRequestProperty("User-Agent", USERAGENT);
			
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "ISO-8859-1"));
			
			String line;
			
			while ((line = reader.readLine()) != null) {
				
				int position = line.indexOf("Results");
				
				if (position != -1) {
					
					line = line.substring(position);
					
					position = line.indexOf("<b>");
					
					line = line.substring(position+3);
					
					position = line.indexOf("</b>");
					
					first = Integer.parseInt(line.substring(0, position));
					
					line = line.substring(position+10);
					
					position = line.indexOf("</b>");
					
					last = Integer.parseInt(line.substring(0, position));
					
					line = line.substring(position+18);
					
					position = line.indexOf("</b>");
					
					total = FORMAT.parse(line.substring(0, position)).intValue();
					
					for (int count = first; count <= last; count++) {
						
						Document document = new Document();
						
						position = line.indexOf("class=g");
						
						line = line.substring(position);
						
						position = line.indexOf("<a");
						
						line = line.substring(position + 9);
						
						position = line.indexOf("\"");
						
						document.setUrl(line.substring(0, position));
						
						line = line.substring(position + 10);
						
						position = line.indexOf("</a>");
						
						document.setTitle(URLDecoder.decode(line.substring(0, position).replaceAll("<b>", "").replaceAll("</b>", ""), "ISO-8859-1"));
						
						documents.add(document);
						
					}
					
					break;
					
				}
				
			}
			
			return documents;
			
		} catch (MalformedURLException e) {
			throw new SearchException(e);
		} catch (IOException e) {
			throw new SearchException(e);
		} catch (ParseException e) {
			throw new SearchException(e);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (Exception e) {}
		}
		
	}
	
}