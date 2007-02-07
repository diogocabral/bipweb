package br.bipweb.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class AltaVistaSearch implements SearchAgent {
	
	private static final String SEARCH_URL = "http://www.altavista.com/web/results?q=";
	
	public List<Document> search(String criteria) {
		
		List<Document> documents = new ArrayList<Document>();
		
		try {
			
			URL url = new URL(SEARCH_URL + criteria);
			
			URLConnection connection = url.openConnection();
			
			connection.setRequestProperty("User-Agent", "BIPWeb");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String line;
			
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
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
		}
		
		return documents;
		
	}
	
}