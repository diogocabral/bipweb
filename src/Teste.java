import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Teste {
	
	public static void main(String[] args) {
		StringBuffer html = new StringBuffer();
		
		try {
			FileReader reader = new FileReader(new File("temp/teste.html"));
			BufferedReader buffer = new BufferedReader(reader);
			
			String line;
		
			while ((line = buffer.readLine()) != null) {
				html.append(line);
			}
		} catch (IOException e) {
		}
		
		String[] paradas  = html.toString().split("<(?i)(head)>.{0,}</(?i)(head)>|<\\p{Alpha}\\p{Alnum}*>|<\\p{Alpha}\\p{Alnum}*(\\p{Blank}{1,}(\\p{Alpha}{1,}\\p{Blank}{0,}=\\p{Blank}{0,}\"(\\p{Alnum}*\\p{Punct}*)*\"))*>|</\\p{Alpha}\\p{Alnum}*>");
		
		StringBuffer lista = new StringBuffer();
		for (int i = 0; i < paradas.length; i++) {
			paradas[i] = paradas[i].replaceAll("\t|[.]", "");
			if (paradas[i].trim().equals("")) {
				continue;
			}
			lista.append(paradas[i] + " ");
		}
		
		for (String parada : lista.toString().split(" ")) {
			System.out.println(parada);
		}
	}

}
