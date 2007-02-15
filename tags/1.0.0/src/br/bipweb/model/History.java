package br.bipweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History extends Document implements Serializable {
	
	private static final long serialVersionUID = 853378906342751473L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Category category;
	
	private Float feedbackScore;
	
	public History() {
		super();
	}
	
	public History(Document document) {
		super();
		
		this.title = document.title;
		this.url = document.url;
		this.score = document.score;
		
	}
	
	public Document toDocument() {
		
		Document document = new Document();
		
		document.title = this.title;
		document.url = this.url ;
		document.score = this.score;
		
		return document;
		
	}
	
	@Override
	public String toString() {
		return String.format("{ %s(%s) %s - %s - '%s' <%s> }", getClass().getSimpleName(), getId(), getScore(), getFeedbackScore(), getTitle(), getUrl());
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Float getFeedbackScore() {
		return feedbackScore;
	}
	
	public void setFeedbackScore(Float feedbackScore) {
		this.feedbackScore = feedbackScore;
	}
	
}