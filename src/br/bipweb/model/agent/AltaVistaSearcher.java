package br.bipweb.model.agent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import br.bipweb.model.Document;

/**
 * 
 * @author Leonardo Costa Beltrão Lessa
 */
public class AltaVistaSearcher extends AbstractSearcher {
	
	private static final String SEARCH_URL = "http://www.altavista.com/web/results?nbq=" + N + "&q=";
	
	public AltaVistaSearcher() {
		super();
	}
	
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
			
			URL url = new URL(SEARCH_URL + criteria + "&stq=" + last);
			
			return search(url);
			
		} catch (MalformedURLException e) {
			throw new SearchException(e);
		}
		
	}
	
	public boolean hasMoreDocuments()
			throws SearchException {
		super.hasMoreDocuments();
		
		if (last < total)
			return true;
		
		return false;
		
	}
	
	private Collection<Document> search(URL url)
			throws SearchException {
		
		try {
			
			URLConnection connection = url.openConnection();
			
			connection.setRequestProperty("User-Agent", USERAGENT);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String line;
			
			/*
			 * Calculo de total
			 */
			while ((line = reader.readLine()) != null) {
				
				int position = line.indexOf("AltaVista found ");
				
				if (position != -1) {
					
					position += 16;
					
					line = line.substring(position);
					
					position = line.indexOf(" results");
					
					total = FORMAT.parse(line.substring(0, position)).intValue();
					
					break;
					
				}
				
			}
			
			/*
			 * Documentos
			 */			
			Collection<Document> documents = new ArrayList<Document>();
			
			while ((line = reader.readLine()) != null) {
				
				int position = line.indexOf("<a class='res' href='");
				
				if (position != -1) {
					
					while (position != -1) {
						
						Document document = new Document();
					
						position += 21;
						
						line = line.substring(position);
						
						position = line.indexOf("'>");
						
						document.setUrl(line.substring(0, position));
						
						position += 2;
						
						line = line.substring(position);
						
						position = line.indexOf("</a>");
						
						document.setTitle(line.substring(0, position).replaceAll("<b>","").replaceAll("</b>", ""));
						
						position = line.indexOf("<a class='res' href='");
						
						documents.add(document);
						
					}
					
					break;
					
				}
				
			}
			
			/*
			 * Cálculo de first e last
			 */
			if (total > N) {
				
				while ((line = reader.readLine()) != null) {
					
					int position = line.indexOf("stq=");
					
					if (position != -1) {
						
						position = line.indexOf("\" target=\"_self\">N");
						
						if (position != -1) { // Tem Next
							line = line.substring(0, position);
							position = line.lastIndexOf("stq=");
							position += 4;
							last = Integer.parseInt(line.substring(position));
							first = last - N + 1;
						} else { // Tem que ter Prev, por causa do "if (total > N) {"
							// Fim da busca.
							position = line.indexOf("\" target=\"_self\">&lt;");
							line = line.substring(0, position); // TODO talvez possa0 dar erro, mas é pouco provável
							position = line.lastIndexOf("stq=");
							position += 4;
							first = Integer.parseInt(line.substring(position)) + N + 1;
							last = total;
						}
						
						break;
						
					}
				}
				
			} else {
				// Fim da busca.
				first = 1;
				last = total;
			}
			
			return documents;
			
		} catch (IllegalAccessError e) {
			throw new SearchException(e);
		} catch (IOException e) {
			throw new SearchException(e);
		} catch (ParseException e) {
			throw new SearchException("Não foi possível obter o total da busca.", e);
		}
		
	}
	
}