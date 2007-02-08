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
 * 
 * @author Leonardo Costa Beltrão Lessa
 */
public class AltaVistaSearch implements SearchAgent {
	
	private static final int N = 50;
	private static final String SEARCH_URL = "http://www.altavista.com/web/results?nbq=" + N + "&q=";
	
	private int first, last, total;
	private String criteria;
	
	public AltaVistaSearch() {
		super();
	}
	
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
			
			URL url = new URL(SEARCH_URL + criteria + "&stq=" + last);
			
			return search(url);
			
		} catch (MalformedURLException e) {
			throw new SearchException(e);
		}
		
	}
	
	private Collection<Document> search(URL url)
			throws SearchException {
		
		try {
			
			URLConnection connection = url.openConnection();
			
			connection.setRequestProperty("User-Agent", "BIPWeb");
			
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
					
					total = NumberFormat.getNumberInstance(new Locale("en")).parse(line.substring(0, position)).intValue();
					
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