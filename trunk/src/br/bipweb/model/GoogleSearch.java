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

/**
 * 
 * @author Leonardo Costa Beltrão Lessa
 */
public class GoogleSearch implements SearchAgent {
	
	private static final String SEARCH_URL = "http://www.google.com/search?num=100&q=";
	
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