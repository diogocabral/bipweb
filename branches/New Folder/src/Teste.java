import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.ufal.ic.articles.core.DublinCoreArticle;
import br.ufal.ic.articles.xml.ArticleSerializer;

public class Teste {

	public static void main(String[] args) throws Exception {		
		String urlString = "http://localhost:8080/articles/search?term=object";
		
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Request-Method", "GET");
		connection.setDoInput(true);
		connection.setDoOutput(false);
		connection.connect();

		List<DublinCoreArticle> list = (List<DublinCoreArticle>) new ArticleSerializer().unserialize(connection.getInputStream());
		
		for (DublinCoreArticle article : list) {
			System.out.println(article.getIdentifier() + " " + article.getDcTitle());
		}
		
		System.out.println("Resultado: " + connection.getResponseCode() + "/" 
				+ connection.getResponseMessage());
	}
	
}
