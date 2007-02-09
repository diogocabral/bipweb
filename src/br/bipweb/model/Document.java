package br.bipweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class Document implements Serializable {

	private static final long serialVersionUID = 4650548819192132342L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String url;
	
	public Document() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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