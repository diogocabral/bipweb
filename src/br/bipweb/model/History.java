package br.bipweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History extends Document implements Serializable {
	
	private static final long serialVersionUID = 853378906342751473L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private User user;
	private Category category;
	private Float feedbackScore;
	
	public History() {
		super();
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