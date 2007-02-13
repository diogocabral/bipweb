package br.bipweb.model;

import java.io.Serializable;

public class Document implements Serializable {

	private static final long serialVersionUID = 4650548819192132342L;

	protected String title;
	protected String url;
	protected Float score;
	
	public Document() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Document other = (Document) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("{ %s %s - '%s' <%s> }", getClass(), getScore(), getTitle(), getUrl());
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
	
	public Float getScore() {
		return score;
	}
	
	public void setScore(Float score) {
		this.score = score;
	}
	
}