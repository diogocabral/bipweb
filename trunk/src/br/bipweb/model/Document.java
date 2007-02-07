package br.bipweb.model;

public class Document {
	
	private int id;
	private String title;
	private String url;
	
	public Document() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "id={" + id + "}" + " title={" + title + "} url={" + url + "}";
	}
	
}