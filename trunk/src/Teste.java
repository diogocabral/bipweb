import java.util.ArrayList;
import java.util.List;

import org.htmlparser.parserapplications.StringExtractor;
import org.htmlparser.util.ParserException;

public class Teste {
	
	public static void main(String[] args) {
		String url = "http://www.uol.com.br";

		List<String> palavras = new ArrayList<String>();
		
		StringExtractor se = new StringExtractor(url);
		try {
			String text = se.extractStrings(false);
			
			text = text.replaceAll("\\p{Punct}|©", " ");		
			
			for (String palavra : text.split("\\s")) {
				String temp = palavra.trim();
				if (temp.equals("") || temp.length() < 1) {
					continue;
				}
				
				palavras.add(temp);
			}
			
			System.out.println(palavras);
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}

}
