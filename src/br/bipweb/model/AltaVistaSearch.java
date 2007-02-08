package br.bipweb.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AltaVistaSearch implements SearchAgent {
	
	private static final String SEARCH_URL = "http://www.altavista.com/web/results?nbq=100&q=";
	
	private int first, last, total;
	
	public List<Document> search(String criteria) {
		
		// TODO falta saber o valor de first e last (pega pela pagina��o)
		
		List<Document> documents = new ArrayList<Document>();
		
		try {
			
			URL url = new URL(SEARCH_URL + criteria);
			
			URLConnection connection = url.openConnection();
			
			connection.setRequestProperty("User-Agent", "BIPWeb");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String line;
			
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
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return documents;
		
	}
	
}