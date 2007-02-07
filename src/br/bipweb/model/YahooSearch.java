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

public class YahooSearch implements SearchAgent {
	
	private static final String SEARCH_URL = "http://search.yahoo.com/search?n=10&p=";
	
	private int first, last, total;
	
	public List<Document> search(String criteria) {
		
		List<Document> documents = new ArrayList<Document>();
		
		try {
			
			URL url = new URL(SEARCH_URL + criteria);
			
			URLConnection connection = url.openConnection();
			
			connection.setRequestProperty("User-Agent", "BIPWeb");
			
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
					
					total = NumberFormat.getNumberInstance(new Locale("en")).parse(line.substring(0, position)).intValue();
					
					break;
					
				}
				
			}
			
			for (int count = first; count <= last; count++) {
				
				while ((line = reader.readLine()) != null) {
					
					int position = line.indexOf("<a class=yschttl  href=\"");
					
					if (position != -1) {
						
						Document document = new Document();
						
						position += 24;
						
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