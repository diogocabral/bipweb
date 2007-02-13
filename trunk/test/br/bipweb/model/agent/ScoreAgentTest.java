package br.bipweb.model.agent;

import java.util.Collection;

import org.junit.Test;

import br.bipweb.model.Document;

public class ScoreAgentTest {

	@Test
	public void testExecute() {
		
		ScoreAgent agent = new ScoreAgent();
		
		Collection<Document> documents = agent.execute("database", null);
		
		for (Document document : documents) {
			System.out.println(document);
		}
		
	}

}
