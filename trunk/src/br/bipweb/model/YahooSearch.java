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

public class YahooSearch extends AbstractSearchAgent {
	
	private static final String SEARCH_URL = "http://search.yahoo.com/search?n=" + N + "&p=";
	
	private int first, last, total;
	private String criteria;
	
	public Collection<Document> search(String criteria)
			throws SearchException {
		super.search(criteria);
		
		try {
			
			URL url = new URL(SEARCH_URL + criteria);
		
			return search(url);
			
		} catch (MalformedURLException e) {
			throw new SearchException(e);
		}
		
	}

	public Collection<Document> searchNext()
			throws SearchException {
		super.searchNext();
		
		try {
			
			URL url = new URL(SEARCH_URL + criteria + "&b=" + (last + 1));
		
			return search(url);
			
		} catch (MalformedURLException e) {
			throw new SearchException(e);
		}
		
	}
	
	public boolean hasMoreDocuments()
			throws SearchException {
		super.hasMoreDocuments();
		
		if (!(last == total || last == 1000)) // Yahoo retorna no máximo 1000 resultados
			return true;
		
		return false;
		
	}
	
	public Collection<Document> search(URL url)
			throws SearchException {
		
		try {
			
			URLConnection connection = url.openConnection();
			
			connection.setRequestProperty("User-Agent", USERAGENT);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String line;
			
			while ((line = reader.readLine()) != null) {
				
				int position = line.indexOf("<div id=yschinfo>");
				
				if (position != -1) {
					
					position = line.indexOf("<p>");
					position += 3;
					
					line = line.substring(position);
					
					position = line.indexOf(" - ");
					
					first = Integer.parseInt(line.substring(0, position));
					
					position += 3;
					
					line = line.substring(position);
					
					position = line.indexOf(" of about ");
					
					last = Integer.parseInt(line.substring(0, position));
					
					position += 10;
					
					line = line.substring(position);
					
					position = line.indexOf(" for ");
					
					total = FORMAT.parse(line.substring(0, position)).intValue();
					
					break;
					
				}
				
			}
			
			Collection<Document> documents = new ArrayList<Document>();
			
			for (int count = first; count <= last; count++) {
				
				while ((line = reader.readLine()) != null) {
					
					int position = line.indexOf("<a class=yschttl ");
					
					if (position != -1) {
						
						Document document = new Document();
						
						position += 17;
						line = line.substring(position);
						position = line.indexOf(" href=\"");
						position += 7;
						line = line.substring(position);
						position = line.indexOf("\">");
						
						document.setUrl(line.substring(0, position));
						
						line = line.substring(position + 2);
						position = line.indexOf("</a>");
						
						document.setTitle(line.substring(0, position).replaceAll("<b>", "").replaceAll("</b>", ""));
						
						documents.add(document);
						
						break;
						
					}
					
				}
				
			}
			
			return documents;
			
		} catch (ParseException e) {
			throw new SearchException(e);
		} catch (IOException e) {
			throw new SearchException(e);
		}
		
	}
	
}