package br.bipweb.lucene;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

import org.apache.lucene.document.Field;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.tidy.Tidy;

public class HTMLDocument {
	
	private String path;
	private Element rawDoc;

	public HTMLDocument(File file)
			throws IOException {
		
		this.path = file.getPath();
		
		Tidy tidy = new Tidy();
		tidy.setQuiet(true);
		tidy.setShowWarnings(false);
		org.w3c.dom.Document root = tidy.parseDOM(new FileInputStream(file), null);
		rawDoc = root.getDocumentElement();
	}

	public HTMLDocument(URL url)
			throws IOException {
		
		this.path = url.toString();
		
		URLConnection connection = url.openConnection();
		connection.setReadTimeout(1500);
		
		System.out.println(connection.getContentType());
		
		//if (connection.getContentType().indexOf("text/html") == -1)
			//throw new IOException("O documento n�o est� no formato html.");
		
		Tidy tidy = new Tidy();
		tidy.setQuiet(true);
		tidy.setShowWarnings(false);
		
		org.w3c.dom.Document root = tidy.parseDOM(connection.getInputStream(), null);
		rawDoc = root.getDocumentElement();
	}

	public static org.apache.lucene.document.Document getDocument(URL url)
			throws IOException {
		
		HTMLDocument htmlDoc = new HTMLDocument(url);
		org.apache.lucene.document.Document luceneDoc = new org.apache.lucene.document.Document();
		
		luceneDoc.add(new Field("path", htmlDoc.getPath(), Field.Store.YES,
				Field.Index.UN_TOKENIZED));
		luceneDoc.add(new Field("title", htmlDoc.getTitle(), Field.Store.YES,
				Field.Index.TOKENIZED));
		luceneDoc.add(new Field("contents", htmlDoc.getBody(), Field.Store.YES,
				Field.Index.TOKENIZED));

		return luceneDoc;
	}

	public static org.apache.lucene.document.Document Document(File file)
			throws IOException {
		HTMLDocument htmlDoc = new HTMLDocument(file);
		org.apache.lucene.document.Document luceneDoc = new org.apache.lucene.document.Document();
		
		luceneDoc.add(new Field("path", htmlDoc.getPath(), Field.Store.YES,
				Field.Index.UN_TOKENIZED));
		luceneDoc.add(new Field("title", htmlDoc.getTitle(), Field.Store.YES,
				Field.Index.TOKENIZED));
		luceneDoc.add(new Field("contents", htmlDoc.getBody(), Field.Store.YES,
				Field.Index.TOKENIZED));

		String contents = null;
		BufferedReader br = new BufferedReader(new FileReader(file));
		StringWriter sw = new StringWriter();
		String line = br.readLine();
		while (line != null) {
			sw.write(line);
			line = br.readLine();
		}
		br.close();
		contents = sw.toString();
		sw.close();

		luceneDoc.add(new Field("rawcontents", contents, Field.Store.YES,
				Field.Index.NO));

		return luceneDoc;
	}
	
	public String getPath() {
		return path;
	}

	public String getTitle() {
		if (rawDoc == null) {
			return null;
		}

		String title = "";

		NodeList nl = rawDoc.getElementsByTagName("title");
		if (nl.getLength() > 0) {
			Element titleElement = ((Element) nl.item(0));
			Text text = (Text) titleElement.getFirstChild();
			if (text != null) {
				title = text.getData();
			}
		}
		return title;
	}

	public String getBody() {
		if (rawDoc == null) {
			return null;
		}

		String body = "";
		NodeList nl = rawDoc.getElementsByTagName("body");
		if (nl.getLength() > 0) {
			body = getBodyText(nl.item(0));
		}
		return body;
	}

	private String getBodyText(Node node) {
		NodeList nl = node.getChildNodes();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < nl.getLength(); i++) {
			Node child = nl.item(i);
			switch (child.getNodeType()) {
			case Node.ELEMENT_NODE:
				buffer.append(getBodyText(child));
				buffer.append(" ");
				break;
			case Node.TEXT_NODE:
				buffer.append(((Text) child).getData());
				break;
			}
		}
		return buffer.toString();
	}
	
}