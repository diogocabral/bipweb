package br.bipweb.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/**
 * Agente de busca que acessa o mecanismo de busca da Google.
 * Url do mecanismo de busca: www.google.com.
 * 
 * TODO Implementar as exce��es.
 * TODO Implementar o m�todo "public Collection<Document> searchNext();".
 * 
 * @author Leonardo Costa Beltr�o Lessa
 */
public class GoogleSearch implements SearchAgent {
	
	private static final int N = 50;
	private static final String SEARCH_URL = "http://www.google.com/search?num=" + N + "&q=";
	
	private int first, last, total;
	private String criteria;
	
	public Collection<Document> search(String criteria)
			throws SearchException {
		
		this.criteria = criteria;
		
		try {
			
			URL url = new URL(SEARCH_URL + criteria);
		
			return search(url);
			
		} catch (MalformedURLException e) {
			throw new SearchException(e);
		}
		
	}

	public Collection<Document> searchNext()
			throws SearchException {
		
		if (criteria == null) {
			throw new SearchException("Deve-se primeiro fazer a busca.");
		}
		
		if (last == total) {
			throw new SearchException("Fim da busca.");
		}
		
		try {
			
			URL url = new URL(SEARCH_URL + criteria + "&start=" + last);
			
			return search(url);
			
		} catch (MalformedURLException e) {
			throw new SearchException(e);
		}
		
	}
	
	private Collection<Document> search(URL url)
			throws SearchException {
		
		try {
			
			Collection<Document> documents = new ArrayList<Document>();
			
			URLConnection connection = url.openConnection();
			
			connection.setRequestProperty("User-Agent", "BIPWeb");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
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
					
					total = NumberFormat.getNumberInstance(new Locale("en")).parse(line.substring(0, position)).intValue();
					
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
						
						document.setTitle(line.substring(0, position).replaceAll("<b>", "").replaceAll("</b>", ""));
						
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
		}
		
	}
	
}