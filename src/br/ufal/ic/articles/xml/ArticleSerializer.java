package br.ufal.ic.articles.xml;

import java.io.InputStream;
import java.util.List;

import br.ufal.ic.articles.core.DublinCoreArticle;

import com.thoughtworks.xstream.XStream;

public class ArticleSerializer {	
	
	private XStream xStream = new XStream();
	
	public ArticleSerializer() {
		xStream.alias("list", List.class);
		xStream.alias("article", DublinCoreArticle.class);
	}
	
	public String serialize(Object object) {
		return xStream.toXML(object);
	}
	
	public Object unserialize(InputStream inputStream) {
		return xStream.fromXML(inputStream);
	}

}
